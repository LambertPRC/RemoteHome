package web;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import com.oracle.webservices.internal.api.databinding.Databinding.Builder;

import TCP.Config;
import SDK.Tools;
import domain.Result;
import sun.misc.BASE64Encoder;

public class getFileServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);// 获得文件项
		List<FileItem> parseRequest;
		try {
			parseRequest = upload.parseRequest(request);
			for (FileItem fileItem : parseRequest) {//判断
				if(!fileItem.isFormField()){
					String fileName = fileItem.getName();
					String path = this.getServletContext().getRealPath("upload");
					InputStream in = fileItem.getInputStream();
					OutputStream out = new FileOutputStream(path + "/" + fileName);// I:/xxx/xx/xxx/xxx.jpg
					IOUtils.copy(in, out);
					in.close();
					out.close();
					fileItem.delete();
					
					
					
				
					
					
				   	String localPath=path+"/"+fileName;

					
					File file=new File(localPath);
					FileInputStream fins=new FileInputStream(file);
					byte[] buffer = new byte[(int)file.length()];
					fins.read(buffer);
					fins.close();
					BASE64Encoder encoder=new BASE64Encoder();
			        String base=encoder.encode(buffer);
			        
			        
			        
			        
			        
			        
	        Socket socket = null;
		            String Code_Adress = Config.getValue("ip");
		            int port=Integer.valueOf(Config.getValue("port"));
		            //
		            try {
		                socket = new Socket(Code_Adress,port);
		                OutputStream outputStream = socket.getOutputStream();
		                InputStream inputStream = socket.getInputStream();
		                byte[] bytes = new byte[1024];
		                outputStream.write(base.getBytes());
		                System.out.println("发送成功");
		                int len = inputStream.read(bytes);
		                String str = new String(bytes,0,len);
		                System.out.println(str);
		                str=str.substring(1,str.length()-1);
		                //去除字符串中的空格
		                str=str.replaceAll("\n", "");	
		                str=str.replaceAll("  ", " ");
		                System.out.println(str);
		                //拆开字符串
		                String [] strr=str.split(" ");
		                System.out.println(strr);

		                Tools tool=new Tools();
		               
		                String flowerImage="upload/" + fileName;
		                String flowerName="";
		                if(str.charAt(10)!='e'){
		                	flowerName=tool.getFlowerClass(tool.getFlowerIndex(strr,0));
		                }else{
		                //System.out.println(flowerImage);
		                	flowerName=tool.getFlowerClass(tool.getFlowerIndex(strr));
		                }
		           	Result result=new Result();
		           	result.setImg(flowerImage);
		           	result.setName(flowerName);
		           	System.out.println(result.getImg());
		              
		              request.setAttribute("result", result);
		  
		            } catch (IOException e) {
		                e.printStackTrace();
		            }
			        
				}
				
				
				
			}
			
		} catch (FileUploadException e) {
			
			e.printStackTrace();
		}	// 将文件项装成集合，以便解析文件项，
		request.getRequestDispatcher("/result.jsp").forward(request, response);
	//response.sendRedirect(request.getContextPath() + "/show.jsp");
	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
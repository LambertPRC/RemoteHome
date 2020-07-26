package Interface;

import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.geom.RoundRectangle2D;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.Socket;

import javax.swing.JLabel;

import com.sun.awt.AWTUtilities;

import DB.IpConfig;
import Methods.ChooseImage;
import Methods.Imagebase64;
import SDK.Tools;

import java.awt.Font;
import java.awt.Color;
import java.awt.Image;

public class Interface extends JFrame {

	private JPanel contentPane;
	static String path=null;   //存放图片的路径
	static String base64=null;  //存放图片转成的base64
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
		                if ("Nimbus".equals(info.getName())) {
		                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
		                    break;
		                }
		            }
					//JFrame.setDefaultLookAndFeelDecorated(true);
					Interface frame = new Interface();
					//frame.setUndecorated(true);
					/*AWTUtilities.setWindowShape(frame, new RoundRectangle2D.Double(
							0.0D, 0.0D, frame.getWidth(), frame.getHeight(), 26.0D,
							26.0D));*/
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Interface() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(600, 300, 585, 406);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("华文楷体", Font.BOLD, 20));
		lblNewLabel.setBounds(219, 232, 158, 30);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("选择图片");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFont(new Font("华文楷体", Font.BOLD, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				path=ChooseImage.fileChooser();    //存放图片的路径
				base64=Imagebase64.getImageBinary(path);
				/*********将图片base64格式传到后台*****/
				/*显示选中图片*/
				if(path!=null){
					setVisible(false);    //将之前窗口隐藏
					String[] args1;
					args1 = new String[1];
					Interface.main(args1);
					dispose();		//本窗口销毁，释放内存资源
					System.out.println(path);
				}
			}
		});
		btnNewButton.setBounds(112, 275, 127, 52);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("上传");
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setFont(new Font("华文楷体", Font.BOLD, 20));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				 Socket socket = null;
		            String Code_Adress = IpConfig.getValue("ip");
		            try {
		                socket = new Socket(Code_Adress,Integer.parseInt(IpConfig.getValue("port")));
		                OutputStream outputStream = socket.getOutputStream();
		                InputStream inputStream = socket.getInputStream();
		                byte[] bytes = new byte[1024];
		                outputStream.write(base64.getBytes());
		                System.out.println("发送成功");
		                int len = inputStream.read(bytes);
		                if(len==-1){
		                	lblNewLabel.setText("图片太大");
		                }
		                else{
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
			                String flowerName="";
			                if(str.charAt(10)!='e'){
			                	flowerName=tool.getFlowerClass(tool.getFlowerIndex(strr,0));
			                }else{
			                //System.out.println(flowerImage);
			                	flowerName=tool.getFlowerClass(tool.getFlowerIndex(strr));
			                }
			                String []args1=new String[1];
		                	Result.setPath(path);
			                Result.setResult(flowerName);
			                Result.main(args1);
		                }
		            }catch (IOException e) {
		                e.printStackTrace();
		            }
			}
		});
		btnNewButton_1.setBounds(319, 275, 134, 52);
		contentPane.add(btnNewButton_1);
		
		if(path!=null){
			JLabel label = new JLabel("");
			label.setBounds(74, 13, 430, 196);
			contentPane.add(label);
			try {
				//为了显示BMP格式图片而加的内容
	        	File file = new File(path);
				Image image = ImageIO.read(file);
				label.setIcon(new ImageIcon(image));
				
				/*String temp1="哈哈哈";
				sessionStorage.setItem('testKey','这是一个测试的value值');
				String temp= "<html><font style=\"color:black;font-family: STKaiti;font-size:24;\" >这是测试</font></html>";
				label.setToolTipText(temp);    //当鼠标移动到图片上显示 temp的内容*/
			} catch (IOException e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}
		}
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("E:\\background1.jpg"));
		lblNewLabel_1.setBounds(0, 0, 567, 359);
		contentPane.add(lblNewLabel_1);
	}
}

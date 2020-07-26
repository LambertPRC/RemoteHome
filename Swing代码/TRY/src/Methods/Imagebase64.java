package Methods;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

import javax.imageio.ImageIO;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class Imagebase64{
	static BASE64Encoder encoder = new sun.misc.BASE64Encoder();
	static BASE64Decoder decoder = new sun.misc.BASE64Decoder();

	public static String getImageBinary(String path){     //输出图片的base64格式
		if(path!=null){
			File f = new File(path);
			try{
				BufferedImage bi = ImageIO.read(f);
				ByteArrayOutputStream baos = new ByteArrayOutputStream();
				ImageIO.write(bi, "jpg", baos);
				byte[] bytes = baos.toByteArray();
				System.out.println("本地图片转换Base64:" + encoder.encode(Objects.requireNonNull(bytes)));
				return encoder.encodeBuffer(bytes).trim();
			}catch (IOException e){
				 e.printStackTrace();
			}
		}
		return null;
	}

	public static void base64StringToImage(String base64String){		//根据base64还原图片
		try {
			byte[] bytes1 = decoder.decodeBuffer(base64String);
			ByteArrayInputStream bais = new ByteArrayInputStream(bytes1);
			BufferedImage bi1 = ImageIO.read(bais);
			File f1 = new File("d://out.jpg");
			ImageIO.write(bi1, "jpg", f1);
		} catch (IOException e){
			e.printStackTrace();
		}
	}
	public static void main(String[] args){
		//base64StringToImage(getImageBinary()); // base64 to image*/
	}
}
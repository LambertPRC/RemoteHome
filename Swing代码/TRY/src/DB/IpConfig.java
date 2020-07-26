package DB;

import java.io.FileInputStream;
import java.util.Properties;

public class IpConfig {
	private static Properties p=null;
	static {
		try {
			p=new Properties();
			p.load(new FileInputStream("E:\\eclipse\\TRY\\src\\Ip.properties"));
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static String getValue(String key) {
		return p.get(key).toString();
	}
}

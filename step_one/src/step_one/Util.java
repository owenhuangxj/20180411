package step_one;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Util {
	
	public static String getProperty(String key,String filename){
		String value = null;
		//Util.class.getClassLoader()��ȡ��Util.class�ļ�������������ô˼�����������ͬ·���µ�properties�ļ�
		InputStream in = Util.class.getClassLoader().getResourceAsStream("users.properties");
		Properties ppt = new Properties();
		try {
			ppt.load(in);//Ч����ͬ��FileInputStream fis = new FileInputStream(in);ֻ�������Ʋ�������ܶ��ļ�			
		} catch (IOException e) {
			e.printStackTrace();
		}
		value = ppt.getProperty(key);
		try {
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return value;
	}

}

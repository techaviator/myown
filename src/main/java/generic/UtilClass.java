package generic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class UtilClass {
	
	public static String getConfigFileInfo(String key)
	{
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\resources\\ConfigFile.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Properties prop = new Properties();
		try {
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return prop.getProperty(key);		
		
	}

}

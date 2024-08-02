package Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class propertiesUtil {
	
	public static String getValue(String key)
	{
	FileInputStream fis=null;
	try {
		fis = new FileInputStream(System.getProperty("user.dir") +"/src/main/java/Configurations/config.properties");
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	Properties prop= new Properties();
	try {
		prop.load(fis);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	String value=prop.getProperty(key);
	return value;
	
	}

	
	
}


package com.trello.qspiders.genericutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * This Class will give or facilitate file handiling to fetch the data from the diffrent files.
 * @author AJAY BOSS
 *
 */
public class FileUtility
{
	/**
	 * We can read the data from the properties file in the form of key and Value.
	 * @author QASM6
	 * @param key
	 * @return key
	 * @throws IOException
	 */
	public String readDataFromPropertyFile(String key) throws IOException {
		FileInputStream fis = new FileInputStream("./src/test/resource/trellocommondata.properties");
		Properties pobj = new Properties();
		pobj.load(fis);
		String value = pobj.getProperty(key);
		return value;
		
	}
}

package Utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class Appconfig {
	private static boolean headless;
	private static String chromePath;
	public static Appconfig appConfig;

	/**
	 * Read AppConfig.properties File and
	 * 
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public void readConfigSetting() throws FileNotFoundException, IOException {
		try {
			File file = new File("D:\\Shreyas\\salesforce\\ConfigFolder\\AppConfig.properties");// appconfig.properties
																								// path
			FileReader in = new FileReader(file);
			Properties p = new Properties();
			p.load(in);
			setHeadless(Boolean.valueOf(p.getProperty("headless")));
			setChromePath(p.getProperty("chromepath"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * 
	 * @return
	 */
	public static boolean isHeadless() {
		return headless;
	}

	/**
	 * 
	 * @param headless
	 */
	public void setHeadless(boolean headless) {
		this.headless = headless;
	}

	/**
	 * 
	 * @return
	 */
	public static String getChromePath() {
		return chromePath;
	}

	/**
	 * 
	 * @param chromePath
	 */
	public void setChromePath(String chromepath) {
		this.chromePath = chromepath;
	}

	/**
	 * 
	 * @return
	 */
}
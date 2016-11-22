package Grp1.base;

import org.apache.logging.log4j.*;

import Grp1.testCases.LoginTestCase;

public class ConfigurationClass {
	
	public final static Logger log = LogManager.getLogger(ConfigurationClass.class);
	
	public static String XLPath="C:\\Users\\Prithviraj\\workspace\\Selenium_PageObjectFramework\\LoginCreds.xlsx";
	public static String XLSheetName="Sheet1";
	public static String BrowserPicker="CD";

}

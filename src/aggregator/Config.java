package aggregator;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {

	static private Properties prop;
	static private String result = "";
	static private InputStream inStream;
	static private final String FILE_PATH = "./src/conf.properties";

	public static String getBingID() {

		try {
			prop = new Properties();
			inStream = new FileInputStream(new File(FILE_PATH));
			prop.load(inStream);
			result = prop.getProperty("bingID");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (inStream != null) {
				try {
					inStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
		return result;
	}
}

package org.bigfield.twitter;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.bigfield.twitter.param.AccessToken;

/**
 * Not implemented
 * 
 * @author yohira0616
 *
 */
public class PropertyLoader {

	public AccessToken loadAccessToken() {
		Properties prop = new Properties();
		try {
			InputStream stream = ClassLoader.getSystemResourceAsStream("token.properties");
			prop.load(stream);
			AccessToken token = new AccessToken();
			token.setConsumerKey(prop.getProperty("consumerKey"));
			token.setConsumerSecret(prop.getProperty("consumerSecret"));
			token.setAccessToken(prop.getProperty("accessToken"));
			token.setAccessTokenSecret(prop.getProperty("accessTokenSecret"));
			stream.close();
			return token;
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}

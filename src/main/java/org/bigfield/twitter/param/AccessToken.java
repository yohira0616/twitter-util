package org.bigfield.twitter.param;

import lombok.Data;

@Data
public class AccessToken {

	private String consumerKey;
	private String consumerSecret;
	private String accessToken;
	private String accessTokenSecret;

}

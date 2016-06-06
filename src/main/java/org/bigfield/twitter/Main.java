package org.bigfield.twitter;

import org.bigfield.twitter.operation.util.TwitterUtil;
import org.bigfield.twitter.param.AccessToken;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.impl.TwitterTemplate;

public class Main {

	public static void main(String[] args) {
		PropertyLoader loader = new PropertyLoader();

		AccessToken token = loader.loadAccessToken();
		Twitter twitter = new TwitterTemplate(token.getConsumerKey(), token.getConsumerSecret(), token.getAccessToken(),
				token.getAccessTokenSecret());
		TwitterUtil operation = new TwitterUtil(twitter);
		operation.noop();
		System.out.println("done");
	}
}

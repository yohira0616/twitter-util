package org.bigfield.twitter.operation.util;

import org.springframework.social.twitter.api.Twitter;

/**
 * ハッシュタグをつぶやいた人をフォローします wordには、ハッシュタグの先頭部#を除外した文字列を渡します
 * 
 * @author yohira0616
 *
 */
public class HashtagFollow {

	public void execute(Twitter twitter, String word) {
		twitter.searchOperations().search("#" + word, 100).getTweets().stream().forEach((tweet) -> {
			twitter.friendOperations().follow(tweet.getFromUser());
		});
	}

}
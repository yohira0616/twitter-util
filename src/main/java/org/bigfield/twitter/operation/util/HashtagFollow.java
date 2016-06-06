package org.bigfield.twitter.operation.util;

import org.springframework.social.twitter.api.CursoredList;
import org.springframework.social.twitter.api.Twitter;

/**
 * ハッシュタグをつぶやいた人をフォローします wordには、ハッシュタグの先頭部#を除外した文字列を渡します
 * 
 * @author yohira0616
 *
 */
public class HashtagFollow {

	public void execute(Twitter twitter, String word) {
		long myId = twitter.userOperations().getProfileId();
		CursoredList<Long> friends = twitter.friendOperations().getFriendIds();
		twitter.searchOperations().search("#" + word, 100).getTweets().stream().forEach((tweet) -> {
			if ((!friends.contains(tweet.getFromUserId())) && (myId != tweet.getFromUserId())) {
				twitter.friendOperations().follow(tweet.getFromUser());
			}
		});
	}

}

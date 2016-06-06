package org.bigfield.twitter.operation.util;

import org.springframework.social.twitter.api.CursoredList;
import org.springframework.social.twitter.api.Twitter;

/**
 * 相互フォロー以外をリムーブします
 * 
 * @author yohira0616
 *
 */
public class RemoveExceptMurualFollower {

	public void execute(Twitter twitter) {
		CursoredList<Long> followers = twitter.friendOperations().getFollowerIds();

		twitter.friendOperations().getFriendIds().forEach((friendId) -> {
			if (!followers.contains(friendId)) {
				twitter.friendOperations().unfollow(friendId);
			}
		});
	}

}

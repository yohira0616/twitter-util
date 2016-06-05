package org.bigfield.twitter.operation.util;

import org.springframework.social.twitter.api.Twitter;

/**
 * 相互フォロー以外をリムーブします
 * 
 * @author yohira0616
 *
 */
public class RemoveExceptMurualFollower {

	public void execute(Twitter twitter) {
		twitter.friendOperations().getFollowerIds().forEach((friendId) -> {
			if (!twitter.friendOperations().getFollowerIds().contains(friendId)) {
				twitter.friendOperations().unfollow(friendId);
			}
		});
	}

}

package org.bigfield.twitter.operation.util;

import org.springframework.social.OperationNotPermittedException;
import org.springframework.social.twitter.api.CursoredList;
import org.springframework.social.twitter.api.Twitter;

/**
 * フォロー返し
 * 
 * @author yohira0616
 *
 */
public class FollowReturn {

	public void execute(Twitter twitter) {
		CursoredList<Long> followerList = twitter.friendOperations().getFollowerIds();
		CursoredList<Long> friendList = twitter.friendOperations().getFriendIds();

		int count = 0;
		for (Long id : followerList) {
			if (!friendList.contains(id)) {
				try {
					twitter.friendOperations().follow(id);
				} catch (OperationNotPermittedException e) {
					e.printStackTrace();
				}
			}
		}
		/*
		 * int count=0;
		 * twitter.friendOperations().getFollowerIds().forEach((followerId) -> {
		 * if (!twitter.friendOperations().getFriendIds().contains(followerId))
		 * { twitter.friendOperations().follow(followerId); count++; } });
		 */
	}

}

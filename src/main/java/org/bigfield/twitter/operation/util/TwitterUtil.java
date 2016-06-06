package org.bigfield.twitter.operation.util;

import org.springframework.social.twitter.api.Twitter;

public class TwitterUtil {

	private Twitter twitter;

	// operations
	private FollowReturn followReturn = new FollowReturn();

	private HashtagFollow hashtagFollow = new HashtagFollow();

	private RemoveExceptMurualFollower removeExceptMurualFollower = new RemoveExceptMurualFollower();

	public TwitterUtil(Twitter twitter) {
		this.twitter = twitter;
	}

	public void followReturn() {
		followReturn.execute(twitter);
	}

	public void hashtagFollow(String word) {
		hashtagFollow.execute(twitter, word);
	}

	public void removeExceptMutualFollower() {
		removeExceptMurualFollower.execute(twitter);
	}

	public void noop() {
		// noop
	}

}

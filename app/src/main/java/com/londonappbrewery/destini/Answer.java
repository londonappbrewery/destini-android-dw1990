package com.londonappbrewery.destini;

/**
 * Created by User on 14.09.2017.
 */

public class Answer {
    int answerId;
    int followStoryId;

    public Answer(int answerId, int followStoryId) {
        this.answerId = answerId;
        this.followStoryId = followStoryId;
    }

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    public int getFollowStoryId() {
        return followStoryId;
    }

    public void setFollowStoryId(int followStoryId) {
        this.followStoryId = followStoryId;
    }
}

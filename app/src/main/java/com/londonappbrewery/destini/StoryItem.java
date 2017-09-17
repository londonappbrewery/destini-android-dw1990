package com.londonappbrewery.destini;

/**
 * Created by User on 14.09.2017.
 */

public class StoryItem {
    private int id;
    private int text;
    private boolean isEnd;


    public void setEnd(boolean end) {
        isEnd = end;
    }

    private Answer answerOne;
    private Answer answerTwo;

    public StoryItem(int id, int text, boolean isEnd) {
        this.id = id;
        this.text = text;
        this.isEnd = isEnd;
    }

    public StoryItem(int id, int text) {
        this.id = id;
        this.text = text;
    }

    public boolean isEnd() {
        return isEnd;
    }

    public int getId() {
        return id;
    }

    public int getText() {
        return text;
    }


    public Answer getAnswerOne() {
        return answerOne;
    }

    public void setAnswerOne(Answer answerOne) {
        this.answerOne = answerOne;
    }

    public Answer getAnswerTwo() {
        return answerTwo;
    }

    public void setAnswerTwo(Answer answerTwo) {
        this.answerTwo = answerTwo;
    }
}

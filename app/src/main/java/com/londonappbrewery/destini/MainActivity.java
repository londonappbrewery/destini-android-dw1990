package com.londonappbrewery.destini;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
    private TextView storyView;
    private Button topAnswerButton;
    private Button bottomAnswerButton;

    private StoryItem[] stories;

    private StoryItem currentItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initStories();
        linkUI();

        setCurrentStory(stories[0]);
        updateStoryAndButtonTexts();
    }

    private void initStories() {
        StoryItem story1 = new StoryItem(1, R.string.T1_Story);
        Answer s1Answer1 = new Answer(R.string.T1_Ans1, 3);
        Answer s1Answer2 = new Answer(R.string.T2_Ans2, 2);
        story1.setAnswerOne(s1Answer1);
        story1.setAnswerTwo(s1Answer2);

        StoryItem story2 = new StoryItem(2, R.string.T2_Story);
        Answer s2Answer1 = new Answer(R.string.T2_Ans1, 3);
        Answer s2Answer2 = new Answer(R.string.T2_Ans2, 4);
        story2.setAnswerOne(s2Answer1);
        story2.setAnswerTwo(s2Answer2);

        StoryItem story3 = new StoryItem(3, R.string.T3_Story);
        Answer s3Answer1 = new Answer(R.string.T3_Ans1, 6);
        Answer s3Answer2 = new Answer(R.string.T3_Ans2, 5);
        story3.setAnswerOne(s3Answer1);
        story3.setAnswerTwo(s3Answer2);

        StoryItem end4 = new StoryItem(4, R.string.T4_End, true);
        StoryItem end5= new StoryItem (5, R.string.T5_End, true);
        StoryItem end6 = new StoryItem(6, R.string.T6_End, true);

        this.stories = new StoryItem[]{story1, story2, story3, end4, end5, end6};
    }

    private void linkUI(){
        storyView = (TextView) findViewById(R.id.storyTextView);
        topAnswerButton = (Button) findViewById(R.id.buttonTop);
        bottomAnswerButton = (Button) findViewById(R.id.buttonBottom);
    };

    private void setCurrentStory(StoryItem item){
        this.currentItem = item;
    }

    private void updateStoryAndButtonTexts(){
        this.storyView.setText(currentItem.getText());

        if(currentItem.isEnd()){
            bottomAnswerButton.setVisibility(View.GONE);
            topAnswerButton.setVisibility(View.GONE);
            return;
        }

        if(currentItem.getAnswerOne() != null){
            topAnswerButton.setText(currentItem.getAnswerOne().getAnswerId());
        }

        if(currentItem.getAnswerTwo() != null){
            bottomAnswerButton.setText(currentItem.getAnswerTwo().getAnswerId());
        }

    }

    private void handleAnswer(int followupId){
        StoryItem nextStory = getStoryById(followupId);

        setCurrentStory(nextStory);
        updateStoryAndButtonTexts();
    }

    public void OnTopAnswerButtonClick(View view){
        handleAnswer(currentItem.getAnswerOne().getFollowStoryId());
    }

    public void OnBottomAnswerButtonClick(View view){
        handleAnswer(currentItem.getAnswerTwo().getFollowStoryId());
    }

    private StoryItem getStoryById(int id){
       for(StoryItem storyItem : stories){
           if(storyItem.getId() == id){
               return storyItem;
           }
       }
       return null;
    }
}

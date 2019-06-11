package com.example.medikan.ptsd_treatment;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "test_question_table")
public class TestQuestion {

    @PrimaryKey
    private int mQuestionID;
    @NonNull
    @ColumnInfo(name = "question")
    private String mQuestion;
    @ColumnInfo(name = "rating")
    private int mRating;

    public TestQuestion(@NonNull int questionID, @NonNull String question, int rating)
    {
        this.mQuestionID = questionID;
        this.mQuestion = question;
        this.mRating = rating;
    }

    public int getQuestionID() {return this.mQuestionID;}

    public String getQuestion() {return this.mQuestion;}

    public int getRating() {return this.mRating;}

    public void setRating(int rating) {mRating = rating;}
}

package com.example.medikan.ptsd_treatment;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface TestQuestionDao {

    @Insert
    void insert(TestQuestion testQuestion);

    @Query("DELETE FROM test_question_table")
    void deleteAll();

    @Query("SELECT * FROM test_question_table ORDER BY mQuestionID ASC")
    LiveData<List<TestQuestion>> getAllTestQuestions();

    @Update
    void updateTestQuestions(TestQuestion... testQuestions);
}

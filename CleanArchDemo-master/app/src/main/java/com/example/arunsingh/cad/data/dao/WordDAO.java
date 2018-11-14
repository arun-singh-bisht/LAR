package com.example.arunsingh.cad.data.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;


import com.example.arunsingh.cad.data.model.local.Word;

import java.util.List;

/**
 * Created by Arun.Singh on 9/11/2018.
 */

@Dao
public interface WordDAO {

    @Insert
    void addNewWord(Word word);

    @Query("SELECT * FROM word_table")
    LiveData<List<Word>> getAllWords();

    @Query("DELETE FROM word_table")
    void deleteAllWords();

}

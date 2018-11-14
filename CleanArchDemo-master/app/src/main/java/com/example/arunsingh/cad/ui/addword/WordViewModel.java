package com.example.arunsingh.cad.ui.addword;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import com.example.arunsingh.cad.data.model.local.Word;

import java.util.List;

/**
 * Created by Arun.Singh on 9/11/2018.
 */

public class WordViewModel extends AndroidViewModel {

    private WordRepository wordRepository;
    public WordViewModel(@NonNull Application application) {
        super(application);
        wordRepository = new WordRepository(application);
    }

    public void addNewWord(Word word)
    {
        wordRepository.addNewWord(word);
    }

    public void deleteAllWords()
    {
        wordRepository.deleteAllWord();
    }

    public LiveData<List<Word>> getAllWords()
    {
        return wordRepository.getAllWords();
    }
}

package com.example.night.presenter;

import androidx.fragment.app.Fragment;

import com.example.night.Bean.PersonalHistory;
import com.example.night.SQLiteHelper.model.PersonalHistoryModel;
import com.example.night.fragmentManage.indentFragment;

public class PersonalHistoryPresenter {
   Fragment intentFragment;
    PersonalHistoryModel personalHistoryModel;

    public PersonalHistoryPresenter(Fragment intentFragment) {
        this.intentFragment = intentFragment;
        this.personalHistoryModel = new PersonalHistoryModel();
    }

    public PersonalHistory getPersonalHistory() {
        return personalHistoryModel.getPersonalHistory();
    }
}

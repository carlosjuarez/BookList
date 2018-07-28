package com.juvcarl.batch.mcs.booklist.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.juvcarl.batch.mcs.booklist.model.objects.Item;
import com.juvcarl.batch.mcs.booklist.model.repository.DataRepository;
import com.juvcarl.batch.mcs.booklist.model.repository.RetrofitRepository;

import java.util.List;

public class BookListViewmodel extends ViewModel {

    private MutableLiveData<List<Item>> items;

    public void init() {
        if (items == null) {
            DataRepository dataRepository = RetrofitRepository.getInstance();
            items = dataRepository.getData();
        }
    }

    public MutableLiveData<List<Item>> getItems() {
        return items;
    }
}

package com.juvcarl.batch.mcs.booklist.model.repository;

import android.arch.lifecycle.MutableLiveData;

import com.juvcarl.batch.mcs.booklist.model.objects.Item;

import java.util.List;

public interface DataRepository {

    MutableLiveData<List<Item>> getData();
}

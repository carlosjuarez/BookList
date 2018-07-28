package com.juvcarl.batch.mcs.booklist.model.repository;

import com.juvcarl.batch.mcs.booklist.model.objects.Item;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIRequestClient {

    @GET("/books.json")
    Call<List<Item>> getItems();

}

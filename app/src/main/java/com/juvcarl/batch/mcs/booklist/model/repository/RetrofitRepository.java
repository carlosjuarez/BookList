package com.juvcarl.batch.mcs.booklist.model.repository;

import android.arch.lifecycle.MutableLiveData;

import com.juvcarl.batch.mcs.booklist.model.objects.Item;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitRepository implements DataRepository {

    private static RetrofitRepository instance = new RetrofitRepository();
    private APIRequestClient apiRequestClient;

    private RetrofitRepository() {
        Retrofit.Builder builder = new Retrofit.Builder().
                baseUrl("http://de-coding-test.s3.amazonaws.com").
                addConverterFactory(GsonConverterFactory.create());
        Retrofit retrofit = builder.build();

        apiRequestClient = retrofit.create(APIRequestClient.class);
    }

    public static DataRepository getInstance() {
        return instance;
    }

    public MutableLiveData<List<Item>> getData() {

        final MutableLiveData<List<Item>> data = new MutableLiveData<>();
        apiRequestClient.getItems().enqueue(new Callback<List<Item>>() {
            @Override
            public void onResponse(Call<List<Item>> call, Response<List<Item>> response) {
                if (response.isSuccessful()) {
                    data.setValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Item>> call, Throwable t) {
                data.setValue(null);
            }
        });
        return data;
    }

}

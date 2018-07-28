package com.juvcarl.batch.mcs.booklist;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.juvcarl.batch.mcs.booklist.adapter.ItemRecyclerViewAdapter;
import com.juvcarl.batch.mcs.booklist.databinding.FragmentItemListBinding;
import com.juvcarl.batch.mcs.booklist.model.objects.Item;
import com.juvcarl.batch.mcs.booklist.viewmodel.BookListViewmodel;

import java.util.List;
import java.util.Objects;

/**
 * A fragment representing a list of Items.
 */
public class ItemFragment extends Fragment {

    RecyclerView recyclerView;
    ItemRecyclerViewAdapter itemRecyclerViewAdapter;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public ItemFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        FragmentItemListBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_item_list, container, false);
        View view = binding.getRoot();
        recyclerView = binding.listitem;
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setNestedScrollingEnabled(true);

        BookListViewmodel bookListViewmodel = ViewModelProviders.of(Objects.requireNonNull(getActivity())).get(BookListViewmodel.class);
        bookListViewmodel.init();
        bookListViewmodel.getItems().observe(this, new Observer<List<Item>>() {
            @Override
            public void onChanged(@Nullable List<Item> items) {
                setupRecyclerView(items);
            }
        });
        return view;
    }

    private void setupRecyclerView(List<Item> itemList) {
        itemRecyclerViewAdapter = new ItemRecyclerViewAdapter(itemList);
        recyclerView.setAdapter(itemRecyclerViewAdapter);
        itemRecyclerViewAdapter.notifyDataSetChanged();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}

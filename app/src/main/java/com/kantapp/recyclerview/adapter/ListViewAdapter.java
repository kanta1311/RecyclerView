package com.kantapp.recyclerview.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kantapp.recyclerview.R;
import com.kantapp.recyclerview.viewholder.ListViewHolder;

import java.util.ArrayList;

/**
 * Created by Android-1 on 10/13/2017.
 */

public class ListViewAdapter extends RecyclerView.Adapter<ListViewHolder> {
    private ArrayList number;
    public ListViewAdapter(ArrayList number) {
        this.number=number;
    }


    @Override
    public ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.view_of_listview,parent,false);
        ListViewHolder listViewHolder=new ListViewHolder(view);
        return listViewHolder;
    }

    @Override
    public void onBindViewHolder(ListViewHolder holder, int position) {
        holder.Name.setText(String.valueOf(number.get(position)));
    }

    @Override
    public int getItemCount() {
        return number.size();
    }
}

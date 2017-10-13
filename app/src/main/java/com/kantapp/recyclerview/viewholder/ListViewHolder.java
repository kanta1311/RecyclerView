package com.kantapp.recyclerview.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.kantapp.recyclerview.R;

/**
 * Created by Android-1 on 10/13/2017.
 */

public class ListViewHolder extends RecyclerView.ViewHolder
{
    public TextView Name;
    public ListViewHolder(View itemView) {
        super(itemView);
        Name=itemView.findViewById(R.id.name);
    }
}

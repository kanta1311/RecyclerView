package com.kantapp.recyclerview.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.kantapp.recyclerview.R;
import com.kantapp.recyclerview.adapter.ListViewAdapter;

import java.util.ArrayList;

public class ListView extends AppCompatActivity {

    private ArrayList number;
    private RecyclerView listView;
    private RecyclerView.LayoutManager listViewManager;
    private RecyclerView.Adapter listViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        number=new ArrayList();
        for(int i=0;i<=20;i++)
        {
            number.add(i);
        }

        listView=(RecyclerView)findViewById(R.id.listView);

        listViewManager=new LinearLayoutManager(getApplication(),LinearLayoutManager.VERTICAL,false);
        listViewAdapter=new ListViewAdapter(number);

        listView.setHasFixedSize(true);
        listView.setLayoutManager(listViewManager);
        listView.setAdapter(listViewAdapter);

        listView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            GestureDetector gestureDetector=new GestureDetector(getApplicationContext(),new GestureDetector.SimpleOnGestureListener(){
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }
            });
            @Override
            public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
                View view=rv.findChildViewUnder(e.getX(),e.getY());
                if(view!=null && gestureDetector.onTouchEvent(e))
                {
                    int position=rv.getChildAdapterPosition(view);
                    Toast.makeText(ListView.this, "Position is "+position, Toast.LENGTH_SHORT).show();
                }
                return false;
            }

            @Override
            public void onTouchEvent(RecyclerView rv, MotionEvent e) {

            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        });
    }
}

package com.songmoo.anroid.bisiclist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerCardActivity extends AppCompatActivity {
    ArrayList<User> datas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_card);

        Data data = new Data();
        datas = data.get();
        //리스트뷰 가져오기
        RecyclerView rv = (RecyclerView)findViewById(R.id.recyclerView);
        //어댑터생성.
        CardAdapter ca = new CardAdapter(datas, this);
        //
        rv.setAdapter(ca);
        //
        rv.setLayoutManager(new LinearLayoutManager(this));
    }
}

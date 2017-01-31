package com.songmoo.anroid.bisiclist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerActivity extends AppCompatActivity {

    ArrayList<User> datas = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        Data data = new Data();
        datas = data.get();

        //1. Recycler 가져오기
        RecyclerView rv = (RecyclerView)findViewById(R.id.recyclerView);

        //2. Adapter 생성하기
        RecyclerCustomAdapter rca = new RecyclerCustomAdapter(datas, R.layout.list_holder_item); // 리스트의 id값이 넘어간다.
        //3. Recycler 뷰에 Adapter 새팅하기
        rv.setAdapter(rca);
        //4. Recycler 뷰 매니저 등록하기.( 뷰 모양을 결정: 그리드, 일반, 비대칭리스트 등등..)
        rv.setLayoutManager(new LinearLayoutManager(this));
    }
}

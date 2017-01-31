package com.songmoo.anroid.bisiclist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListActivity extends AppCompatActivity {
    ListView listView;
    String array[] = {"월","화","수","목","금","토","일"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        //1.리스트뷰 가져오기
        listView = (ListView)findViewById(R.id.listView);


        //2. 어댑터 정의
       // ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, array);
        CustomAdapter adapter = new CustomAdapter(array, this);

        //리스트뷰에 어댑터 셋팅.
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(listener);
    }
    //클릭 리스너 생성
    AdapterView.OnItemClickListener listener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
            //디테일 액티비티로 전환하기 위해 intent 생성.
            Intent intent = new Intent(ListActivity.this, DetailActivity.class);
            //넘길 데이터를 세팅하고
            intent.putExtra("no",position+1);
            intent.putExtra("day",array[position]);
            //액티비티 호출
            startActivity(intent);
        }
    };

}

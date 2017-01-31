package com.songmoo.anroid.bisiclist;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Random;

public class ListHolderActivity extends AppCompatActivity {
    ArrayList<User> datas = new ArrayList<>();
    private void load(){
        Random random = new Random(); //특정 범위의 무작위 난수 생성.


        //datas에 100의 User를 생성해서 담는다.
        for(int i=0; i<100; i++){
            User user = new User();

            user.id = i+1;
            user.name = "홍길동"+user.id;
            user.age =random.nextInt(80);
            //"1~80"사이의 숫자
            datas.add(user);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_holder);

        load();

        ListView listView = (ListView)findViewById(R.id.listView);
        CustomHolderAdapter adapter = new CustomHolderAdapter(datas, this);
        listView.setAdapter(adapter);
    }

    class CustomHolderAdapter extends BaseAdapter{
        ArrayList<User> datas;
        LayoutInflater inflater;
        public CustomHolderAdapter(ArrayList<User> datas, Context context) {
            this.datas = datas;
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return datas.size();
        }

        @Override
        public Object getItem(int position) {
            return datas.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            //뷰 행이 화면에 보여져서 생성된 적이 있다면 재사용.
            Holder holder;
            if(convertView == null){
                convertView = inflater.inflate(R.layout.list_holder_item,null);
                holder = new Holder();

                holder.txtNo = (TextView)convertView.findViewById(R.id.txtId);
                holder.txtName= (TextView)convertView.findViewById(R.id.txtName);
                holder.txtAge = (TextView)convertView.findViewById(R.id.txtAge);
                convertView.setTag(holder);
            }else{
                holder= (Holder)convertView.getTag();
            }

            User user = datas.get(position); //사용할 데이터 instance를 ArrayList에서 꺼낸다.
            holder.txtNo.setText(user.id + "");
            holder.txtName.setText(user.name);
            holder.txtAge.setText(user.age + "");
            return convertView;
        }
        //각행에서 사용되는 위젯을 재사용 하기위한 Holder클래스
        class Holder{
            public TextView txtNo;
            public TextView txtName;
            public TextView txtAge;


        }
    }
}

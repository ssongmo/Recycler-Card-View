package com.songmoo.anroid.bisiclist;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by Songmoo on 2017-01-31.
 */

public class RecyclerCustomAdapter extends RecyclerView.Adapter<RecyclerCustomAdapter.CustomViewHolder> {
    ArrayList<User> datas;
  //리스트 각 행에서 사용되는 layout xml의 아이디.
    int itemLayout;
    public RecyclerCustomAdapter(ArrayList<User> datas, int itemLayout){
        this.datas = datas;
        this.itemLayout = itemLayout;

    }
    //뷰를 생성해서 홀더에 저장하는 함수.
    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(itemLayout, parent, false);
        CustomViewHolder cvh = new CustomViewHolder(view);
        return cvh;
    }
    //listView에서의 get함수 역할
    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        User user = datas.get(position);

        holder.txtId.setText(user.id + "");
        holder.txtName.setText(user.name);
        holder.txtAge.setText(user.age + "");
    }

    // 데이터 총 개수
    @Override
    public int getItemCount() {
        return datas.size();
    }
//Recylcer 뷰에
    public class CustomViewHolder extends RecyclerView.ViewHolder {

        TextView txtId, txtName, txtAge;
        public CustomViewHolder(View view) {
            super(view);
            txtId = (TextView)view.findViewById(R.id.txtId);
            txtName = (TextView)view.findViewById(R.id.txtName);
            txtAge = (TextView)view.findViewById(R.id.txtAge);
        }
    }
}


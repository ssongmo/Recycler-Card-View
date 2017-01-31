package com.songmoo.anroid.bisiclist;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Songmoo on 2017-01-31.
 */

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.CustomViewHolder> {
    ArrayList<User> datas;
    Context context; //클릭처리, 애니메이션 등을 위한 시스템 자원사용이 필요

    public CardAdapter(ArrayList<User> datas, Context context){
        this.datas = datas;
        this.context= context;

    }
    //뷰를 생성해서 홀더에 저장하는 함수.
    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_card_item, parent, false);
        CustomViewHolder cvh = new CustomViewHolder(view);
        return cvh;
    }
    //listView에서의 get함수 역할
    @Override
    public void onBindViewHolder(CustomViewHolder holder, int position) {
        final User user = datas.get(position);

        holder.txtId.setText(user.id + "");
        holder.txtName.setText(user.name);
        holder.txtAge.setText(user.age + "");
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("no", user.id);
                intent.putExtra("name",user.name);

                context.startActivity(intent);
            }
        });
        //애니메이션
        Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
        holder.cardView.setAnimation(animation);
    }

    // 데이터 총 개수
    @Override
    public int getItemCount() {
        return datas.size();
    }
//Recylcer 뷰에
    public class CustomViewHolder extends RecyclerView.ViewHolder {

        TextView txtId, txtName, txtAge;
        CardView cardView;
        public CustomViewHolder(View view) {
            super(view);
            txtId = (TextView)view.findViewById(R.id.txtId);
            txtName = (TextView)view.findViewById(R.id.txtName);
            txtAge = (TextView)view.findViewById(R.id.txtAge);

            cardView = (CardView) view.findViewById(R.id.cardView);
        }
    }
}


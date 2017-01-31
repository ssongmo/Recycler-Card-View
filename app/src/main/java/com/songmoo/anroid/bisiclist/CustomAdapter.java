package com.songmoo.anroid.bisiclist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

/**
 * Created by Songmoo on 2017-01-31.
 */

public class CustomAdapter extends BaseAdapter{
    LayoutInflater inflater;
    String datas[];
    public CustomAdapter(String datas[], Context context){
        //getView함수에서 사용할 xml 레이아웃을 객체로 변환해주는 inflater를 가져온다.
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.datas = datas;
    }

    /**사용하는 데이터의 총 개수
     *
     * @return
     */
    @Override
    public int getCount() {
        return datas.length;
    }

    /**선택된 리스트 아이템
     *
     * @param position
     * @return
     */
    @Override
    public Object getItem(int position) {
        return datas[position];
    }

    /**아이템 인덱스 값
     *
     * @param position
     * @return
     */
    @Override
    public long getItemId(int position) {
        return position;
    }

    //리스트 어댑터에서 뷰는 한 행 단위이다.
    //한 행 단위를 개발자가 직접 만들어 넘겨줘야 한다.
    @Override
    public View getView(int position, View convertview, ViewGroup parent) {
        //한 행에 해당하는 레이아웃 xml를 뷰 객체로 만들어준다. inflater를 통해서
        if(convertview==null) //한번 화면에 셋팅됐던 행은 convertView에 담겨져서 돌아온다. 화면에 보이는 부분만 view를 할당해주고 사라지면 재활용한다.
            convertview =  inflater.inflate(R.layout.list_item, null);
        //View view =  inflater.inflate(R.layout.list_item, null);

        //inflate된 뷰를 통해서 findByViewId함수를 사용한다.
        TextView txtNo = (TextView)convertview.findViewById(R.id.textView);
        TextView txtDay = (TextView)convertview.findViewById(R.id.txtDay);
     //inclate 된 뷰의 위젯에 값을 세팅한다.
        txtNo.setText((position+1)+"");
        txtDay.setText(datas[position]);
        return convertview;
    }
}

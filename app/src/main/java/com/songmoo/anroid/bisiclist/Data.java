package com.songmoo.anroid.bisiclist;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Songmoo on 2017-01-31.
 */

public class Data {
    private ArrayList<User> datas;

    public ArrayList<User> get(){
        return datas;
    }

    public Data(){
        datas = new ArrayList<>();
        load();
    }
    private void load() {
        Random random = new Random(); //특정 범위의 무작위 난수 생성.


        //datas에 100의 User를 생성해서 담는다.
        for (int i = 0; i < 100; i++) {
            User user = new User();

            user.id = i + 1;
            user.name = "홍길동" + user.id;
            user.age = random.nextInt(80);
            //"1~80"사이의 숫자
            datas.add(user);
        }
    }

}

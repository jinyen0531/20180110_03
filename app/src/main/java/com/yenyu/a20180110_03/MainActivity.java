package com.yenyu.a20180110_03;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    Handler handler = new Handler() //新增一個handler
    {
        @Override
        public void handleMessage(Message msg) { //覆寫handlerMessage
            super.handleMessage(msg);
            Log.d("MSG","您已取得一個MESSAGE");
            //做動作
            Bundle b = msg.getData(); //包裹接受message內容
            String str = b.getString("DATA"); //拆開包裹內容
            Log.d("MSG","DATA"+str);
        }
    };

    public void click1(View v)
    {
        Message msg= new Message(); //新增一個message
        //handler.sendMessage(msg); //將message傳給handler
        Bundle b = new Bundle();
        b.putString("DATA","myDATA");
        msg.setData(b); //設定訊息內容(包裹)
        handler.sendMessageDelayed(msg,3000);
        //延遲時間傳送訊息給handler

    }
}

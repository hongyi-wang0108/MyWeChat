package com.example.mywechat;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<MyMsg> myMsgList = new ArrayList<>();
    private RecyclerView rv_main;
    private MyMsgAdapter adapter;
    private LinearLayoutManager linearLayoutManager;
    private EditText tv_main;
    private Button btn_main;
    private LinearLayout ll_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        rv_main = findViewById(R.id.rv_main);
        linearLayoutManager = new LinearLayoutManager(MainActivity.this);
        adapter = new MyMsgAdapter(myMsgList);
        tv_main = findViewById(R.id.tv_main);
        btn_main = findViewById(R.id.btn_main);
        ll_main = findViewById(R.id.ll_main);

        rv_main.setLayoutManager(linearLayoutManager);
        rv_main.setAdapter(adapter);

        btn_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = tv_main.getText().toString();
                if(!s.equals("")){
                    MyMsg msg = new MyMsg(MyMsg.TYPE_RIGHT_SEND,s);
                    myMsgList.add(msg);
                    adapter.notifyItemInserted(myMsgList.size()-1);
                    rv_main.scrollToPosition(myMsgList.size()-1);
                    tv_main.setText("");
                }
            }
        });
    }

    private void init() {
        MyMsg msg = new MyMsg(MyMsg.TYPE_LEFT_RECIVER,"hello,i am left");
        myMsgList.add(msg);
        msg = new MyMsg(MyMsg.TYPE_RIGHT_SEND,"i am right");
        myMsgList.add(msg);
    }

}
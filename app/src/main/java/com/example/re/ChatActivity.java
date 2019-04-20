package com.example.re;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.net.DatagramSocket;
import java.net.SocketException;

public class ChatActivity extends AppCompatActivity {
    private String ip;
    private RecyclerView chatlist;
    private Button button;
    private EditText inputmsg;
    private ChatAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        chatlist = findViewById(R.id.recyclerView);
        button = findViewById(R.id.button2);
        inputmsg = findViewById(R.id.editText);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        chatlist.setLayoutManager(linearLayoutManager);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    DatagramSocket datagramSocket;

    {
        try {
            datagramSocket = new DatagramSocket();
//            datagramSocket.receive();
        } catch (SocketException e) {
            e.printStackTrace();
        }
    }

}

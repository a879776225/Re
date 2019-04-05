package com.example.re;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;



import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


public class MainActivity extends AppCompatActivity {
//    private static final String TAG = ;
    public final String DATA_PATH=Environment.getExternalStorageDirectory().getPath()+"/redata";
    String filePath= Environment.getExternalStorageDirectory().getPath()+"/a.txt";

    private final String DATA_NAME="/sa.db";
    String url="http://192.168.43.169:8080/appService/servlet/LogVerify";
    private Button button;
    private EditText name;
    private EditText pwd;
    private Button offline;
    public  static final int up=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkPermission();
        button = findViewById(R.id.button);
        name = findViewById(R.id.textView);
        pwd = findViewById(R.id.textView3);

        offline = findViewById(R.id.offline);
        offline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actionStart(MainActivity.this,"","");
                Thread thread=new Thread(new Runnable() {
                    @Override
                    public void run() {
                        outPut();
                    }
                });
                thread.start();
                finish();
//                outPut();
//                name.setText(DATA_PATH);
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            try {


                send(name.getText().toString(), pwd.getText().toString());
//                    actionStart(MainActivity.this, name.getText().toString(), "");
            }catch (NullPointerException e){
                e.printStackTrace();
            }
            }
        });

    }

    public static void actionStart(Context context, String data1, String data2) {
        Intent intent = new Intent(context, Main2.class);
        intent.putExtra("param1", data1);
//        intent.putExtra("param2", data2);
        context.startActivity(intent);
    }


    private void checkPermission() {
        //检查权限（NEED_PERMISSION）是否被授权 PackageManager.PERMISSION_GRANTED表示同意授权
        if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {
            //用户已经拒绝过一次，再次弹出权限申请对话框需要给用户一个解释
            if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this, Manifest.permission
                    .WRITE_EXTERNAL_STORAGE)) {
                Toast.makeText(this, "请开通相关权限，否则无法正常使用本应用！", Toast.LENGTH_SHORT).show();
            }
            //申请权限
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},1);

        } else {
            Toast.makeText(this, "授权成功！", Toast.LENGTH_SHORT).show();

//            Log.e(TAG_SERVICE, "checkPermission: 已经授权！");
        }
    }



    private String send(final String name, final String pwd) {
         String responsData=null ;
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    OkHttpClient client = new OkHttpClient();
                    RequestBody requestBody=new FormBody.Builder()
                            .add("username",name)
                            .add("pwd",pwd).build();
                    Request request = new Request.Builder()
                            .url(url)
                            .post(requestBody)
                            .build();
                    Response response = client.newCall(request).execute();
                    String  responsData =response.body().string();
                            showResponse(responsData);


                } catch (Exception e) {
                    e.printStackTrace();
                }}
        }).start();

        return responsData;
    }


    private void showResponse(final String response) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                String s="true";
                if(s.equals(response))
                actionStart(MainActivity.this,name.getText().toString(),"");
               else
                   name.setText(response);
            }
        });
    }
    public void outPut(){
        File database=new File(DATA_PATH+DATA_NAME);
        InputStream in=null;
        File dir = new File(DATA_PATH);
        FileOutputStream out=null;
        if(!dir.exists()){
            dir.mkdir();
        }
        try {
            if(!(new File(DATA_PATH+DATA_NAME)).exists()) {
                in = getResources().openRawResource(R.raw.sa);
                out = new FileOutputStream(database);
                byte[] buff = new byte[204800];
                int hasread;
                while ((hasread = in.read(buff)) > 0) {
                    out.write(buff, 0, hasread);
                }
            }
            if(out!=null&&in!=null){
            out.close();
            in.close();}
//            Toast.makeText(MainActivity.this,"输出成功",Toast.LENGTH_LONG).show();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}

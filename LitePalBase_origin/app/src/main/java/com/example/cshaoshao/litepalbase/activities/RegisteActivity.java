package com.example.cshaoshao.litepalbase.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.cshaoshao.litepalbase.R;
import com.example.cshaoshao.litepalbase.entities.Message;
import com.example.cshaoshao.litepalbase.entities.MyUrl;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by cshaoshao on 2017/6/13.
 */
public class RegisteActivity extends AppCompatActivity implements View.OnClickListener {
    @BindViews({R.id.account,R.id.name,R.id.tutorName,R.id.role,R.id.password,R.id.confirmPassword})
    public List<EditText>list;
    @BindViews({R.id.back,R.id.registe})
    public List<Button>buttonList;
    @BindView(R.id.spinner)
    public Spinner spinner;
    private String arr[];
    String type;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registeview);
        ButterKnife.bind(this);
        buttonList.get(0).setOnClickListener(this);
        buttonList.get(1).setOnClickListener(this);
        arr=getResources().getStringArray(R.array.spingarr);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               list.get(3).setText(arr[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.back:
                Intent intent=new Intent(RegisteActivity.this,LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.registe:
                final String uid=list.get(0).getText().toString();
                final String name=list.get(1).getText().toString();
                final String mentor=list.get(2).getText().toString();
                String kind=list.get(3).getText().toString();
                final String pw1=list.get(4).getText().toString();
                final String pw2=list.get(5).getText().toString();
                final String type ;
                if(kind.contains("在校学生"))
                {
                    kind="2";
                }
                else
                {
                    kind="3";
                }
                type=kind;
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            OkHttpClient okHttpClient = new OkHttpClient();
                            RequestBody requestBody = new FormBody.Builder().add("uid", uid)
                                    .add("name",name).add("kind", type).add("pw1",pw1).add("pw2",pw2)
                                    .add("mentor",mentor).build();
                            Request request = new Request.Builder().url(MyUrl.URLSave).post(requestBody).build();
                            Response response = okHttpClient.newCall(request).execute();
                            String responseData = response.body().string();
                            showJson(responseData);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }).start();
                break;
            default:
                break;
        }

    }

    private void showJson(String responseData)
    {
        if(responseData!=null)
        {
            final Message message=new Gson().fromJson(responseData, Message.class);
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if(message.getFlag().contains("Success"))
                    {
                        Toast.makeText(RegisteActivity.this,"注册成功，等待审核",Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(RegisteActivity.this,LoginActivity.class);
                        startActivity(intent);
                    }
                    else if(message.getFlag().contains("Error"))
                    {
                        Toast.makeText(RegisteActivity.this,"注册失败，请再次注册",Toast.LENGTH_SHORT).show();
                    }
                }
            });

        }
    }
}

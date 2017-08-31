package com.example.cshaoshao.litepalbase.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.cshaoshao.litepalbase.R;
import com.example.cshaoshao.litepalbase.entities.Message;
import com.example.cshaoshao.litepalbase.entities.MyUrl;
import com.example.cshaoshao.litepalbase.utils.LogUtil;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import butterknife.BindViews;
import butterknife.ButterKnife;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by cshaoshao on 2017/6/12.
 */

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    @BindViews({R.id.denglu,R.id.zhuce})
    public List<ImageButton>buttonList;
    private EditText et_user, et_password;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginview);
        ButterKnife.bind(this);
        et_user = (EditText) findViewById(R.id.zhanghao);
        et_password = (EditText) findViewById(R.id.mima);
        et_password.setTransformationMethod(PasswordTransformationMethod.getInstance());
        buttonList.get(0).setOnClickListener(this);
        buttonList.get(1).setOnClickListener(this);
    }
    @Override
    public void onClick(View v)
    {
        if(v.getId()==R.id.denglu)
        {
            final String user = et_user.getText().toString();
            final String password = et_password.getText().toString();
            LogUtil.d("hello", user + "..." + password);
            if (user!=null&& password!=null) {
                LogUtil.d("hello", user + "..." + password);
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            OkHttpClient okHttpClient = new OkHttpClient();
                            RequestBody requestBody = new FormBody.Builder().add("uid", user).add("password", password).build();
                            Request request = new Request.Builder().url(MyUrl.URL).post(requestBody).build();
                            Response response = okHttpClient.newCall(request).execute();
                            String responseData = response.body().string();
                            LogUtil.d("heihei", responseData);
                            Message message = new Gson().fromJson(responseData, Message.class);
                            shouMessage(message);
                        } catch (IOException e) {
                            e.printStackTrace();
                            LogUtil.d("hello", e.getMessage());
                        }
                    }
                }).start();
            }
        } else if(v.getId()==R.id.zhuce){
            Intent intent1=new Intent(LoginActivity.this,RegisteActivity.class);
            startActivity(intent1);
        }
    }

    private void shouMessage(final Message message)
    {
        if(message!=null)
        {
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if(message.getFlag().contains("Success")) {
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                       //intent.putExtra("info",message);
                        Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                        startActivity(intent);
                    }
                        else
                        {
                            if(message.getMsg().contains("123")) {
                                Toast.makeText(LoginActivity.this, "密码或者账号错误，请重新输入", Toast.LENGTH_SHORT).show();
                            }
                            else if(message.getMsg().contains("456"))
                            {
                                Toast.makeText(LoginActivity.this,"密码或者账号为空，请重新输入",Toast.LENGTH_SHORT).show();
                            }
                        }

                    }
            });
        }
    }
}

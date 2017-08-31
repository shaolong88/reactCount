package com.example.cshaoshao.litepalbase.activities;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.cshaoshao.litepalbase.R;
import com.example.cshaoshao.litepalbase.entities.MyUrl;

import java.io.IOException;

import butterknife.BindView;
import butterknife.ButterKnife;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * Created by cshaoshao on 2017/6/26.
 */

public class TestActivity extends AppCompatActivity
{
    @BindView(R.id.textTest)
    TextView textView;
    private Handler handle=new Handler()
    {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Bundle data=msg.getData();
            String value=data.getString("value");
            textView.setText(value);
        }
    };
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_layout);
        ButterKnife.bind(this);
        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    OkHttpClient client=new OkHttpClient();
                    RequestBody body=new FormBody.Builder().build();
                    Request request=new Request.Builder().url(MyUrl.URL).post(body).build();
                    Response response=client.newCall(request).execute();
                    String str=response.body().string();
                    Message message=new Message();
                    Bundle bundle=new Bundle();
                    bundle.putString("value",str);
                    message.setData(bundle);
                    handle.sendMessage(message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}

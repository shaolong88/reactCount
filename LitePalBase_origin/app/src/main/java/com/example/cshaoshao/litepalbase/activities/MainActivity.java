package com.example.cshaoshao.litepalbase.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.example.cshaoshao.litepalbase.R;
import com.example.cshaoshao.litepalbase.entities.Message;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    private List<Message.DataBean> list=new ArrayList<>();
    private ArrayList<Message.DataBean.FunctionBean>totalist=new ArrayList<>();
    private ArrayList<Message.DataBean.FunctionBean>beanlist=new ArrayList<>();
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test_layout);
        ButterKnife.bind(this);
//        Intent intent=getIntent();
//        Message message=intent.getParcelableExtra("info");
//        list=message.getData();
//        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
//        for (int i = 0; i <list.size() ; i++)
//        {
//            totalist.addAll(list.get(i).getFunction());
//        }
//        RecyclerAdapter adapter=new RecyclerAdapter(this,list);
//        recyclerView.setAdapter(adapter);
    }

}

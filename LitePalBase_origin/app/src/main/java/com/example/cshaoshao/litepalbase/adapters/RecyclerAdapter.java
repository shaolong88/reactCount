package com.example.cshaoshao.litepalbase.adapters;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cshaoshao.litepalbase.R;
import com.example.cshaoshao.litepalbase.entities.Message;

import java.util.List;

/**
 * Created by cshaoshao on 2017/7/24.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.Holder>  {
    private Context context;
    private List<Message.DataBean> list;

    public RecyclerAdapter(Context context, List<Message.DataBean> list) {
        this.context=context;
        this.list=list;
    }
//    public RecyclerAdapter(Context context, ArrayList<Message.DataBean> list) {
//        this.context=context;
//        this.list=list;
//    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (context==null)
        {
            context=parent.getContext();
        }
        View view= LayoutInflater.from(context).inflate(R.layout.item_layout,parent,false);
        Holder holder=new Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        Message.DataBean bean =list.get(position);
        holder.tv.setText(bean.getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Holder extends RecyclerView.ViewHolder
    {
        TextView tv;
        CardView cardView;
        public Holder(View itemView) {
            super(itemView);
            cardView= (CardView) itemView;
            tv= (TextView) itemView.findViewById(R.id.modlename);
        }
    }
}


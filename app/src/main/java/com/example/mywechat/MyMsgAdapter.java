package com.example.mywechat;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

class MyMsgAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    class MyViewHolder extends RecyclerView.ViewHolder{
        LinearLayout linearLayoutright;
        LinearLayout linearLayoutleft;
        TextView textViewright;
        TextView textViewleft;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            linearLayoutleft = itemView.findViewById(R.id.ll_left);
            linearLayoutright = itemView.findViewById(R.id.ll_right);
            textViewright = itemView.findViewById(R.id.tv_item_right);
            textViewleft = itemView.findViewById(R.id.tv_item_left);
        }
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        myViewholder = new MyViewHolder(view);
        return myViewholder;
    }
    private MyViewHolder myViewholder;
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {//卡了
        MyMsg msg = mlist.get(position);
        myViewholder = (MyViewHolder) holder;
        if(msg.getType() == msg.TYPE_RIGHT_SEND){
            myViewholder.textViewright.setText(msg.getContent());
            myViewholder.linearLayoutright.setVisibility(View.VISIBLE);
            myViewholder.linearLayoutleft.setVisibility(View.INVISIBLE);
        }else if(msg.getType() == msg.TYPE_LEFT_RECIVER){
            myViewholder.textViewleft.setText(msg.getContent());
            myViewholder.linearLayoutright.setVisibility(View.INVISIBLE);
            myViewholder.linearLayoutleft.setVisibility(View.VISIBLE);
        }

    }
    private List<MyMsg> mlist;
    public MyMsgAdapter(List<MyMsg> list) {
        mlist = list;
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }
}

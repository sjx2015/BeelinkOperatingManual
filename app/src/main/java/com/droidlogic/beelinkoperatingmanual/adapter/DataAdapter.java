package com.droidlogic.beelinkoperatingmanual.adapter;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.droidlogic.beelinkoperatingmanual.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DataAdapter extends BaseAdapter {
    private LayoutInflater mInflater;
    private List<Map<String,Object>> list;


    public DataAdapter(Context context , List<Map<String,Object>> list){

        this.mInflater = LayoutInflater.from(context);
        this.list = list;
    }


    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub

        ViewHolder holder = null;

        if (convertView == null) {

            holder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.list_item, null);
            holder.title = (TextView)convertView.findViewById(R.id.txt);
            holder.icon = (ImageView)convertView.findViewById(R.id.img);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder)convertView.getTag();
        }

        holder.title.setText(convertView.getResources().getText((Integer) list.get(position).get("title")));
        holder.icon.setBackgroundResource((Integer)list.get(position).get("icon"));

        return convertView;
    }


    public final class ViewHolder{

        public TextView title;
        public ImageView icon;


    }
}
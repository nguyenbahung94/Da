package com.example.ntex_user.testapp;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by NTex-User on 3/22/2017.
 */

public class CustomAdapter extends ArrayAdapter<ModelData> {
    private List<ModelData> listData = null;
    private List<ModelData> listSearch;
    private Context mContext;

    private LayoutInflater mLayoutInflater;

    public CustomAdapter(Context context, int source, List<ModelData> listData) {
        super(context, source, listData);
        this.listData = listData;
        mContext = context;
        listSearch = new ArrayList<ModelData>();
        listSearch.addAll(listData);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        final ViewHolder viewHolder;
        mLayoutInflater = ((Activity) mContext).getLayoutInflater();
        if (convertView == null) {
            viewHolder = new ViewHolder();

            convertView = mLayoutInflater.inflate(R.layout.fragment_custom_item_listview, parent, false);
            viewHolder.imgBank = (ImageView) convertView.findViewById(R.id.img_bank);
            viewHolder.imgChose = (ImageView) convertView.findViewById(R.id.img_chose);
            viewHolder.moneyUser = (TextView) convertView.findViewById(R.id.tv_money);
            viewHolder.nameBank = (TextView) convertView.findViewById(R.id.tvname_bank);
            viewHolder.nameUser = (TextView) convertView.findViewById(R.id.tvname_user);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.nameBank.setText(listData.get(position).getNameBank());
        viewHolder.moneyUser.setText(listData.get(position).getMoney() + "");
        viewHolder.nameUser.setText(listData.get(position).getNameUser());
        viewHolder.imgBank.setImageResource(listData.get(position).getImgBank());
        viewHolder.imgChose.setImageResource(listData.get(position).getImgChose());
        return convertView;
    }

    private static class ViewHolder {
        ImageView imgBank;
        TextView nameUser;
        TextView nameBank;
        TextView moneyUser;
        ImageView imgChose;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Nullable
    @Override
    public ModelData getItem(int position) {
        return listData.get(position);
    }

    @Override
    public int getCount() {
        return listData.size();
    }

    public void clearlistdata() {
        listData.clear();
        listData.addAll(listSearch);
    }

    public void fillter(String chartext) {
        chartext = chartext.toLowerCase(Locale.getDefault());
        listData.clear();
        if (chartext.length() == 0) {
            listData.addAll(listSearch);
        } else {
            for (ModelData ss : listSearch) {
                String tam = ss.getNameUser();
                if (tam.toLowerCase(Locale.getDefault()).contains(chartext)) {
                    listData.add(ss);
                    Log.e("Data", ss.getNameUser());
                }
            }
        }
        notifyDataSetChanged();
    }
}

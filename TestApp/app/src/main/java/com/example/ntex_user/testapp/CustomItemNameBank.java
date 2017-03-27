package com.example.ntex_user.testapp;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by NTex-User on 3/27/2017.
 */

public class CustomItemNameBank extends ArrayAdapter<String> {
    private List<String> mlistData;
    private List<String> mlistSearch;
    private Context mContext;
    private LayoutInflater mlayout;

    public CustomItemNameBank(Context context, int resource, List<String> listdata) {
        super(context, resource, listdata);
        mContext = context;
        mlistData = listdata;
        mlistSearch = new ArrayList<String>();
        mlistSearch.addAll(mlistData);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        final ViewHolder viewHolder;
        mlayout = ((Activity) getContext()).getLayoutInflater();
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = mlayout.inflate(R.layout.fragment_custom_itemnamebank, parent, false);
            viewHolder.nameofbank = (TextView) convertView.findViewById(R.id.tvnameitem);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        viewHolder.nameofbank.setText(mlistData.get(position));
        return convertView;
    }

    @Nullable
    @Override
    public String getItem(int position) {
        return mlistData.get(position);
    }

    @Override
    public int getCount() {
        return mlistData.size();
    }

    private static class ViewHolder {
        TextView nameofbank;
    }

    public void fillter(String chartext) {
        chartext = chartext.toLowerCase(Locale.getDefault());
        mlistData.clear();
        if (chartext.length() == 0) {
            mlistData.addAll(mlistSearch);
        } else {
            for (String ss : mlistSearch) {
                if (ss.toLowerCase(Locale.getDefault()).contains(chartext)) {
                    mlistData.add(ss);
                }
            }
        }
        notifyDataSetChanged();
    }
}

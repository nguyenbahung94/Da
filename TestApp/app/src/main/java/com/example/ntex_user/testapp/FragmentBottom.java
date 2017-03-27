package com.example.ntex_user.testapp;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;

/**
 * Created by NTex-User on 3/27/2017.
 */

public class FragmentBottom extends Fragment implements RadioButton.OnClickListener {
    private RadioButton rbdskt, rdbsothe;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_receive_money, container, false);
        rbdskt=(RadioButton)root.findViewById(R.id.rdb_stk);
        rdbsothe=(RadioButton)root.findViewById(R.id.rdb_sothe);
        rbdskt.setOnClickListener(this);
        rdbsothe.setOnClickListener(this);
        return root;
    }

    @Override
    public void onClick(View v) {
        boolean checked=((RadioButton)v).isChecked();
        switch (v.getId()){
            case R.id.rdb_stk:
                if (checked){
                    Log.e("radio","so tai khoan");
                    rdbsothe.setChecked(false);
                }
                break;
            case R.id.rdb_sothe:
                if (checked){
                    Log.e("radio","so the");
                    rbdskt.setChecked(false);
                }
                break;
        }

    }
}

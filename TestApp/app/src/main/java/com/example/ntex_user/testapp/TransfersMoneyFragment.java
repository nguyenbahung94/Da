package com.example.ntex_user.testapp;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by NTex-User on 3/22/2017.
 */

public class TransfersMoneyFragment extends Fragment {
    private List<ModelData> listData;
    private ListView listViewsmall, listViewAll;
    private CustomAdapter mCustomAdapter, mCustomAdapterofDialog;
    private EditText search, seachInDialog;
    private Button btnCancel;
    private LinearLayout layoutlistview;
    private View root;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        root = inflater.inflate(R.layout.fragment_transfers_money, container, false);
        search = (EditText) root.findViewById(R.id.edt_search);
        layoutlistview = (LinearLayout) root.findViewById(R.id.layout_listview);
        listViewsmall = (ListView) root.findViewById(R.id.mylistviewtransfer);
        Toolbar toolbar = (Toolbar) root.findViewById(R.id.toolbar);
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
        ActionBar actionBar = ((AppCompatActivity) getActivity()).getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowCustomEnabled(true);
            actionBar.setCustomView(R.layout.custom_toolbar);
            actionBar.setDisplayShowTitleEnabled(false);
        }
        init();
        return root;
    }

    public void init() {
        FragmentHeader fmhd = new FragmentHeader();
        swapFragmentNext(fmhd);
        FragmentBottom fmbt=new FragmentBottom();
        addFragmentBottom(fmbt);
        search.setFocusable(false);
        listData = new ArrayList<ModelData>();
        mCustomAdapter = new CustomAdapter(getActivity(), R.layout.fragment_custom_item_listview, listData);
        listViewsmall.setAdapter(mCustomAdapter);
        addData();
        search.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    final AlertDialog.Builder alertdialog = new AlertDialog.Builder(getActivity(), R.style.AppTheme);
                    LayoutInflater inflater1 = getActivity().getLayoutInflater();
                    final View view = inflater1.inflate(R.layout.fragment_tranfer, null);
                    seachInDialog = (EditText) view.findViewById(R.id.edt_search);
                    seachInDialog.addTextChangedListener(new TextWatcher() {
                        @Override
                        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                        }

                        @Override
                        public void onTextChanged(CharSequence s, int start, int before, int count) {
                            if (TextUtils.isEmpty(seachInDialog.getText())) {
                                mCustomAdapterofDialog.fillter("");
                            } else {
                                String text = seachInDialog.getText().toString().toLowerCase(Locale.getDefault());
                                mCustomAdapterofDialog.fillter(text);
                            }
                        }

                        @Override
                        public void afterTextChanged(Editable s) {

                        }
                    });
                    btnCancel = (Button) view.findViewById(R.id.btn_cancel);
                    listViewAll = (ListView) view.findViewById(R.id.mylistview);
                    mCustomAdapterofDialog = new CustomAdapter(getActivity(), R.layout.fragment_custom_item_listview, listData);
                    listViewAll.setAdapter(mCustomAdapterofDialog);
                    alertdialog.setView(view);
                    final AlertDialog createDialog = alertdialog.create();
                    createDialog.show();
                    btnCancel.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            mCustomAdapterofDialog.clearlistdata();
                            createDialog.dismiss();

                        }
                    });
                }
                return false;
            }
        });
    }

    public void addData() {
        listData.add(new ModelData("Nguyễn Hạo Nhiên", "AAA", 999999999, R.drawable.logo_acb, R.drawable.more));
        listData.add(new ModelData("Nguyễn Hạo Nhiên", "BBB", 999999999, R.drawable.logo_acb, R.drawable.more));
        listData.add(new ModelData("Nguyễn Hạo Nhiên", "CCC", 999999999, R.drawable.logo_acb, R.drawable.more));
        listData.add(new ModelData("Nguyễn Hạo Nhiên", "DDD", 999999999, R.drawable.logo_acb, R.drawable.more));
        listData.add(new ModelData("Nguyễn Hạo Nhiên", "EEE", 999999999, R.drawable.logo_acb, R.drawable.more));
        listData.add(new ModelData("Nguyễn Hạo Nhiên", "FFF", 999999999, R.drawable.logo_acb, R.drawable.more));
        listData.add(new ModelData("Nguyễn Hạo Nhiên", "GGG", 999999999, R.drawable.logo_acb, R.drawable.more));
        listData.add(new ModelData("Nguyễn Hạo Nhiên", "HHH", 999999999, R.drawable.logo_acb, R.drawable.more));
        listData.add(new ModelData("Nguyễn Hạo Nhiên", "III", 999999999, R.drawable.logo_acb, R.drawable.more));
        listData.add(new ModelData("Nguyễn Hạo Nhiên", "KKK", 999999999, R.drawable.logo_acb, R.drawable.more));
        listData.add(new ModelData("Nguyễn Hạo Nhiên", "LLL", 999999999, R.drawable.logo_acb, R.drawable.more));
        listData.add(new ModelData("Nguyễn Hạo Nhiên", "MMM", 999999999, R.drawable.logo_acb, R.drawable.more));
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.search_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    public void swapFragmentNext(Fragment fragment) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fm_header, fragment);
        fragmentTransaction.commit();
    }
    public void addFragmentBottom(Fragment fragment) {
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.bottom, fragment);
        fragmentTransaction.commit();
    }
}

package com.example.ntex_user.testapp;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * Created by NTex-User on 3/27/2017.
 */

public class FragmentChoseBank extends Fragment implements RadioButton.OnClickListener {
    private List<String> listBank;
    private List<String> listCity;
    private RadioButton rdbstk, rdbsothe;
    private List<String> listBranch;
    private View inclChosebank,inclCardNumber;
    private TextView tvnNameBank, tvfullNameBankChose, tvNameBankChose;
    private RelativeLayout relativeNameBank, relativeNameBankChose;
    private LinearLayout layoutCitychose, layoutCity, layoutBranch,layoutBranchChose;
    private TextView tvNameCityChose, tvFullNameCity, tvNameCity, tvBankChose,tvFullNameBranch,tvNameBranch;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_chose_bank, container, false);
        rdbstk = (RadioButton) root.findViewById(R.id.rdb_stk);
        rdbsothe = (RadioButton) root.findViewById(R.id.rdb_sothe);
        rdbstk.setChecked(true);
        relativeNameBank = (RelativeLayout) root.findViewById(R.id.rela_namebank);
        tvnNameBank = (TextView) relativeNameBank.findViewById(R.id.tv_namebank);
        relativeNameBankChose = (RelativeLayout) root.findViewById(R.id.rela_namebankchose);
        tvfullNameBankChose = (TextView) relativeNameBankChose.findViewById(R.id.tv_fullnamebankchose);
        tvNameBankChose = (TextView) relativeNameBankChose.findViewById(R.id.tv_namebankchose);
        layoutCitychose = (LinearLayout) root.findViewById(R.id.linnear_citychose);
        tvNameCityChose = (TextView) root.findViewById(R.id.tv_namecitychose);
        layoutCity = (LinearLayout) root.findViewById(R.id.linear_city);
        tvFullNameCity = (TextView) layoutCity.findViewById(R.id.tv_fullnamecity);
        tvNameCity = (TextView) layoutCity.findViewById(R.id.tv_namecity);
        tvBankChose = (TextView) root.findViewById(R.id.tvbranchchose);
        layoutBranchChose=(LinearLayout)root.findViewById(R.id.linear_branchchose);
        layoutBranch = (LinearLayout) root.findViewById(R.id.linear_branchch);
        tvFullNameBranch=(TextView)layoutBranch.findViewById(R.id.tv_fullnamebranch);
        tvNameBranch=(TextView)layoutBranch.findViewById(R.id.tv_namebranch);
        rdbsothe.setOnClickListener(this);
        rdbstk.setOnClickListener(this);
        inclChosebank = (View) root.findViewById(R.id.incl_chosebank);
        inclCardNumber = (View) root.findViewById(R.id.incl_cardnumber);
        tvnNameBank = (TextView) inclChosebank.findViewById(R.id.tv_namebank);
        listBank = new ArrayList<String>();
        listCity = new ArrayList<String>();
        listBranch = new ArrayList<String>();
        addlist();
        handlerEvent();
        return root;
    }

    public void handlerEvent() {
        tvnNameBank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder alertdialog = new AlertDialog.Builder(getActivity(), R.style.AppTheme);
                LayoutInflater inflater1 = getActivity().getLayoutInflater();
                final View view = inflater1.inflate(R.layout.fragment_tranfer, null);
                final TextView seachInDialog = (EditText) view.findViewById(R.id.edt_search);
                seachInDialog.requestFocus();
                final CustomItemNameBank mCustomItemNameBank = new CustomItemNameBank(getActivity(), R.layout.fragment_custom_itemnamebank, listBank);
                seachInDialog.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        if (TextUtils.isEmpty(seachInDialog.getText())) {
                            mCustomItemNameBank.fillter("");
                        } else {
                            String text = seachInDialog.getText().toString().toLowerCase(Locale.getDefault());
                            mCustomItemNameBank.fillter(text);
                        }
                    }

                    @Override
                    public void afterTextChanged(Editable s) {

                    }
                });
                final Button btnCancel = (Button) view.findViewById(R.id.btn_cancel);
                final ListView listViewAll = (ListView) view.findViewById(R.id.mylistview);
                listViewAll.setAdapter(mCustomItemNameBank);
                alertdialog.setView(view);
                final AlertDialog createDialog = alertdialog.create();
                createDialog.show();
                listViewAll.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String tam = listBank.get(position);
                        Log.e("positinon", tam);
                        tvfullNameBankChose.setText(tam);
                        tvNameBankChose.setText(tam);
                        relativeNameBank.setVisibility(View.INVISIBLE);
                        relativeNameBankChose.setVisibility(View.VISIBLE);
                        createDialog.dismiss();
                    }
                });
                btnCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        createDialog.dismiss();

                    }
                });

            }
        });
        tvNameCityChose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder alertdialog = new AlertDialog.Builder(getActivity(), R.style.AppTheme);
                LayoutInflater inflater1 = getActivity().getLayoutInflater();
                final View view = inflater1.inflate(R.layout.fragment_tranfer, null);
                final TextView seachInDialog = (EditText) view.findViewById(R.id.edt_search);
                seachInDialog.requestFocus();
                final CustomItemNameBank mCustomItemNameBank = new CustomItemNameBank(getActivity(), R.layout.fragment_custom_itemnamebank, listCity);

                seachInDialog.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        if (TextUtils.isEmpty(seachInDialog.getText())) {
                            mCustomItemNameBank.fillter("");
                        } else {
                            String text = seachInDialog.getText().toString().toLowerCase(Locale.getDefault());
                            mCustomItemNameBank.fillter(text);
                        }
                    }

                    @Override
                    public void afterTextChanged(Editable s) {

                    }
                });
                final Button btnCancel = (Button) view.findViewById(R.id.btn_cancel);
                final ListView listViewAll = (ListView) view.findViewById(R.id.mylistview);
                listViewAll.setAdapter(mCustomItemNameBank);
                alertdialog.setView(view);
                final AlertDialog createDialog = alertdialog.create();
                createDialog.show();
                listViewAll.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String tam = listCity.get(position);
                        tvNameCity.setText(tam);
                        tvFullNameCity.setText(tam);
                        layoutCity.setVisibility(View.VISIBLE);
                        layoutCitychose.setVisibility(View.GONE);
                        createDialog.dismiss();
                    }
                });
                btnCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        createDialog.dismiss();

                    }
                });

            }
        });
        tvBankChose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder alertdialog = new AlertDialog.Builder(getActivity(), R.style.AppTheme);
                LayoutInflater inflater1 = getActivity().getLayoutInflater();
                final View view = inflater1.inflate(R.layout.fragment_tranfer, null);
                final TextView seachInDialog = (EditText) view.findViewById(R.id.edt_search);
                seachInDialog.requestFocus();
                final CustomItemNameBank mCustomItemNameBank = new CustomItemNameBank(getActivity(), R.layout.fragment_custom_itemnamebank, listBranch);

                seachInDialog.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        if (TextUtils.isEmpty(seachInDialog.getText())) {
                            mCustomItemNameBank.fillter("");
                        } else {
                            String text = seachInDialog.getText().toString().toLowerCase(Locale.getDefault());
                            mCustomItemNameBank.fillter(text);
                        }
                    }

                    @Override
                    public void afterTextChanged(Editable s) {

                    }
                });
                final Button btnCancel = (Button) view.findViewById(R.id.btn_cancel);
                final ListView listViewAll = (ListView) view.findViewById(R.id.mylistview);
                listViewAll.setAdapter(mCustomItemNameBank);
                alertdialog.setView(view);
                final AlertDialog createDialog = alertdialog.create();
                createDialog.show();
                listViewAll.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String tam = listBranch.get(position);
                        layoutBranchChose.setVisibility(View.GONE);
                        layoutBranch.setVisibility(View.VISIBLE);
                        tvFullNameBranch.setText(tam);
                        tvNameBranch.setText(tam);
                        createDialog.dismiss();
                    }
                });
                btnCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        createDialog.dismiss();

                    }
                });
            }
        });
    }

    public void addlist() {
        listBank.add("VIET COMBANK");
        listBank.add("VIET TINBANk");
        listBank.add("VIET Á Bank");
        listBank.add("VIET TINBANK");
        listBank.add("VIET COMBANK");
        listBank.add("VIET COMBANK");
        listBank.add("VIET COMBANK");
        listBank.add("VIET COMBANK");
        listBank.add("VIET COMBANK");
        listBank.add("VIET COMBANK");
        listBank.add("VIET COMBANK");
        listBank.add("VIET COMBANK");
        listBank.add("VIET COMBANK");
        listBank.add("VIET COMBANK");
        listBank.add("VIET COMBANK");
        listBank.add("VIET COMBANK");
        listBank.add("VIET COMBANK");
        listBank.add("VIET COMBANK");
        listCity.add("TP HCM");
        listCity.add("TP HCM");
        listCity.add("TP HCM");
        listCity.add("TP HCM");
        listCity.add("TP HCM");
        listCity.add("TP HCM");
        listCity.add("TP HCM");
        listCity.add("TP HCM");
        listCity.add("TP HCM");
        listCity.add("TP HCM");
        listCity.add("TP HCM");
        listCity.add("TP HCM");
        listCity.add("TP HCM");
        listCity.add("TP HCM");
        listCity.add("TP HCM");
        listBranch.add("TÂN ĐỊNH");
        listBranch.add("TÂN ĐỊNH");
        listBranch.add("TÂN ĐỊNH");
        listBranch.add("TÂN ĐỊNH");
        listBranch.add("TÂN ĐỊNH");
        listBranch.add("TÂN ĐỊNH");
        listBranch.add("TÂN ĐỊNH");
        listBranch.add("TÂN ĐỊNH");
        listBranch.add("TÂN ĐỊNH");
        listBranch.add("TÂN ĐỊNH");
        listBranch.add("TÂN ĐỊNH");
        listBranch.add("TÂN ĐỊNH");
        listBranch.add("TÂN ĐỊNH");
        listBranch.add("TÂN ĐỊNH");
        listBranch.add("TÂN ĐỊNH");
        listBranch.add("TÂN ĐỊNH");
        listBranch.add("TÂN ĐỊNH");
        listBranch.add("TÂN ĐỊNH");
        listBranch.add("TÂN ĐỊNH");
        listBranch.add("TÂN ĐỊNH");
        listBranch.add("TÂN ĐỊNH");
        listBranch.add("TÂN ĐỊNH");

    }

    @Override
    public void onClick(View v) {
        boolean checked = ((RadioButton) v).isChecked();
        switch (v.getId()) {
            case R.id.rdb_stk:
                if (checked) {
                    Log.e("radio", "so tai khoan");
                    inclChosebank.setVisibility(View.VISIBLE);
                    inclCardNumber.setVisibility(View.GONE);
                    rdbsothe.setChecked(false);
                }
                break;
            case R.id.rdb_sothe:
                if (checked) {
                    Log.e("radio", "so the");
                    inclChosebank.setVisibility(View.GONE);
                    inclCardNumber.setVisibility(View.VISIBLE);
                    rdbstk.setChecked(false);
                }
                break;
        }
    }
}

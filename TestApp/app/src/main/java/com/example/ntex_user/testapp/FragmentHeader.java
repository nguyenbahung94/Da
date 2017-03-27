package com.example.ntex_user.testapp;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by NTex-User on 3/23/2017.
 */

public class FragmentHeader extends Fragment {
    private List<ModelBank> listBank;
    private RelativeLayout relativeRoot;
    private LinearLayout lineatRoot, containtListBank;
    private TextView tvBank;
    private TextView tvNameBank;
    private HorizontalScrollView horizontalScrollView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_hearder, container, false);
        lineatRoot = (LinearLayout) root.findViewById(R.id.fm_content_hearder_2);
        horizontalScrollView = (HorizontalScrollView) lineatRoot.findViewById(R.id.horizontalscrollview);
        tvNameBank = (TextView) root.findViewById(R.id.tv_nameofbank);
        relativeRoot = (RelativeLayout) root.findViewById(R.id.fm_content_hearder_1);
        containtListBank = (LinearLayout) lineatRoot.findViewById(R.id.contain_list_bank);
        relativeRoot.setVisibility(View.VISIBLE);
        tvBank = (TextView) relativeRoot.findViewById(R.id.logo_bank);

        createdata();
        eventClick();
        return root;
    }

    public void addImg() {
        containtListBank.removeAllViews();
        horizontalScrollView.scrollTo(0, 0);
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View myLayout = inflater.inflate(R.layout.item_img_bank, containtListBank, false);
        myLayout.setBackgroundColor(getResources().getColor(R.color.white));
        final TextView tvView = (TextView) myLayout.findViewById(R.id.tv_imgbankcustom);
        final TextView tvname = (TextView) myLayout.findViewById(R.id.tv_namebankcustom);
        tvView.setTextColor(getResources().getColor(R.color.white));
        tvView.setBackgroundResource(R.drawable.bg_home_btn2);
        tvView.setText(tvBank.getText().toString());
        tvView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvBank.setText(tvView.getText());
                tvNameBank.setText(tvname.getText().toString());
                relativeRoot.setVisibility(View.VISIBLE);
                lineatRoot.setVisibility(View.GONE);
            }
        });
        tvname.setText(tvNameBank.getText());
        containtListBank.addView(myLayout);
        for (int i = 0; i < listBank.size(); i++) {
            ModelBank mdbank = listBank.get(i);
            if (!mdbank.getNameBank().equalsIgnoreCase(tvNameBank.getText().toString())) {
                View myLayoutTam = inflater.inflate(R.layout.item_img_bank, containtListBank, false);
                myLayoutTam.setBackgroundColor(getResources().getColor(R.color.background));
                final TextView tvViewTam = (TextView) myLayoutTam.findViewById(R.id.tv_imgbankcustom);
                final TextView tvnameTam = (TextView) myLayoutTam.findViewById(R.id.tv_namebankcustom);
                tvnameTam.setTextColor(getResources().getColor(R.color.colorPrimary));
                tvViewTam.setText(mdbank.getImgBank());
                tvnameTam.setText(mdbank.getNameBank());
                tvnameTam.setTextColor(getResources().getColor(R.color.white));
                tvViewTam.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        tvBank.setText(tvViewTam.getText().toString());
                        tvNameBank.setText(tvnameTam.getText().toString());
                        relativeRoot.setVisibility(View.VISIBLE);
                        lineatRoot.setVisibility(View.GONE);
                    }
                });
                containtListBank.addView(myLayoutTam);
            }
        }

    }

    public void eventClick() {
        tvBank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addImg();
                relativeRoot.setVisibility(View.GONE);
                lineatRoot.setVisibility(View.VISIBLE);
            }
        });
    }

    public void createdata() {
        listBank = new ArrayList<ModelBank>();
        listBank.add(new ModelBank("Viet Tin bank", "ACB"));
        listBank.add(new ModelBank("Viet Com bank", "ACB"));
        listBank.add(new ModelBank("Viet TiN bank", "ACB"));
        listBank.add(new ModelBank("Viet Com bank", "ACB"));
        listBank.add(new ModelBank("Viet  A  bank", "ACB"));
        listBank.add(new ModelBank("Viet  B  bank", "ACB"));
        listBank.add(new ModelBank("Viet  C  bank", "ACB"));
        listBank.add(new ModelBank("Viet  D  bank", "ACB"));

    }
}

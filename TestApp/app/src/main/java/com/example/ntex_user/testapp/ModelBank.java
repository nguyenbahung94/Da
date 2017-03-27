package com.example.ntex_user.testapp;

/**
 * Created by NTex-User on 3/23/2017.
 */

public class ModelBank {
    private String nameBank;
    private String imgBank;

    public ModelBank(String nameBank, String imgBank) {
        this.nameBank = nameBank;
        this.imgBank = imgBank;
    }

    public String getNameBank() {
        return nameBank;
    }

    public void setNameBank(String nameBank) {
        this.nameBank = nameBank;
    }

    public String getImgBank() {
        return imgBank;
    }

    public void setImgBank(String imgBank) {
        this.imgBank = imgBank;
    }
}

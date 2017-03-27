package com.example.ntex_user.testapp;

/**
 * Created by NTex-User on 3/22/2017.
 */

public class ModelData {
    private String nameUser;
    private String nameBank;
    private int money;
    private int imgBank;
    private int imgChose;

    public ModelData(String nameUser, String nameBank, int money, int imgBank, int imgChose) {
        this.nameUser = nameUser;
        this.nameBank = nameBank;
        this.money = money;
        this.imgBank = imgBank;
        this.imgChose = imgChose;
    }

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getNameBank() {
        return nameBank;
    }

    public void setNameBank(String nameBank) {
        this.nameBank = nameBank;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getImgBank() {
        return imgBank;
    }

    public void setImgBank(int imgBank) {
        this.imgBank = imgBank;
    }

    public int getImgChose() {
        return imgChose;
    }

    public void setImgChose(int imgChose) {
        this.imgChose = imgChose;
    }
}

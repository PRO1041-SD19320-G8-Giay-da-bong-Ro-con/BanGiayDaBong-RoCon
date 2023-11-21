package com.entity;

/**
 *
 * @author Thai
 */
public class ChatLieu {

    private String MaChatLieu;
    private String Ten;

    public ChatLieu() {
    }

    public ChatLieu(String MaChatLieu, String Ten) {
        this.MaChatLieu = MaChatLieu;
        this.Ten = Ten;
    }

    public String getMaChatLieu() {
        return MaChatLieu;
    }

    public void setMaChatLieu(String MaChatLieu) {
        this.MaChatLieu = MaChatLieu;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String Ten) {
        this.Ten = Ten;
    }

    

}

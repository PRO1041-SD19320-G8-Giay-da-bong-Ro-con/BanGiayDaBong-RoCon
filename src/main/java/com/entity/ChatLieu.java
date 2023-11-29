package com.entity;

/**
 *
 * @author Thai
 */
public class ChatLieu extends ThuocTinh{

    private String MaChatLieu;
    private String Ten;

    public ChatLieu() {
    }

    public ChatLieu(String MaChatLieu, String Ten) {
        this.MaChatLieu = MaChatLieu;
        this.Ten = Ten;
    }

    @Override
    public String getMa() {
        return MaChatLieu;
    }

    public void setMaChatLieu(String MaChatLieu) {
        this.MaChatLieu = MaChatLieu;
    }

    @Override
    public String getTen() {
        return Ten;
    }

    public void setTen(String Ten) {
        this.Ten = Ten;
    }
    public Object[] todatarowChatLieu(){
        return new Object[]{this.MaChatLieu,this.Ten};
    }
}

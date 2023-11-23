package model;

/**
 *
 * @author Thai
 */
public class LoaiGiay {

    private String MaLoai;
    private String Ten;

    public LoaiGiay() {
    }

    public LoaiGiay(String MaLoai, String Ten) {
        this.MaLoai = MaLoai;
        this.Ten = Ten;
    }

    public String getMaLoai() {
        return MaLoai;
    }

    public void setMaLoai(String MaLoai) {
        this.MaLoai = MaLoai;
    }

    public String getTen() {
        return Ten;
    }

    public void setTen(String Ten) {
        this.Ten = Ten;
    }

    @Override
    public String toString() {
        return this.getTen();
    }

    
    

}

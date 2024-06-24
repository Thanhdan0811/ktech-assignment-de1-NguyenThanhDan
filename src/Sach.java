public class Sach {
    private String tenSach;
    private String tenTacGia;
    private int soLuongThucTe;
    private int maSach;


    Sach(String tenSach, String tenTacGia, int soLuongThucTe) {
        this.tenSach = tenSach;
        this.tenTacGia = tenTacGia;
        this.soLuongThucTe = soLuongThucTe;
    }

    public String getTenSach() {
        return tenSach;
    }

    public void setTenSach(String tenSach) {
        this.tenSach = tenSach;
    }

    public String getTenTacGia() {
        return tenTacGia;
    }

    public void setTenTacGia(String tenTacGia) {
        this.tenTacGia = tenTacGia;
    }

    public int getSoLuongThucTe() {
        return soLuongThucTe;
    }

    public void setSoLuongThucTe(int soLuongThucTe) {
        this.soLuongThucTe = soLuongThucTe;
    }

    public void inThongTinSach() {
        System.out.println("Sách " + this.getTenSach() + " của tác giả " + this.getTenTacGia() + " hiện có  " + this.getSoLuongThucTe() + " trong thư viện");
    }

    public int getMaSach() {
        return maSach;
    }

    public void setMaSach(int maSach) {
        this.maSach = maSach;
    }
}

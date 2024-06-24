
public class NguoiThue {
    private String tenNgThue;
    private int tuoi;
    private String ngayThue;
    private String ngayTra;
    private int soLuongThue;
    private Sach sachThue;
    private int maNguoiThue;

    NguoiThue(String ten, int tuoi) {
        this.tenNgThue = ten;
        this.tuoi = tuoi;
    }

    public void themSachThue(Sach sach, int soLuongThue, String ngayTra, String ngayThue) {
        this.ngayThue = ngayThue;
        this.ngayTra = ngayTra;
        this.sachThue = sach;
        this.soLuongThue = soLuongThue;

    }

    public Sach getSachThue() {
        return this.sachThue;
    }

    public int getSoLuongThue() {
        return this.soLuongThue;
    }

    public void inThongTinNguoiThue() {
        System.out.println("tên : " + this.tenNgThue + " đã thuê : ");
        System.out.println("sách: " + this.sachThue.getTenSach() + " || số lượng thuê: " + this.soLuongThue + " || thuê ngày: " + this.getNgayThue() + " || trả ngày: " + this.getNgayTra());
    }

    public String getTenNgThue() {
        return tenNgThue;
    }

    public void setTenNgThue(String tenNgThue) {
        this.tenNgThue = tenNgThue;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    public void setNgayTra(String ngayTra) {
        this.ngayTra = ngayTra;
    }

    public String getNgayThue() {
        return ngayThue;
    }

    public String getNgayTra() {
        return ngayTra;
    }

    public void setsMaNguoiThue(int maNguoiThue) {
        this.maNguoiThue = maNguoiThue;
    }

    public int getsMaNguoiThue() {
        return maNguoiThue;
    }
}

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class QuanLyNguoiThue {
    private final ArrayList<NguoiThue> listNguoiThue;

    QuanLyNguoiThue() {
        this.listNguoiThue = new ArrayList<>();
    }

    public void themNguoiThue(QuanLySach qlSach) {

        if(qlSach.getListSach().isEmpty()) {
            System.out.println("Hiện tại thư viện không có sách để thuê");
            return;
        }

        Scanner sc = new Scanner(System.in);
        String tenNgThue;
        int tuoiNgThue;
        String ngayThue;
        String ngayTra;
        int maSach;
        int soLuongThue;
        int soSachConLai;
        Sach sachThue;

        System.out.print("Nhập tên người thuê: ");
        tenNgThue = sc.next();

        System.out.print("Nhập tuổi người thuê: ");
        tuoiNgThue = sc.nextInt();

        if(tuoiNgThue <= 16) {
            System.out.println("Người thuê chưa đủ tuổi thuê sách");
            return;
        }

        while (true) {
            System.out.print("Nhập ngày thuê có dạng dd/mm/yyyy: ");
            ngayThue = sc.next();
            boolean isValidDate = checkNgayTruocHaySauHienTai(ngayThue);
            if(!isValidDate) {
                System.out.println("Ngày bạn nhập là trong quá khứ");
                continue;
            }
            break;
        }


        while (true) {
            System.out.print("Nhập ngày trả có dạng dd/mm/yyyy: ");
            ngayTra = sc.next();
            boolean checkDate = checkNgayGuiVaNgayTraSach(ngayThue, ngayTra);
            if(!checkDate) {
                System.out.println("Ngày trả sách phải ít nhất sau 24h");
                continue;
            }
            break;
        }

        System.out.print("Mã sách bạn muốn thuê là: ");
        maSach = sc.nextInt();
        sachThue = qlSach.timSachBangMaSach(maSach);
        if(sachThue == null) {
            System.out.println("Sách bạn muốn thuê không tồn tại");
            return;
        }

        while (true) {
            System.out.print("Số lượng muốn thuê: ");
            soLuongThue = sc.nextInt();
            soSachConLai = sachThue.getSoLuongThucTe();
            if(soLuongThue > soSachConLai) {
                System.out.println("Số lượng Sách bạn muốn thuê vượt quá số sách hiện có");
                continue;
            }
            break;
        }

        sachThue.setSoLuongThucTe(soSachConLai - soLuongThue);
        NguoiThue ngThue = new NguoiThue(tenNgThue, tuoiNgThue);
        ngThue.themSachThue(sachThue ,soLuongThue,ngayTra, ngayThue);
        int sizeList = this.listNguoiThue.size();
        ngThue.setsMaNguoiThue(sizeList + 1);

        this.listNguoiThue.add(ngThue);

        System.out.println("Bạn đã thêm người thuê");

        this.danhSachNguoiThue();

    }

    public void doiThongTinNguoiThue() {
        Scanner sc = new Scanner(System.in);
        String tenNgThue;
        int tuoiNgThue;
        NguoiThue ngThue;

        while (true) {
            System.out.print("Nhập mã người thuê,(nhập 0 để thoát) :");
            int maNguoiThue = sc.nextInt();

            if(maNguoiThue == 0) return;

            ngThue = timNgThueTuIndexTrongList(maNguoiThue);
            if(ngThue == null) {
                System.out.println("Không tìm thấy người thuê");
                continue;
            }
            break;
        }

        while (true) {
            System.out.println("Bạn muốn thay đổi thông tin nào");
            System.out.println("1. Tên người thuê");
            System.out.println("2. Tuổi người thuê");
            System.out.println("0. Để thoát");

            int luaChon = sc.nextInt();
            if(luaChon == 0) return;

            switch (luaChon) {
                case 1:
                    System.out.println("Nhập tên người thuê mới");
                    tenNgThue = sc.next();
                    ngThue.setTenNgThue(tenNgThue);
                    System.out.println("Thay đổi thành công");
                    return;
                case 2:
                    System.out.println("Nhập tuổi người thuê mới");
                    tuoiNgThue = sc.nextInt();
                    if(tuoiNgThue <= 16) {
                        System.out.println("Tuổi không được nhỏ hơn 16");
                        break;
                    }
                    ngThue.setTuoi(tuoiNgThue);
                    System.out.println("Thay đổi thành công");
                    return;
                default:
                    System.out.println("Mời bạn nhập lại");
            }

        }
    }

    public NguoiThue timNgThueTuIndexTrongList(int maNguoiThue) {
        for(NguoiThue ng: this.listNguoiThue) {
            if(ng.getsMaNguoiThue() == maNguoiThue)
                return ng;
        }
        return null;
    }

    public void danhSachNguoiThue() {
        int stt = 0;
        System.out.println("STT ==== Mã Người Thuê ==== tên ==== tuoi ==== tên sách === số lượng thuê ==== ngày thuê ==== ngày trả ====");
        for(NguoiThue ng: this.listNguoiThue) {
            System.out.println((++stt)+ " ==== " +ng.getsMaNguoiThue() + " ==== " + ng.getTenNgThue() + " ==== " + ng.getTuoi() + " ==== " + ng.getSachThue().getTenSach() + " ==== " + ng.getSoLuongThue() + " ==== " + ng.getNgayThue() + " ==== " + ng.getNgayTra() + " ====" );
        }
    }

    public void traSachThue() {
        Scanner sc = new Scanner(System.in);
        NguoiThue ngThue;
        while (true) {
            System.out.print("Nhập mã người thuê,(nhập 0 để thoát) :");
            int maNguoiThue = sc.nextInt();

            if(maNguoiThue == 0) return;

            ngThue = timNgThueTuIndexTrongList(maNguoiThue);
            if(ngThue == null) {
                System.out.println("Không tìm thấy người thuê");
                continue;
            }
            break;
        }

        Sach sachThue = ngThue.getSachThue();
        sachThue.setSoLuongThucTe(sachThue.getSoLuongThucTe() + ngThue.getSoLuongThue());

        this.listNguoiThue.remove(ngThue);

        System.out.println("Trả sách thành công");

    }

    private boolean checkNgayGuiVaNgayTraSach(String ngayThue, String ngayTra) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dateThue = LocalDate.parse(ngayThue, df);
        LocalDate dateTra = LocalDate.parse(ngayTra, df);

        int checkDate = dateTra.compareTo(dateThue);

        return checkDate > 0;

    }

    private boolean checkNgayTruocHaySauHienTai(String ngayThue) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dateThue = LocalDate.parse(ngayThue, df);
        LocalDate dateNow = LocalDate.now();

        int checkDate = dateThue.compareTo(dateNow);

        return checkDate >= 0;
    }

}

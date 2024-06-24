import java.util.ArrayList;
import java.util.Scanner;

public class QuanLySach {
    private final ArrayList<Sach> listSach;

    QuanLySach() {
        this.listSach = new ArrayList<>();
    }

    public Sach themSach(String tenSach, String tenTacGia, int soLuongThucTe) {
        Sach sachMoi = new Sach(tenSach, tenTacGia, soLuongThucTe);
        int sizeList = this.listSach.size();
        sachMoi.setMaSach(sizeList + 1);
        this.listSach.add(sachMoi);
        return sachMoi;
    }

    public Sach timSachBangMaSach(int maSach) {
        for(Sach sach: this.listSach) {
            if(sach.getMaSach() == maSach)
                return sach;
        }
        return null;
    }

    public void inDanhSachSach() {
        if(this.listSach.isEmpty()) {
            System.out.println("Hiện thư viện chưa có sách");
            return;
        }

        System.out.println("STT ==== Mã sách ==== Tên sách ==== Tác giả ==== Số lượng còn lại ====");
        int stt = 0;
        for(Sach sach: this.listSach) {
            System.out.println((++stt) + " ==== " + sach.getMaSach() + " ==== " + sach.getTenSach() + " ==== " + sach.getTenTacGia() + " ==== " + sach.getSoLuongThucTe() + " ====");
//            System.out.println("STT " + sach.getSTT() + ". " + sach.getTenSach() + " của tác giả " + sach.getTenTacGia() + " số lượng còn lại : " + sach.getSoLuongThucTe());
        }
    }

    public void printLuaChonThemSach(Scanner sc) {
        Sach sachMoi;
        while (true) {
            sc.skip("\n");
            String tenSach="";
            String tenTacGia = "";
            int soLuongThucTe;

            System.out.print("Nhập tên sách : ");
            tenSach = sc.nextLine();
            System.out.print("Nhập tên tác giả : ");
            tenTacGia = sc.nextLine();
            System.out.print("Nhập số lượng : ");
            soLuongThucTe = sc.nextInt();

            sachMoi = this.themSach(tenSach, tenTacGia, soLuongThucTe);
            System.out.println("Bạn đã thêm sách");

            String themTiep;
            System.out.print("bạn có muốn thêm sách khác (y/n): ");
            themTiep = sc.next();

            if(themTiep.equals("y")) continue;
            break;

        }
//        sc.close();
        if(sachMoi == null) return;
        inDanhSachSach();
    }

    public void printLuaChonSuaSach(Scanner sc) {
        sc.skip("\n");
        System.out.println("Nhập mã sách bạn muốn chỉnh sửa : ");
        int maSach = sc.nextInt();

        Sach sachCanSua = timSachBangMaSach(maSach);
        if(sachCanSua == null) {
            System.out.println("Mã sách bạn nhập không tồn tại");
            return;
        }

        while (true) {
            sc.skip("\n");
            Scanner newSc = new Scanner(System.in);

            System.out.println("Sách cần chỉnh sửa là : ");
            sachCanSua.inThongTinSach();
            System.out.println("\nBạn muốn sửa thông tin nào : ");
            System.out.println("1. tên sách : ");
            System.out.println("2. tên tác giả");
            System.out.println("3. số lượng hiện có");
            System.out.println("0. Để thoát");

            int luaChon = newSc.nextInt();
            if(luaChon == 0) break;
            String tenMoiHoacTacGiaMoi;
            int soLuongMoi;
            switch (luaChon) {
                case 1:
                    System.out.print("nhập tên sách mới");
                    tenMoiHoacTacGiaMoi = newSc.next();
                    sachCanSua.setTenSach(tenMoiHoacTacGiaMoi);
                    System.out.println("Cập nhật thành công");
                    return;
                case 2:
                    System.out.print("nhập tên tác giả mới");
                    tenMoiHoacTacGiaMoi = newSc.next();
                    sachCanSua.setTenTacGia(tenMoiHoacTacGiaMoi);
                    System.out.println("Cập nhật thành công");
                    return;
                case 3:
                    System.out.print("nhập số lượng mới");
                    soLuongMoi = newSc.nextInt();
                    sachCanSua.setSoLuongThucTe(soLuongMoi);
                    System.out.println("Cập nhật thành công");
                    return;
                default:
                    System.out.println("Vui lòng chọn lại");

            }

        }


    }

    public void printXoaSach(Scanner sc) {
        sc.skip("\n");
        System.out.println("Nhập mã sách bạn mún xóa");
        int maSach = sc.nextInt();

        Sach sach = timSachBangMaSach(maSach);
        if(sach == null) {
            System.out.println("Sach bạn mún xóa không tồn tại");
            return;
        }

        this.listSach.remove(sach);
        System.out.println("Bạn đã xóa thành công");

    }

    public ArrayList<Sach> getListSach() {
        return this.listSach;
    }

}

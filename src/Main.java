import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // In ra lựa chọn
        Scanner sc = new Scanner(System.in);
        int luaChon = 0;

        QuanLySach qLSach = new QuanLySach();
        QuanLyNguoiThue qLNgThue = new QuanLyNguoiThue();

        while (true) {
            System.out.println();
            printLuaChon();
            luaChon = sc.nextInt();

            if(luaChon == 0) break;

            switch (luaChon) {
                case 1:
                    qLSach.inDanhSachSach();
                    break;
                case 2:
                    qLNgThue.danhSachNguoiThue();
                    break;
                case 3:
                    qLSach.printLuaChonThemSach();
                    break;
                case 4:
                    qLSach.printLuaChonSuaSach();
                    break;
                case 5:
                    qLSach.printXoaSach();
                    break;
                case 6:
                    qLNgThue.themNguoiThue(qLSach);
                    break;
                case 7:
                    qLNgThue.doiThongTinNguoiThue();
                    break;
                case 8:
                    qLNgThue.traSachThue();
                    break;
                default:
                    System.out.println("Lựa chọn của bạn không phù hợp");
                    break;
            }
        }





    }

    public static void printLuaChon() {
        System.out.println("Ứng dụng quản lý thư viện");
        System.out.println("Bạn muốn làm gì : ");
        System.out.println("1. Danh sách các đầu sách trong thư viện.");
        System.out.println("2. Danh sách người thuê sách.");
        System.out.println("3. Thêm sách vào thư viện.");
        System.out.println("4. Chỉnh sửa sách.");
        System.out.println("5. Xóa sách.");
        System.out.println("6. Thêm người thuê.");
        System.out.println("7. Sửa thông tin người thuê.");
        System.out.println("8. Người thuê trả sách.");
        System.out.println("0. Để thoát");
    }





}
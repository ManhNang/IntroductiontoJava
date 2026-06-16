public class WalletSystem {
    public static void main(String[] args) {
        System.out.println("--- GIAO DỊCH NẠP TIỀN ---");
        // BUG 1: Khách hàng có 2.147 tỷ, nạp thêm 1 triệu
        long currentBalance = 2147000000L;
        long depositAmount = -1000000L;

        // Toán tử + ở đây sẽ gây ra thảm họa
        long newBalance;
        if (depositAmount < 0) {
            newBalance = currentBalance;
        } else {
            newBalance = currentBalance + depositAmount;
        }
        System.out.println("Số tiền nạp: " + depositAmount);
        System.out.println("Số dư sau khi nạp: " + newBalance + " VNĐ");

        System.out.println("\n--- THỐNG KÊ CHI TIÊU ---");
        // BUG 2: Người dùng mới tinh, chưa từng chi tiêu
        int totalSpent = 0;
        int transactionCount = 0;

        // Chương trình sẽ chết (crash) ngay tại dòng này
        int averageSpent;
        if (transactionCount == 0) {
            averageSpent = 0;
        } else {
            averageSpent = totalSpent / transactionCount;
        }
        System.out.println("Số giao dịch: " + transactionCount);
        System.out.println("Chi tiêu trung bình mỗi giao dịch: " + averageSpent + " VNĐ");
        System.out.println("Đoạn code này sẽ không bao giờ được in ra vì app đã sập!");
    }
}

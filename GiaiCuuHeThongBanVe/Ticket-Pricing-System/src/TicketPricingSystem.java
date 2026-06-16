public class TicketPricingSystem {
    public static void main(String[] args) {
        int age = 65;
        String dayOfWeek = "Friday";
        boolean isMember = false;
        System.out.println("Log test Legacy: " + calculatePriceLegacy(age, dayOfWeek, isMember));
        System.out.println("Log test Refactored: " + calculatePriceRefactored(age, dayOfWeek, isMember));
    }

    public static double calculatePriceLegacy(int age, String dayOfWeek, boolean isMember) {
        double basePrice = 100000;
        double finalPrice = 0;

        // Vấn đề 1: Validate đầu vào ôm trọn toàn bộ logic bên trong
        if (age > 0) {
            if (dayOfWeek != null && !dayOfWeek.isEmpty()) {
                // Vấn đề 2: Logic ngày thứ 3 bị tách rời thiếu nhất quán
                if (dayOfWeek.equalsIgnoreCase("Tuesday")) {
                    finalPrice = basePrice * 0.5; // Happy Day 50%
                } else {
                    // Vấn đề 3: Lồng ghép sâu cho độ tuổi và thành viên
                    if (age <= 12) {
                        if (isMember) {
                            finalPrice = (basePrice * 0.7) - 10000; // Trẻ em + VIP
                        } else {
                            finalPrice = basePrice * 0.7; // Trẻ em
                        }
                    } else if (age >= 60) {
                        finalPrice = basePrice * 0.6; // Người cao tuổi
                    } else {
                        // Người lớn bình thường
                        if (dayOfWeek.equalsIgnoreCase("Saturday") || dayOfWeek.equalsIgnoreCase("Sunday")) {
                            if (isMember) {
                                finalPrice = (basePrice * 1.2) * 0.9; // Cuối tuần + VIP được giảm 10%
                            } else {
                                finalPrice = basePrice * 1.2; // Cuối tuần tăng giá
                            }
                        } else {
                            if (isMember) {
                                finalPrice = basePrice * 0.9; // Ngày thường + VIP
                            } else {
                                finalPrice = basePrice;
                            }
                        }
                    }
                }
            } else {
                return -1; // Lỗi ngày
            }
        } else {
            return -1; // Lỗi tuổi
        }

        return finalPrice;
    }

    public static double calculatePriceRefactored(int age, String dayOfWeek, boolean isMember) {
        if (age <= 0 || dayOfWeek == null || dayOfWeek.isEmpty()) {
            return -1;
        }

        double basePrice = 100000;
        double ageMultiplier;

        if (age <= 12) {
            ageMultiplier = 0.7;
        } else if (age >= 60) {
            ageMultiplier = 0.6;
        } else {
            ageMultiplier = 1.0;
        }

        double dayMultiplier = switch (dayOfWeek.toLowerCase()) {
            case "tuesday" -> 0.5;
            case "saturday", "sunday" -> 1.2;
            default -> 1.0;
        };

        if (dayOfWeek.equalsIgnoreCase("Tuesday")) {
            return basePrice * dayMultiplier;
        }

        double finalPrice = basePrice * ageMultiplier * dayMultiplier;

        if (isMember) {
            if (age <= 12) {
                finalPrice -= 10000;
            } else {
                finalPrice *= 0.9;
            }
        }

        return finalPrice;
    }
}

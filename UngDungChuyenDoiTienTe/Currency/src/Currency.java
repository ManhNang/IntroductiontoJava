import java.util.Scanner;

public class Currency {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.print("Nhap so luong USD muon doi: ");
        float usd = scn.nextFloat();
        float rate = 23000f;
        System.out.println(usd + " USD = " + usd * rate + " VND");
    }
}

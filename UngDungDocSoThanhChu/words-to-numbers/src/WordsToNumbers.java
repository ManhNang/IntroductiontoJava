import java.util.Scanner;

public class WordsToNumbers {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        System.out.println("Nhap so can doc (toi da 3 chu so): ");
        int num = scn.nextInt();

        if (num < 10) {
            System.out.println(readUnit(num));
        } else if (num < 20) {
            System.out.println(readTeen(num));
        } else if (num < 100) {
            int tens = num / 10;
            int unit = num % 10;
            System.out.println(readTens(tens) + " " + readTens(unit));
        } else {
            int hundreds = num / 100;
            int remainder = num % 100;
            String result = readUnit(hundreds) + " hundred";

            if (remainder == 0) {
                System.out.println(result);
            } else if (remainder < 10) {
                System.out.println(result + " and " + readUnit(remainder));
            } else if (remainder < 20) {
                System.out.println(result + " and " + readTeen(remainder));
            } else {
                int tens = remainder / 10;
                int unit = remainder % 10;
                System.out.println(result + " and " + readTens(tens) + (unit != 0 ? " " + readUnit(unit) : ""));
            }

        }
    }

    public static String readUnit(int number) {
        switch (number) {
            case 0:
                return "zero";
            case 1:
                return "one";
            case 2:
                return "two";
            case 3:
                return "three";
            case 4:
                return "four";
            case 5:
                return "five";
            case 6:
                return "six";
            case 7:
                return "seven";
            case 8:
                return "eight";
            case 9:
                return "nine";
            default:
                return "";
        }
    }

    public static String readTeen(int number) {
        switch (number) {
            case 10:
                return "ten";
            case 11:
                return "eleven";
            case 12:
                return "twelve";
            case 13:
                return "thirteen";
            case 14:
                return "fourteen";
            case 15:
                return "fifteen";
            case 16:
                return "sixteen";
            case 17:
                return "seventeen";
            case 18:
                return "eighteen";
            case 19:
                return "nineteen";
            default:
                return "";
        }
    }

    public static String readTens(int number) {
        switch (number) {
            case 2:
                return "twenty";
            case 3:
                return "thirty";
            case 4:
                return "forty";
            case 5:
                return "fifty";
            case 6:
                return "sixty";
            case 7:
                return "seventy";
            case 8:
                return "eighty";
            case 9:
                return "ninety";
            default:
                return "";
        }
    }
}

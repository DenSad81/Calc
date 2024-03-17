import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner inputFromConsole = new Scanner(System.in);
        String inputData;
        Digit digit1 = new Digit();
        Digit digit2 = new Digit();
        Digit result = new Digit();
        StringBuffer mathSign = new StringBuffer();

        System.out.println("Введите числа в формате 1 + 2");
        inputData = inputFromConsole.nextLine();

        getComponents(inputData, digit1, digit2, mathSign);
        calk(mathSign, digit1, digit2, result);

        System.out.println("Вывод");

        if (digit1.IsArabic)
            result.printArabic();
        else
            result.printRomanian();
    }

    public static void getComponents(String str, Digit dj1, Digit dj2, StringBuffer sig) {
        String[] digits = str.split(" ");

        if (digits.length != 3)
            throw new NullPointerException("Неверный формат ввода");

        convertToDigit(digits[0], dj1);
        convertToDigit(digits[2], dj2);
        sig.append(digits[1]); // переводим String в StringBuffer
    }

    public static void calk(StringBuffer sig, Digit dj1, Digit dj2, Digit res) {
        if (dj2.IsArabic != dj1.IsArabic)
            throw new NullPointerException("Числа разных систем");

        String tempSig = sig.toString();// переводим StringBuffer в String

        switch (tempSig) {
            case ("+"):
                addition(dj1, dj2, res);
                break;
            case ("-"):
                subtraction(dj1, dj2, res);
                break;
            case ("*"):
                multiplication(dj1, dj2, res);
                break;
            case ("/"):
                division(dj1, dj2, res);
                break;
            default:
                throw new NullPointerException("Неверный формат действия");
        }
    }

    public static void addition(Digit dj1, Digit dj2, Digit res) {
        res.DigitArabic = dj1.DigitArabic + dj2.DigitArabic;
    }

    public static void subtraction(Digit dj1, Digit dj2, Digit res) {
        if (dj1.IsArabic == true && dj2.IsArabic == true)
            res.DigitArabic = dj1.DigitArabic - dj2.DigitArabic;

        if (dj1.IsArabic == false && dj2.IsArabic == false) {
            if (dj1.DigitArabic > dj2.DigitArabic)
                res.DigitArabic = dj1.DigitArabic - dj2.DigitArabic;
            else
                throw new NullPointerException("Отрицательное число");
        }
    }

    public static void multiplication(Digit dj1, Digit dj2, Digit res) {
        res.DigitArabic = dj1.DigitArabic * dj2.DigitArabic;
    }

    public static void division(Digit dj1, Digit dj2, Digit res) {
        res.DigitArabic = dj1.DigitArabic / dj2.DigitArabic;
    }

    public static void convertToDigit(String str, Digit dj) {
        switch (str) {
            case ("1"):
                dj.DigitArabic = 1;
                dj.IsArabic = true;
                break;
            case ("2"):
                dj.DigitArabic = 2;
                dj.IsArabic = true;
                break;
            case ("3"):
                dj.DigitArabic = 3;
                dj.IsArabic = true;
                break;
            case ("4"):
                dj.DigitArabic = 4;
                dj.IsArabic = true;
                break;
            case ("5"):
                dj.DigitArabic = 5;
                dj.IsArabic = true;
                break;
            case ("6"):
                dj.DigitArabic = 6;
                dj.IsArabic = true;
                break;
            case ("7"):
                dj.DigitArabic = 7;
                dj.IsArabic = true;
                break;
            case ("8"):
                dj.DigitArabic = 8;
                dj.IsArabic = true;
                break;
            case ("9"):
                dj.DigitArabic = 9;
                dj.IsArabic = true;
                break;
            case ("10"):
                dj.DigitArabic = 10;
                dj.IsArabic = true;
                break;

            case ("I"):
                dj.DigitArabic = 1;
                dj.IsArabic = false;
                break;
            case ("II"):
                dj.DigitArabic = 2;
                dj.IsArabic = false;
                break;
            case ("III"):
                dj.DigitArabic = 3;
                dj.IsArabic = false;
                break;
            case ("IV"):
                dj.DigitArabic = 4;
                dj.IsArabic = false;
                break;
            case ("V"):
                dj.DigitArabic = 5;
                dj.IsArabic = false;
                break;
            case ("VI"):
                dj.DigitArabic = 6;
                dj.IsArabic = false;
                break;
            case ("VII"):
                dj.DigitArabic = 7;
                dj.IsArabic = false;
                break;
            case ("VIII"):
                dj.DigitArabic = 8;
                dj.IsArabic = false;
                break;
            case ("IX"):
                dj.DigitArabic = 9;
                dj.IsArabic = false;
                break;
            case ("X"):
                dj.DigitArabic = 10;
                dj.IsArabic = false;
                break;

            default:
                throw new NullPointerException("Неверный формат чисел");
        }
    }

}
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner _inputFromConsole = new Scanner(System.in);
        String _string;
        String _result;

        System.out.println("Введите числа в формате 1 + 2");
        _string = _inputFromConsole.nextLine();

        _result = calk(_string);

        System.out.println("Вывод");
        System.out.println(_result);
    }

    public static String calk(String _string) {
        String[] digits;
        int digit1;
        int digit2;
        int result;

        digits = _string.split(" ");

        if (digits.length != 3)
            throw new NullPointerException("Неверный формат  ввода");

        digit1 = convertToDigit(digits[0]);
        digit2 = convertToDigit(digits[2]);

        result = switch (digits[1]) {
            case ("+") -> addition(digit1, digit2);
            case ("-") -> subtraction(digit1, digit2);
            case ("*") -> multiplication(digit1, digit2);
            case ("/") -> division(digit1, digit2);
            default -> throw new NullPointerException("Неверный формат действия");
        };

        return (convertFromDigit(result));
    }

    public static int addition(int in1, int in2) {
        if ((in1 > 0 && in1 < 11) && (in2 > 0 && in2 < 11))
            return in1 + in2;

        if ((in1 > 200 && in1 < 211) && (in2 > 200 && in2 < 211))
            return ((in1 - 200) + (in2 - 200)) + 200;

        throw new NullPointerException("Числа разных систем");
    }

    public static int subtraction(int in1, int in2) {
        if ((in1 > 0 && in1 < 11) && (in2 > 0 && in2 < 11))
            return in1 - in2;

        if ((in1 > 200 && in1 < 211) && (in2 > 200 && in2 < 211)) {
            if (in1 > in2)
                return ((in1 - 200) - (in2 - 200)) + 200;
            else
                throw new NullPointerException("Отрицательное число");
        }

        throw new NullPointerException("Числа разных систем");
    }

    public static int multiplication(int in1, int in2) {
        if ((in1 > 0 && in1 < 11) && (in2 > 0 && in2 < 11))
            return in1 * in2;

        if ((in1 > 200 && in1 < 211) && (in2 > 200 && in2 < 211))
            return ((in1 - 200) * (in2 - 200)) + 200;

        throw new NullPointerException("Числа разных систем");
    }

    public static int division(int in1, int in2) {
        if ((in1 > 0 && in1 < 11) && (in2 > 0 && in2 < 11))
            return (in1 / in2);

        if ((in1 > 200 && in1 < 211) && (in2 > 200 && in2 < 211))
            return ((in1 - 200) / (in2 - 200)) + 200;

        throw new NullPointerException("Числа разных систем");
    }

    public static int convertToDigit(String str) {
        return switch (str) {
            case ("1") -> 1;
            case ("2") -> 2;
            case ("3") -> 3;
            case ("4") -> 4;
            case ("5") -> 5;
            case ("6") -> 6;
            case ("7") -> 7;
            case ("8") -> 8;
            case ("9") -> 9;
            case ("10") -> 10;

            case ("I") -> 201;
            case ("II") -> 202;
            case ("III") -> 203;
            case ("IV") -> 204;
            case ("V") -> 205;
            case ("VI") -> 206;
            case ("VII") -> 207;
            case ("VIII") -> 208;
            case ("IX") -> 209;
            case ("X") -> 210;
            default -> throw new NullPointerException("Неверный формат чисел");
        };
    }

    public static String convertFromDigit(int in) {
        String result = "";

        if (in < 101) {
            result = Integer.toString(in);
            return result;
        }

        in -= 200;

        int[] arab = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
        String[] roman = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};
        int i = arab.length - 1;

        while (in > 0) {
            if (in >= arab[i]) {
                result += roman[i];
                in -= arab[i];
            } else
                i--;
        }

        return result;
    }
}
public class Digit {
    public Boolean IsArabic;
    public int DigitArabic;
    public String DigitRomanian = new String();

    public void convertToRomanian() {
        if (DigitArabic <= 0)
            throw new NullPointerException("В римской сс нет отрицательных чисел");

        int[] arab = { 1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000 };
        String[] roman = { "I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M" };
        int i = arab.length - 1;

        while (DigitArabic > 0) {
            if (DigitArabic >= arab[i]) {
                DigitRomanian += roman[i];
                DigitArabic -= arab[i];
            } else
                i--;
        }
    }

    public void printArabic() {
        System.out.println(DigitArabic);
    }

    public void printRomanian() {
        convertToRomanian();
        System.out.println(DigitRomanian);
    }
}
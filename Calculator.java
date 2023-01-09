package Calculator;
import java.util.*;

public class Calculator {
    static Map<Integer, String> map = new HashMap<>();
    static Map<Integer, String> symbol = new HashMap<>();
    static List<String> numberList = new ArrayList<>();

    static String[] array = {" ", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII",
            "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII",
            "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
            "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII",
            "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV",
            "XCVI", "XCVII", "XCVIII", "XCIX", "C"};
    static List<String> arrlist = Arrays.asList(array);

    public static void main(String[] args) throws Exception {
        Scanner console = new Scanner(System.in);
        String result1 = console.nextLine();
        calc(result1);
        System.out.println(calc(result1));
    }


    public static String calc(String StringInput) throws Exception {
        map.put(0, " ");
        map.put(1, "I");
        map.put(2, "II");
        map.put(3, "III");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(6, "VI");
        map.put(7, "VII");
        map.put(8, "VIII");
        map.put(9, "IX");
        map.put(10, "X");

        numberList.add("1");
        numberList.add("2");
        numberList.add("3");
        numberList.add("4");
        numberList.add("5");
        numberList.add("6");
        numberList.add("7");
        numberList.add("8");
        numberList.add("9");
        numberList.add("10");

        symbol.put(1, "+");
        symbol.put(2, "-");
        symbol.put(3, "*");
        symbol.put(4, "/");

        String[] arrSplit = StringInput.split(" ");

        if (arrSplit.length > 3) {
            throw new Exception("Формат математической операции не удовлетворяет заданию - два операнда и один оператор");
        }
        if (arrSplit.length < 3) {
            throw new Exception("Строка не является математической операцией");
        }
        String one = (arrSplit[0]);
        String symbol = arrSplit[1];
        String three = (arrSplit[2]);

        return checkVariables(one, symbol, three);
    }

    static String checkVariables(String a, String operator, String c) throws Exception {
        String result;

        if (numberList.contains(a) && numberList.contains(c) && (symbol.containsValue(operator)) || (map.containsValue(a) && map.containsValue(c) && (symbol.containsValue(operator)))) {
            result = Calculator.separate(a, operator, c);
        } else if (symbol.containsValue(operator) == false) {
            throw new Exception("Неверный символ оператора. Допустимо использование (+, - , / , *)");
        } else if (numberList.contains(a) || numberList.contains(c) && map.containsValue(a) || map.containsValue(c)) {
            throw new Exception("Используются одновременно разные системы счисления");
        } else {
            throw new Exception("Формат введенных данных не соответствует заданию");
        }
        return result;
    }

    static String separate(String a, String operator, String c) throws Exception {
        String a1;
        if ((map.containsValue(a)) && (map.containsValue(c))) {
            Integer one = arrlist.indexOf(a);
            Integer two = arrlist.indexOf(c);
            Integer result = counter(operator, one, two);

            checkRoman(result);

          return a1 = arrlist.get(result);
        } else if (map.containsKey(Integer.valueOf(a)) && (map.containsKey(Integer.valueOf(c)))) {
            Integer oneVar = Integer.parseInt(a);
            Integer threeVar = Integer.parseInt(c);
            a1 = String.valueOf(counter(operator, oneVar, threeVar));

        } else {
            throw new Exception();
        }
        return a1;
    }

    static int checkRoman(int numberRom) throws Exception {

        if (numberRom < 1) {
            throw new Exception("В римской системе нет отрицательных чисел");
        }
        return numberRom;
    }

    static int counter(String a, int b, int c) throws Exception {
        int result = 0;
        switch (a) {
            case ("+"):
                result = b + c;
                break;
            case ("-"):
                result = b - c;
                break;
            case ("/"):
                result = b / c;
                break;
            case ("*"):
                result = b * c;
                break;
        }
        return result;
    }
}

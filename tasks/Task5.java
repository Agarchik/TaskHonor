import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;

public class Task5 {
    public static void main(String[] args) {
        System.out.println("\n**** Ex 1 ****");
        Task1();
        System.out.println("\n**** Ex 2 ****");
        Task2();
        System.out.println("\n**** Ex 3 ****");
        Task3();
        System.out.println("\n**** Ex 4 ****");
        Task4();
        System.out.println("\n**** Ex 5 ****");
        Task5();
        System.out.println("\n**** Ex 6 ****");
        Task6();
        System.out.println("\n**** Ex 7 ****");
        Task7();
        System.out.println("\n**** Ex 8 ****");
        Task8();
        System.out.println("\n**** Ex 9 ****");
        Task9();
        System.out.println("\n**** Ex 10 ****");
        Task10();
    }

    public static void Task1() {

        String string = "Hello";
        int[] arr = {72, 33, -73, 84, -12, -3, 13, -13, -68};

        System.out.println("Result encrypt: " + encrypt(string));
        System.out.println("Result decrypt: " + decrypt(arr));
    }

    public static String encrypt(String str) {
        int[] encoded = new int[str.length()];
        encoded[0] = str.charAt(0);

        for (int i = 1; i < encoded.length; i++) {
            encoded[i] = str.charAt(i) - str.charAt(i - 1);
        }

        return Arrays.toString(encoded);
    }

    public static String decrypt(int[] arr) {
        String str = "";
        int charCode = 0;
        for (int i = 0; i < arr.length; i++) {
            str += (char) (arr[i] + charCode);
            charCode = arr[i] + charCode;
        }
        return str;
    }

    public static void Task2() {
        String fig = "Bishop";
        String cur = "A7";
        String tar = "G1";
        System.out.println("Result: " + canMove(fig, cur, tar));
    }

    public static boolean canMove(String fig, String current, String target) {
        boolean flag = false;
        String a = current.substring(0, 1);
        int b = Integer.parseInt(current.substring(1));
        String c = target.substring(0, 1);
        int d = Integer.parseInt(target.substring(1));
        if (fig.equals("Pawn")) {
            if (a.equals(c) && (b + 1 == d || b + 2 == d))
                flag = true;
        } else if (fig.equals("Knight")) {
            if ((int) Math.abs((int) a.charAt(0) - (int) c.charAt(0)) == 1 && (int) Math.abs(b - d) == 2)
                flag = true;
        } else if (fig.equals("Bishop")) {
            if ((int) Math.abs((int) a.charAt(0) - (int) c.charAt(0)) == (int) Math.abs(b - d))
                flag = true;
        } else if (fig.equals("Rook")) {
            if (a.equals(c) || b == d)
                flag = true;
        } else if (fig.equals("Queen")) {
            if (((int) Math.abs((int) a.charAt(0) - (int) c.charAt(0)) == (int) Math.abs(b - d)) || (a.equals(c) || b == d))
                flag = true;
        } else {
            if ((int) Math.abs((int) a.charAt(0) - (int) c.charAt(0)) == 1 || (int) Math.abs(b - d) == 1 || (((int) a.charAt(0) - (int) c.charAt(0)) == 1 && ((int) Math.abs(b - d) == 1)))
                flag = true;
        }
        return flag;
    }

    public static void Task3() {
        String subs = "butl";
        String word = "beautiful";
        System.out.println("Result: " + canComplete(subs, word));
    }

    public static boolean canComplete(String subs, String word) {
        int count = 0;
        for (int i = 0, j = 0; i < word.length(); i++) {

            if (subs.toLowerCase().charAt(j) == word.toLowerCase().charAt(i)) {
                count++;
                j++;
            }
        }

        if (count == subs.length())
            return true;
        else
            return false;
    }

    public static void Task4() {

        int[] myArray = {16, 28};

        System.out.println("Result: " + sumDigProd(myArray));
    }

    public static long sumDigProd(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) sum += nums[i];
        while (sum > 9) {
            int product = 1;
            while (sum != 0) {
                product *= sum % 10;
                sum /= 10;
            }
            sum = product;
        }
        return sum;
    }

    public static void Task5() {
        System.out.println("Result: " + sameVowelGroup(new String[]{"hoops", "chuff", "bot", "bottom"}));
    }

    public static ArrayList<String> sameVowelGroup(String[] myArray) {
        String[] allVowels = new String[]{"a", "e", "y", "u", "i", "o"};
        String vowels = "";
        ArrayList<String> result = new ArrayList<>(); //Создаем динамический массив

        for (int i = 0; i < allVowels.length; i++) { //Проходимся по всем гласным
            if (myArray[0].contains(allVowels[i]) && !vowels.contains(allVowels[i])) { //Проверка на содержание объекта
                vowels += allVowels[i];// Добавление в строку
            }
        }

        if (vowels.length() > 0) {
            result.add(myArray[0]);//Добавляем в массив
        } else {
            return result;
        }

        for (int i = 1; i < myArray.length; i++) {
            boolean pass = true;

            for (int j = 0; j < vowels.length(); j++) {
                if (!myArray[i].contains(String.valueOf(vowels.charAt(j)))) {//Если итый элемент не содержит
                    pass = false;
                    break;
                }
            }

            if (pass) result.add(myArray[i]);
        }

        return result;
    }



    public static void Task6(){
        long card = 1234567890123452L;
        System.out.println("Result: " + validateCard(card));
    }

    public static boolean validateCard(long num) {
        String string = String.valueOf(num);
        if(string.length() < 14 || string.length() > 19)
            return false;
        int lastDigit = Integer.parseInt(string.substring(string.length()-1));
        string = string.substring(0, string.length()-1);
        StringBuilder builder = new StringBuilder(string);
        string = builder.reverse().toString();

        int arr[] = new int[string.length()];
        long sum = 0;
        for(int i = 0; i< arr.length; i++) {
            int number = Integer.parseInt(""+(string.charAt(i)));
            int aux = number;
            if((i+1) % 2 != 0) {
                aux = number * 2;
                if (aux >= 10) {
                    int rest = aux / 10;
                    aux = aux % 10;
                    aux = aux + rest;
                }
            }
            arr[i] = aux;
            sum += arr[i];
        }
        return (10 - ((int)sum %10)) == lastDigit;
    }

    public static void Task7(){

        int num = 322;
        System.out.println("Result: " + numToEng(num));
    }

    public static String numToEng(int n) {
        final String[] NUMS = {"zero", "one", "two", "three", "four", "five", "six",
                "seven", "eight", "nine"};
        final String[] TENS2 = {"", "", "twenty", "thirty", "fourty", "fifty", "sixty",
                "seventy", "eighty", "ninety"};
        final String[] TENS = {"ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen",
                "sixteen", "seventeen", "eighteen", "nineteen"};
        String ret = "";
        if (n == 0) {
            return NUMS[0];
        }
        if (n >= 100) {
            ret += NUMS[n/100] + " hundred";
            n = n%100;
            if (n != 0) {
                ret += " ";
            }
        }
        if (n >= 20) {
            ret += TENS2[n/10];
            n = n%10;
            if (n != 0) {
                ret += " ";
            }
        } else if (n >= 10) {
            ret += TENS[n%10];
            n = 0;
        }
        if (n > 0) {
            ret += NUMS[n];
        }
        return ret;
    }

    public static void Task8(){

        String string = "password123";
        System.out.println("Result: " + getSha256Hash(string));

    }

    public static String getSha256Hash(String str) {
        try {
            MessageDigest mDigest= MessageDigest.getInstance("SHA-256");
            byte[] result=mDigest.digest(str.getBytes());
            String out="";
            for (int i=0; i<result.length; i++)
                out+=Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1);
            return out;
        } catch (Exception e) {return null;}
    }

    public static void Task9(){

        String string = "jOn SnoW, kINg IN thE noRth.";
        System.out.println("Result: " + correctTitle(string));
    }

    public static String correctTitle(String str) {
        str=" "+str.toLowerCase();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==' '||str.charAt(i)=='-'){
                str=str.substring(0,i+1)+str.substring(i+1,i+2).toUpperCase()+str.substring(i+2);
            }
        }
        str=str.replaceAll("And ","and ").replaceAll("The ", "the ").replaceAll("The", "the").
                replaceAll("Of ", "of ").replaceAll("In ","in ").trim();
        return str;
    }

    public static void Task10(){
        int num = 21;
        System.out.println(hexLattice(num));
    }

    public static String hexLattice(int n) {
        int t=1,c=1;
        while(t!=n){
            t=t+(c*6);
            if(t>n) return "Invalid";
            c++;
        }
        String res="";
        for(int i=c;i<(c*2);i++){
            for(int k=1;k<c*2-i;k++){
                res+=" ";
            }
            for(int j=0;j<i;j++){
                res+=" o";
            }
            res+=" ";
            for(int k=1;k<c*2-i;k++){
                res+=" ";
            }
            res+="\n";
        }
        for(int i=c*2-2;i>=c;i--){
            for(int k=1;k<c*2-i;k++){
                res+=" ";
            }
            for(int j=0;j<i;j++){
                res+=" o";
            }
            res+=" ";
            for(int k=1;k<c*2-i;k++){
                res+=" ";
            }
            res+="\n";
        }
        return res.substring(0,res.length()-1);
    }

}
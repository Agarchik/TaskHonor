public class Task3 {

    public static void main(String[] args) {
        System.out.println("TASK 1");
        Task1();
        System.out.println("TASK 2");
        Task2();
        System.out.println("TASK 3");
        Task3();
        System.out.println("TASK 4");
        Task4();
        System.out.println("TASK 5");
        Task5();
        System.out.println("TASK 6");
        Task6();
        System.out.println("TASK 7");
        Task7();
        System.out.println("TASK 8");
        Task8();
        System.out.println("TASK 9");
        Task9();
        System.out.println("TASK 10");
        Task10();
    }

    public static void Task1(){
        int a = 1;
        int b = 0;
        int c = -1;
        System.out.println("Count of solutions: " + solution(a, b, c));
    }

    public static int solution(int a, int b, int c){
        int d = b * b - 4 * a * c;
        int s = 0;
        if (d > 0)
            s = 2;
        else if (d == 0)
            s = 1;
        else if (d < 0)
            s= 0;
        return s;
    }

    public static void Task2(){
        String string = "all zip files are zipped";
        System.out.println("Index of zip: " + findZip(string));
    }

    public static int findZip(String str){
        int firstZip = str.indexOf("zip");
        int secondZip = str.indexOf("zip", firstZip + 1);
        return  secondZip;
    }

    public static void Task3(){
        int r = 6;
        System.out.println("Is this number perfect? - " + checkPerfect(r));
    }

    public static boolean checkPerfect(int r){
        int sum = 0;
        for (int i = 1; i < r; i++ ){
            if (r % i == 0){
                sum += i;
            }
        }
        return sum == r;
    }

    public static void Task4(){
        String str = "z";
        System.out.println("The result is: " + flipEndChars(str));
    }

    public static String flipEndChars(String str){
        if (str.length() < 2){
            return "String is too small!";
        }
        else if (str.charAt(0) == str.charAt(str.length() - 1)) {
            return  "Two's a pair.";
        }
        else {
            char[] words = str.toCharArray();
            char sym1 = words[0];
            words[0] = words[words.length - 1];
            words[words.length - 1] = sym1;
            return new String(words);
        }
    }

    public static void Task5(){

        String str ="CD5C5C";
        System.out.println("The result is: " + isValidHexCode(str));
    }

    public static boolean isValidHexCode(String str){
        if (str.length() > 5){
            return false;
        }
        return str.matches("#[0-9a-fA-F]+");
    }

    public static void Task6(){
        int [] arr1 = new int[] {1, 3, 4, 4, 4};
        int [] arr2 = new int[] {2, 5, 7};

        System.out.println("The result is: " + same(arr1, arr2));
    }

    public static boolean same(int[] arr1, int[] arr2){
        int k = 0;
        int s = 0;
        for (int i = 0; i < arr1.length; i++){
            for (int j = i + 1;j < arr1.length; j++){
                if (arr1[i] != arr1[j]){
                    k = k + 1;
                    i = j;
                }
            }
        }

        for (int i = 0; i < arr2.length; i++){
            for (int j = i + 1; j < arr2.length; j++){
                if (arr2[i] != arr2[j]){
                    s = s + 1;
                    i = j;
                }
            }
        }
        return (k) == (s);
    }

    public static void Task7(){
        int num = 3;
        System.out.println("The result is: " + isKaprekar(num));
    }

    public static boolean isKaprekar(int num){
        if (num == 1)
            return true;
        int numpow = num*num;
        int len= 0;

        while (numpow != 0)
        {
            len++;
            numpow /= 10;
        }

        numpow = num * num;

        for (int i = 1; i < len; i++)
        {
            int modulo = (int) Math.pow(10, i);

            int sum = numpow / modulo + numpow % modulo;
            if (sum == num)
                return true;
        }

        return false;
    }

    public static void Task8(){
        String str = "01100001011000";
        System.out.println("The result is: " + longestZero(str));
    }

    public static String longestZero(String str){
        int maxstreak = 0;
        int currentstreak = 0;
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) == '0') {
                currentstreak++;

                if (currentstreak > maxstreak) {
                    maxstreak = currentstreak;
                }
            }
            else {
                currentstreak = 0;
            }
        }
        StringBuilder resstring = new StringBuilder("");
        for (int i = 0; i < maxstreak; i++){
            resstring.insert(i, '0');
        }
        return resstring.toString();
    }

    public static void Task9(){
        int num = 12;
        System.out.println("The result is: " + nextPrime(num));
    }

    public static int nextPrime(int x) {

        boolean currentPrime = true;


        for (int i = 2; i < x; i++) {
            if (x % i == 0) {
                currentPrime = false;
                break;
            }
        }

        if (currentPrime) {
            return x;
        }

        while (!currentPrime) {

            x++;
            currentPrime = true;

            for (int i = 2; i < x; i++) {
                if (x % i == 0) {
                    currentPrime = false;
                    break;
                }
            }
        }

        return x;
    }

    public static void Task10(){
        int a = 3;
        int b = 4;
        int c = 5;
        System.out.println("The result is: " + rightTriange(a, b, c));
    }

    public static boolean rightTriange(int a, int b, int c) {
        return a * a + b * b == c * c || a * a + c * c == b * b || b * b + c * c == a * a;
    }
}
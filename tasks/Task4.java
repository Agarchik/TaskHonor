public class Task4 {
    public static void main(String[] args) {
        System.out.println("\n****Test 1****");
        Task1();
        System.out.println("\n****Test 2****");
        Task2();
        System.out.println("\n****Test 3****");
        Task3();
        System.out.println("\n****Test 4****");
        Task4();
        System.out.println("\n****Test 5****");
        Task5();
        System.out.println("\n****Test 6****");
        Task6();
        System.out.println("\n****Test 7****");
        Task7();
        System.out.println("\n****Test 8****");
        Task8();
        System.out.println("\n****Test 9****");
        Task9();
        System.out.println("\n****Test 10****");
        Task10();
    }
    public static void Task1()
    {
        String string = "hello my name is Bessie and this is my essay";
        int n = 10;
        int k = 7;
        System.out.println(BessiesEssay(n, k, string));
    }

    public static String BessiesEssay(int n, int k, String str)
    {
        int r = 0;
        String[] letter = str.split(" ");
        String result = "";
        str = "";
        for (int i = 0; i < n; i++){
            if( str.length() + letter[i].length() > k){
                result = result.trim() + "\r\n" + letter[i] + " ";
                str = letter[i];
            } else{
                result = result + letter[i] + " ";
                str = str + letter[i];
            }
        }
        return result.trim();
    }
    public static void Task2()
    {
        String str = "()()()";
        for (String s : split(str))
            System.out.print(s + " ");
        System.out.println("");
    }
    public static String[] split(String str)
    {
        char[] chars = str.toCharArray();
        StringBuilder build = new StringBuilder();

        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            switch (chars[i]) {
                case '(': count++;
                break;
                case ')': count--;
                break;
            }

            build.append(chars[i]);

            if (count < 0) return null;
            if (count == 0) build.append(" ");
        }
        return build.toString().split(" ");
    }

    public static void Task3()
    {
        String strS = "helloEdabit";
        String strC = "hello_edabit";
        System.out.println("Result in snake_case:" + toSnakeCase(strC));
        System.out.println("Result in camelCase:"  + toCamelCase(strS));
    }

    public static String toSnakeCase(String str)
    {
        String result = "";
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (Character.isUpperCase(ch)) {
                result = result + '_';
                result= result + Character.toLowerCase(ch);
            }
            else {
                result = result + ch;
            }
        }

        return result;
    }

    public static String toCamelCase(String str)
    {
        StringBuilder builder = new StringBuilder(str);
        for (int i = 0; i < builder.length(); i++) {
            if (builder.charAt(i) == '_') {
                builder.deleteCharAt(i);
                builder.replace(i, i + 1, String.valueOf(Character.toUpperCase(builder.charAt(i))));
            }
        }
        return builder.toString();
    }

    public static void Task4()
    {
        String s = "9 17 30 1.5";
        System.out.println("$"+ String.format("%.2f",overTime(s)));
    }

    public static double overTime(String s)
    {
        String [] ot = s.split(" ");
        double [] money = new double[ot.length];
        double sum = 0;
        for (int i = 0; i < ot.length; i++)
            money[i] = Double.parseDouble(ot[i]);
        if (money[1] <=17)
            sum = (money[1] - money[0])*money[2];
        else
            sum = (money[1] - 17)*money[2]*money[3] + (17 - money[0])*money[2];
        return sum;
    }

    public static void Task5()
    {
        String weight = "205 pounds";
        String height = "73 inches";
        System.out.println("Result: ");
        System.out.println(bmi(weight, height));
    }

    public static String bmi(String weight, String height)
    {
        double weightD = Double.parseDouble(weight.split(" ")[0]);
        double heightD = Double.parseDouble(height.split(" ")[0]);
        String res = "";
        if (weight.contains("pounds"))
            weightD *= 0.45;
        if (height.contains("inches"))
            heightD *= 0.0254;
        double bmi = Math.round((weightD / (heightD * heightD)) * 10.0) / 10.0;
        if (bmi < 18.5)
            bmi = Math.ceil(bmi);
        res = bmi + " Underweight";
        if (bmi >= 18.5 && bmi <= 24.9)
            bmi = Math.ceil(bmi);
        res = bmi + " Normal weight";
        if (bmi > 25)
            bmi = Math.ceil(bmi);
        res = bmi + " Overweight";
        return res;
    }

    public static void Task6()
    {
        int num = 39;
        System.out.println(bugger(num));
    }

    public static int bugger(int n)
    {
        int count = 0;
        while (n > 9) {
            int dig = 1;
            while (n > 0) {
                dig *= n % 10;
                n /= 10;
            }
            n = dig;
            count++;
        }
        return count;
    }

    public static void Task7()
    {
        String s = "abbbbcccccc";
        System.out.println("Result: ");
        System.out.println(toStarShorthand(s));
    }

    public static String toStarShorthand(String str)
    {
        int count = 1;
        char l = str.charAt(0);
        String newStr = "";
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) != l) {
                if (count != 1)
                    newStr += l + "*" + count;
                else
                    newStr += l;
                l = str.charAt(i);
                count = 1;
            } else
                count++;
        }
        if (count != 1)
            newStr += l + "*" + count;
        else
            newStr += l;
        return newStr;
    }

    public static void Task8()
    {
        String s = "Sam I am!";
        String s1 = "Green eggs and ham.";
        System.out.println("Result: " + doesRhyme(s,s1));
    }

    public static boolean doesRhyme(String s1, String s2)
    {
        s1 = s1.substring(s1.lastIndexOf(" ") + 1).toLowerCase();
        s2 = s2.substring(s2.lastIndexOf(" ") + 1).toLowerCase();
        char[] lettersInEng = {'a', 'e', 'i', 'o', 'u', 'y' };
        String sublett1 = "";
        String sublett2 = "";
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < lettersInEng.length; j++) {
                if (s1.charAt(i) == lettersInEng[j]) sublett1 += lettersInEng[j];
            }
        }

        for (int i = 0; i < s2.length(); i++) {
            for (int j = 0; j < lettersInEng.length; j++) {
                if (s2.charAt(i) == lettersInEng[j]) sublett2 += lettersInEng[j];
            }
        }

        return sublett1.equals(sublett2);
    }

    public static void Task9()
    {
        String num1 = "451999277";
        String num2 = "41177722899";
        System.out.println("Result: ");
        System.out.println(trouble(num1,num2));
    }

    public static boolean trouble(String num1, String num2)
    {
        int sym = 0;
        for (int i = 2; i < num1.length(); i++) {
            if (num1.charAt(i) == num1.charAt(i - 1) && num1.charAt(i) == num1.charAt(i - 2))
                sym = num1.charAt(i);
        }
        for (int i = 0; i < num2.length(); i++) {
            if (num2.charAt(i) == sym && num2.charAt(i + 1) == sym)
                return true;
        }
        return false;
    }

    public static void Task10()
    {
        String stringSequence = "AZYWABBCATTTA";
        String bookEnd = "A";
        System.out.println("Result: ");
        System.out.println(countUniqueBooks(stringSequence,bookEnd));

    }

    public static int countUniqueBooks(String stringSequence, String bookEnd)
    {
        String new_s = "";
        int counter = 0;
        int index = 0;
        for (int i = 0; i<stringSequence.length(); i++)
            if (stringSequence.charAt(i) == bookEnd.charAt(0))
                counter++;
        for (int i = 0; i<counter/2; i++) {
            index = stringSequence.indexOf(bookEnd, index);
            int nextIndex = stringSequence.indexOf(bookEnd, index + 1);
            new_s += stringSequence.substring(index+1, nextIndex);
            index = stringSequence.indexOf(bookEnd, nextIndex + 1);
        }
        counter = 0;
        boolean[] isItThere = new boolean[Character.MAX_VALUE];
        for (int i = 0; i < new_s.length(); i++) {
            isItThere[new_s.charAt(i)] = true;
        }
        for (int i = 0; i < isItThere.length; i++) {
            if (isItThere[i]){
                counter++;
            }
        }
        return counter;
    }
}
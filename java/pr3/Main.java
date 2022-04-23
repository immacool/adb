public class Main {
    public static void main(String[] args) {
        // задача 1
        for (int i = 1; i <= 99; i++)
            if (i % 2 != 0)
                System.out.println(i);

        // задача 2
        int n = 7;
        int fac = 1;

        for (int i = 0; i < n; i++)
            fac += fac * i;

        System.out.println(fac);

        // задача 3
        int i = 0;
        int j = 0;
        int n = 7;
        int fac = 1;

        while (i < 100) {
            i += 1;

            if (i % 2 != 0)
                System.out.println(i);
        }

        while (j < n) {
            j += 1;

            fac += fac * j;
        }

        // задача 4
        int x = 9;
        int n = 4;

        System.out.println(Math.pow(x, n));

        // задача 5
        int n = 0;

        for (int i = 0; i < 10; i++) {
            n -= 5;

            System.out.println(n);
        }

        // задача 6
        String searchMe = "Мама мыла раму";
        int max = searchMe.length();
        char symb = 'ы';
        int find = 0;
        for (int i = 0; i < max; i++) {
            if (searchMe.charAt(i) == symb) {
                find++;
                if (find == 2)
                    break;
            }
        }

        if (find)
            System.out.println("Символ '" + symb + "' найден в строке");
        else
            System.out.println("Символ '" + symb + "' не найден в строке");
    }
}
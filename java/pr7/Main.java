import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // задание 2.2
        // Создать приложение с использованием рекурсии для
        // перевода целого числа, введенного с клавиатуры, в двоичную систе-
        // му счисления.
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите целое число:");
        int number = scanner.nextInt();
        StringBuilder result = new StringBuilder();
        for (int i = 31; i >= 0; i--) {
            int mask = 1 << i;
            result.append((number & mask) != 0 ? "1" : "0");
        }
        System.out.println("Двоичное число: " + result);

        // задание 2.3
        // Создать приложение, позволяющее ввести и вывести
        // одномерный массив целых чисел. Для ввода и вывода массива разра-
        // ботать рекурсивные методы вместо циклов for.
        int[] array = new int[10];
        task2(arraySize, 0, new int[arraySize + 1]);
        
        // задание 2.4
        // Ознакомиться с теорией и исследовать работу про-
        // граммы для нахождения корней нелинейного уравнения методом
        // Ньютона и методом деления отрезка пополам, описанную в приложе-
        // нии 1 лабораторного практикума. Выполнить собственную реализа-
        // цию методов с помощью рекурсии и проверить их на уравнениях,
        // приведенных в табл. 2.1 согласно заданному варианту.
        System.out.println(x_div(1,2,0.000001));
        
    }

    public static double F(double x){
        return Math.pow(x, 3) - 5 * Math.pow(x, 2) + 2 * x + 8;
    }

    public static double f(double x){
        return 2 * Math.pow(x,2) - 8 * x -20;
    }

    public static double newtone(double a, double e){
        double xn = a - F(a) / f(a);
        double razn = Math.abs( xn - a);
        if(razn > e){
            return newtone(xn, e);
        }
        else {
            return xn;
        }
    }

    public static double x_div(double a, double b, double e){
        if(b - a > e){
            double c =  (a + b) / 2;
            if(F(a) *  (F(c)) < 0){
                return (x_div(a, c, e));
            }
            else{
                if(F(a) * F(c) > 0){
                    return x_div(c, b, e);
                }
                else {
                    return c;
                }
            }
        }
        else {
            return (a + b) / 2;
        }
    }

    public static void task2(final int arraySize, int currentIndex, int[] arr) {
        Scanner scanner = new Scanner(System.in);
        arr[currentIndex] = scanner.nextInt();

        if (arraySize != currentIndex)
            task2(arraySize, currentIndex+1, arr);

    }
}
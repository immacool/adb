// import scanner
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // тест для головного списка
        LinkedListHead list = new LinkedListHead();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        
        Node node = list.head;
        while (node != null) {
            System.out.println(node.value);
            node = node.next;
        }

        // тест для хвостового списка
        LinkedListTail list2 = new LinkedListTail();
        list2.add(1);
        list2.add(2);
        list2.add(3);
        list2.add(4);
        list2.add(5);

        node = list2.head;
        while (node != null) {
            System.out.println(node.value);
            node = node.next;
        }

        // тест для списка с помощью рекурсии
        LinkedListRec list3 = new LinkedListRec();
        list3.createHeadRec();
        list3.createTailRec();
        list3.add(1);
        list3.add(2);
        list3.add(3);
        list3.add(4);
        list3.add(5);
        System.out.println(list3.toStringRec());

        // тест для списка с помощью цикла
        LinkedListRec list4 = new LinkedListRec();
        list4.createHead();
        list4.createTail();
        list4.add(1);
        list4.add(2);
        list4.add(3);
        list4.add(4);
        list4.add(5);
        System.out.println(list4.toString());

        // тест пункта 3.4
        Task3_4.test();
    } 
}


// Задание 3.2.
// Создать два проекта, в которых продемонстрировать
// два способа создания линейного однонаправленного списка (с головы
// и с хвоста)
public class Node {
    int value;
    Node next;
    Node(int value) {
        this.value = value;
    }
}


class LinkedListTail {
    Node head;
    Node tail;
    public void add(int value) {
        Node node = new Node(value);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
    }
}


class LinkedListHead {
    Node head;
    Node tail;
    public void add(int value) {
        Node node = new Node(value);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            head = node;
        }
    }
}


// Задание 3.3.
// Разработать проект, в котором для ввода, вывода и
// изменения односвязного линейного списка создать следующие методы:
// а) с использованием цикла:
// – ввод с головы createHead();
// – ввод с хвоста createTail();
// – вывод (возвращается строка, сформированная из элементов списка) toString();
// – добавление элемента в начало списка AddFirst();
// – добавление элемента в конец списка AddLast();
// – вставка элемента в список с указанным номером Insert();
// – удаление элемента с головы списка RemoveFirst();
// – удаление последнего элемента списка RemoveLast();
// – удаление из списка элемента с указанным номером Remove();
// а) с использованием рекурсии:
// – ввод с головы createHeadRec();
// – ввод с хвоста createTailRec();
// – вывод (возвращается строка, сформированная из элементов списка) toStringRec().
public class LinkedListRec {
    Node head;
    Node tail;
    public void createHead() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите значение для головы списка");
        int value = scanner.nextInt();
        Node node = new Node(value);
        head = node;
        tail = node;
    }
    public void createTail() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите значение для хвоста списка");
        int value = scanner.nextInt();
        Node node = new Node(value);
        tail.next = node;
        tail = node;
    }
    public void add(int value) {
        Node node = new Node(value);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
    }
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node node = head;
        while (node != null) {
            sb.append(node.value);
            node = node.next;
        }
        return sb.toString();
    }
    public void addFirst(int value) {
        Node node = new Node(value);
        node.next = head;
        head = node;
    }
    public void addLast(int value) {
        Node node = new Node(value);
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }
    }
    public void insert(int value, int index) {
        Node node = new Node(value);
        if (index == 0) {
            node.next = head;
            head = node;
        } else {
            Node prev = head;
            for (int i = 0; i < index - 1; i++) {
                prev = prev.next;
            }
            node.next = prev.next;
            prev.next = node;
        }
    }
    public void removeFirst() {
        head = head.next;
    }
    public void removeLast() {
        Node prev = head;
        while (prev.next != tail) {
            prev = prev.next;
        }
        tail = prev;
        tail.next = null;
    }
    public void remove(int index) {
        if (index == 0) {
            head = head.next;
        } else {
            Node prev = head;
            for (int i = 0; i < index - 1; i++) {
                prev = prev.next;
            }
            prev.next = prev.next.next;
        }
    }
    public String toStringRec() {
        return toStringRec(head);
    }
    private String toStringRec(Node node) {
        if (node == null) {
            return "";
        }
        return node.value + " " + toStringRec(node.next);
    }
    public void createHeadRec() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите значение для головы списка");
        int value = scanner.nextInt();
        head = new Node(value);
        tail = head;
    }
    public void createTailRec() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите значение для хвоста списка");
        int value = scanner.nextInt();
        Node node = new Node(value);
        tail.next = node;
        tail = node;
    }
}


// Задание 3.4
// Ввести с клавиатуры список из n целых чисел.
// а) Найти сумму, количество и среднее значение среди чисел, делящихся на 7
// б) Найти среди положительных чисел данного массива минимальное и макси-
// мальное значения и их номера и поменять их местами.
public class Task3_4 {
    public static void test() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите количество чисел в списке");
        int n = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Введите число");
            array[i] = scanner.nextInt();
        }
        System.out.println("Сумма чисел, делящихся на 7: " + sum(array));
        System.out.println("Количество чисел, делящихся на 7: " + count(array));
        System.out.println("Среднее значение чисел, делящихся на 7: " + average(array));
        System.out.println("Массив после перестановки минимального и максимального чисел: " + minMax(array));
    }
    public static int sum(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 7 == 0) {
                sum += array[i];
            }
        }
        return sum;
    }
    public static int count(int[] array) {
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 7 == 0) {
                count++;
            }
        }
        return count;
    }
    public static double average(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 7 == 0) {
                sum += array[i];
            }
        }
        return (double) sum / count(array);
    }
    public static int[] minMax(int[] array) {
        int min = array[0];
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
            if (array[i] > max) {
                max = array[i];
            }
        }
        array[array.length - 1] = min;
        array[array.length - 2] = max;
        return array;
    }
}
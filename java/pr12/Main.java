public class Main {
    public static void main(String[] args) {
        // 1-й проект – работа с файлом с произвольным доступом;
        // 2-й проект – работа через сериализацию.
        // Вариант 3
        // Записать в исходный файл информацию о людях: Фамилия, Имя, Отчество, возраст, вес
        // Количество людей задать с клавиатуры.
        // Создать программным способом другой файл и переписать в него информацию о людях в возрасте до 18 лет.
        try {
            FileReader fr = new FileReader("input.txt");
            BufferedReader br = new BufferedReader(fr);
            FileWriter fw = new FileWriter("output.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            String line;
            int count = Integer.parseInt(br.readLine());
            while ((line = br.readLine()) != null) {
                String[] words = line.split(" ");
                int age = Integer.parseInt(words[3]);
                if (age < 18) {
                    bw.write(line);
                    bw.newLine();
                    count++;
                }
            }
            bw.write(count);
            bw.newLine();
            bw.close();
            fw.close();
            br.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

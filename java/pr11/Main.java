class Main {
    public static void main(String[] args) {
        // Переписать в результирующий файл слова, начинающиеся с русских согласных букв.
        // Требования:
        // – слова из предложения выделять методом split();
        // – в новом файле следует указать номер строки, в которой иско-
        // мые слова находились в исходном файле;
        // – для каждой строки указать количество выбранных слов.
        try {
            FileReader fr = new FileReader("input.txt");
            BufferedReader br = new BufferedReader(fr);
            FileWriter fw = new FileWriter("output.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            String line;
            int lineNumber = 1;
            while ((line = br.readLine()) != null) {
                String[] words = line.split(" ");
                int count = 0;
                for (String word : words) {
                    if (word.matches("^[аеёиоуыэюя].*")) {
                        bw.write(word);
                        bw.newLine();
                        count++;
                    }
                }
                if (count > 0) {
                    bw.write(lineNumber + " " + count);
                    bw.newLine();
                }
                lineNumber++;
            }
            bw.close();
            fw.close();
            br.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
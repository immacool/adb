class Main {
    // В исходном файле содержится произвольное количество чисел типа int. 
    // В результирующий файл переписать числа, которые делятся на 3.
    public static void main(String[] args) {
        try {
            FileReader fr = new FileReader("input.txt");
            BufferedReader br = new BufferedReader(fr);
            FileWriter fw = new FileWriter("output.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            String line;
            while ((line = br.readLine()) != null) {
                int value = Integer.parseInt(line);
                if (value % 3 == 0) {
                    bw.write(line);
                    bw.newLine();
                }
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
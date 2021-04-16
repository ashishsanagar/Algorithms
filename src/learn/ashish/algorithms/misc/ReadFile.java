package learn.ashish.algorithms.misc;

import java.io.*;

public class ReadFile {

    public static void main(String[] args) {
        new ReadFile().readFile();
    }

    public void readFile() {
        File file = new File("test.txt");

        try {
            if (file.exists()) {
                file.delete();
            }

            if (file.createNewFile()) {
                System.out.println("File created");
            } else {
                System.out.println("File creation failed");
            }

            FileOutputStream out = new FileOutputStream(file);
            out.write("This is a test ".getBytes());
            out.write("\nThis is a test2 ".getBytes());
            out.close();

            PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(file)));
            pw.println("write using PrintWriter");
            pw.println("write using PrintWriter continued ...");
            pw.close();

            BufferedReader reader = new BufferedReader(new FileReader(file));

            String line = reader.readLine();
            while (line != null) {
                System.out.println(line);

                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

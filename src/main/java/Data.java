import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
public class Data {
    private static final String filename = "./src/main/java/tina.txt";
    public static void write(ArrayList<Task> list) throws TinaException{
        try {
            FileWriter writer = new FileWriter(filename);
            for (Task task : list) {
                writer.write(task.toString() + "\n");
            }
            writer.close();
        } catch (IOException e) {
            throw new TinaException("error occurred while writing the task list to the file");
        }
    }

    public static ArrayList<Task> read() {
        ArrayList<Task> list = new ArrayList<>();
        try {
            File file = new File(filename);
//            System.out.println("Looking for file at: " + file.getAbsolutePath());
            if (!file.exists()) {
                file.createNewFile();
            }
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;
            while ((line = reader.readLine()) != null) {
                Task task = Parse.parseLine(line);
                list.add(task);
            }
            reader.close();
        } catch (IOException e) {
            throw new TinaException("error occurred while reading the task list from the file");
        }
        return list;
    }
}

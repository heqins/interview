import java.io.File;
import java.nio.file.Files;

public class Counter2 {
    public static void main(String[] args) {
        File file = new File("C:\\");
        File[] files = file.listFiles();
        readFiles(files);
    }

    public static void readFiles(File[] files) {
        if (files == null) {
            return;
        }

        for (File f: files) {
            if (f.isFile()) {
                System.out.println(f.getName());
            }else if (f.isDirectory()) {
                readFiles(f.listFiles());
            }
        }
    }
}

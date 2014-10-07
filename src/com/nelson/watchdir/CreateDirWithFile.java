import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by tjnelson on 3/17/14.
 */
public class CreateDirWithFile {

    public static void main(String[] args) throws IOException {

        int count = 90000;
        Path dir = Paths.get("/Users/tjnelson/Downloads");

        // Copy image into directory
        String imageName = "thomasmonson.jpg";

        for (int i = 1; i <= count; i++) {
            Path filePath = Paths.get(dir + "/b" + i);
            Files.createDirectory(filePath);


            Path source = Paths.get("/Users/tjnelson/Dropbox/java/sandbox/src/com/nelson/watchdir/" + imageName);
            Path target = Paths.get(filePath + "/" + imageName);
            Files.copy(source, target);
        }
    }
}

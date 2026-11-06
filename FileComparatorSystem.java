import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FileComparatorSystem {
    public boolean checkIfFileExists(String filePath) {
        File file = new File(filePath);
        return file.exists();
    }

    public String getUnixDiff(String oldFile, String newFile) {
        File oldFileObject = new File(oldFile);
        File newFileObject = new File(newFile);

        String oldFilePath = oldFileObject.getAbsolutePath();
        String newFilePath = newFileObject.getAbsolutePath();

        ProcessBuilder processBuilder = new ProcessBuilder("diff", "-u", oldFilePath, newFilePath);

        try {
            Process process = processBuilder.start();
            InputStream inputStream = process.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            return bufferedReader.readAllAsString();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}

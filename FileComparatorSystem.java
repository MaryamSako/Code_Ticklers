import java.io.File;

public class FileComparatorSystem {
    public boolean checkIfFileExists(String filePath) {
        File file = new File(filePath);
        return file.exists();
    }

    //public String calculateUnixDiff(String oldFile, String newFile) {

    //}
}

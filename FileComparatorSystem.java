import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FileComparatorSystem {
    /**
     * Checks if a file path is valid.
     * <p>
     * This method takes a file path entered by the user via
     * the command line as a string. It uses the string to
     * create a File object and calls exists() method and returns
     * a boolean value.
     * </P>
     * @param filePath 
     * @return True if the file exists, false otherwise.
     */
    public boolean checkIfFileExists(String filePath) {
        File file = new File(filePath);
        return file.exists();
    }

    /**
     * Returns the Unix difference between two files.
     * <p>
     * This method accepts two valid file paths as strings
     * and uses the ProcessBuilder class to perform the
     * Unix diff command on the given files. It returns the
     * result of the difference. If an exception or error
     * occurs, an empty string is returned.
     * </p>
     * @param oldFile
     * @param newFile
     * @return The Unix difference of the two files as a string.
     * If an exception or error occurs, an empty string is returned.
     */
    public String getUnixDiff(String oldFile, String newFile) {
        File oldFileObject = new File(oldFile);
        File newFileObject = new File(newFile);

        String oldFilePath = oldFileObject.getAbsolutePath();
        String newFilePath = newFileObject.getAbsolutePath();

        // Setup for running the Unix diff command
        ProcessBuilder processBuilder = new ProcessBuilder("diff", "-u", oldFilePath, newFilePath);

        try {
            // Runs the command and returns the result as a string
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

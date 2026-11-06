import java.util.Scanner;

public class SourceControlSystem {
  public static void main(String[] args) {

    FileComparatorSystem fileComparatorSystem = new FileComparatorSystem();

    // User inputs the names of two files to compare
    // from the command line.
    Scanner scanner = new Scanner(System.in);
    System.out.printf("Please enter two file paths to compare: ");
    String oldFile = scanner.next();
    String newFile = scanner.next();

    // Checks if the file paths are valid.
    boolean oldFileExists = fileComparatorSystem.checkIfFileExists(oldFile);
    boolean newFileExists = fileComparatorSystem.checkIfFileExists(newFile);

    // Continuously prompts the user to enter valid file paths
    // until they do.
    while (!oldFileExists || !newFileExists) {
      System.out.printf("At least one of the entered file paths is invalid. Please try again: ");
      oldFile = scanner.next();
      newFile = scanner.next();

      oldFileExists = fileComparatorSystem.checkIfFileExists(oldFile);
      newFileExists = fileComparatorSystem.checkIfFileExists(newFile);
    }

    scanner.close();


  }
}

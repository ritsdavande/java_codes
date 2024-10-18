import java.io.*;
import java.util.Scanner;
public class ReadFile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the filename: ");
        String filename = scanner.nextLine();
            try {
            FileInputStream fis = new FileInputStream(filename);
            int content;
            System.out.println("Contents of the file:");
            while ((content = fis.read()) != -1) {
                System.out.print((char) content); // Display contents
            }
            fis.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found. A new file will be created.");
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file.");
            e.printStackTrace();
        }

        System.out.print("\nDo you want to add contents to the file? (yes/no): ");
        String response = scanner.nextLine();

        if (response.equalsIgnoreCase("yes")) {
            
            System.out.print("Enter the contents to append to the file: ");
            String userData = scanner.nextLine();

            try (FileOutputStream fos = new FileOutputStream(filename, true)) { // true for append mode
                fos.write(userData.getBytes()); // Convert string to bytes and write
                fos.write(System.lineSeparator().getBytes()); // Add a newline after the data
                System.out.println("Data successfully appended to the file.");
            } catch (IOException e) {
                System.out.println("An error occurred while writing to the file.");
                e.printStackTrace();
            }
        } else {
            System.out.println("No changes made to the file.");
        }
        scanner.close(); // Close the scanner
    }
}

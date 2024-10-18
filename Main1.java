import java.io.*;
import java.util.Scanner;

class StudentInfo {
    private String rollNo;
    private String studentClass;
    private int age;
    private float weight;
    private float height;
    private String city;
    private String phone;

    public void getDetails() throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Roll No: ");
        rollNo = scanner.nextLine();
        
        System.out.print("Enter Class: ");
        studentClass = scanner.nextLine();
        
        System.out.print("Enter Age: ");
        age = Integer.parseInt(scanner.nextLine());
        
        System.out.print("Enter Weight (kg): ");
        weight = Float.parseFloat(scanner.nextLine());
        
        System.out.print("Enter Height (cm): ");
        height = Float.parseFloat(scanner.nextLine());
        
        System.out.print("Enter City: ");
        city = scanner.nextLine();
        
        System.out.print("Enter Phone: ");
        phone = scanner.nextLine();
        
        scanner.close();
    }

    public void writeToFile(String filename) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileOutputStream(filename))) {
            writer.println(rollNo);
            writer.println(studentClass);
            writer.println(age);
            writer.println(weight);
            writer.println(height);
            writer.println(city);
            writer.println(phone);
        }
    }

    public void readFromFile(String filename) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            System.out.println("Student Details:");
            System.out.println("Roll No: " + reader.readLine());
            System.out.println("Class: " + reader.readLine());
            System.out.println("Age: " + reader.readLine());
            System.out.println("Weight: " + reader.readLine() + " kg");
            System.out.println("Height: " + reader.readLine() + " cm");
            System.out.println("City: " + reader.readLine());
            System.out.println("Phone: " + reader.readLine());
        }
    }
}

public class Main1 {
    public static void main(String[] args) {
        StudentInfo student = new StudentInfo();
        String filename = "student_info.txt"; // Changed to .txt for better clarity

        try {
            student.getDetails(); // Get student details from user

            student.writeToFile(filename); // Write student details to file

            student.readFromFile(filename); // Read and display student details from file
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}

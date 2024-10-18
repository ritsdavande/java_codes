import java.io.*;
import java.util.Scanner;

class StudentInfo {
    private String name;
    private int age;
    private String studentId;


    public void getDetails() {
        try (DataInputStream dis = new DataInputStream(System.in)) {
            Scanner scanner = new Scanner(dis);
            System.out.print("Enter student name: ");
            this.name = scanner.nextLine();
            System.out.print("Enter student age: ");
            this.age = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.print("Enter student ID: ");
            this.studentId = scanner.nextLine();
        } catch (IOException e) {
            System.out.println("Error reading input: " + e.getMessage());
        }
    }


    public void writeToFile(String filename) {
        try (FileOutputStream fos = new FileOutputStream(filename);
             DataOutputStream dos = new DataOutputStream(fos)) {
            dos.writeUTF(name);
            dos.writeInt(age);
            dos.writeUTF(studentId);
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

   
    public void readFromFile(String filename) {
        try (FileInputStream fis = new FileInputStream(filename);
             DataInputStream dis = new DataInputStream(fis)) { 
            String name = dis.readUTF();
            int age = dis.readInt();
            String studentId = dis.readUTF();
            System.out.println("Student Details:");
            System.out.println("Name: " + name);
            System.out.println("Age: " + age);
            System.out.println("Student ID: " + studentId);
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
    }
	public class Main2{
    public static void main(String[] args) {
        StudentInfo student = new StudentInfo();
        student.getDetails();

        String filename = "studentinfo.dat";
        student.writeToFile(filename);
        student.readFromFile(filename);
    }
}
}

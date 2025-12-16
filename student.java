import java.util.Scanner;


class Student {
    String name;
    String usn;
    String collegeName;
    int age;

    Scanner sc = new Scanner(System.in);

    public void studDetails() {
        System.out.println("Enter student name:");
        name = sc.nextLine();

        System.out.println("Enter student USN:");
        usn = sc.nextLine();

        System.out.println("Enter college name:");
        collegeName = sc.nextLine();

        System.out.println("Enter student age:");
        age = sc.nextInt();
    }

    public void displayDetails() {
        System.out.println("\nStudent Name: " + name);
        System.out.println("USN: " + usn);
        System.out.println("College Name: " + collegeName);
        System.out.println("Age: " + age);
    }
}


class SecondYear extends Student {
    public void calcPercentage() {
        int total = 0;
        System.out.println("Enter marks for 6 subjects:");

        for (int i = 1; i <= 6; i++) {
            System.out.println("Enter marks for subject " + i + ":");
            int marks = sc.nextInt();
            total += marks;
        }

        float percentage = (total / 600.0f) * 100;
        System.out.println("Percentage: " + percentage + "%");
    }
}


class ThirdYear extends Student {
    public void calcPercentage() {
        int total = 0;
        System.out.println("Enter marks for 8 subjects:");

        for (int i = 1; i <= 8; i++) {
            System.out.println("Enter marks for subject " + i + ":");
            int marks = sc.nextInt();
            total += marks;
        }

        float percentage = (total / 800.0f) * 100;
        System.out.println("Percentage: " + percentage + "%");
    }
}


class FourthYear extends Student {
    public void calcPercentage() {
        int total = 0;
        System.out.println("Enter marks for 4 subjects:");

        for (int i = 1; i <= 4; i++) {
            System.out.println("Enter marks for subject " + i + ":");
            int marks = sc.nextInt();
            total += marks;
        }

        float percentage = (total / 400.0f) * 100;
        System.out.println("Percentage: " + percentage + "%");
    }
}

public class Main {
    public static void main(String[] args) {

        SecondYear s = new SecondYear();

        s.studDetails();
        s.displayDetails();
        s.calcPercentage();
    }
}

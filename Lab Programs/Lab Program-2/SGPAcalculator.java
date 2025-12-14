import java.util.Scanner;

class Student {
    String usn;
    String name;
    int[] credits;
    int[] marks;

    public void acceptDetails(Scanner sc) {
        System.out.print("Enter USN: ");
        usn = sc.nextLine();

        System.out.print("Enter Name: ");
        name = sc.nextLine();

        System.out.print("Enter number of subjects: ");
        int numSubjects = sc.nextInt();

        credits = new int[numSubjects];
        marks = new int[numSubjects];

        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Enter credits for subject " + (i + 1) + ": ");
            credits[i] = sc.nextInt();

            System.out.print("Enter marks for subject " + (i + 1) + ": ");
            marks[i] = sc.nextInt();
        }
        sc.nextLine(); // clear buffer
    }

    public void displayDetails() {
        System.out.println("\nStudent Details:");
        System.out.println("USN: " + usn);
        System.out.println("Name: " + name);

        for (int i = 0; i < credits.length; i++) {
            System.out.println("Subject " + (i + 1) +
                    " - Credits: " + credits[i] +
                    ", Marks: " + marks[i]);
        }
    }

    public double calculateSGPA() {
        double totalCredits = 0;
        double weightedSum = 0;

        for (int i = 0; i < credits.length; i++) {
            int gradePoint;

            if (marks[i] >= 90) gradePoint = 10;
            else if (marks[i] >= 80) gradePoint = 9;
            else if (marks[i] >= 70) gradePoint = 8;
            else if (marks[i] >= 60) gradePoint = 7;
            else if (marks[i] >= 50) gradePoint = 6;
            else if (marks[i] >= 40) gradePoint = 5;
            else gradePoint = 0;

            weightedSum += gradePoint * credits[i];
            totalCredits += credits[i];
        }

        return (totalCredits == 0) ? 0 : weightedSum / totalCredits;
    }
}

public class SGPAcalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Student student = new Student();

        student.acceptDetails(sc);
        student.displayDetails();

        double sgpa = student.calculateSGPA();
        System.out.printf("SGPA of the student: %.2f\n", sgpa);

        sc.close();
    }
}

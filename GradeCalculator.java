import java.util.Scanner;

public class GradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalSubjects, totalMarks;
        double averagePercentage;

        // Step 1: Input - Take marks obtained (out of 100) in each subject.
        System.out.print("Enter the total number of subjects: ");
        totalSubjects = scanner.nextInt();
        int[] subjectMarks = new int[totalSubjects];

        for (int i = 0; i < totalSubjects; i++) {
            int mark;
            do {
                System.out.print("Enter marks obtained in subject " + (i + 1) + " (0-100): ");
                mark = scanner.nextInt();
            } while (mark < 0 || mark > 100); // Check for valid mark range
            subjectMarks[i] = mark;
        }

        // Step 2: Calculate Total Marks - Sum up the marks obtained in all subjects.
        totalMarks = 0;
        for (int i = 0; i < totalSubjects; i++) {
            totalMarks += subjectMarks[i];
        }

        // Step 3: Calculate Average Percentage - Divide the total marks by the total number of subjects.
        averagePercentage = (double) totalMarks / totalSubjects;

        // Step 4: Grade Calculation - Assign grades based on the average percentage achieved.
        String grade;
        if (averagePercentage >= 90) {
            grade = "A+";
        } else if (averagePercentage >= 80) {
            grade = "A";
        } else if (averagePercentage >= 70) {
            grade = "B";
        } else if (averagePercentage >= 60) {
            grade = "C";
        } else if (averagePercentage >= 50) {
            grade = "D";
        } else {
            grade = "F";
        }

        // Step 5: Display Results - Show the total marks, average percentage, and the corresponding grade to the user.
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");
        System.out.println("Grade: " + grade);

        scanner.close();
    }
}

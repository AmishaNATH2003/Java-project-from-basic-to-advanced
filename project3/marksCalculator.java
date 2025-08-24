import java.util.*;

public class marksCalculator {
    // Grade function
    String grade(int marks) {
        if (marks >= 90) return "A+";
        else if (marks >= 75) return "A";
        else if (marks >= 65) return "B+";
        else if (marks >= 60) return "B";
        else if (marks >= 50) return "C+";
        else if (marks >= 45) return "C";
        else if (marks >= 40) return "D";
        else if (marks >= 33) return "E";
        else return "F";
    }

    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        marksCalculator obj = new marksCalculator(); // to use grade()

        System.out.print("Enter Number of Students: ");
        int Number = sc.nextInt();
        System.out.print("Enter Number of Subjects: ");
        int Subject = sc.nextInt();
        sc.nextLine();

        String[] name = new String[Number];
        double[][] marks = new double[Number][Subject];
        double[] totals = new double[Number];
        double[] percentages = new double[Number];
        String[] grades = new String[Number];
        double[] subjectTotals = new double[Subject];

        double topperPercentage = -1.0;
        int topperIndex = -1;

        // Input + Calculate totals & percentages
        for (int i = 0; i < Number; i++) {
            System.out.print("\nEnter Name of Student " + (i + 1) + ": ");
            name[i] = sc.nextLine().trim();

            System.out.println("Enter Marks of " + Subject + " Subjects:");
            double sum = 0.0;
            for (int j = 0; j < Subject; j++) {
                marks[i][j] = sc.nextDouble();
                sum += marks[i][j];
                subjectTotals[j] += marks[i][j];
            }
            sc.nextLine();

            totals[i] = sum;
            percentages[i] = sum / Subject;  // calculate %
            grades[i] = obj.grade((int) percentages[i]); // assign grade

            if (percentages[i] > topperPercentage) {
                topperPercentage = percentages[i];
                topperIndex = i;
            }
        }

        // Class average
        double classAvg = 0.0;
        for (double p : percentages) classAvg += p;
        classAvg /= Number;

        // Subject-wise averages
        double[] subjectAverages = new double[Subject];
        for (int j = 0; j < Subject; j++) subjectAverages[j] = subjectTotals[j] / Number;

        // Ranking (by percentage)
        int[] order = new int[Number];
        for (int i = 0; i < Number; i++) order[i] = i;

        for (int i = 0; i < Number - 1; i++) {
            int maxIdx = i;
            for (int k = i + 1; k < Number; k++) {
                if (percentages[order[k]] > percentages[order[maxIdx]]) {
                    maxIdx = k;
                }
            }
            int tmp = order[i];
            order[i] = order[maxIdx];
            order[maxIdx] = tmp;
        }

        // Output
        System.out.println("\n\n--- Student Report ---");
        for (int i = 0; i < Number; i++) {
            System.out.printf(
                "%s -> Total: %.0f, Percentage: %.2f%%, Grade: %s%n",
                name[i], totals[i], percentages[i], grades[i]
            );
        }

        System.out.printf("%nTopper: %s (%.2f%%)%n", name[topperIndex], topperPercentage);
        System.out.printf("Class Average: %.2f%%%n", classAvg);

        System.out.println("\nSubject-wise Averages:");
        for (int j = 0; j < Subject; j++) {
            System.out.printf("Subject %d: %.2f%n", (j + 1), subjectAverages[j]);
        }

        System.out.println("\n--- Ranking (by Percentage) ---");
        for (int rank = 0; rank < Number; rank++) {
            int i = order[rank];
            System.out.printf("%d) %s - %.2f%%%n", (rank + 1), name[i], percentages[i]);
        }
    }
}

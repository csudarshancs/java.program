import CIE.*;
import SEE.*;
import java.util.*;

public class finalMarks {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of students: ");
        int n = sc.nextInt();
        sc.nextLine();

        external[] ext = new external[n];
        Internals[] in = new Internals[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Student " + (i + 1) + ":");
            System.out.print("USN: ");
            String usn = sc.nextLine();
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Semester: ");
            int sem = sc.nextInt();

            ext[i] = new external(usn, name, sem);
            in[i] = new Internals();

            int[] internalMarks = new int[5];
            int[] seeMarks = new int[5];

            System.out.println("Enter 5 internal marks:");
            for (int j = 0; j < 5; j++) internalMarks[j] = sc.nextInt();

            System.out.println("Enter 5 SEE marks:");
            for (int j = 0; j < 5; j++) seeMarks[j] = sc.nextInt();

            in[i].setMarks(internalMarks);
            ext[i].setSEE(seeMarks);
            sc.nextLine(); 
        }

        System.out.println("\n----- Final Marks -----");
        for (int i = 0; i < n; i++) {
            ext[i].displayPersonal();
            int[] finalMarks = new int[5];

            for (int j = 0; j < 5; j++) {
                
                finalMarks[j] = in[i].internalMarks[j] + (ext[i].seeMarks[j] / 2);
            }

            System.out.print("Final Marks in 5 Courses: ");
            for (int m : finalMarks) System.out.print(m + " ");
            System.out.println("\n");
        }

        sc.close();
    }
}
import java.util.Scanner;

class Subject {
    int subjectMarks;
    int credits;
    int grade;
}

class Student {
    String name;
    String usn;
    double SGPA;
    Subject subject[];
    Scanner s = new Scanner(System.in);

    Student() {
        subject = new Subject[8];
        for (int i = 0; i < 8; i++) {
            subject[i] = new Subject();
        }
    }

    void getStudentDetails() {
        System.out.print("Enter Student Name: ");
        name = s.nextLine();
        System.out.print("Enter Student USN: ");
        usn = s.nextLine();
    }

    void getMarks() {
        for (int i = 0; i < 8; i++) {
            System.out.println("\nEnter marks of subject" + (i + 1)+"::");
            subject[i].subjectMarks = s.nextInt();
            System.out.print("Enter Credits: ");
            subject[i].credits = s.nextInt();

            subject[i].grade = (subject[i].subjectMarks / 10) + 1;

            if (subject[i].grade == 11)
                subject[i].grade = 10;
            if (subject[i].grade <= 4)
                subject[i].grade = 0;
        }
    }

    void computeSGPA() {
        int Score = 0, Credits = 0;
        for (int i = 0; i < 8; i++) {
            Score += (subject[i].grade * subject[i].credits);
            Credits += subject[i].credits;
        }
        SGPA = (double) Score / Credits;
    }

    void display() {
        System.out.println("Name: " + name);
        System.out.println("USN: " + usn);
        System.out.printf("SGPA: %.2f\n", SGPA);
    }
}

public class studentSGPA {
    public static void main(String[] args) {
        int n;
        System.out.println("\nenter number of students:: ");
        Scanner s=new Scanner(System.in);
        n=s.nextInt();
        while (n>0){
        Student st = new Student();
        st.getStudentDetails();
        st.getMarks();
        st.computeSGPA();
        st.display();
        n-=1;
        }
    }
}
package corejavaproject;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("---------------------------------------------------------");
        System.out.println("      SMART STUDENT LEARNING BEHAVIOR ANALYZER");
        System.out.println("---------------------------------------------------------\n");

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();

        Student s = new Student(name, id);

        System.out.print("\nEnter number of subjects: ");
        int n = sc.nextInt();

        for(int i=0; i<n; i++) {
            while(true) {
                System.out.print("Enter marks for subject "+(i+1)+": ");
                try {
                    int mark = sc.nextInt();
                    s.addMark(mark);
                    break;
                } catch(Exception e) {
                    System.out.println(e.getMessage() + " Try again.");
                    sc.nextLine(); // clear buffer
                }
            }
        }

        BehaviorAnalyzer analyzer = new BehaviorAnalyzer();
        analyzer.generateReport(s);
    }
}

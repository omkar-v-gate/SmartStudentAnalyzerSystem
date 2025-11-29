package corejavaproject;

import java.util.*;

public class BehaviorAnalyzer {

    public void generateReport(Student s) {
        List<Integer> marks = s.getMarks();
        int total = s.getTotalMarks();
        double avg = s.calculateAverage();

        System.out.println("\n---------------------------------------------------------");
        System.out.println("STUDENT REPORT");
        System.out.println("---------------------------------------------------------");
        System.out.println("Name            : " + s.getName());
        System.out.println("Student ID      : " + s.getStudentId());
        System.out.println("Marks List      : " + marks);
        System.out.println("Total Marks     : " + total);
        System.out.printf("Average Marks   : %.2f\n", avg);

        String grade = calculateGrade(avg);
        System.out.println("Grade           : " + grade);

        // Weak subjects
        List<Integer> weakSubjects = s.getWeakSubjects();
        System.out.println("\nBehavior Analysis:");
        System.out.println("- Focus Level          : " + getFocusLevel(avg));
        System.out.println("- Consistency Level    : " + getConsistencyLevel(marks));
        System.out.println("- Concept Strength     : " + getConceptStrength(avg));
        System.out.println("- Risk Subjects        : " + weakSubjects);

        System.out.println("\nPerformance Tips:");
        if(!weakSubjects.isEmpty()) {
            System.out.println("- Improve consistency in low-scoring subjects.");
        }
        System.out.println("- Maintain strong focus in strong subjects.");
        System.out.println("- Practice regularly and revise weak concepts.");

        System.out.println("---------------------------------------------------------");
        System.out.println("Analysis Completed Successfully.");
        System.out.println("---------------------------------------------------------\n");
    }

    private String calculateGrade(double avg) {
        if(avg >= 85) return "A+";
        else if(avg >= 75) return "A";
        else if(avg >= 60) return "B";
        else return "C";
    }

    private String getFocusLevel(double avg) {
        if(avg >= 80) return "HIGH";
        else if(avg >= 65) return "MODERATE";
        else return "LOW";
    }

    private String getConsistencyLevel(List<Integer> marks) {
        int count = 0;
        for(int i=1; i<marks.size(); i++) {
            if(Math.abs(marks.get(i) - marks.get(i-1)) <= 10) count++;
        }
        if(count >= marks.size()-1) return "HIGH";
        else if(count >= (marks.size()/2)) return "MODERATE";
        else return "LOW";
    }

    private String getConceptStrength(double avg) {
        if(avg >= 75) return "GOOD";
        else if(avg >= 60) return "AVERAGE";
        else return "WEAK";
    }
}

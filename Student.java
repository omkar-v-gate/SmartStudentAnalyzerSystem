package corejavaproject;

import java.util.*;

public class Student {
    private String name;
    private int studentId;
    private List<Integer> marks;

    public Student(String name, int studentId) {
        this.name = name;
        this.studentId = studentId;
        this.marks = new ArrayList<>();
    }

    public void addMark(int mark) throws Exception {
        if(mark < 0 || mark > 100) {
            throw new Exception("Invalid mark! Must be between 0-100.");
        }
        marks.add(mark);
    }

    public List<Integer> getMarks() {
        return marks;
    }

    public String getName() {
        return name;
    }

    public int getStudentId() {
        return studentId;
    }

    public double calculateAverage() {
        return marks.stream().mapToInt(Integer::intValue).average().orElse(0);
    }

    public List<Integer> getWeakSubjects() {
        List<Integer> weak = new ArrayList<>();
        for(int i=0; i<marks.size(); i++) {
            if(marks.get(i) < 70) { // less than 70 = weak
                weak.add(i+1); // subject number
            }
        }
        return weak;
    }

    public int getTotalMarks() {
        return marks.stream().mapToInt(Integer::intValue).sum();
    }
}

package modul;

import java.util.Random;

public class Student {

    private String name;
    private boolean active;
    private int[] grades;
    private Team team;
    private char[] multiChoise;

    public Student(String name, boolean active) {
        this.name = name;
        this.active = active;
        multiChoise = createMultiChoise();
    }

    public String getName() {
        return name;
    }

    public int[] getGrades() {
        return grades;
    }

    public void setGrades(int[] grades) {
        this.grades = grades;
    }

    public boolean isActive() {

        return active;
    }

    //Get mulit choise answers
    public char[] getMultiChoise() {
        return multiChoise;

    }

    //Create multi choise answers (random)
    public char[] createMultiChoise() {
        Random r = new Random();
        char[] temparr = new char[10];
        char[] answer = new char[]
                {'A', 'B', 'C', 'D'};

        for (int i = 0; i < 10; i++) {
            temparr[i] = answer[r.nextInt(0, 4)];

        }


        return temparr;
    }

    //Set multi choise
    public void setMultiChoise(char[] multiChoise) {
        this.multiChoise = multiChoise;
    }

    //Get higest grade
    public int highestGrade(){
        int max = grades[0];
        for (int i = 0; i < grades.length; i++) {
            if (grades[0] > max);
            max = grades[0];
        }

        return max;
    }

    //Average grade
    public int averageGrade() {
        int sum = 0;
        for (int i = 0; i < grades.length; i++) {
            sum += grades[i];
        }

        return sum / grades.length;
    }

}


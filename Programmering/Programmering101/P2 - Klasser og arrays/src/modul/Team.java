package modul;

import java.util.Arrays;

public class Team {

    private String name;
    private String room;
    public static final char[] finalAnswers = {'A', 'C', 'D', 'C', 'A', 'A', 'C', 'D', 'D', 'B'};
    private Student[] studentList;
    private int countStudents;

    public Team(String name, String room) {
        this.name = name;
        this.room = room;
        this.studentList = new Student[32];
    }

    public String getName() {
        return name;
    }

    public String getRoom() {
        return room;
    }

    //Add student
    public void addStudent(Student student) {
        studentList[countStudents] = student;
        countStudents++;
    }

    //Get student count
    public int getCountStudents() {
        return countStudents;
    }



    //Counts students on a team
    public Student[] studentOnTeam() {
        Student[] StudentOnTeam = new Student[countStudents];
        for (int i = 0; i < countStudents; i++)
            StudentOnTeam[i] = studentList[i];


        return StudentOnTeam;
    }

    //Removes student
    public void removeStudent(String name) {
        for (int i = 0; i < countStudents; i++) {
            if (studentList[i].getName() == name) {
                studentList[i] = null;
                countStudents--;
            }
        }

        Student[] tempArr = new Student[32];
        int count = 0;
        for (int n = 0; n < studentList.length; n++) {
            if (studentList[n] != null) {
                tempArr[count] = studentList[n];
                count++;

            }
        }
        studentList = tempArr;
    }


    //Average grades for all students
    public int averageGrades() {
        int sum = 0;
        for (Student s : studentOnTeam()) {
            sum += s.averageGrade();
        }

        return sum / studentOnTeam().length;
    }

    //Gets amount of student with the same or higher average then min
    public Student[] highScoreStudents(double minAverage) {
        Student[] tempArr = new Student[32];
        int counter = 0;

        for (int i = 0; i < studentList.length; i++) {
            if (studentList[i] == null) {
                continue;
            }

            if (studentList[i].isActive() == true && studentList[i].averageGrade() >= minAverage) {
                tempArr[counter] = studentList[i];
                counter++;
            }

        }

        return tempArr;
    }

    //Gets correct answers count
    public int[] correctAnswersCount() {
        int[] correntAnswerCounter = new int[studentOnTeam().length];
        int counter = 0;
        for (Student student : studentOnTeam()) {
            for (int i = 0; i < 10; i++) {
                if (student.getMultiChoise()[i] == finalAnswers[i]) {
                correntAnswerCounter[counter]++;
                }

            }
            counter++;
        }
        return correntAnswerCounter;
    }

    //Gets student stats (name, average grades, answers on test)
    public String[] getStudentsstats() {
        String[] studentStats = new String[countStudents];
        int counter = 0;
        for (Student student : studentOnTeam()) {
            String s = student.getName() + " " + student.averageGrade();
            for (int answer : student.getMultiChoise()) {
                s += " " + Character.toString(answer);
            }
            studentStats[counter] = s;
            counter++;
        }
        return studentStats;
    }

    //Return each correct answer pr question in multi choise test
    public int[] testStats() {
        int[] correctAnswers = new int[10];
        for (Student student : studentOnTeam()) {
            for (int i = 0; i < 10; i++) {
                if (student.getMultiChoise()[i] == finalAnswers[i]) {
                correctAnswers[i]++;
                }
            }
        }
        return correctAnswers;
    }




    @Override
    public String toString() {
        return "Count of Students = " + countStudents;
    }
}

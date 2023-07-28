package modul;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Team Team1 = new Team("Datamatiker", "23y");
        Team Team2 = new Team("Datamatiker", "23x");
        Student en = new Student("Henrik", true);
        Student to = new Student("Joakim", true);
        Student tre = new Student("Sofie", true);
        Student fire = new Student("Yvonne", true);
        Student fem = new Student("Lasse", true);
        Student seks = new Student("Gustav", true);
        Student syv = new Student("Wiljam", true);


        // Team 1
        System.out.println("Team name: " + Team1.getName());
        Team1.addStudent(en);
        Team1.addStudent(to);
        Team1.addStudent(seks);
        for (Student student : Team1.studentOnTeam()) {
            System.out.println(student.getName());
        }

        //Team 2
        System.out.println("\n" + "Team name: " + Team2.getName());
        Team2.addStudent(tre);
        tre.setGrades(new int[]{12});
        Team2.addStudent(fire);
        fire.setGrades(new int[]{7});
        Team2.addStudent(fem);
        fem.setGrades(new int[]{7});
        Team2.addStudent(syv);
        syv.setGrades(new int[]{2});
        for (Student student : Team2.studentOnTeam()) {
            System.out.println(student.getName());
        }

        // Averge grades
        System.out.println("Averge grades for 23x: " + Team2.averageGrades());

        // Student count
        System.out.println(Team2.toString() + "\n");

        //Removes a student
        Team2.removeStudent("Lasse");
        for (Student student : Team2.studentOnTeam()) {
            System.out.println(student.getName());
        }

        //Highest grade
        System.out.println("Sofie's highest grade: " + tre.highestGrade());


        //Averge score over min average?
        for (Student student : Team2.highScoreStudents(4)) {
            if (student == null) {
                continue;
            }
            System.out.println("\n" + "Student name: " + student.getName() + "\n" + "Student averge grade: " + student.averageGrade());
        }


        //Correct answers for eact student
        for (int i = 0; i < Team2.getCountStudents(); i++) {
            System.out.println(Team2.studentOnTeam()[i].getName() + "\n" + "Has " + Team2.correctAnswersCount()[i] + " corrent answers");

            }
        // Gets student stats (name, average grades, answers on test)
        for (int i = 0; i < Team2.getCountStudents(); i++) {
            System.out.println(Team2.getStudentsstats()[i]);
        }

        System.out.println("Correct answer counter: " + Arrays.toString(Team2.finalAnswers));
        for (int i = 0; i < 10; i++) {
            System.out.println(Team2.testStats()[i]);
        }



        }
    }
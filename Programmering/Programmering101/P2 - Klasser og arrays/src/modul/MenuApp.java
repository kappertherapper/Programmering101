package modul;

import java.util.Arrays;
import java.util.Scanner;

public class MenuApp {

    static Student[] students;
    static Team[] teams;
    static int teamCounter;

    public static void main(String[] args) {
        students = new Student[32];
        teams = new Team[10];
        runapp();

    }


    public static void runapp() {

        // Scanner
        Scanner input = new Scanner(System.in);

        menuDisplay();
        System.out.println("\n" + "Pick from the menu: ");
        int choise = input.nextInt();

        //1 Create team
        if (choise == 1) {
            System.out.println("What name and which room u want?");
            Team team = new Team(input.next(), input.next());
            teams[teamCounter] = team;
            teamCounter++;
            System.out.println("Team created: " + team.getName() + "\n" + "placed in room: " + team.getRoom());
            runapp();
        }

        //2 Create a student
        if (choise == 2) {
            System.out.println("What name should the new student have?");
            Student student = new Student(input.next(), input.nextBoolean());
            System.out.println("Which team should the student, be on?");
            String teamname = input.next();
            for (int i = 0; i < teamCounter; i++) {
                if (teamname == teams[i].getName()) {
                    teams[i].addStudent(student);

                }
            }
            runapp();

        }

        //3 Show one student's info and results
        if (choise == 3) {
            System.out.println("Which team are you looking for? ");
            String teamname = input.next();
            for (int i = 0; i < teamCounter; i++) {
                if (teams[i].getName() == teamname) {
                    System.out.println("Which student are you looking for?");
                    String studentname = input.next();
                    for (int j = 0; j < teams[i].getCountStudents(); j++) {
                        if (studentname == teams[i].studentOnTeam()[j].getName()) {
                            System.out.println(teams[i].studentOnTeam()[j]);
                        }
                    }

                }

            }

        }

        //4 Show one team's info and results
        if (choise == 4) {
            System.out.println("Which team are you looking for?");
            String teamname = input.next();
            for (int i = 0; i < teamCounter; i++) {
                if (teams[i].getName() == teamname) {

                }

                //5 Show info and results for all teams
                if (choise == 5) {

                }

                //6 Exit program
                if (choise == 6) {

                }

            }
        }
    }


            public static void menuDisplay() {
                System.out.println("Main menu");
                System.out.println("1: create a team");
                System.out.println("2: create a student");
                System.out.println("3: Show one student's info and results ");
                System.out.println("4: Show one team's info and results ");
                System.out.println("5: Show info and results for all teams ");
                System.out.println("6: exit");
            }
        }


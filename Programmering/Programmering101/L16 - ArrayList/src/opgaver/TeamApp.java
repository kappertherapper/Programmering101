package opgaver;

import java.util.ArrayList;
import java.util.List;

public class TeamApp {
    public static void main(String[] args) {
        Player player = new Player("Michael Jordan",26);
        Player player1 = new Player("Kobe Bryan",28);
        Player player2 = new Player("Lebron James",26);
        Player player3 = new Player("Larry Bird",24);

        Team team = new Team("Chicacao ballers");
        team.addPlayer(player);
        team.addPlayer(player1);
        team.addPlayer(player2);
        team.addPlayer(player3);

        player.setScore(45);
        player1.setScore(63);
        player2.setScore(3);
        player3.setScore(77);

        // Prints info on all players
        team.printPlayers();

        //Average age on all players
        System.out.println("Average age on all player: " + team.calcAverageAge());

        //Total score of all players
        System.out.println("Total score: " + team.calcTotalScore());

        //Score and player, older then agelimit
        System.out.println("Score of the oldest player: " + team.calcOldPlayersScore(55));

        //highest score obtained by any player
        System.out.println("Player with highest score" + team.maxScore());

        //Best player on team
        System.out.println("Best players on team: " + team.bestPlayerNames());

    }
}

package opgaver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Team {

    private String name;
    ArrayList<Player> players;

    public Team(String name){
        this.name = name;
        players = new ArrayList<>();

    }

    public String getName() {
        return name;
    }

    public ArrayList<Player> getPlayers() {
        return players;
    }

    public void addPlayer(Player player){
        this.players.add(player);

        }

    // Print name, age, score of players
    public void printPlayers(){
        for (Player player : players) {
            System.out.println("Info on players: " + player.toString());

        }

    }

    // Prints average age of all players
    public double calcAverageAge(){
        double sum = 0;
        double average = 0;
        for (Player player : players) {
            sum += player.getAge();
            average = sum / players.size();

        }
        return average;
    }

    //Prints total player score
    public int calcTotalScore() {
        int sum = 0;
        for (Player player : players) {
            sum += player.getScore();

        }
        return sum;
    }

    // Prints score og player older then agelimit
    public int calcOldPlayersScore(int ageLimit) {
        int sum = 0;
        for (Player player : players) {
            if (player.getAge() > ageLimit) {
                sum += player.getScore();
            }
        }
        return sum;
    }

    //Print highest score obtained by any player
    public int maxScore() {
        int max = 0;
        int sum = 0;
        for (Player player : players) {
            sum = player.getScore();

            if (sum > max);
            max = sum;

        }
        return max;
    }

    public ArrayList<Player> bestPlayerNames() {
        ArrayList<Player> Bestplayers = new ArrayList<Player>();
        int highscore = maxScore();
        for (Player player : players) {
            if (player.getScore() == highscore) {
                Bestplayers.add(player); //fejl her
                System.out.println(player.getName());
            }
        }
        return Bestplayers;
    }

    @Override
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                ", players=" + players +
                '}';
    }
}

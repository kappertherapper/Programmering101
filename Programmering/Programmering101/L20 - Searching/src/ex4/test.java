package ex4;

import java.util.ArrayList;

public class test {
    public static void main(String[] args) {

        ArrayList<player> players = new ArrayList<player>();
        players.add(new player("Lucas", 195, 90, 6));
        players.add(new player("Mogens", 170, 77, 3));
        players.add(new player("Anton", 187, 88, 2));
        players.add(new player("Villiam", 180, 98, 0));
        players.add(new player("Joakim", 177, 69, 1));
        players.add(new player("Frederik", 169, 89, 8));
        players.add(new player("Henrik", 195, 90, 6));


        // Calling method findPlayerLinear
        player result = findPlayerLinear(players, 9);

        // Verifying the returned player object
        if (result != null) {
            System.out.println("Player found: " + result.getName());
        } else {
            System.out.println("No player found with the given score.");
        }


    }

    /**
     * Finds a player with a given score
     **/
    public static player findPlayerLinear(ArrayList<player> players, int score) {
        for (player player : players) {
            if (player.getScoredGoals() == score) {
                return player;
            }
        }
        // If player not found
        return null;
    }


    /**
     * Finds a player with a height less than 170 cm and with more than 50 scored goals
     **/
    public static String findPlayerName(ArrayList<player> players) {
        for (player player : players) {
            if (player.getHeight() > 170 && player.getScoredGoals() > 50) {
                return player.getName();
            }
        }
        // If player not found
        return null;
    }


    /**
     * Returns indexes of a given string in a given arraylist
     **/
    public static ArrayList<Integer> findAllIndices(ArrayList<String> list, String target) {
        ArrayList<Integer> indexs = new ArrayList<Integer>();
        for (int i = 0; i < list.size(); i++) {
            if (list.equals(target)) {
                indexs.add(i);
            }
        }
        return indexs;
    }

    /** returns true if chars in a string is repeated k times **/
    public static boolean repeatedChars(String s, int k) {
        char string[] = s.toCharArray();
        int count = 0;

        for (int i = 0; i < string.length; i++) {
            for (int j = i + 1; j < string.length; j++) {
                if (string[i] == string[j]) {
                    count++;
                }
            }
        }
        if (count == k) {
            return true;
        } else {
            return false;
        }
    }

    public int searchSum(int[] t, int total) {

        return total;
    }
}

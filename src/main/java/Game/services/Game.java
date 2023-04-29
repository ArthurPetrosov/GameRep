package Game.services;

import java.util.ArrayList;
import java.util.List;

public class Game {
    List<Player> players = new ArrayList<>();

    public void register(Player player) {
        players.add(player);
    }

    public Player findByName(String name) {
        for (Player player : players) {
            if (player.getName().equals(name)) {
                return player;
            }
        }
        return null;
    }

    public int round(String name1, String name2) {
        Player player1 = findByName(name1);
        Player player2 = findByName(name2);
        if (player1 == null) {
            throw new NotRegisteredException("Player with Name: " + name1 + " is Not Registered");
        }
        if (player2 == null) {
            throw new NotRegisteredException("Player with Name: " + name2 + " is Not Registered");
        }

        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        }
        if (player1.getStrength() < player2.getStrength()) {
            return 2;
        } else return 0;
    }
}
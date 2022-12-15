
import java.util.HashMap;

public class Game {


    HashMap<String, Integer> map = new HashMap<>();


    public void register(Player player) {
        map.put(player.getName(), player.getStrength());
    }

    public int round(String playerName1, String playerName2) {

        String player1 = null;
        String player2 = null;
        for (String player : map.keySet()) {
            if (player.equals(playerName1)) {
                player1 = player;
            }
            if (player.equals(playerName2)) {
                player2 = player;
            }
        }

        if (player1 == null) {
            throw new NotRegisteredException(playerName1);
        }
        if (player2 == null) {
            throw new NotRegisteredException(playerName2);
        }

        if (map.get(player1) > map.get(player2)) {
            return 1;
        }
        if (map.get(player1) < map.get(player2)) {
            return 2;
        }
        return 0;
    }
}



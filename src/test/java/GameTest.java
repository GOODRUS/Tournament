import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {
    Game game = new Game();

    Player player1 = new Player(1, "Nikolay", 50);
    Player player2 = new Player(2, "Petr", 60);
    Player player3 = new Player(3, "Anastasiya", 40);
    Player player4 = new Player(4, "Svetlana", 60);

    @Test
    public void WhenSecondPlayerStronger() {

        game.register(player1);
        game.register(player2);

        int expected = 2;
        int actual = game.round("Nikolay", "Petr");

        assertEquals(expected, actual);
    }

    @Test
    public void WhenFirstPlayerStronger() {

        game.register(player1);
        game.register(player3);

        int expected = 1;
        int actual = game.round("Nikolay", "Anastasiya");

        assertEquals(expected, actual);
    }

    @Test
    public void WhenStrongEquals() {

        game.register(player2);
        game.register(player4);

        int expected = 0;
        int actual = game.round("Petr", "Svetlana");

        assertEquals(expected, actual);
    }

    @Test
    public void WhenThrowPlayer1() {

        game.register(player2);
        game.register(player4);

        assertThrows(NotRegisteredException.class,
                () -> game.round("Nikolay", "Svetlana"));
    }

    @Test
    public void WhenThrowPlayer2() {

        game.register(player2);
        game.register(player4);

        assertThrows(NotRegisteredException.class,
                () -> game.round("Petr", "Anastasiya"));
    }
}

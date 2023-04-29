import Game.services.Player;
import Game.services.Game;
import Game.services.NotRegisteredException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GameTest {

    Player Serral = new Player(1, "Serral", 9);
    Player Dark = new Player(2, "Dark", 7);
    Player Reynor = new Player(3, "Reynor", 8);
    Player Stats = new Player(4, "Stats", 7);
    Player HeroMarine = new Player(5, "HeroMarine", 3);
    Player Clem = new Player(6, "Clem", 11);

    @Test
    public void firstPlayerWin() {
        Game manager = new Game();
        manager.register(Serral);
        manager.register(Dark);
        int expected = 1;
        int actual = manager.round("Serral", "Dark");
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void secondPlayerWin() {
        Game manager = new Game();
        manager.register(Dark);
        manager.register(Reynor);
        int expected = 2;
        int actual = manager.round("Dark", "Reynor");
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void drawGame() {
        Game manager = new Game();
        manager.register(Dark);
        manager.register(Stats);
        int expected = 0;
        int actual = manager.round("Dark", "Stats");
        Assertions.assertEquals(expected, actual);

    }

    @Test
    public void throwExceptionFirstPlayer() {
        Game manager = new Game();
        manager.register(HeroMarine);
        manager.register(Stats);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            manager.round("Dark", "Clem");
        });
    }

    @Test
    public void throwExceptionSecondPlayer() {
        Game manager = new Game();
        manager.register(Dark);
        manager.register(Stats);

        Assertions.assertThrows(NotRegisteredException.class, () -> {
            manager.round("Dark", "Clem");
        });


    }
}
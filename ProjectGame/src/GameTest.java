import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GameTest {
    Game game = new Game();

    @Before
    public void createGame(){
        game.startGame("procrastination", "description");
    }

    @Test
    public void startGameTest(){
        assertEquals(0, game.getAttempts()) ;
        assertEquals(0, game.getBalance()) ;
        //balance = 0 ;
        //attempts = 0;
    }

    // correct -> balance
    // incorrect -> balance
    // incorrect -> attemts
    // correct -> attemts

    @Test
    public void openCorrectLetterTest(){
        game.openLetter('a');
        assertEquals(1, game.getAttempts()) ;
        assertEquals(10, game.getBalance()) ;
    }

    @Test
    public void openIncorrectLetterTest(){
        game.openLetter('x');
        assertEquals(1, game.getAttempts()) ;
        assertEquals(-5, game.getBalance()) ;
    }

    @Test
    public void openCorrectWordTest() throws WrongWordLengthException {
        game.openWord("procrastination");
        assertEquals(50, game.getBalance()) ;
    }

    @Test
    public void openIncorrectWordTest() throws WrongWordLengthException {
        game.openWord("gamificationaaa");
        assertEquals(-25, game.getBalance()) ;
    }
    /*
    openWord correct / incorrect
     */

    //---------------------------------
    @Test
    public void attemptsCheck() throws WrongWordLengthException {
        game.openLetter('a');
        assertEquals(1,game.getAttempts());
        game.openLetter('x');
        assertEquals (2,game.getAttempts());
        game.openWord("gamificationaaa");
        assertEquals (3,game.getAttempts());
        game.openWord("procrastination");
        assertEquals (4,game.getAttempts());
    }

    @Test
    public void balanceCheck() throws WrongWordLengthException {
        game.openLetter('a');
        assertEquals(10,game.getBalance());
        game.openLetter('x');
        assertEquals (5,game.getBalance());
        game.openWord("gamificationaaa");
        assertEquals (-20,game.getBalance());
        game.openWord("procrastination");
        assertEquals (30,game.getBalance());
    }
}

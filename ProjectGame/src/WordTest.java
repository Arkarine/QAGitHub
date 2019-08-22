import org.junit.Test;

import static org.junit.Assert.*;

public class WordTest {

    Word word = new Word("apple", "some description");

    @Test
    public void testGetWordWithStars(){
        Word word = new Word("apple", "some description");
        assertEquals("*****", word.getWordWithStars());
    }
    //---------------

    @Test //lower, capital case, special symbols, cyrillic
    public void testOpenLetterValidChar() {

        word.openLetter('a');
        assertEquals("a****", word.getWordWithStars());


        word.openLetter('b');
        assertEquals("a****", word.getWordWithStars());

        word.openLetter('p');
        assertEquals("app**", word.getWordWithStars());
    }

    @Test //lower, capital case, special symbols, cyrillic
    public void testInvalidLetter() {

        Word word = new Word("apple", "some description");

        word.openLetter('A');
        assertEquals("*****", word.getWordWithStars());


        word.openLetter('%');
        assertEquals("*****", word.getWordWithStars());


        word.openLetter('р'); //cyrillic
        assertEquals("*****", word.getWordWithStars());
    }
    //---------------

    @Test
    public void testOpenCorrectLetter (){
        Word word = new Word("apple", "some description");
        assertEquals(2, word.openLetter('p'));
    }

    @Test
    public void testOpenIncorrectLetter (){
        Word word = new Word("apple", "some description");
        assertEquals(0, word.openLetter('x'));
    }

    @Test
    public void testOpenInvalidLetter (){
        Word word = new Word("apple", "some description");
        assertEquals(0, word.openLetter('%'));
    }

    @Test
    public void testOpenUpperCaseLetter (){
        Word word = new Word("apple", "some description");
        assertEquals(0, word.openLetter('A'));
    }

    @Test
    public void testOpenCorrectWord () throws WrongWordLengthException {
        Word word = new Word("apple", "some description");
        assertTrue(word.openWord("apple"));
    }

    @Test
    public void testOpenIncorrectWord () throws WrongWordLengthException {
        Word word = new Word("apple", "some description");
        assertFalse(word.openWord("asdfg"));
    }

    @Test(expected = WrongWordLengthException.class)
    public void testOpenWrongLengthWord () throws WrongWordLengthException {
        Word word = new Word("apple", "some description");
        word.openWord("asdfgafsafdafssfd");
    }

}

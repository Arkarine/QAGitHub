import java.util.Random;

public class RandomCharGenerator implements GameInput {
    Random r = new Random();
    char letter;
    @Override
    public char getNextChar() {
        //To generate a random char in a-z:
        letter = (char)(r.nextInt(26) + 'a');
        return letter;
    }
}

public class PlayGame {
    //private Game game;
    private String word;
    private String description;
    private GameInput input;
    private GameOutput output;

    public PlayGame(String word, String description, GameInput input, GameOutput output) {
        this.word = word;
        this.description = description;
        this.input = input;
        this.output = output;
    }

    public void play(){
        Game game = new Game();
        game.startGame(word, description);
        char letter;
        while (game.isWin() != true){
            letter = input.getNextChar();
            output.print(game.getWord().getWordWithStars());
            game.openLetter(letter);
        }
    }
}

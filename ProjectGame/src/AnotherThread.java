public class AnotherThread extends Thread{
    public void run(){
        long begin = System.currentTimeMillis();
        //System.out.println("Begin of the game " + begin);
        GameInput input = new RandomCharGenerator();
        GameOutput output = new ConsoleGameOutput();
        PlayGame playGame = new PlayGame("procrastination", "description", input, output );
        playGame.play();
        long end = System.currentTimeMillis();
        //System.out.println("End of the game " + end);
        System.out.format("Duration of Game in /AnotherThread/ thread is %d milliseconds \n", end - begin);
    }
}
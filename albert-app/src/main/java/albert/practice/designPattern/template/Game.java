package albert.practice.designPattern.template;

public abstract class Game {
    abstract void initialize();
    abstract void startGame();
    abstract void endGame();
    
    /**
     * template method
     */
    public final void play() {
        initialize();
        startGame();
        endGame();
    }
    
}

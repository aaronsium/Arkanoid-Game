import biuoop.DrawSurface;

import java.awt.Color;

/**
 * The type Lose screen.
 */
public class LoseScreen implements Animation {
    private int finalScore;

    /**
     * Instantiates a new Lose screen.
     *
     * @param finalScore the final score
     */
    public LoseScreen(int finalScore) {
        this.finalScore = finalScore;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        d.setColor(Color.white);
        d.fillRectangle(0, 0, 800, 800);
        d.setColor(Color.BLACK);
        d.drawText(80, 380, "Game Over. Your score is " + String.valueOf(finalScore), 50);
    }

    @Override
    public boolean shouldStop() {
        return false;
    }
}

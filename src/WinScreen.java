import biuoop.DrawSurface;

import java.awt.Color;

/**
 * The type Win screen.
 */
public class WinScreen implements Animation {
    private int finalScore;
    private String kindOfScreen;

    /**
     * Instantiates a new Win screen.
     *
     * @param finalScore1 the final score 1
     */
    public WinScreen(int finalScore1) {
        finalScore = finalScore1;
        kindOfScreen = "space";
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        d.setColor(Color.white);
        d.fillRectangle(0, 0, 800, 800);
        d.setColor(Color.BLACK);
        d.drawText(80, 380, "You Won! Your score is " + String.valueOf(finalScore), 50);
    }

    @Override
    public boolean shouldStop() {
        return false;
    }
}

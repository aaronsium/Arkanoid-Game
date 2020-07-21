import biuoop.DrawSurface;

import java.awt.Color;

/**
 * The type Score indicator.
 * counter the points we earned
 */
public class ScoreIndicator implements Sprite {
    private Counter currentScore;

    /**
     * Instantiates a new Score indicator.
     *
     * @param scoreCounter the score counter
     */
    public ScoreIndicator(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }

    @Override
    public void drawOn(DrawSurface surface) {
        surface.setColor(Color.GRAY);
        surface.fillRectangle(0, 0, 900, 50);
        surface.setColor(Color.BLACK);
        surface.drawRectangle(0, 0, 900, 50);
        surface.setColor(Color.BLACK);
        surface.drawText(250, 45, "Score:" + String.valueOf(currentScore.getNumber()), 30);

    }

    @Override
    public void timePassed() {
    }
}
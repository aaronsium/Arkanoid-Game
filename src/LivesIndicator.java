import biuoop.DrawSurface;

import java.awt.Color;

/**
 * The type Lives indicator.
 * indicate the lives that remained to the player
 */
public class LivesIndicator implements Sprite {
    private Counter currentScore;

    /**
     * Instantiates a new Lives indicator.
     *
     * @param livesCounter the lives counter
     */
    public LivesIndicator(Counter livesCounter) {
        this.currentScore = livesCounter;
    }

    @Override
    public void drawOn(DrawSurface surface) {
        surface.setColor(Color.BLACK);
        surface.drawText(80, 45, "Lives:" + String.valueOf(currentScore.getNumber()), 30);

    }

    @Override
    public void timePassed() {
    }
}


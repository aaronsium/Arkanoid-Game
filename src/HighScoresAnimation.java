import biuoop.DrawSurface;

import java.awt.Color;

/**
 * The type High scores animation.
 */
public class HighScoresAnimation implements Animation {
    private HighScoresTable table;

    /**
     * Instantiates a new High scores animation.
     *
     * @param scores the scores
     */
    public HighScoresAnimation(HighScoresTable scores) {
        this.table = scores;
    }


    @Override
    public void doOneFrame(DrawSurface d) {
        d.setColor(Color.gray);
        d.fillRectangle(0, 0, 800, 800);
        d.setColor(Color.green);
        d.drawText(80, 350, "Player name", 20);
        d.drawText(300, 350, "Score", 20);
        int index = 0;
        for (int i = 0; i < (table.getHighScores().size()); i++) {
            d.setColor(Color.BLACK);
            d.drawText(80, 380 + (i * 20), table.getHighScores().get(index).getName(), 20);
            d.drawText(300, 380 + (i * 20), Integer.toString(table.getHighScores().get(index).getScore()), 20);
            index++;
        }
    }

    @Override
    public boolean shouldStop() {
        return false;
    }


}


import biuoop.DrawSurface;

import java.awt.Color;

/**
 * The type Level name.
 */
public class LevelName implements Sprite {
    private String levelName;

    /**
     * Instantiates a new name.
     *
     * @param levelName the name of the level
     */
    public LevelName(String levelName) {
        this.levelName = levelName;
    }

    @Override
    public void drawOn(DrawSurface surface) {
        surface.setColor(Color.BLACK);
        surface.drawText(450, 45, "Level Name: " + levelName, 30);

    }

    @Override
    public void timePassed() {
    }
}

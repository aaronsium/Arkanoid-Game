import biuoop.DrawSurface;

import java.util.ArrayList;

/**
 * The type Sprite collection.
 */
public class SpriteCollection {
    private ArrayList<Sprite> spritesList;

    /**
     * Instantiates a new Sprite collection.
     */
    public SpriteCollection() {
        this.spritesList = new ArrayList<>();
    }


    /**
     * Add sprite.
     *
     * @param s the s
     */
    public void addSprite(Sprite s) {
        this.spritesList.add(s);
    }

    /**
     * Gets sprites list.
     *
     * @return the sprites list
     */
    public ArrayList<Sprite> getSpritesList() {
        return spritesList;
    }

    /**
     * Notify all time passed.
     */
// call timePassed() on all sprites.
    public void notifyAllTimePassed() {
        ArrayList<Sprite> listeners = new ArrayList<Sprite>(spritesList);
        for (Sprite c : listeners) {
            c.timePassed();
        }
    }

    /**
     * Draw all on.
     *
     * @param d the d
     */
// call drawOn(d) on all sprites.
    public void drawAllOn(DrawSurface d) {
        for (Sprite c : this.spritesList) {
            c.drawOn(d);
        }
    }

    /**
     * Remove sprite for the collection.
     *
     * @param s the s
     */
    public void removeSprite(Sprite s) {
        spritesList.remove(s);
    }
}
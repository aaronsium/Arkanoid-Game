import biuoop.DrawSurface;

import java.awt.Color;
import java.awt.Image;

/**
 * The type Back ground creator.
 */
public class BackGroundCreator implements Sprite {

    private boolean isImage = false;
    private boolean isColor = false;
    private Image photo;
    private Color color;


    /**
     * Instantiates a new Back ground creator.
     *
     * @param photo the photo
     */
    public BackGroundCreator(Image photo) {
        this.photo = photo;

    }

    /**
     * Instantiates a new Back ground creator.
     *
     * @param color the color
     */
    public BackGroundCreator(Color color) {
        this.color = color;
    }

    /**
     * Sets is image.
     *
     * @param image1 the image 1
     */
    public void setIsImage(boolean image1) {
        isImage = image1;
    }

    /**
     * Sets is color.
     *
     * @param color1 the color 1
     */
    public void setIsColor(boolean color1) {
        isColor = color1;
    }

    @Override
    public void drawOn(DrawSurface d) {
        if (this.isImage) {
            d.drawImage(0, 0, photo);
        }
        if (this.isColor) {
            d.setColor(this.color);
            d.fillRectangle(0, 0, 800, 800);
        }

    }

    @Override
    public void timePassed() {

    }
}

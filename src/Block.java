import biuoop.DrawSurface;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
/**
 * The type Block.
 */
public class Block implements Collidable, Sprite, HitNotifier {
    private Rectangle rect;
    private Color color;
    private String text;

    /**
     * Gets rect.
     *
     * @return the rect
     */
    public Rectangle getRect() {
        return rect;
    }

    private int numberOfHit;
    private List<HitListener> hitListeners;

    /**
     * Instantiates a new Block.
     *
     * @param upperLeft the upper left
     * @param width     the width
     * @param height    the height
     * @param colorx    the colorx
     */
    public Block(Point upperLeft, double width, double height, Color colorx) {
        List<HitListener> listeners = new ArrayList<HitListener>();
        Rectangle rect1 = new Rectangle(upperLeft, width, height);
        this.color = colorx;
        this.rect = rect1;
        numberOfHit = 0;
        hitListeners = listeners;
    }

    /**
     * Gets number of hit.
     *
     * @return the number of hit
     */
    public int getNumberOfHit() {
        return numberOfHit;
    }

    /**
     * Sets number of hit.
     *
     * @param numberOfHit1 the number of hit 1
     */
    public void setNumberOfHit(int numberOfHit1) {
        this.numberOfHit = numberOfHit1;
    }

    /**
     * Instantiates a new Block.
     *
     * @param surface the collision Point
     */
    //drawing the Rectangle
    public void drawOn(DrawSurface surface) {
        Point rightUp = new Point(rect.getUpperLeft().getX() + rect.getWidth(), rect.getUpperLeft().getY());
        Point leftDown = new Point(rect.getUpperLeft().getX(), rect.getUpperLeft().getY() + rect.getHeight());
        Point rightDown = new Point(rightUp.getX(), rightUp.getY() + this.rect.getHeight());
        Line up = new Line(this.rect.getUpperLeft(), rightUp);
        Line left = new Line((this.rect.getUpperLeft()), leftDown);
        Point middle1 = up.middle();
        Point middle2 = left.middle();
        double yLeft = this.rect.getUpperLeft().getY();
        double xRight = this.rect.getUpperLeft().getX();
        double yRight = this.rect.getUpperLeft().getY() + this.rect.getHeight();
        for (int i = 0; i < 3; i++) {
            surface.setColor(this.color);
            surface.fillRectangle((int) xRight, (int) yLeft, (int) rect.getWidth(), (int) rect.getHeight());
            surface.setColor(Color.BLACK);
            surface.drawRectangle((int) xRight, (int) yLeft, (int) rect.getWidth(), (int) rect.getHeight());
        }
    }

    /**
     * Gets none.
     *
     * @return the CollisionRectangle.
     */
    public Rectangle getCollisionRectangle() {
        return rect;
    }

    /**
     * Instantiates a new Block.
     *
     * @param collisionPoint  the collision Point
     * @param currentVelocity the current Velocity
     * @param hitter          the current Velocity
     * @return the new Velocity after the collision
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        //coPoint the collision point
        Point coPoint = collisionPoint;
        if (this.text == "1") {
            this.setText("x");
        } else if (this.text == "2") {
            this.setText("1");
        }
        //marking 4 points of the rectangle
        Point rightUp = new Point(this.rect.getUpperLeft().getX() + rect.getWidth(), rect.getUpperLeft().getY());
        Point leftUp = this.rect.getUpperLeft();
        Point leftDown = new Point(rect.getUpperLeft().getX(), rect.getUpperLeft().getY() + rect.getHeight());
        Point rightDown = new Point(rightUp.getX(), rightUp.getY() + rect.getHeight());
        double cpointX = coPoint.getX();
        double cpointY = coPoint.getY();
        //if the line is the right one
        if ((int) cpointX == rightUp.getX() && coPoint.getY() >= rightUp.getY() && coPoint.getY() <= rightDown.getY()) {
            currentVelocity = new Velocity(-1 * currentVelocity.getDx(), currentVelocity.getDy());
        }
        //if the lint is the left one
        if ((int) cpointX == leftUp.getX() && coPoint.getY() >= leftUp.getY() && coPoint.getY() <= leftDown.getY()) {
            currentVelocity = new Velocity(-1 * currentVelocity.getDx(), currentVelocity.getDy());
        }
        //if the lint is the top one
        if ((int) cpointY == rightUp.getY() && coPoint.getX() <= rightUp.getX() && coPoint.getX() >= leftUp.getX()) {
            currentVelocity = new Velocity(currentVelocity.getDx(), -1 * currentVelocity.getDy());
        }
        //if the lint is the down one
        if ((int) cpointY == rightDown.getY() && cpointX <= rightDown.getX() && coPoint.getX() >= leftDown.getX()) {
            currentVelocity = new Velocity(currentVelocity.getDx(), -1 * currentVelocity.getDy());
        }
        notifyHit(hitter);
        List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners);
        return currentVelocity;
    }

    /**
     * Sets text.
     *
     * @param t the text.
     */
    public void setText(String t) {
        this.text = t;
    }

    /**
     * Sets number ofhit.
     *
     * @param num the number of hit.
     */
    public void setNumberOfhit(int num) {
        this.numberOfHit = num;
    }

    /**
     * Gets text.
     * life of the specifiec block
     *
     * @return the text.
     */
    public String getText() {
        return text;
    }

    /**
     * Gets number ofhit.
     *
     * @return the number ofhit.
     */
    public int getNumberOfhit() {
        return this.numberOfHit;
    }

    /**
     * Gets number timePassed.
     */
    public void timePassed() {
    }

    /**
     * Add to game.
     *
     * @param g is the game.
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }
    @Override
    public void addHitListener(HitListener hl) {
        this.hitListeners.add(hl);

    }
    @Override
    public void removeHitListener(HitListener hl) {
        this.hitListeners.remove(hl);

    }
    /**
     * Add to game.
     *
     * @param hitter is the game.
     */
    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }

    /**
     * Remove from game.
     *from the sprites and the collidables
     * @param game the game
     */
    public void removeFromGame(GameLevel game) {

    }

    /**
     * Gets hit points.
     *
     * @return the hit points
     */
    public int getHitPoints() {
        if (text == "x") {
            return 0;
        } else {
            return Integer.parseInt(text);
        }
    }
}



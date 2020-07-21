import java.awt.Color;

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * The type Paddle.
 */
public class Paddle implements Sprite, Collidable {
    private biuoop.KeyboardSensor keyboard;
    private Rectangle rect;

    /**
     * Instantiates a new Paddle.
     *
     * @param rec the rectangle
     * @param key the KeyboardSensor
     */
    public Paddle(Rectangle rec, KeyboardSensor key) {
        this.keyboard = key;
        this.rect = rec;
    }


    /**
     * Set keyboard sensor.
     *
     * @param k the KeyboardSensor
     */
    public void setKeyboardSensor(KeyboardSensor k) {
        this.keyboard = k;
    }

    /**
     * Set rect.
     *
     * @param r the rectangle
     */
    public void setRect(Rectangle r) {
        this.rect = r;
    }

    /**
     * Move left.
     */
    public void moveLeft() {
        //if the paddle ariived to the limits of the board
        if (this.getCollisionRectangle().getUpperLeft().getX() > 15) {
            Point newUpperLeft = new Point(this.rect.getUpperLeft().getX() - 5, this.rect.getUpperLeft().getY());
            rect = new Rectangle(newUpperLeft, this.rect.getWidth(), this.rect.getHeight());
        }
    }

    /**
     * Move right.
     */
    public void moveRight() {
        //if the paddle ariived to the limits of the board
        if (this.getCollisionRectangle().getUpperLeft().getX() + this.getCollisionRectangle().getWidth() < 785) {
            Point newUpperLeft = new Point(this.rect.getUpperLeft().getX() + 5, this.rect.getUpperLeft().getY());
            rect = new Rectangle(newUpperLeft, this.rect.getWidth(), this.rect.getHeight());
        }
    }

    /**
     * execute left turn or right according to the keyboard actions.
     */
    public void timePassed() {
        if (keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            moveLeft();
        } else if (keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            moveRight();
        }
    }

    /**
     * this method drawn the paddle by.
     *
     * @param surface the g
     */
    public void drawOn(DrawSurface surface) {
        Point rightUp = new Point(rect.getUpperLeft().getX() + rect.getWidth(), rect.getUpperLeft().getY());
        Point leftDown = new Point(rect.getUpperLeft().getX(), rect.getUpperLeft().getY() + rect.getHeight());
        Point rightDown = new Point(rightUp.getX(), rightUp.getY() + rect.getHeight());
        double width = rect.getWidth();
        double height = rect.getHeight();

        for (int i = 0; i < 3; i++) {

            surface.setColor(Color.yellow);
            surface.fillRectangle((int) rect.getUpperLeft().getX(), (int) rightUp.getY(), (int) width, (int) height);
            surface.setColor(Color.BLACK);
            surface.drawRectangle((int) rect.getUpperLeft().getX(), (int) rightUp.getY(), (int) width, (int) height);
        }
    }

    /**
     * @return the rectangle which Collided.
     */
    public Rectangle getCollisionRectangle() {
        return rect;
    }

    /**
     * return the hit's velocity after the collision.
     *
     * @param collisionPoint  the collision Point.
     * @param currentVelocity the current Velocity.
     * @param hitter          the current Velocity.
     * @return the Velocity.
     */
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {
        Velocity newVelocity = currentVelocity;
        //separate the rib to 5 Parts
        double x1 = this.rect.getUpperLeft().getX();
        double x2 = x1 + (this.rect.getWidth() / 5);
        double x3 = x2 + this.rect.getWidth() / 5;
        double x4 = x3 + this.rect.getWidth() / 5;
        double x5 = x4 + this.rect.getWidth() / 5;
        double x6 = x5 + this.rect.getWidth() / 5;
        //if hit is in part 1
        if (collisionPoint.getX() >= x1 && collisionPoint.getX() < x2) {
            newVelocity = currentVelocity.fromAngleAndSpeed(300, currentVelocity.getSpeed());
            //if hit is in part 2
        } else if (collisionPoint.getX() >= x2 && collisionPoint.getX() < x3) {
            newVelocity = currentVelocity.fromAngleAndSpeed(330, currentVelocity.getSpeed());
            //if hit is in part 3
        } else if (collisionPoint.getX() >= x3 && collisionPoint.getX() < x4) {
            newVelocity = currentVelocity.fromAngleAndSpeed(0, currentVelocity.getSpeed());
            //if hit is in part 4
        } else if (collisionPoint.getX() >= x4 && collisionPoint.getX() < x5) {
            newVelocity = currentVelocity.fromAngleAndSpeed(30, currentVelocity.getSpeed());
            //if hit is in part 5
        } else if (collisionPoint.getX() >= x5 && collisionPoint.getX() <= x6) {
            newVelocity = currentVelocity.fromAngleAndSpeed(60, currentVelocity.getSpeed());
        }
        return newVelocity;
    }

    /**
     * Add the paddle to the game.
     *
     * @param g the is the new game.
     */
// Add this paddle to the game.
    public void addToGame(GameLevel g) {
        g.addCollidable(this);
        g.addSprite(this);
    }
}
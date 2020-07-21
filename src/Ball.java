import biuoop.DrawSurface;

/**
 * The type Ball fields.
 */
public class Ball implements Sprite {
    private Point center;
    private int r;
    private Velocity velocity;
    private java.awt.Color color;
    private Point leftUp;
    private Point leftDown;
    private Point rightUp;
    private Point rightDown;
    private GameEnvironment environment;
    private Line trajectory;

    /**
     * Instantiates a new Ball.
     *
     * @param center the center
     * @param r      the r
     * @param colorx the color
     */
// constructor
    public Ball(Point center, int r, java.awt.Color colorx) {
        this.center = center;
        this.r = r;
        this.color = colorx;

    }

    /**
     * Sets game environment.
     *
     * @param e the e
     */
    public void setGameEnvironment(GameEnvironment e) {
        this.environment = e;
    }

    /**
     * Instantiates a new Ball.
     * another points
     *
     * @param x1    the x 1
     * @param y1    the y 1
     * @param r     the r
     * @param color the color
     */
    public Ball(int x1, int y1, int r, java.awt.Color color) {
        Point centerX = new Point((double) x1, (double) y1);
        this.center = centerX;
        this.r = r;
        this.color = color;


    }

    /**
     * Instantiates a new Ball.
     *
     * @param dx the dx
     * @param dy the dy
     */
    public Ball(double dx, double dy) {
        Velocity speed = new Velocity(dx, dy);
    }

    /**
     * Gets x.
     *
     * @return the x return the dx of the velocity
     */
// accessors
    public double getX() {
        return this.center.getX();
    }

    /**
     * Gets y.
     * return the dy of the velocity
     *
     * @return the y
     */
    public double getY() {
        return this.center.getY();
    }

    /**
     * Gets size.
     *
     * @return the size
     */
    public int getSize() {
        return this.r;
    }

    /**
     * Gets color.
     *
     * @return the color
     */
    public java.awt.Color getColor() {
        return this.color;
    }

    /**
     * Gets .
     *
     * @return the
     */
    public int getr() {
        return this.r;
    }

    /**
     * Gets 1.
     *
     * @return the 1
     */
    public Point getlimit1() {
        return this.leftUp;
    }

    /**
     * Gets 2.
     *
     * @return the 2
     */
    public Point getlimit2() {
        return this.leftDown;
    }

    /**
     * Gets 3.
     *
     * @return the 3
     */
    public Point getlimit3() {
        return this.rightUp;
    }

    /**
     * Gets 4.
     *
     * @return the 4
     */
    public Point getlimit4() {
        return this.rightDown;
    }

    /**
     * Draw on.
     *
     * @param surface the surface
     */
// draw the Ball on the given DrawSurface
    public void drawOn(DrawSurface surface) {


        for (int i = 0; i < 3; i++) {
            int x = (int) this.center.getX();
            int y = (int) this.center.getY();
            int size = (int) this.r;
            surface.setColor(color.WHITE);
            surface.fillCircle(x, y, size);
            surface.setColor(color.BLACK);
            surface.drawCircle(x, y, size);
        }


    }

    /**
     * Sets velocity.
     *
     * @param v the v
     */
    public void setVelocity(Velocity v) {
        this.velocity = v;
        this.trajectory = new Line(this.center, this.velocity.applyToPoint(this.center));

    }

    /**
     * Sets velocity.
     *
     * @param dx the dx
     * @param dy the dy set the velocity to the ball
     */
    public void setVelocity(double dx, double dy) {
        Velocity speed = new Velocity(dx, dy);
        this.velocity = speed;
        this.trajectory = new Line(this.center, this.velocity.applyToPoint(this.center));

    }

    /**
     * Sets limits.
     * the for the.
     *
     * @param left1  the left 1
     * @param left2  the left 2
     * @param right1 the right 1
     * @param right2 the right 2
     */
    public void setLimits(Point left1, Point left2, Point right1, Point right2) {
        this.leftUp = left1;
        this.leftDown = left2;
        this.rightUp = right1;
        this.rightDown = right2;
    }

    /**
     * Sets trajectory.
     *
     * @param traj the traj
     */
    public void setTrajectory(Line traj) {
        this.trajectory = traj;

    }

    /**
     * Gets velocity.
     *
     * @return the velocity
     */
    public Velocity getVelocity() {
        return this.velocity;

    }

    /**
     * Move one step.
     * this method is return the next step of the ball b simple rules
     * if the ball is getting to the limit which they are insersted to him
     * thw ball chenge his "speed"(way) adnt by that will stay alwase in the limits
     */
    public void moveOneStep() {
//array with the closest points

        //
        int sighdx = 1, sighdy = 1;
        CollisionInfo crush = this.environment.getClosestCollision(this.trajectory);
        if (crush == null) {
            if (velocity.getDx() < 0) {
                sighdx = -1;
            }
            if (velocity.getDy() < 0) {
                sighdy = -1;
            }
            this.center = this.velocity.applyToPoint(this.center);
            Point tampCenter = this.center;
            Point temp = this.velocity.applyToPoint(this.center);
            temp = new Point(temp.getX() + this.getSize() * sighdx, temp.getY() + this.getSize() * sighdy);
            Line newTrajectory = new Line(tampCenter, temp);
            this.setTrajectory(newTrajectory);
        } else {


            this.velocity = crush.collisionObject().hit(this, crush.collisionPoint(), this.velocity);
            Line newTrajectory = new Line(this.center, this.velocity.applyToPoint(this.center));
            this.setTrajectory(newTrajectory);
        }


    }

    /**
     * Add to game.
     *
     */
    public void timePassed() {
        moveOneStep();


    }

    /**
     * Add to game.
     *
     * @param g the g
     */
    public void addToGame(GameLevel g) {

        g.addSprite(this);


    }






/*
        //check if the ball is ovr the limit(the center +radius and the future step)
        if (this.center.getX() + this.velocity.getDx() > this.rightUp.getX() - this.getr()) {
            //if he pass the right limit
            if (this.velocity.getDx() > 0) {
                this.setVelocity(-1 * this.velocity.getDx(), this.velocity.getDy());
            }
            // if he pass the left limit
        } else if (this.center.getX() + this.velocity.getDx() < this.leftUp.getX() + this.getr()) {
            if (this.velocity.getDx() < 0) {
                this.setVelocity(-1 * this.velocity.getDx(), this.velocity.getDy());
            }
        } else if (this.center.getY() + this.velocity.getDy() > this.rightDown.getY() - this.getr()) {
            //if he pass the up limit
            if (this.velocity.getDy() > 0) {
                this.setVelocity(this.velocity.getDx(), -1 * this.velocity.getDy());
            }
            // if he pass the douwn limit
        } else if (this.center.getY() + this.velocity.getDy() < this.rightUp.getY() + this.getr()) {
            if (this.velocity.getDy() < 0) {
                this.setVelocity(this.velocity.getDx(), -1 * this.velocity.getDy());
            }
        }
        //return the final next step of the ball
        this.center = this.getVelocity().applyToPoint(this.center);

    }
    */
}

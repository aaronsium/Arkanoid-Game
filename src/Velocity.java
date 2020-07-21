/**
 * The type Velocity.
 */
public class Velocity {
    private double dx;
    private double dy;

    /**
     * Instantiates a new Velocity.
     *
     * @param dx the dx
     * @param dy the dy
     */
// constructor
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * Gets dx.
     *
     * @return the dx
     */
    public double getDx() {
        return this.dx;
    }

    /**
     * Gets dy.
     *
     * @return the dy
     */
    public double getDy() {
        return this.dy;
    }

    /**
     * Gets velocity.
     *
     * @return the velocity
     */
    public Velocity getVelocity() {
        return this.getVelocity();
    }

    /**
     * Apply to point point.
     *
     * @param p the p
     * @return the point
     */
// Take a point with position (x,y) and return a new point
    // with position (x+dx, y+dy)
    public Point applyToPoint(Point p) {
        double x, y;
        x = p.getX();
        y = p.getY();
        return new Point(x + this.dx, y + this.dy);
    }

    /**
     * From angle and speed velocity.
     *
     * @param angle the angle
     * @param speed the speed
     * @return the velocity by calculator the dx and dy
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        angle = Math.toRadians(angle);
        double dy = -1 * Math.cos(angle) * speed;
        double dx = Math.sin(angle) * speed;
        return new Velocity(dx, dy);
    }

    /**
     * Get speed double.
     *
     * @return the double
     */
    public double getSpeed() {
        return Math.sqrt(getDx() * getDx() + getDy() * getDy());
    }
}
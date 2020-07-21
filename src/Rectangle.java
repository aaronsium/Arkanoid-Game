import java.util.ArrayList;

/**
 * The type Rectangle fields.
 */
public class Rectangle {
    private Point upperLeft;
    private double width;
    private double height;
    private int numberOfHit;

    /**
     * Instantiates a new Rectangle.
     *
     * @param upperLeft the upper left
     * @param width     the width
     * @param height    the height
     */
    public Rectangle(Point upperLeft, double width, double height) {
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
    }

    /**
     * Gets upper left.
     *
     * @return the upper left
     */
// accessors
    public Point getUpperLeft() {
        return this.upperLeft;
    }

    /**
     * Gets width.
     *
     * @return the width
     */
    public double getWidth() {
        return this.width;
    }

    /**
     * Gets height.
     *
     * @return the height
     */
    public double getHeight() {
        return this.height;
    }

    /**
     * Setupper left.
     *
     * @param p the p
     */
    public void setupperLeft(Point p) {
        upperLeft = p;
    }

    /**
     * Setwidth.
     *
     * @param n the n
     */
    public void setwidth(double n) {
        width = n;
    }

    /**
     * Setheight.
     *
     * @param n the n
     */
    public void setheight(double n) {
        height = n;
    }

    /**
     * Get number ofhit int.
     *
     * @return the int
     */
    public int getNumberOfhit() {
        return numberOfHit;
    }

    /**
     * Sets number ofhit.
     *
     * @param num the num
     */
    public void setNumberOfhit(int num) {
        numberOfHit = num;
    }

    /**
     * Intersection points array list.
     * this method check if there are intersection Points
     * between the rectangle and a line.
     *
     * @param line the line
     * @return the array list which made from the intersection Points
     */
    public ArrayList<Point> intersectionPoints(Line line) {
        ArrayList<Point> interList = new ArrayList<Point>();
        int intersectionsTimes = 0;
        //marks 3 other point of the rectangle.
        Point rightUp = new Point(this.getUpperLeft().getX() + this.getWidth(), this.getUpperLeft().getY());
        Point leftDown = new Point(this.getUpperLeft().getX(), this.getUpperLeft().getY() + this.getHeight());
        Point rightDown = new Point(rightUp.getX(), rightUp.getY() + this.getHeight());
        //create a lines which are the Ribs of the rectangle
        Line up, down, right, left;
        up = new Line(this.getUpperLeft(), rightUp);
        down = new Line(leftDown, rightDown);
        right = new Line(rightUp, rightDown);
        left = new Line(this.getUpperLeft(), leftDown);
        //intersections by each rib and the specific line
        if (line.isIntersecting(up)) {
            interList.add(line.intersectionWith(up));
            intersectionsTimes++;
        }
        if (line.isIntersecting(down)) {
            interList.add(line.intersectionWith(down));
            intersectionsTimes++;
        }
        if (line.isIntersecting(right)) {
            interList.add(line.intersectionWith(right));
            intersectionsTimes++;
        }
        if (line.isIntersecting(left)) {
            interList.add(line.intersectionWith(left));
            intersectionsTimes++;
        }
        //if there are no intersections
        if (intersectionsTimes == 0) {
            return null;
        } else {
            return interList;
        }
    }
}

import java.util.ArrayList;

import static java.lang.Math.max;
import static java.lang.Math.min;

/**
 * The type Line.
 */
public class Line {

    private Point start;
    private Point end;

    /**
     * Instantiates a new Line.
     *
     * @param start the start
     * @param end   the end
     */
// constructors
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    /**
     * Instantiates a new Line.
     *
     * @param x1 the x 1
     * @param y1 the y 1
     * @param x2 the x 2
     * @param y2 the y 2
     */
    public Line(double x1, double y1, double x2, double y2) {
        Point start1 = new Point(x1, y1);
        Point end1 = new Point(x2, y2);
        this.start = start1;
        this.end = end1;
    }

    /**
     * Length double.
     *
     * @return the double
     */
// Return the length of the line
    public double length() {
        return (this.start.distance(this.end));
    }

    /**
     * Middle point.
     * this method return the middle point of the line
     *
     * @return the point
     */
// Returns the middle point of the line
    public Point middle() {
        Point middle;
        double start1 = this.start.getX();
        double start2 = this.start.getY();
        double end1 = this.end.getX();
        double end2 = this.end.getY();
        double midx = (start1 + end1) / 2;
        double midy = (start2 + end2) / 2;
        middle = new Point(midx, midy);
        return middle;
    }

    /**
     * Start point.
     * this return the start point
     *
     * @return the point
     */
// Returns the start point of the line
    public Point start() {
        return this.start;
    }

    /**
     * End point.
     * this return the end point
     *
     * @return the point
     */
// Returns the end point of the line
    public Point end() {
        return this.end;
    }

    /**
     * Is intersecting boolean.
     * this return true if their is intersection point betewwn the lines
     *
     * @param other the other
     * @return the boolean
     */
// Returns true if the lines intersect, false otherwise
    public boolean isIntersecting(Line other) {

        Point p1 = this.start;
        Point q1 = this.end;
        Point p2 = other.start;
        Point q2 = other.end;
        // Find the four orientations needed for general and
        // special cases
        double o1 = orientation(p1, q1, p2);
        double o2 = orientation(p1, q1, q2);
        double o3 = orientation(p2, q2, p1);
        double o4 = orientation(p2, q2, q1);
        // General case
        if (o1 != o2 && o3 != o4) {
            return true;
        }
        // Special Cases
        // p1, q1 and p2 are colinear and p2 lies on segment p1q1
        if (o1 == 0 && onSegment(p1, p2, q1)) {
            return true;
        }
        // p1, q1 and q2 are colinear and q2 lies on segment p1q1
        if (o2 == 0 && onSegment(p1, q2, q1)) {
            return true;
        }
        // p2, q2 and p1 are colinear and p1 lies on segment p2q2
        if (o3 == 0 && onSegment(p2, p1, q2)) {
            return true;
        }
        // p2, q2 and q1 are colinear and q1 lies on segment p2q2
        if (o4 == 0 && onSegment(p2, q1, q2)) {
            return true;
        }
        return false; // Doesn't fall in any of the above cases
    }

    /**
     * Intersection with point.
     * Returns the intersection point if the lines intersect and null otherwise.
     *
     * @param other the other
     * @return the point
     */
    public Point intersectionWith(Line other) {
        if (!this.isIntersecting(other)) {
            return null;
        } else {
            // the start/end point of the 2 lines
            double thisStartX = this.start.getX();
            double thisStartY = this.start().getY();
            double thisEndX = this.end().getX();
            double thisEndY = this.end().getY();
            double otherStartX = other.start.getX();
            double otherStartY = other.start.getY();
            double oEndX = other.end().getX();
            double otherEndY = other.end.getY();
            Point meeting;
            //if the 2 lines ara vertical
            if (this.end().getX() == this.start().getX() && other.end().getX() == other.start().getX()) {
                return null;
            } else if (this.end().getX() != this.start().getX() && other.end().getX() != other.start().getX()) {
                //if the both is not vertical
                double slope1 = (this.end().getY() - this.start().getY()) / (this.end().getX() - this.start().getX());
                double slope2 = (other.end().getY() - otherStartY) / (other.end().getX() - other.start().getX());
                //if the lines are parallel
                if (slope1 == slope2) {
                    return null;
                }
            } else if (this.end().getX() == this.start().getX()) {
                // if only one line is vertial
                double slope2 = (other.end().getY() - other.start().getY()) / (oEndX - other.start().getX());
                double variableC2 = other.end().getY() - (slope2 * other.end().getX());
                double x = this.start().getX();
                double y = this.start().getX() * slope2 + variableC2;
                meeting = new Point(x, y);
                return new Point(meeting.getX(), meeting.getY());
            } else if (other.end().getX() == other.start().getX()) {
                // if only the other line is vertial
                double slope1 = (this.end().getY() - this.start().getY()) / (this.end().getX() - this.start().getX());
                double variableC1 = this.end().getY() - (slope1 * this.end().getX());
                double x = other.start().getX();
                double y = other.start().getX() * slope1 + variableC1;
                meeting = new Point(x, y);
                return new Point(meeting.getX(), meeting.getY());
            }
            //the other cases of lines
            double slope1 = (this.end().getY() - this.start().getY()) / (this.end().getX() - this.start().getX());
            double slope2 = (other.end().getY() - other.start().getY()) / (other.end().getX() - other.start().getX());
            double variableC1 = this.end().getY() - (slope1 * this.end().getX());
            double variableC2 = other.end().getY() - (slope2 * other.end().getX());
            double x = (variableC2 - variableC1) / (slope1 - slope2);
            double y = x * slope1 + variableC1;
            meeting = new Point(x, y);
            //checking if the point is between the start/end limits
            if (x >= thisStartX && x <= thisEndX && x >= otherStartX && x <= oEndX) {
                return new Point(meeting.getX(), meeting.getY());
            } else if (x >= thisEndX && x <= thisStartX && x >= oEndX && x <= otherStartX) {
                return new Point(meeting.getX(), meeting.getY());
            } else if (x >= thisStartX && x <= thisEndX && x >= oEndX && x <= otherStartX) {
                return new Point(meeting.getX(), meeting.getY());
            } else if (x >= thisEndX && x <= thisStartX && x >= otherStartX && x <= oEndX) {
                return new Point(meeting.getX(), meeting.getY());
            }
            return null;
        }
    }

    /**
     * Equals boolean.
     *
     * @param other the other
     * @return the boolean return true if thay are the same and false if the are not
     */
// equals -- return true is the lines are equal, false otherwise
    public boolean equals(Line other) {
        //  /*
        if (this.start() == other.start() && this.end() == other.end) {
            return true;
        }
        return false;
    }

    /**
     * Closest intersection to start of line point.
     *
     * @param rect the rect
     * @return the point
     */
// If this line does not intersect with the rectangle, return null.
    // Otherwise, return the closest intersection point to the
    // start of the line.
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        if (rect.intersectionPoints(this) == null) {
            return null;
        } else {
            ArrayList<Point> interList = new ArrayList<Point>();
            Point closest = rect.intersectionPoints(this).get(0);
            Double distance = rect.intersectionPoints(this).get(0).distance(this.start);
            interList = rect.intersectionPoints(this);
            for (Point c : interList) {
                double temp = c.distance(this.start);
                if (temp < distance) {
                    distance = temp;
                    closest = c;
                }
                return closest;
            }
        }
        return null;
    }

    /**
     * Distance points double.
     *
     * @param one the one
     * @param two the two
     * @return the double
     */
//method which found the distnace between 2 points
    public double distancePoints(Point one, Point two) {
        double x1 = one.getX();
        double y1 = one.getY();
        double x2 = two.getX();
        double y2 = two.getY();
        double distance = Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
        return distance;
    }

    /**
     * Orientation double.
     *
     * @param p1 the p 1
     * @param p2 the p 2
     * @param p3 the p 3
     * @return the double
     */
    public double orientation(Point p1, Point p2, Point p3) {
        double val;
        val = (p2.getY() - p1.getY()) * (p3.getX() - p2.getX()) - (p2.getX() - p1.getX()) * (p3.getY() - p2.getY());
        if (val == 0) {
            return 0;
        }
        return (val > 0) ? 1 : 2;
    }

    /**
     * On segment boolean.
     * this method checks if the 3 points are on the same segment
     *
     * @param p the p
     * @param q the q
     * @param r the r
     * @return the boolean
     */
    public boolean onSegment(Point p, Point q, Point r) {
        if (q.getX() <= max(p.getX(), r.getX()) && q.getX() >= min(p.getX(), r.getX())) {
            if (q.getY() <= max(p.getY(), r.getY()) && q.getY() >= min(p.getY(), r.getY())) {
                return true;
            }
        }
        return false;
    }
}



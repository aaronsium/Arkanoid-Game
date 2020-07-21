import java.util.ArrayList;

/**
 * The type GameLevel environment.
 */
public class GameEnvironment {

    private ArrayList<Collidable> collidables;

    /**
     * Instantiates a new GameLevel environment.
     *
     * @param x the x
     */
    public GameEnvironment(ArrayList x) {

        ArrayList<Collidable> collidables1 = x;
        this.collidables = collidables1;


    }

    /**
     * Instantiates a new GameLevel environment.
     */
    public GameEnvironment() {
        this(new ArrayList());
    }

    /**
     * Add collidable.
     *
     * @param c the c
     */
// add the given collidable to the environment.
    public void addCollidable(Collidable c) {

        this.collidables.add(c);
    }

    /**
     * Gets collidables.
     *
     * @return the collidables
     */
//getter
    public ArrayList<Collidable> getCollidables() {

        return this.collidables;
    }

    /**
     * Gets closest collision.
     * If this object will not collide with any of the collidables
     * in this collection, return null. Else, return the information
     * about the closest collision that is going to occur.
     *
     * @param trajectory the trajectory
     * @return the closest collision
     */
    //
    public CollisionInfo getClosestCollision(Line trajectory) {
        //if there are no intersections
        if (this.collidables.isEmpty()) {
            return null;
        }
        // initialization point and Collidable
        Point closest = null;
        Collidable shape = null;
        //check the closest point to the start of the line
        for (Collidable c : this.getCollidables()) {
            Point temp = trajectory.closestIntersectionToStartOfLine(c.getCollisionRectangle());
            //if the are none- skip
            if (temp == null) {
                continue;
            }
            if (closest == null) {
                closest = temp;
                shape = c;
            }
            // check the closest intersection be distance
            if (closest.distance(trajectory.start()) > temp.distance(trajectory.start())) {
                closest = temp;
                shape = c;
            }
        }
        if (closest == null) {
            return null;
        }
        return new CollisionInfo(closest, shape);
    }

    /**
     * remove collidable.
     * from the list
     *
     * @param c the c
     */
    public void removeCollidable(Collidable c) {

        collidables.remove(c);
    }
}

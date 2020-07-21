/**
 * The type Collision info.
 * this object includ in him the collisionPoint and the Object which collide
 */
public class CollisionInfo {
    private Point collisionPoint;
    private Collidable collisionObject;

    /**
     * Instantiates a new Collision info.
     *
     * @param collisionPoint1  is the collision Point
     * @param collisionObject1 is the collision Object
     */
    public CollisionInfo(Point collisionPoint1, Collidable collisionObject1) {
        this.collisionPoint = collisionPoint1;
        this.collisionObject = collisionObject1;
    }

    /**
     * Collision point point.
     *
     * @return the collision Point
     */
// the point at which the collision occurs.
    public Point collisionPoint() {
        return collisionPoint;

    }

    /**
     * Collision object collidable.
     *
     * @return the collidable object involved in the collision.
     */
    public Collidable collisionObject() {
        return collisionObject;
    }
}
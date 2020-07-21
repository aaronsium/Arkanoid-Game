/**
 * The type Ball remover.
 */
// a BlockRemover is in charge of removing blocks from the game, as well as keeping count
// of the number of blocks that remain.
public class BallRemover implements HitListener {
    private GameLevel game;
    private Counter remainingballs;

    /**
     * Instantiates a new Ball remover.
     *
     * @param game1         the game 1
     * @param removedBalls1 the removed balls 1
     */
    public BallRemover(GameLevel game1, Counter removedBalls1) {
        game = game1;
        remainingballs = removedBalls1;
    }

    // when a ball reach to the bottom of the screen it should be removed
    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        game.getCounterBalls().decrease(1);
        game.removeSprite(hitter);



    }
}

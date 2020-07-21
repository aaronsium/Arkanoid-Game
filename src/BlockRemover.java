/**
 * The type Block remover.
 */
// a BlockRemover is in charge of removing blocks from the game, as well as keeping count
// of the number of blocks that remain.
public class BlockRemover implements HitListener {
    private GameLevel game;
    private Counter remainingBlocks;

    /**
     * Instantiates a new Block remover.
     * counter for the remained blocks at the game
     *
     * @param game1          the game 1
     * @param removedBlocks1 the removed blocks 1
     */
    public BlockRemover(GameLevel game1, Counter removedBlocks1) {
        game = game1;
        remainingBlocks = removedBlocks1;
    }

    // Blocks that are hit and reach 0 hit-points should be removed
    // from the game. Remember to remove this listener from the block
    // that is being removed from the game.
    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        if (beingHit.getText().equals("x")) {
            game.removeSprite(beingHit);
            game.removeCollidable(beingHit);
            beingHit.removeHitListener(this);
            game.getCounterG().setNumber(game.getCounterG().getNumber() - 1);
        }
        if (game.getCounterG().getNumber() == 0) {
            game.getScore().increase(100);
        }
    }
}

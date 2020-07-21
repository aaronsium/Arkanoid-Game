import java.util.HashMap;
import java.util.Map;

/**
 * The type Blocks from symbols factory.
 */
public class BlocksFromSymbolsFactory {
    private Map<String, Integer> spacerWidths;
    private Map<String, BlockCreator> blockCreators;

    /**
     * Instantiates a new Blocks from symbols factory.
     */
    public BlocksFromSymbolsFactory() {
        Map<String, Integer> sMap = new HashMap<String, Integer>();
        Map<String, BlockCreator> bMap = new HashMap<String, BlockCreator>();
        this.spacerWidths = sMap;
        this.blockCreators = bMap;
    }

    /**
     * Add block creator.
     *
     * @param symbol  the symbol
     * @param creator the creator
     */
    public void addBlockCreator(String symbol, BlockCreator creator) {
        this.blockCreators.put(symbol, creator);
    }

    /**
     * Add spacer.
     *
     * @param symbol the symbol
     * @param width  the width
     */
    public void addSpacer(String symbol, int width) {
        this.spacerWidths.put(symbol, width);
    }

    /**
     * Is space symbol boolean.
     *
     * @param s the s
     * @return the boolean
     */
    public boolean isSpaceSymbol(String s) {
        if (spacerWidths.containsKey("s")) {
            return true;
        }
        return false;
    }

    /**
     * Is block symbol boolean.
     *
     * @param s the s
     * @return the boolean
     */
// returns true if 's' is a valid block symbol.
    public boolean isBlockSymbol(String s) {
        if (blockCreators.containsKey("s")) {
            return true;
        }
        return false;
    }


    /**
     * Gets space width.
     *
     * @param s the s
     * @return the space width
     */
    public int getSpaceWidth(String s) {
        return this.spacerWidths.get(s);
    }

    /**
     * Gets block.
     *
     * @param s the s
     * @param x the x
     * @param y the y
     * @return the block
     */
    public Block getBlock(String s, int x, int y) {
        return this.blockCreators.get(s).create(x, y);
    }
}

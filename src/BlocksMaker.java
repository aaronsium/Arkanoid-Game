import java.awt.Color;
import java.awt.Image;
import java.util.HashMap;
import java.util.Map;

/**
 * The type Blocks maker.
 */
public class BlocksMaker implements BlockCreator {
    private String symbol;
    private int height;
    private int width;
    private int hitPoints;
    private String fillDfualt;
    private Color stroke;
    private String color;
    private Map<Integer, Image> imageMap;
    private Map<Integer, Color> colorMap;


    /**
     * Instantiates a new Blocks maker.
     */
    public BlocksMaker() {
        this.symbol = null;
        this.fillDfualt = null;
        this.stroke = null;
        this.width = width;
        this.height = height;
        this.hitPoints = hitPoints;
        this.color = null;
        Map<Integer, Image> iMap = new HashMap<Integer, Image>();
        Map<Integer, Color> cMap = new HashMap<Integer, Color>();
        this.imageMap = iMap;
        this.colorMap = cMap;
        this.width = -1;
        this.height = -1;
        this.hitPoints = -1;


    }

    /**
     * Sets color.
     *
     * @param color1 the color 1
     */
    public void setColor(String color1) {
        this.color = color1;
    }

    /**
     * Gets symbol.
     *
     * @return the symbol
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * Sets symbol.
     *
     * @param symbol1 the symbol 1
     */
    public void setSymbol(String symbol1) {
        this.symbol = symbol1;
    }

    /**
     * Sets height.
     *
     * @param height1 the height 1
     */
    public void setHeight(int height1) {
        this.height = height1;
    }

    /**
     * Sets width.
     *
     * @param width1 the width 1
     */
    public void setWidth(int width1) {
        this.width = width1;
    }

    /**
     * Sets hit points.
     *
     * @param hitPoints1 the hit points 1
     */
    public void setHitPoints(int hitPoints1) {
        this.hitPoints = hitPoints1;
    }

    /**
     * Sets fill.
     *
     * @param fill1 the fill 1
     */
    public void setFill(String fill1) {
        this.fillDfualt = fill1;
    }

    /**
     * Sets stroke.
     *
     * @param stroke1 the stroke 1
     */
    public void setStroke(Color stroke1) {
        this.stroke = stroke1;
    }

    /**
     * Add image map.
     *
     * @param hitsNumber the hits number
     * @param photo      the photo
     */
    public void addImageMap(int hitsNumber, Image photo) {
        this.imageMap.put(hitsNumber, photo);
    }

    /**
     * Add color map.
     *
     * @param hitsNumber the hits number
     * @param color1     the color 1
     */
    public void addColorMap(int hitsNumber, Color color1) {
        this.colorMap.put(hitsNumber, color1);
    }


    @Override
    public Block create(int xpos, int ypos) {
        Point upperLeft = new Point(xpos, ypos);
        Block oneBlock = new Block(upperLeft, this.width, this.height, Color.BLACK);

        return oneBlock;
    }
}



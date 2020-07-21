import javax.imageio.ImageIO;
import java.awt.Image;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.HashMap;
import java.util.Map;

/**
 * The type Blocks definition reader.
 */
public class BlocksDefinitionReader {
    private Map<String, Integer> colorMap = new HashMap<String, Integer>();
    private Map<String, BlocksMaker> imageMap = new HashMap<String, BlocksMaker>();
    private Map<String, String> defaultMap = new HashMap<String, String>();


    /**
     * Instantiates a new Blocks definition reader.
     */
    public BlocksDefinitionReader() {
        colorMap = null;
        imageMap = null;
        defaultMap = null;
    }

    /**
     * From reader blocks from symbols factory.
     *
     * @param reader the reader
     * @return the blocks from symbols factory
     */
    public static BlocksFromSymbolsFactory fromReader(java.io.Reader reader) {
        BlocksFromSymbolsFactory factory = new BlocksFromSymbolsFactory();
        try {
            LineNumberReader lineReader = null;
            lineReader = new LineNumberReader(reader);
            String line = null;
            while ((line = lineReader.readLine()) != null) {
                if ((!"".equals(line)) && (!line.startsWith("#"))) {
//                    if (line.startsWith("default")) {
//
//

                    if (line.startsWith("bdef")) {
                        // new Block type
                        BlocksMaker oneBlock = new BlocksMaker();
                        String[] lineArray = line.split(" ");
                        for (int i = 0; i < lineArray.length; i++) {
                            if (lineArray[i].startsWith("symbol")) {
                                String[] symbolArray = lineArray[i].split(":");
                                oneBlock.setSymbol(symbolArray[1]);
                            } else if (lineArray[i].startsWith("width")) {
                                String[] widthArray = lineArray[i].split(":");
                                oneBlock.setWidth(Integer.parseInt(widthArray[1]));
                            } else if (lineArray[i].startsWith("height")) {
                                String[] heightArray = lineArray[i].split(":");
                                oneBlock.setHeight(Integer.parseInt(heightArray[1]));
                            } else if (lineArray[i].startsWith("hit_points")) {
                                String[] hitPointsArray = lineArray[i].split(":");
                                oneBlock.setHitPoints(Integer.parseInt(hitPointsArray[1]));
                            } else if (lineArray[i].startsWith("stroke")) {
                                String[] strokeArray = lineArray[i].split(":");
                                if (strokeArray[1].startsWith("color")) {

                                    String colorArray = strokeArray[1].split("\\(")[1];
                                    try {
                                        Color colorByDefinition = (Color) Color.class.getField(colorArray).get(null);
                                        oneBlock.setStroke(colorByDefinition);
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }

                                }
                            } else if (lineArray[i].startsWith("fill")) {
                                String[] fillArray = lineArray[i].split(":");
                                if (fillArray[1].equals("color")) {
                                    String[] colorArray = fillArray[1].split("\\(");
                                    if (colorArray[0].equals("RGB")) {
                                        int red = Integer.parseInt(colorArray[1]);
                                        int green = Integer.parseInt(colorArray[2]);
                                        int blue = Integer.parseInt(colorArray[3]);
                                        if (fillArray[0].length() == 4) {
                                            oneBlock.addColorMap(1, new Color(red, green, blue));
                                        } else {
                                            String[] klINE = lineArray[i].split("-");
                                            int lifeNumber = Integer.parseInt(klINE[1]);
                                            oneBlock.addColorMap(lifeNumber, new Color(red, green, blue));
                                        }
                                    }
                                }
                                if (fillArray[1].equals("image")) {

                                    String photo = fillArray[1].split("\\(")[1];
                                    Image img = null;
                                    try {
                                        img = ImageIO.read(new File(photo));
                                        // no k
                                        if (fillArray[0].length() == 4) {
                                            oneBlock.addImageMap(1, img);
                                            //if there is k
                                        } else {
                                            String[] klINE = lineArray[i].split("-");
                                            int lifeNumber = Integer.parseInt(klINE[1]);
                                            oneBlock.addImageMap(lifeNumber, img);
                                        }
                                    } catch (IOException e) {
                                        e.getStackTrace();
                                    }
                                }

                            }

                        }
                        factory.addBlockCreator(oneBlock.getSymbol(), oneBlock);
                    } else if (line.startsWith("sdef")) {
                        String[] lineArray = line.split(" ");
                        String[] symbolLine = lineArray[1].split(":");
                        String symbol = symbolLine[3];
                        factory.addSpacer(symbol, 3);
                    }
                }
            }
            return factory;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}

//    public void getDefaults(String line) {
//        for (/* each sub string*/) {
//            // split by ":"
//            // put (string[0], sting[1])
//        }
//    }

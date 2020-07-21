import javax.imageio.ImageIO;
import java.awt.Image;
import java.awt.Color;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * The type Level specification reader.
 */
public class LevelSpecificationReader {
    private List<Velocity> velocities;
    private int paddleSpeed;
    private int paddleWidth;
    private String levelName;
    private List<Block> blocks;
    private int numberOfBlocksToClear;
    private Sprite backgroundSprite;
    private LevelInformation level;
    private boolean blockPart;
    private CreateLevelInfo newLevel = null;
    private BlocksFromSymbolsFactory levelFactory;
    private int blocksStartX = -1;
    private int blocksStartY = -1;
    private int rowHeight = -1;

    /**
     * Instantiates a new Level specification reader.
     */
    public LevelSpecificationReader() {
        levelFactory = null;

    }

    /**
     * From reader list.
     *
     * @param reader the reader
     * @return the list
     */
    public List<LevelInformation> fromReader(java.io.Reader reader) {
        List levels = new LinkedList();
        Map fileDefinitions = new HashMap();
        blockPart = false;
        try {
            LineNumberReader lineReader = new LineNumberReader(reader);
            String linecopy;
            String line = null;
            while ((line = lineReader.readLine()) != null) {
                linecopy = line;
                if ((!"".equals(linecopy)) && (!linecopy.startsWith("#"))) {
                    if (line.equals("START_LEVEL")) {
                        newLevel = new CreateLevelInfo();
                    } else if (line.equals("End_LEVEL")) {
                        levels.add(newLevel);
                        this.newLevel = null;
                        this.levelFactory = null;
                        this.rowHeight = -1;
                        this.blocksStartX = -1;
                        this.blocksStartY = -1;
                    } else if ("END_BLOCKS".equals(line)) {
                        blockPart = false;
                    } else {
                        String[] lineArray = linecopy.split(":");
                        String key = lineArray[0];
                        String value = lineArray[1];

                        if (key.equals("level_name")) {
                            newLevel.setLevelName(value);
                        } else if (key.equals("block_definitions")) {
                            getBlockDef(value);
                        } else if (key.equals("ball_velocities")) {
                            String[] allVelocities = value.split(" ");
                            for (int i = 0; i < allVelocities.length; i++) {
                                String[] partsOfSpeed = allVelocities[i].split(",");
                                int speed = Integer.parseInt(partsOfSpeed[0]);
                                int angle = Integer.parseInt(partsOfSpeed[1]);
                                newLevel.initialBallVelocities().add(Velocity.fromAngleAndSpeed(angle, speed));
                            }
                        } else if (key.equals("paddle_speed")) {
                            newLevel.setPaddleSpeed(Integer.parseInt(value));
                        } else if (key.equals("paddle_width")) {
                            newLevel.setPaddleWidth(Integer.parseInt(value));
                        } else if (key.equals("blocks_start_y")) {
                            newLevel.setyStart(Integer.parseInt(value));
                        } else if (key.equals("blocks_start_x")) {
                            newLevel.setxStart(Integer.parseInt(value));
                        } else if (key.equals("num_blocks")) {
                            newLevel.setNumberOfBlocksToRemove(Integer.parseInt(value));
                        } else if (key.equals("row_height")) {
                            setRowHeight(Integer.parseInt(value));
                            newLevel.setRowHeight(Integer.parseInt(value));
                        } else if (key.equals("background")) {
                            if (lineArray[1].startsWith("image")) {
                                try {
                                    String photo = key.split("\\(")[1];
                                    Image img = null;
                                    img = ImageIO.read(new File(photo));
                                    BackGroundCreator b = new BackGroundCreator(img);
                                    b.setIsImage(true);
                                    newLevel.setGetBackground(b);
                                } catch (IOException e) {
                                    e.getStackTrace();
                                }


                            } else if (lineArray[1].startsWith("color")) {
                                String color = key.split("\\(")[1];
                                try {
                                    Color realColor = (Color) Color.class.getField(color).get(null);

                                    BackGroundCreator b = new BackGroundCreator(realColor);
                                    b.setIsColor(true);
                                    newLevel.setGetBackground(b);
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }

                            }
                        } else if (linecopy.equals("START_BLOCKS")) {
                            this.blockPart = true;
                        } else if (line.equals("End_LEVEL")) {
                            this.blockPart = false;

                        } else if (this.blockPart) {
                            int curx = this.blocksStartX;
                            int cury = this.blocksStartY;

                            for (String symbol : linecopy.split("")) {
                                if (this.levelFactory.isSpaceSymbol(symbol)) {
                                    curx = curx + this.levelFactory.getSpaceWidth(symbol);
                                } else if (this.levelFactory.isBlockSymbol(symbol)) {
                                    this.blocks.add(levelFactory.getBlock(symbol, curx, cury));
                                } else {
                                    continue;
                                }
                                this.blocksStartY += this.rowHeight;
//                            flag = true;
                            }
                        }

                    }
                }

            }
        } catch (IOException e) {
            e.getStackTrace();
        }
        return levels;
    }


    /**
     * Sets row height.
     *
     * @param rowHeight1 the row height 1
     */
    public void setRowHeight(int rowHeight1) {
        this.rowHeight = rowHeight1;
    }

    /**
     * Sets row height.
     *
     * @param value the row height 1
     */
    private void getBlockDef(String value) {
        java.io.Reader reader = null;
        try {
            reader = new InputStreamReader(ClassLoader.getSystemClassLoader().getResourceAsStream(value));
            this.levelFactory = BlocksDefinitionReader.fromReader(reader);
        } catch (Exception e) {
            System.err.println("Unable to load file");
            System.exit(1);
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException e) {
                System.err.println("Unable to close file");
                System.exit(1);
            }
        }
    }
}


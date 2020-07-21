import java.io.ObjectOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * The type High scores table.
 */
public class HighScoresTable {
    private int sizeOfTable;
    private List<ScoreInfo> scoreTable;


    /**
     * Instantiates a new High scores table.
     *
     * @param size the size
     */
// Create an empty high-scores table with the specified size.
    // The size means that the table holds up to size top scores.
    public HighScoresTable(int size) {
        this.scoreTable = new ArrayList(size);
        this.sizeOfTable = size;
    }

    /**
     * Add.
     *
     * @param score the score
     */
// Add a high-score.
    public void add(ScoreInfo score) {
        int rank = getRank(score.getScore());
        if (rank > scoreTable.size()) {
            scoreTable.add(score);
        } else {
            scoreTable.add(rank, score);
        }
        if (scoreTable.size() > sizeOfTable) {
            scoreTable.remove(scoreTable.size() - 1);
        }
    }

    /**
     * Size int.
     *
     * @return the int
     */
// Return table size.
    public int size() {
        return this.scoreTable.size();

    }

    /**
     * Gets high scores.
     *
     * @return the high scores
     */
// Return the current high scores.
    // The list is sorted such that the highest
    // scores come first.
    public List<ScoreInfo> getHighScores() {
        return this.scoreTable;

    }

    /**
     * Gets rank.
     *
     * @param score the score
     * @return the rank
     */
// return the rank of the current score: where will it
    // be on the list if added?
    // Rank 1 means the score will be highest on the list.
    // Rank `size` means the score will be lowest.
    // Rank > `size` means the score is too low and will not
    //      be added to the list.
    public int getRank(int score) {

        for (int i = 0; i <= sizeOfTable; i++) {
            if (scoreTable.size() == i) {

                for (int j = 0; j < i; j++) {

                    if (score > this.scoreTable.get(j).getScore()) {
                        return j;
                    }
                }
                return i;
            }

        }
        return sizeOfTable + 1;
    }

    /**
     * Clear.
     */
// Clears the table
    public void clear() {
        scoreTable.clear();

    }

    /**
     * Load.
     *
     * @param filename the filename
     * @throws IOException the io exception
     */
// Load table data from file.
    // Current table data is cleared.
    public void load(File filename) throws IOException {
        this.scoreTable.clear();
        ScoreInfo player;
        ObjectInputStream inputStream1 = null;
        try {
            inputStream1 = new ObjectInputStream(new FileInputStream(filename));
            if (inputStream1 != null) {
                this.scoreTable = (ArrayList) inputStream1.readObject();
            }
            inputStream1.close();
        } catch (Exception e) {
            e.getStackTrace();
        }

    }

    /**
     * Save.
     *
     * @param filename the filename
     * @throws IOException the io exception
     */
// Save table data to the specified file.
    public void save(File filename) throws IOException {
        ScoreInfo player;
        ObjectOutputStream outputStream1 = null;
        try {
            outputStream1 = new ObjectOutputStream(new FileOutputStream(filename));
            outputStream1.writeObject(this.scoreTable);
            outputStream1.close();
        } catch (IOException e) {
            e.getStackTrace();
        }
    }

    /**
     * Load from file high scores table.
     *
     * @param filename the filename
     * @return the high scores table
     * @throws ClassNotFoundException the class not found exception
     */
// Read a table from file and return it.
    // If the file does not exist, or there is a problem with
    // reading it, an empty table is returned.
    public static HighScoresTable loadFromFile(File filename) throws ClassNotFoundException {
        HighScoresTable table = new HighScoresTable(5);
        table.clear();
        ScoreInfo player;
        ObjectInputStream inputStream1 = null;
        try {
            inputStream1 = new ObjectInputStream(new FileInputStream(filename));
            while ((player = (ScoreInfo) inputStream1.readObject()) != null) {
                table.add(player);
            }
            inputStream1.close();
            return table;
        } catch (IOException e) {
            e.getStackTrace();
        }
        return null;
    }
}

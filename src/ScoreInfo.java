import java.io.Serializable;

/**
 * The type Score info.
 */
public class ScoreInfo implements Serializable {
    private String name;
    private int score;

    /**
     * Instantiates a new Score info.
     *
     * @param name  the name
     * @param score the score
     */
    public ScoreInfo(String name, int score) {
        this.name = name;
        this.score = score;
    }

    /**
     * Sets name.
     *
     * @param name1 the name 1
     */
    public void setName(String name1) {
        this.name = name1;
    }

    /**
     * Sets score.
     *
     * @param score1 the score 1
     */
    public void setScore(int score1) {
        this.score = score1;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets score.
     *
     * @return the score
     */
    public int getScore() {
        return score;
    }
}

import biuoop.DrawSurface;

import java.awt.Color;

/**
 * The type Countdown animation.
 */
public class CountdownAnimation implements Animation {
    private double numOfSecondsPerNumber;
    private int currentNumber;
    private SpriteCollection gameScreen;
    private boolean stopped;
    private double timeToEndNumber;

    /**
     * Instantiates a new Countdown animation.
     *
     * @param numOfSeconds the num of seconds
     * @param countFrom    the count from number
     * @param gameScreen   the game screen
     */
    public CountdownAnimation(double numOfSeconds, int countFrom, SpriteCollection gameScreen) {
        this.numOfSecondsPerNumber = numOfSeconds / (double) countFrom;
        this.currentNumber = countFrom + 1;
        this.gameScreen = gameScreen;
        this.timeToEndNumber = 0;
        this.stopped = false;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        //checked if the current time <= to the right time
        if (timeToEndNumber <= System.currentTimeMillis()) {
            // subtract by 1
            currentNumber--;
            // calculate the specific time that i should stoped the current number's show
            timeToEndNumber = (System.currentTimeMillis() + numOfSecondsPerNumber) + 500;
        }
        //if the currentNumber <= 0 it will stop
        if (currentNumber <= 0) {
            stopped = true;
            //if not we print the screen
        } else {
            gameScreen.drawAllOn(d);
            // drawing each number
            d.setColor(Color.BLACK);
            d.drawText(d.getWidth() / 2, d.getHeight() / 2 + 100, Integer.toString(currentNumber), 50);
            d.drawText(d.getWidth() / 2, d.getHeight() / 2 + 100, Integer.toString(currentNumber), 50);
            d.drawText(d.getWidth() / 2, d.getHeight() / 2 + 100, Integer.toString(currentNumber), 50);
            d.drawText(d.getWidth() / 2, d.getHeight() / 2 + 100, Integer.toString(currentNumber), 50);
            d.setColor(Color.WHITE);
            d.drawText(d.getWidth() / 2, d.getHeight() / 2 + 100, Integer.toString(currentNumber), 50);
        }
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public boolean shouldStop() {
        return stopped;
    }
}
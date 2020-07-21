/**
 * The type Counter.
 */
public class Counter {
    private int number;

    /**
     * Instantiates a new Counter.
     */
    public Counter() {
        number = 0;
    }

    /**
     * Gets number.
     *
     * @return the number
     */
    public int getNumber() {
        return number;
    }

    /**
     * Sets number.
     *
     * @param number1 the number 1
     */
    public void setNumber(int number1) {
        this.number = number1;
    }

    /**
     * Increase.
     * adding to the counter value
     *
     * @param number1 the number 1
     */
// add number to current count.
    public void increase(int number1) {
        setNumber(getNumber() + number1);
    }

    /**
     * Decrease.
     * to the counter value
     *
     * @param number1 the number 1
     */
// subtract number from current count.
    public void decrease(int number1) {
        setNumber(getNumber() - number1);

    }

    /**
     * Gets value.
     *
     * @return the value
     */
// get current count.
    public int getValue() {
        return number;
    }
}

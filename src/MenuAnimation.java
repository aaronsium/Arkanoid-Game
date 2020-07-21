import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import java.awt.Color;
import java.util.Iterator;
import java.util.Map;
import java.util.LinkedHashMap;

/**
 * The type Menu animation.
 *
 * @param <T> the type parameter
 */
public class MenuAnimation<T> implements Menu<T> {
    private static final int TEXT_DISTANCE = 50;

    private KeyboardSensor keyboardSensor;
    private Map<String, String> menuOption;
    private Map<String, T> returnVals;
    private Map<String, Menu<T>> subMenus;
    private T status;
    private String menuTitle;
    private Sprite br;
    private boolean shouldStop, firstTime;
    private String firstPress;
    private Menu<T> subMenu;

    /**
     * Instantiates a new Menu animation.
     *
     * @param menuTitle      the menu title
     * @param keyboardSensor the keyboard sensor
     * @param br             the br
     */
    public MenuAnimation(String menuTitle, KeyboardSensor keyboardSensor, Sprite br) {
        this.menuTitle = menuTitle;
        this.keyboardSensor = keyboardSensor;
        this.menuOption = new LinkedHashMap<>();
        this.returnVals = new LinkedHashMap<>();
        this.subMenus = new LinkedHashMap<>();
        this.br = br;
        this.status = null;
        this.shouldStop = false;
        this.firstTime = true;
        this.firstPress = null;
        this.subMenu = null;
    }

    @Override
    public void doOneFrame(DrawSurface d) {
        if (subMenu != null) {
            subMenu.doOneFrame(d);
            return;
        }

        br.drawOn(d);
        d.setColor(Color.BLACK);
        Iterator<String> keys = menuOption.keySet().iterator();
        Iterator<String> options = menuOption.values().iterator();
        for (int i = 0; i < this.menuOption.size(); i++) {
            d.drawText(90, 110 + (i * TEXT_DISTANCE), "( " + keys.next() + " ) " + options.next(), 24);
        }
//        d.drawText(80, 380, "You Won! Your score is " + String.valueOf(finalScore), 50);
    }

    @Override
    public void addSubMenu(String key, String message, Menu<T> subMenu1) {
        menuOption.put(key, message);
        subMenus.put(key, subMenu1);
    }

    /**
     * Instantiates a new Menu animation.
     *
     * @param key the menu title
     */
    private void checkIsPressed(String key) {
        if (keyboardSensor.isPressed(key)) {
            if (!firstTime && !key.equals(firstPress)) {
                if (returnVals.containsKey(key)) {
                    status = returnVals.get(key);
                    shouldStop = true;
                } else {
                    subMenu = subMenus.get(key);
                    shouldStop = subMenu.shouldStop();
                }
            } else {
                firstPress = key;
            }
        }
    }

    @Override
    public boolean shouldStop() {
        if (subMenu != null) {
            return subMenu.shouldStop();
        }

        if (firstPress != null && !keyboardSensor.isPressed(firstPress)) {
            firstPress = null;
        }

        for (String key : menuOption.keySet()) {
            checkIsPressed(key);
        }

        firstTime = false;

        return shouldStop;
    }

    @Override
    public void addSelection(String key, String message, T returnVal) {
        this.menuOption.put(key, message);
        this.returnVals.put(key, returnVal);
    }

    /**
     * reset each menu.
     */
    private void resetMenu() {
        shouldStop = false;
        firstTime = true;
        subMenu = null;
    }

    @Override
    public T getStatus() {
        if (subMenu != null) {
            status = subMenu.getStatus();
        }

        resetMenu();

        return status;
    }
}

import biuoop.DialogManager;
import biuoop.GUI;
import biuoop.KeyboardSensor;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static java.lang.System.exit;

/**
 * The type Ass 3 game.
 */
public class Ass7Game {
    /**
     * The entry point of application.
     *
     * @param args the input arguments which is the number of the specific level
     */
    public static void main(String[] args) {
        //create a new game
        GUI guix = new GUI("title", 800, 800);
        // creat an array of levels
        DialogManager dialogManager = guix.getDialogManager();
        AnimationRunner animation = new AnimationRunner(guix);
        while (true) {
            Menu<Task<Void>> menu1 = new MenuAnimation<>("asd", guix.getKeyboardSensor(), new BackGround3());
            menu1.addSelection("s", "Start Game", new Task<Void>() {
                @Override
                @SuppressWarnings("unchecked")
                public Void run() {
                    Menu<Task<Void>> menu2 = new MenuAnimation<>("asd", guix.getKeyboardSensor(), new BackGround4());
                    menu2.addSelection("a", "easy", () -> {
                        runGame(guix, animation, dialogManager, args);
                        return null;
                    });
                    menu2.addSelection("b", "medium", () -> {
                        runGame(guix, animation, dialogManager, args);
                        return null;
                    });
                    menu2.addSelection("c", "Hard", () -> {
                        runGame(guix, animation, dialogManager, args);
                        return null;
                    });
                    menu2.addSubMenu("c", "Hard", menu1);
                    animation.run(menu2);
                    menu2.getStatus().run();
                    return null;
                }
            });
            menu1.addSelection("h", "Highscores", new Task<Void>() {
                @Override
                public Void run() {


                    File newFile = new File("highscores");
                    HighScoresTable table = new HighScoresTable(5);

                    try {
                        if (newFile.isFile()) {
                            table.load(newFile);
                        } else {
                            table.save(newFile);
                        }
                    } catch (IOException e) {
                        e.getStackTrace();
                    }
                    animation.run(new KeyPressStoppableAnimation(guix.getKeyboardSensor(), KeyboardSensor.SPACE_KEY,
                            new HighScoresAnimation(table)));
                    return null;
                }
            });
            menu1.addSelection("q", "Quit Game", new Task<Void>() {
                @Override
                public Void run() {
                    guix.close();
                    exit(0);
                    return null;
                }
            });
            animation.run(menu1);
            menu1.getStatus().run();

        }


    }

    /**
     * The entry point of application.
     *
     * @param args          the input arguments which is the number of the specific level
     * @param guix          the input arguments which is the number of the specific level
     * @param animation     the input arguments which is the number of the specific level
     * @param dialogManager animation the input arguments which is the number of the specific level
     */
    private static void runGame(GUI guix, AnimationRunner animation, DialogManager dialogManager, String[] args) {
        ArrayList<LevelInformation> levels = new ArrayList<>();
        Level1 one = new Level1();
        Level2 two = new Level2();
        Level3 three = new Level3();
        Level4 four = new Level4();
        GameFlow game = new GameFlow(animation, guix.getKeyboardSensor(), dialogManager);
        // if there is no argument run the 4 levels one by one
        if (args.length == 0) {
            levels.add(one);
            levels.add(two);
            levels.add(three);
            levels.add(four);
            game.runLevels(levels);
            guix.close();
            // if there are arguments run them according to the the order in putting
        } else {
            for (String level : args) {
                if (level.equals("1") || level.equals("2") || level.equals("3") || level.equals("4")) {
                    if (level.equals("1")) {
                        levels.add(one);
                    }
                    if (level.equals("2")) {
                        levels.add(two);
                    }
                    if (level.equals("3")) {
                        levels.add(three);
                    }
                    if (level.equals("4")) {
                        levels.add(four);
                    }
                } else {
                    //if the argument is not from 1-4
                    exit(1);
                }
            }
            // run the array with the levels
            game.runLevels(levels);
            // at the and close the screen
//            guix.close();

        }
    }
}

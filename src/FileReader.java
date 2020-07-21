//import biuoop.DialogManager;
//import biuoop.KeyboardSensor;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.io.LineNumberReader;
//import java.util.List;
//
//public class FileReader {
//    private Menu<Task<Void>> menu;
//    private String fileName;
//    private GameFlow game;
//
//    public FileReader(String fileName, Menu<Task<Void>> menu, DialogManager dialogManager, AnimationRunner animation
//            , HighScoresTable h, KeyboardSensor keyboard) {
//        this.fileName = fileName;
//        this.menu = menu;
//        this.game = new GameFlow(animation, keyboard, dialogManager);
//    }
//
//    public Menu<Task<Void>> getMenu() {
//        java.io.Reader reader = null;
//        try {
//            reader = new LineNumberReader(new BufferedReader(
//                    new InputStreamReader(ClassLoader.getSystemClassLoader().getResourceAsStream(this.fileName))));
//            String line = ((LineNumberReader) reader).readLine();
//            while (line != null) {
//                String key = line.split(":")[0];
//                String message = line.split(":")[1];
//                line = ((LineNumberReader) reader).readLine();
//                menu.addSelection(key, message, makeTask(line));
//
//                line = ((LineNumberReader) reader).readLine();
//            }
//        } catch (Exception e) {
//            System.err.println("Problem with Level sets");
//            System.exit(1);
//        }
//
//
//        return this.menu;
//    }
//
//    private Task<Void> makeTask(String line) {
//        java.io.Reader reader = null;
//        try {
//            reader = new LineNumberReader(new BufferedReader(new
//                    InputStreamReader(ClassLoader.getSystemClassLoader().getResourceAsStream(line))));
//            List<LevelInformation> list = new LevelSpecificationReader().fromReader(reader);
//            return new Task<Void>() {
//                @Override
//                public Void run() {
//                    game.runLevels(list);
//                    return null;
//                }
//            };
//        } catch (Exception e) {
//            System.err.println("Problem with Level sets");
//            System.exit(1);
//        }
//
//    }
//}

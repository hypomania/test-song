import drawer.Drawer;
import parser.Parser;

public class Main {

    public static final String SONG_FILE_NAME = "song2.txt";
    public static final String IMAGE_FILE_NAME = "image.jpg";

    public static void main(String ... args) {
        Parser parser = new Parser();
        parser.parseFile(SONG_FILE_NAME);

        Drawer drawer = new Drawer();
        drawer.setPoints(parser.getWords());
        drawer.draw(IMAGE_FILE_NAME);
    }
}

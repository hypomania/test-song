package drawer;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Drawer {

    private ArrayList<String> points;

    public ArrayList<String> getPoints() {
        return points;
    }

    public void setPoints(ArrayList<String> points) {
        this.points = points;
    }

    public void draw(String imageFileName) {
        int size = points.size();
        BufferedImage bufferedImage = new BufferedImage(size, size, BufferedImage.TYPE_BYTE_GRAY);
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (points.get(i).equals(points.get(j))) {
                    bufferedImage.setRGB(i, j, Color.WHITE.getRGB());
                }
            }
        }
        File outputFile = new File(imageFileName);
        try {
            ImageIO.write(bufferedImage, "jpg", outputFile);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}

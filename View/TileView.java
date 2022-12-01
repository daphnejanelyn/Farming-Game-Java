package View;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

import javax.imageio.*;
import java.io.IOException;

public class TileView extends JButton {
    private int index;
    public BufferedImage seedImage;
    public BufferedImage appleReadyImage;
    public BufferedImage carrotReadyImage;
    public BufferedImage mangoReadyImage;
    public BufferedImage potatoReadyImage;
    public BufferedImage roseReadyImage;
    public BufferedImage sunflowerReadyImage;
    public BufferedImage tulipReadyImage;
    public BufferedImage turnipReadyImage;
    public BufferedImage witheredImage;
    public BufferedImage plowedImage;
    public BufferedImage rockedImage;

    public TileView() {
        this.setLayout(new GridBagLayout());
        this.setPreferredSize(new Dimension(75, 75));
        assignView("unplowed");
        this.setVisible(true);
    }

    public void assignView(String status) {

        try {
            rockedImage = ImageIO.read(getClass().getResourceAsStream("../resources/buttons/rock-tile.png"));
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        if (status.equals("rocked")) {
            this.setIcon(new ImageIcon(rockedImage));
            this.setBackground(new Color(0x7F462C));
            this.setContentAreaFilled(true);
            this.setForeground(new Color(0x7F462C));
        } else if (status.equals("unplowed")) {

            this.setIcon(null);
            this.setBackground(new Color(0x7F462C));
            this.setContentAreaFilled(true);
            this.setForeground(new Color(0x7F462C));
        }

    }

    public void setIndex(int init) {
        this.index = init;
    }

    public int getIndex() {
        return this.index;
    }

    public void updateView(String status) {
        try {
            plowedImage = ImageIO.read(getClass().getResourceAsStream("../resources/buttons/plowed-tile.png"));
            witheredImage = ImageIO.read(getClass().getResourceAsStream("../resources/crops/withered-crop.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }

        // change color if it is plowed
        if (status.equals("plowed")) {
            this.setIcon(new ImageIcon(plowedImage));
            this.setBorder(BorderFactory.createEmptyBorder());
            this.setContentAreaFilled(false);
            this.setFocusable(false);
            this.setSize(150, 50);
            this.setHorizontalAlignment(JButton.CENTER);
            this.setVerticalAlignment(JButton.CENTER);

        } else if (status.equals("unplowed")) {
            this.setIcon(null);
            this.setBackground(new Color(0x7F462C));
            this.setContentAreaFilled(true);
            this.setForeground(new Color(0x7F462C));

        } else if (status.equals("withered")) {
            this.setIcon(new ImageIcon(witheredImage));
            this.setBorder(BorderFactory.createEmptyBorder());
            this.setContentAreaFilled(false);
            this.setFocusable(false);
            this.setSize(150, 50);
            this.setHorizontalAlignment(JButton.CENTER);
            this.setVerticalAlignment(JButton.CENTER);

        } else if (status.equals("rocked")) {
            this.setIcon(new ImageIcon(rockedImage));
            this.setBorder(BorderFactory.createEmptyBorder());
            this.setContentAreaFilled(false);
            this.setFocusable(false);
            this.setSize(150, 50);
            this.setHorizontalAlignment(JButton.CENTER);
            this.setVerticalAlignment(JButton.CENTER);
        }

    }

    public void updateViewtoPlant(String crop, int startday, int currentday, int finalday) {
        try {
            seedImage = ImageIO.read(getClass().getResourceAsStream("../resources/crops/seeds.png"));
            appleReadyImage = ImageIO.read(getClass().getResourceAsStream("../resources/crops/apple-harvest.png"));
            carrotReadyImage = ImageIO.read(getClass().getResourceAsStream("../resources/crops/carrot-harvest.png"));
            mangoReadyImage = ImageIO.read(getClass().getResourceAsStream("../resources/crops/mango-harvest.png"));
            potatoReadyImage = ImageIO.read(getClass().getResourceAsStream("../resources/crops/potato-harvest.png"));
            roseReadyImage = ImageIO.read(getClass().getResourceAsStream("../resources/crops/rose-harvest.png"));
            sunflowerReadyImage = ImageIO
                    .read(getClass().getResourceAsStream("../resources/crops/sunflower-harvest.png"));
            tulipReadyImage = ImageIO.read(getClass().getResourceAsStream("../resources/crops/tulip-harvest.png"));
            turnipReadyImage = ImageIO.read(getClass().getResourceAsStream("../resources/crops/turnip-harvest.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
        if (startday == currentday || currentday < finalday) {
            this.setIcon(new ImageIcon(seedImage));
            this.setBorder(BorderFactory.createEmptyBorder());
            this.setContentAreaFilled(false);
            this.setFocusable(false);
            this.setSize(150, 50);
            this.setHorizontalAlignment(JButton.CENTER);
            this.setVerticalAlignment(JButton.CENTER);

        } else if (crop.equals("Turnip")) {
            if (currentday == finalday) {
                this.setIcon(new ImageIcon(turnipReadyImage));
                this.setBorder(BorderFactory.createEmptyBorder());
                this.setContentAreaFilled(false);
                this.setFocusable(false);
                this.setSize(150, 50);
                this.setHorizontalAlignment(JButton.CENTER);
                this.setVerticalAlignment(JButton.CENTER);
            }
        } else if (crop.equals("Apple")) {
            if (currentday == finalday) {
                this.setIcon(new ImageIcon(appleReadyImage));
                this.setBorder(BorderFactory.createEmptyBorder());
                this.setContentAreaFilled(false);
                this.setFocusable(false);
                this.setSize(150, 50);
                this.setHorizontalAlignment(JButton.CENTER);
                this.setVerticalAlignment(JButton.CENTER);
            }
        } else if (crop.equals("Carrot")) {
            if (currentday == finalday) {
                this.setIcon(new ImageIcon(carrotReadyImage));
                this.setBorder(BorderFactory.createEmptyBorder());
                this.setContentAreaFilled(false);
                this.setFocusable(false);
                this.setSize(150, 50);
                this.setHorizontalAlignment(JButton.CENTER);
                this.setVerticalAlignment(JButton.CENTER);
            }
        } else if (crop.equals("Mango")) {
            if (currentday == finalday) {
                this.setIcon(new ImageIcon(mangoReadyImage));
                this.setBorder(BorderFactory.createEmptyBorder());
                this.setContentAreaFilled(false);
                this.setFocusable(false);
                this.setSize(150, 50);
                this.setHorizontalAlignment(JButton.CENTER);
                this.setVerticalAlignment(JButton.CENTER);
            }
        } else if (crop.equals("Potato")) {
            if (currentday == finalday) {
                this.setIcon(new ImageIcon(potatoReadyImage));
                this.setBorder(BorderFactory.createEmptyBorder());
                this.setContentAreaFilled(false);
                this.setFocusable(false);
                this.setSize(150, 50);
                this.setHorizontalAlignment(JButton.CENTER);
                this.setVerticalAlignment(JButton.CENTER);
            }
        } else if (crop.equals("Rose")) {
            if (currentday == finalday) {
                this.setIcon(new ImageIcon(roseReadyImage));
                this.setBorder(BorderFactory.createEmptyBorder());
                this.setContentAreaFilled(false);
                this.setFocusable(false);
                this.setSize(150, 50);
                this.setHorizontalAlignment(JButton.CENTER);
                this.setVerticalAlignment(JButton.CENTER);
            }
        } else if (crop.equals("Sunflower")) {
            if (currentday == finalday) {
                this.setIcon(new ImageIcon(sunflowerReadyImage));
                this.setBorder(BorderFactory.createEmptyBorder());
                this.setContentAreaFilled(false);
                this.setFocusable(false);
                this.setSize(150, 50);
                this.setHorizontalAlignment(JButton.CENTER);
                this.setVerticalAlignment(JButton.CENTER);
            }
        } else if (crop.equals("Tulip")) {
            if (currentday == finalday) {
                this.setIcon(new ImageIcon(tulipReadyImage));
                this.setBorder(BorderFactory.createEmptyBorder());
                this.setContentAreaFilled(false);
                this.setFocusable(false);
                this.setSize(150, 50);
                this.setHorizontalAlignment(JButton.CENTER);
                this.setVerticalAlignment(JButton.CENTER);
            }
        }

    }

}

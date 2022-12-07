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
        /* get the file path of rock image assets */
        try {
            rockedImage = ImageIO.read(getClass().getResourceAsStream("../resources/buttons/rock-tile.png"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        /* updates tile according to rock status */
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

    /* This method atrributes an index to the tile. */
    public void setIndex(int init) {
        this.index = init;
    }

    /* This method gets the index attributed to the tile. */
    public int getIndex() {
        return this.index;
    }

    /* This method updates the tile view depending on the status of the tile. */
    public void updateView(String status) {
        try {
            plowedImage = ImageIO.read(getClass().getResourceAsStream("../resources/buttons/plowed-tile.png"));
            witheredImage = ImageIO.read(getClass().getResourceAsStream("../resources/crops/withered-crop.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }

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

    /*
     * This method updates the view of the tile
     * once there is a plant planted on the tile.
     */

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

        /*
         * conditions to change the view of the plant
         * according to crop name and status of the crop
         */

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

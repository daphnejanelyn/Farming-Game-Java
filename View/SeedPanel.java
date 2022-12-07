package View;

import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.IOException;

public class SeedPanel extends JPanel {

    private JButton turnip = new JButton("Turnip");
    private JButton carrot = new JButton("Carrot");
    private JButton potato = new JButton("Potato");
    private JButton rose = new JButton("Rose");
    private JButton sunflower = new JButton("Sunflower");
    private JButton tulips = new JButton("Tulip");
    private JButton mango = new JButton("Mango");
    private JButton apple = new JButton("Apple");

    BufferedImage turnipImage;
    BufferedImage carrotImage;
    BufferedImage potatoImage;
    BufferedImage roseImage;
    BufferedImage sunflowerImage;
    BufferedImage tulipImage;
    BufferedImage mangoImage;
    BufferedImage appleImage;

    public SeedPanel() {
        this.setBackground(new Color(0xA4BE7B));
        this.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        this.setLayout(new GridLayout(9, 1));
        this.setPreferredSize(new Dimension(160, 300));
        init();
        this.setVisible(true);
    }

    private void init() {
        JLabel seeds = new JLabel("Seeds");

        this.add(seeds);
        seeds.setForeground(Color.WHITE);
        seeds.setFont(new Font("Google Sans", Font.BOLD, 15));
        seeds.setVerticalAlignment(JLabel.CENTER);
        seeds.setHorizontalAlignment(JLabel.CENTER);

        /* Gets the file path of the seed assets */
        try {

            turnipImage = ImageIO.read(getClass().getResourceAsStream("../resources/buttons/1.png"));
            carrotImage = ImageIO.read(getClass().getResourceAsStream("../resources/buttons/2.png"));
            potatoImage = ImageIO.read(getClass().getResourceAsStream("../resources/buttons/3.png"));
            roseImage = ImageIO.read(getClass().getResourceAsStream("../resources/buttons/4.png"));
            sunflowerImage = ImageIO.read(getClass().getResourceAsStream("../resources/buttons/5.png"));
            tulipImage = ImageIO.read(getClass().getResourceAsStream("../resources/buttons/6.png"));
            mangoImage = ImageIO.read(getClass().getResourceAsStream("../resources/buttons/7.png"));
            appleImage = ImageIO.read(getClass().getResourceAsStream("../resources/buttons/8.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
        /* set turnip attributes and assets */
        turnip.setIcon(new ImageIcon(turnipImage));
        turnip.setBorder(BorderFactory.createEmptyBorder());
        turnip.setContentAreaFilled(false);
        turnip.setFocusable(false);
        turnip.setSize(150, 50);
        turnip.setHorizontalAlignment(JButton.CENTER);
        turnip.setVerticalAlignment(JButton.CENTER);
        turnip.setFont(new Font("Google Sans", Font.BOLD, 1));
        turnip.setForeground(new Color(0xA4BE7B));

        /* set carrot attributes and assets */
        carrot.setIcon(new ImageIcon(carrotImage));
        carrot.setBorder(BorderFactory.createEmptyBorder());
        carrot.setContentAreaFilled(false);
        carrot.setFocusable(false);
        carrot.setSize(150, 50);
        carrot.setHorizontalAlignment(JButton.CENTER);
        carrot.setVerticalAlignment(JButton.CENTER);
        carrot.setFont(new Font("Google Sans", Font.BOLD, 1));
        carrot.setForeground(new Color(0xA4BE7B));

        /* set potato attributes and assets */
        potato.setIcon(new ImageIcon(potatoImage));
        potato.setBorder(BorderFactory.createEmptyBorder());
        potato.setContentAreaFilled(false);
        potato.setFocusable(false);
        potato.setSize(150, 50);
        potato.setHorizontalAlignment(JButton.CENTER);
        potato.setVerticalAlignment(JButton.CENTER);
        potato.setFont(new Font("Google Sans", Font.BOLD, 1));
        potato.setForeground(new Color(0xA4BE7B));

        /* set rose attributes and assets */
        rose.setIcon(new ImageIcon(roseImage));
        rose.setBorder(BorderFactory.createEmptyBorder());
        rose.setContentAreaFilled(false);
        rose.setFocusable(false);
        rose.setSize(150, 50);
        rose.setHorizontalAlignment(JButton.CENTER);
        rose.setVerticalAlignment(JButton.CENTER);
        rose.setFont(new Font("Google Sans", Font.BOLD, 1));
        rose.setForeground(new Color(0xA4BE7B));

        /* set sunflower attributes and assets */
        sunflower.setIcon(new ImageIcon(sunflowerImage));
        sunflower.setBorder(BorderFactory.createEmptyBorder());
        sunflower.setContentAreaFilled(false);
        sunflower.setFocusable(false);
        sunflower.setSize(150, 50);
        sunflower.setHorizontalAlignment(JButton.CENTER);
        sunflower.setVerticalAlignment(JButton.CENTER);
        sunflower.setFont(new Font("Google Sans", Font.BOLD, 1));
        sunflower.setForeground(new Color(0xA4BE7B));

        /* set tulip attributes and assets */
        tulips.setIcon(new ImageIcon(tulipImage));
        tulips.setBorder(BorderFactory.createEmptyBorder());
        tulips.setContentAreaFilled(false);
        tulips.setFocusable(false);
        tulips.setSize(150, 50);
        tulips.setHorizontalAlignment(JButton.CENTER);
        tulips.setVerticalAlignment(JButton.CENTER);
        tulips.setFont(new Font("Google Sans", Font.BOLD, 1));
        tulips.setForeground(new Color(0xA4BE7B));

        /* set mango attributes and assets */
        mango.setIcon(new ImageIcon(mangoImage));
        mango.setBorder(BorderFactory.createEmptyBorder());
        mango.setContentAreaFilled(false);
        mango.setFocusable(false);
        mango.setSize(150, 50);
        mango.setHorizontalAlignment(JButton.CENTER);
        mango.setVerticalAlignment(JButton.CENTER);
        mango.setFont(new Font("Google Sans", Font.BOLD, 1));
        mango.setForeground(new Color(0xA4BE7B));

        /* set apple attributes and assets */
        apple.setIcon(new ImageIcon(appleImage));
        apple.setBorder(BorderFactory.createEmptyBorder());
        apple.setContentAreaFilled(false);
        apple.setFocusable(false);
        apple.setSize(150, 50);
        apple.setHorizontalAlignment(JButton.CENTER);
        apple.setVerticalAlignment(JButton.CENTER);
        apple.setFont(new Font("Google Sans", Font.BOLD, 1));
        apple.setForeground(new Color(0xA4BE7B));

        this.add(turnip);
        this.add(carrot);
        this.add(potato);
        this.add(rose);
        this.add(sunflower);
        this.add(tulips);
        this.add(mango);
        this.add(apple);

    }

    /*
     * This method returns the intialized
     * turnip seed button.
     */
    public JButton getTurnip() {
        return turnip;
    }

    /*
     * This method returns the intialized
     * carrot seed button.
     */
    public JButton getCarrot() {
        return carrot;
    }

    /*
     * This method returns the intialized
     * potato seed button.
     */
    public JButton getPotato() {
        return potato;
    }

    /*
     * This method returns the intialized
     * rose seed button.
     */
    public JButton getRose() {
        return rose;
    }

    /*
     * This method returns the intialized
     * sunflower seed button.
     */
    public JButton getSunflower() {
        return sunflower;
    }

    /*
     * This method returns the intialized
     * tulips seed button.
     */
    public JButton getTulips() {
        return tulips;
    }

    /*
     * This method returns the intialized
     * mango seed button.
     */
    public JButton getMango() {
        return mango;
    }

    /*
     * This method returns the intialized
     * apple seed button.
     */
    public JButton getApple() {
        return apple;
    }

    /*
     * This method enables all the
     * buttons initialized in the subpanel.
     */
    public void setSeedsEnabled(boolean enabled) {
        turnip.setEnabled(enabled);
        carrot.setEnabled(enabled);
        potato.setEnabled(enabled);
        rose.setEnabled(enabled);
        sunflower.setEnabled(enabled);
        tulips.setEnabled(enabled);
        mango.setEnabled(enabled);
        apple.setEnabled(enabled);
    }

}

package View;

import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.IOException;

public class SeedPanel extends JPanel {

    private JButton turnip = new JButton();
    private JButton carrot = new JButton();
    private JButton potato = new JButton();
    private JButton rose = new JButton();
    private JButton sunflower = new JButton();
    private JButton tulips = new JButton();
    private JButton mango = new JButton();
    private JButton apple = new JButton();

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
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        turnip.setIcon(new ImageIcon(turnipImage));
        turnip.setBorder(BorderFactory.createEmptyBorder());
        turnip.setContentAreaFilled(false);
        turnip.setFocusable(false);
        turnip.setSize(150, 50);
        turnip.setHorizontalAlignment(JButton.CENTER);

        carrot.setIcon(new ImageIcon(carrotImage));
        carrot.setBorder(BorderFactory.createEmptyBorder());
        carrot.setContentAreaFilled(false);
        carrot.setFocusable(false);
        carrot.setSize(150, 50);
        carrot.setHorizontalAlignment(JButton.CENTER);

        potato.setIcon(new ImageIcon(potatoImage));
        potato.setBorder(BorderFactory.createEmptyBorder());
        potato.setContentAreaFilled(false);
        potato.setFocusable(false);
        potato.setSize(150, 50);
        potato.setHorizontalAlignment(JButton.CENTER);

        rose.setIcon(new ImageIcon(roseImage));
        rose.setBorder(BorderFactory.createEmptyBorder());
        rose.setContentAreaFilled(false);
        rose.setFocusable(false);
        rose.setSize(150, 50);
        rose.setHorizontalAlignment(JButton.CENTER);

        sunflower.setIcon(new ImageIcon(sunflowerImage));
        sunflower.setBorder(BorderFactory.createEmptyBorder());
        sunflower.setContentAreaFilled(false);
        sunflower.setFocusable(false);
        sunflower.setSize(150, 50);
        sunflower.setHorizontalAlignment(JButton.CENTER);

        tulips.setIcon(new ImageIcon(tulipImage));
        tulips.setBorder(BorderFactory.createEmptyBorder());
        tulips.setContentAreaFilled(false);
        tulips.setFocusable(false);
        tulips.setSize(150, 50);
        tulips.setHorizontalAlignment(JButton.CENTER);

        mango.setIcon(new ImageIcon(mangoImage));
        mango.setBorder(BorderFactory.createEmptyBorder());
        mango.setContentAreaFilled(false);
        mango.setFocusable(false);
        mango.setSize(150, 50);
        mango.setHorizontalAlignment(JButton.CENTER);

        apple.setIcon(new ImageIcon(appleImage));
        apple.setBorder(BorderFactory.createEmptyBorder());
        apple.setContentAreaFilled(false);
        apple.setFocusable(false);
        apple.setSize(150, 50);
        apple.setHorizontalAlignment(JButton.CENTER);

        this.add(turnip);
        this.add(carrot);
        this.add(potato);
        this.add(rose);
        this.add(sunflower);
        this.add(tulips);
        this.add(mango);
        this.add(apple);

    }

    public JButton getTurnip() {
        return turnip;
    }

    public JButton getCarrot() {
        return carrot;
    }

    public JButton getPotato() {
        return potato;
    }

    public JButton getRose() {
        return rose;
    }

    public JButton getSunflower() {
        return sunflower;
    }

    public JButton getTulips() {
        return tulips;
    }

    public JButton getMango() {
        return mango;
    }

    public JButton getApple() {
        return apple;
    }

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

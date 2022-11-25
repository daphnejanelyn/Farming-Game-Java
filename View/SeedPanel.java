package View;

import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.IOException;

public class SeedPanel extends JPanel {

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

        JButton turnip = new JButton();
        turnip.setIcon(new ImageIcon(turnipImage));
        turnip.setBorder(BorderFactory.createEmptyBorder());
        turnip.setContentAreaFilled(false);
        turnip.setFocusable(false);
        turnip.setSize(150, 50);
        turnip.setHorizontalAlignment(JButton.CENTER);

        JButton carrot = new JButton();
        carrot.setIcon(new ImageIcon(carrotImage));
        carrot.setBorder(BorderFactory.createEmptyBorder());
        carrot.setContentAreaFilled(false);
        carrot.setFocusable(false);
        carrot.setSize(150, 50);
        carrot.setHorizontalAlignment(JButton.CENTER);

        JButton potato = new JButton();
        potato.setIcon(new ImageIcon(potatoImage));
        potato.setBorder(BorderFactory.createEmptyBorder());
        potato.setContentAreaFilled(false);
        potato.setFocusable(false);
        potato.setSize(150, 50);
        potato.setHorizontalAlignment(JButton.CENTER);

        JButton rose = new JButton();
        rose.setIcon(new ImageIcon(roseImage));
        rose.setBorder(BorderFactory.createEmptyBorder());
        rose.setContentAreaFilled(false);
        rose.setFocusable(false);
        rose.setSize(150, 50);
        rose.setHorizontalAlignment(JButton.CENTER);

        JButton sunflower = new JButton();
        sunflower.setIcon(new ImageIcon(sunflowerImage));
        sunflower.setBorder(BorderFactory.createEmptyBorder());
        sunflower.setContentAreaFilled(false);
        sunflower.setFocusable(false);
        sunflower.setSize(150, 50);
        sunflower.setHorizontalAlignment(JButton.CENTER);

        JButton tulips = new JButton();
        tulips.setIcon(new ImageIcon(tulipImage));
        tulips.setBorder(BorderFactory.createEmptyBorder());
        tulips.setContentAreaFilled(false);
        tulips.setFocusable(false);
        tulips.setSize(150, 50);
        tulips.setHorizontalAlignment(JButton.CENTER);

        JButton mango = new JButton();
        mango.setIcon(new ImageIcon(mangoImage));
        mango.setBorder(BorderFactory.createEmptyBorder());
        mango.setContentAreaFilled(false);
        mango.setFocusable(false);
        mango.setSize(150, 50);
        mango.setHorizontalAlignment(JButton.CENTER);

        JButton apple = new JButton();
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

}

package View;

import javax.swing.*;
import java.awt.*;

public class SeedPanel extends JPanel {

    public SeedPanel() {
        this.setBackground(new Color(0x4B8673));
        this.setLayout(new GridLayout(10, 1));
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

        JButton turnip = new JButton();
        turnip.setIcon(new ImageIcon("turnip.png"));
        turnip.setFocusable(false);
        turnip.setSize(150, 50);
        turnip.setHorizontalAlignment(JButton.CENTER);

        JButton carrot = new JButton("Carrot");
        carrot.setFocusable(false);
        carrot.setSize(150, 50);
        carrot.setHorizontalAlignment(JButton.CENTER);

        JButton potato = new JButton("Potato");
        potato.setFocusable(false);
        potato.setSize(150, 50);
        potato.setHorizontalAlignment(JButton.CENTER);

        JButton rose = new JButton("Rose");
        rose.setFocusable(false);
        rose.setSize(150, 50);
        rose.setHorizontalAlignment(JButton.CENTER);

        JButton sunflower = new JButton("Sunflower");
        sunflower.setFocusable(false);
        sunflower.setSize(150, 50);
        sunflower.setHorizontalAlignment(JButton.CENTER);

        JButton tulips = new JButton("Tulips");
        tulips.setFocusable(false);
        tulips.setSize(150, 50);
        tulips.setHorizontalAlignment(JButton.CENTER);

        JButton mango = new JButton("Mango");
        mango.setFocusable(false);
        mango.setSize(150, 50);
        mango.setHorizontalAlignment(JButton.CENTER);

        JButton apple = new JButton("Apple");
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

package View;

import javax.swing.*;
import java.awt.*;
import java.awt.image.*;
import javax.imageio.*;
import java.io.IOException;

public class NextDayPanel extends JPanel {

    private JButton nextDay = new JButton("Proceed to Next Day");

    BufferedImage nextDayImage;

    public NextDayPanel() {
        this.setLayout(new GridLayout(1, 1));
        this.setForeground(Color.WHITE);
        this.setBackground(new Color(0xA4BE7B));
        this.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        this.setPreferredSize(new Dimension(160, 150));
        addButtons();
        this.setVisible(true);
    }

    private void addButtons() {

        try {

            nextDayImage = ImageIO.read(getClass().getResourceAsStream("../resources/buttons/next-day.png"));

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        nextDay.setIcon(new ImageIcon(nextDayImage));
        nextDay.setBorder(BorderFactory.createEmptyBorder());
        nextDay.setContentAreaFilled(false);
        nextDay.setFocusable(false);
        nextDay.setSize(150, 50);
        nextDay.setHorizontalAlignment(JButton.CENTER);
        nextDay.setVerticalAlignment(JButton.CENTER);
        nextDay.setFont(new Font("Google Sans", Font.BOLD, 1));

        this.add(nextDay);
    }
}

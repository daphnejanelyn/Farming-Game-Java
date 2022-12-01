package View;

import javax.swing.*;
import java.awt.*;

public class TitlePanel extends JPanel {
    JLabel prompt = new JLabel();

    public TitlePanel() {
        this.setBackground(new Color(0xF6FBF4));
        this.setPreferredSize(new Dimension(1000, 30));
        // setText();
        this.setVisible(true);
    }

    /* Needs to be fixed */
    private void setText() {
        JLabel title = new JLabel();
        title.setText("My Farm");
        title.setFont(new Font("Google Sans", Font.BOLD, 30));
        title.setVerticalAlignment(JLabel.TOP);
        title.setHorizontalAlignment(JLabel.CENTER);
        this.add(title);
    }

    public void displayPrompt(String status) {

        if (status.equals("Watered")) {
            prompt.setText("Watered Successfully");
            prompt.setFont(new Font("Google Sans", Font.BOLD, 10));
            prompt.setVerticalAlignment(JLabel.BOTTOM);
            prompt.setHorizontalAlignment(JLabel.CENTER);
            this.add(prompt);
            prompt.setVisible(true);

        } else if (status.equals("Fertilized")) {
            prompt.setText("Fertilized Successfully");
            prompt.setFont(new Font("Google Sans", Font.BOLD, 10));
            prompt.setVerticalAlignment(JLabel.BOTTOM);
            prompt.setHorizontalAlignment(JLabel.CENTER);
            this.add(prompt);
            prompt.setVisible(true);

        } else if (status.equals("Failed Watered")) {
            prompt.setText("Watered Failed");
            prompt.setFont(new Font("Google Sans", Font.BOLD, 10));
            prompt.setVerticalAlignment(JLabel.BOTTOM);
            prompt.setHorizontalAlignment(JLabel.CENTER);
            this.add(prompt);
            prompt.setVisible(true);

        } else if (status.equals("Failed Fertilized")) {
            prompt.setText("Fertilized Failed");
            prompt.setFont(new Font("Google Sans", Font.BOLD, 10));
            prompt.setVerticalAlignment(JLabel.BOTTOM);
            prompt.setHorizontalAlignment(JLabel.CENTER);
            this.add(prompt);
            prompt.setVisible(true);

        } else if (status.equals("Buy Failed")) {
            prompt.setText("Seed Bought Failed");
            prompt.setFont(new Font("Google Sans", Font.BOLD, 10));
            prompt.setVerticalAlignment(JLabel.BOTTOM);
            prompt.setHorizontalAlignment(JLabel.CENTER);
            this.add(prompt);
            prompt.setVisible(true);

        } else if (status.equals("Harvest Failed")) {
            prompt.setText("Harvested Crop Failed");
            prompt.setFont(new Font("Google Sans", Font.BOLD, 10));
            prompt.setVerticalAlignment(JLabel.BOTTOM);
            prompt.setHorizontalAlignment(JLabel.CENTER);
            this.add(prompt);
            prompt.setVisible(true);

        } else if (status.equals("Shovel Failed")) {
            prompt.setText("Shovel Crop Failed");
            prompt.setFont(new Font("Google Sans", Font.BOLD, 10));
            prompt.setVerticalAlignment(JLabel.BOTTOM);
            prompt.setHorizontalAlignment(JLabel.CENTER);
            this.add(prompt);
            prompt.setVisible(true);

        } else if (status.equals("Shovel Success")) {
            prompt.setText("Shoveled Crop Successfully");
            prompt.setFont(new Font("Google Sans", Font.BOLD, 10));
            prompt.setVerticalAlignment(JLabel.BOTTOM);
            prompt.setHorizontalAlignment(JLabel.CENTER);
            this.add(prompt);
            prompt.setVisible(true);
        } else if (status.equals("PickAxe Failed")) {
            prompt.setText("Remove Rock Failed");
            prompt.setFont(new Font("Google Sans", Font.BOLD, 10));
            prompt.setVerticalAlignment(JLabel.BOTTOM);
            prompt.setHorizontalAlignment(JLabel.CENTER);
            this.add(prompt);
            prompt.setVisible(true);
        }
    }

    public void hidePrompt() {
        prompt.setText("");
    }
    /* include progress bar for level */

}

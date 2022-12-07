package View;

import javax.swing.*;
import java.awt.*;

public class TitlePanel extends JPanel {
    JLabel prompt = new JLabel();

    public TitlePanel() {
        this.setBackground(new Color(0xF6FBF4));
        this.setPreferredSize(new Dimension(1000, 30));
        this.setVisible(true);
    }

    /*
     * Display prompt in title panel depending
     * on the status of tile status.
     */

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
        } else if (status.equals("Registered Farmer Success")) {
            prompt.setText("Registered Farmer Successfully Upgraded");
            prompt.setFont(new Font("Google Sans", Font.BOLD, 10));
            prompt.setVerticalAlignment(JLabel.BOTTOM);
            prompt.setHorizontalAlignment(JLabel.CENTER);
            this.add(prompt);
            prompt.setVisible(true);
        } else if (status.equals("Registered Farmer Failed")) {
            prompt.setText("Registered Farmer Failed to Upgrade");
            prompt.setFont(new Font("Google Sans", Font.BOLD, 10));
            prompt.setVerticalAlignment(JLabel.BOTTOM);
            prompt.setHorizontalAlignment(JLabel.CENTER);
            this.add(prompt);
            prompt.setVisible(true);
        } else if (status.equals("Distinguished Farmer Success")) {
            prompt.setText("Distinguished Farmer Successfully Upgraded");
            prompt.setFont(new Font("Google Sans", Font.BOLD, 10));
            prompt.setVerticalAlignment(JLabel.BOTTOM);
            prompt.setHorizontalAlignment(JLabel.CENTER);
            this.add(prompt);
            prompt.setVisible(true);
        } else if (status.equals("Distinguished Farmer Failed")) {
            prompt.setText("Distinguished Farmer Failed to Upgrade");
            prompt.setFont(new Font("Google Sans", Font.BOLD, 10));
            prompt.setVerticalAlignment(JLabel.BOTTOM);
            prompt.setHorizontalAlignment(JLabel.CENTER);
            this.add(prompt);
            prompt.setVisible(true);
        } else if (status.equals("Legendary Farmer Success")) {
            prompt.setText("Legendary Farmer Successfully Upgraded");
            prompt.setFont(new Font("Google Sans", Font.BOLD, 10));
            prompt.setVerticalAlignment(JLabel.BOTTOM);
            prompt.setHorizontalAlignment(JLabel.CENTER);
            this.add(prompt);
            prompt.setVisible(true);
        } else if (status.equals("Legendary Farmer Failed")) {
            prompt.setText("Legendary Farmer Failed to Upgrade");
            prompt.setFont(new Font("Google Sans", Font.BOLD, 10));
            prompt.setVerticalAlignment(JLabel.BOTTOM);
            prompt.setHorizontalAlignment(JLabel.CENTER);
            this.add(prompt);
            prompt.setVisible(true);
        } else if (status.equals("Plow Failed")) {
            prompt.setText("Plowed Failed");
            prompt.setFont(new Font("Google Sans", Font.BOLD, 10));
            prompt.setVerticalAlignment(JLabel.BOTTOM);
            prompt.setHorizontalAlignment(JLabel.CENTER);
            this.add(prompt);
            prompt.setVisible(true);
        }
    }

    /* This method hides visible prompt. */
    public void hidePrompt() {
        prompt.setText("");
    }

    /*
     * This method displays products produced
     * and final harvest price of the crop
     */

    public void harvestPrompt(int products, double harvestPrice) {
        prompt.setText("Products: " + products + "          Harvest Price: " + harvestPrice);
        prompt.setFont(new Font("Google Sans", Font.BOLD, 10));
        prompt.setVerticalAlignment(JLabel.CENTER);
        prompt.setHorizontalAlignment(JLabel.CENTER);
        this.add(prompt);
        prompt.setVisible(true);

    }

}

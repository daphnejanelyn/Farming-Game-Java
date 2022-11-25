package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class UpgradePanel extends JPanel {
    private JButton regFarmer = new JButton("Registered");
    private JButton disFarmer = new JButton("Distinguished");
    private JButton legFarmer = new JButton("Legendary");

    public UpgradePanel() {
        this.setLayout(new GridLayout(4, 1));
        this.setForeground(Color.WHITE);
        this.setBackground(new Color(0xA4BE7B));
        this.setBorder(BorderFactory.createLineBorder(Color.WHITE));
        this.setPreferredSize(new Dimension(160, 275));
        init();
        addButtons();
        this.setVisible(true);

    }

    private void init() {
        JLabel upgrade = new JLabel("Farmer Upgrade");
        upgrade.setForeground(Color.WHITE);
        upgrade.setFont(new Font("Google Sans", Font.BOLD, 15));
        upgrade.setVerticalAlignment(JLabel.CENTER);
        upgrade.setHorizontalAlignment(JLabel.CENTER);
        this.add(upgrade);
    }

    private void addButtons() {

        /* Registered Farmer */
        regFarmer.setFocusable(false);
        regFarmer.setSize(150, 50);
        regFarmer.setHorizontalAlignment(JButton.CENTER);
        regFarmer.setFont(new Font("Google Sans", Font.BOLD, 11));

        /* Distinguished Farmer */
        disFarmer.setFocusable(false);
        disFarmer.setSize(150, 50);
        disFarmer.setHorizontalAlignment(JButton.CENTER);
        disFarmer.setFont(new Font("Google Sans", Font.BOLD, 9));

        /* Legendary Farmer */
        legFarmer.setFocusable(false);
        legFarmer.setSize(150, 50);
        legFarmer.setHorizontalAlignment(JButton.CENTER);
        legFarmer.setFont(new Font("Google Sans", Font.BOLD, 11));

        this.add(regFarmer);
        this.add(disFarmer);
        this.add(legFarmer);
    }

    public JButton getReg() {
        return regFarmer;
    }

    public JButton getDis() {
        return disFarmer;
    }

    public JButton getLeg() {
        return legFarmer;
    }

    public void setActionListener(ActionListener listener) {
        regFarmer.addActionListener(listener);
        disFarmer.addActionListener(listener);
        legFarmer.addActionListener(listener);
    }

    public void setRegEnabled(boolean enabled) {
        regFarmer.setEnabled(enabled);
    }

    public void setDisEnabled(boolean enabled) {
        disFarmer.setEnabled(enabled);
    }

    public void setLegEnabled(boolean enabled) {
        legFarmer.setEnabled(enabled);
    }

}

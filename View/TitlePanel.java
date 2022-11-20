package View;

import javax.swing.*;
import java.awt.*;

public class TitlePanel extends JPanel {

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

    /* include progress bar for level */

}

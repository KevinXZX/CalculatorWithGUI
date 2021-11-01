package GUI;

import javax.swing.*;

public class Inputs extends JButton {
    public Inputs(String value, int x, int y){
        this.setText(String.valueOf(value));
        this.addActionListener(e -> Calculator.display.update(value));
        this.setBounds(x,y,100,100);
    }
}

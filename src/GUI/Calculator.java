package GUI;


import java.awt.*;


public class Calculator {
    static Display display = new Display();
    public static void main(String[] args) {
        CalculatorFrame calculator = new CalculatorFrame();
        display.setLayout(new BorderLayout());
        Inputs[][] digits = new Inputs[3][3];
        int initialY = 425;
        int count = 1;
        for (int i = 0; i < 3; i++) {
            int initialX = 25;
            for (int h = 0; h < 3; h++) {
                digits[i][h] = new Inputs(Integer.toString(count), initialX, initialY);
                calculator.add(digits[i][h]);
                count++;
                initialX = initialX + 125;
            }
            initialY = initialY - 125;
        }
        Inputs zero = new Inputs("0", 25, 550);
        Inputs multiplication = new Inputs("*", 400, 175);
        Inputs division = new Inputs("/", 400, 300);
        Inputs plus = new Inputs("+", 400, 425);
        Inputs minus = new Inputs("-", 400, 550);
        Inputs equal = new Inputs("=",275,550);
        Inputs decimal = new Inputs(".",150,550);
        Inputs delete = new Inputs("DEL",25,675);
        Inputs clear = new Inputs("AC",150,675);
        calculator.add(multiplication);
        calculator.add(zero);
        calculator.add(display);
        calculator.add(division);
        calculator.add(plus);
        calculator.add(minus);
        calculator.add(equal);
        calculator.add(decimal);
        calculator.add(delete);
        calculator.add(clear);
        calculator.setVisible(true);
        calculator.revalidate();
        calculator.repaint();
    }
}

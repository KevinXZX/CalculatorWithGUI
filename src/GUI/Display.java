package GUI;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Display extends JPanel {
    JLabel label;
    String sum = "";
    public Display(){
        Font f = new Font("serif", Font.BOLD,25);
        label = new JLabel();
        this.setBackground(Color.WHITE);
        this.setBounds(25,25,475,75);
        label.setForeground(Color.BLACK);
        label.setFont(f);
        this.add(label);
    }
    public void update(String input){
        if(input.equals("=")){
            sum = Double.toString(calculate(sum));
        }
        else{
            sum = sum + input;
        }
        label.setText(sum);
        this.add(label);
    }
    public double calculate(String x){
        ArrayList<Double> numbers = new ArrayList<>();
        ArrayList<Character> signs = new ArrayList<>();
        int startIndex = 0;
        for(int i = 0;i<x.length();i++){
            char c = x.charAt(i);
            if(!(Character.isDigit(c)) && c != '.'){
                String temp = x.substring(startIndex,i);
                startIndex = i+1;
                double y = Double.parseDouble(temp);
                numbers.add(y);
                signs.add(c);
            }
            else if(i == x.length()-1){
                String temp = x.substring(startIndex);
                double y = Double.parseDouble(temp);
                numbers.add(y);
            }
        }
        int i = 0;
        while(signs.contains('*') || signs.contains('/')){
            if(signs.get(i) == '*'){
                double tempAnswer = numbers.get(i) * numbers.get(i+1);
                numbers.set(i+1,tempAnswer);
                numbers.remove(i);
                signs.remove(i);
                i--;
            }
            else if(signs.get(i) == '/'){
                double tempAnswer = numbers.get(i) / numbers.get(i+1);
                numbers.set(i+1,tempAnswer);
                numbers.remove(i);
                signs.remove(i);
                i--;
            }
            i++;
        }
        i = 0;
        while(signs.contains('+') || signs.contains('-')){
            if(signs.get(i) == '+'){
                double tempAnswer = numbers.get(i) + numbers.get(i+1);
                numbers.set(i+1,tempAnswer);
                numbers.remove(i);
                signs.remove(i);
                i--;
            }
            else if(signs.get(i) == '-'){
                double tempAnswer = numbers.get(i) - numbers.get(i+1);
                numbers.set(i+1,tempAnswer);
                numbers.remove(i);
                signs.remove(i);
                i--;
            }
            i++;
        }
        return numbers.get(0);
    }
}

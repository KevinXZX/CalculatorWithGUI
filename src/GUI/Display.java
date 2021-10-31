package GUI;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Display extends JPanel {
    JLabel label;
    String sum = "";
    public Display(){
        label = new JLabel();
        this.setBackground(Color.WHITE);
        this.setBounds(50,0,600,75);
        label.setForeground(Color.BLACK);
    }
    public void update(String input){
        int result = 0;
        if(input.equals("=")){
            sum = Double.toString(calculate(sum));
        }
        else{
            sum = sum + input;
        }
        label.setText(sum);
    }
    public double calculate(String x){
        ArrayList<Double> numbers = new ArrayList<Double>();
        ArrayList<Character> signs = new ArrayList<Character>();
        int startIndex = 0;
        int result = 0;
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

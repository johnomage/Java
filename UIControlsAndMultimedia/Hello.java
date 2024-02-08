package UIControlsAndMultimedia;

import java.util.Scanner;

public class Hello {
    public static void main(String[] args){
        System.out.print("Hello!\nEnter value:");
        
        Scanner input = new Scanner(System.in);
        double value = input.nextDouble();
        for(int i=0; i<value+1; i++){
            System.out.print(i + " cubed is "+ Math.pow(i,3) + "\n");
            if(i == value/2)
                System.out.print("Mid point reached." + "\n");
          //  else  System.out.print("No Mid point scanned." + "\n");
        }
    }
}
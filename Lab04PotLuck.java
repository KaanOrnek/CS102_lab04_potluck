import java.util.Scanner;
import javax.swing.*;

public class Lab04PotLuck {
    public static void main (String [] args){
        Scanner scan = new Scanner(System.in);

        int dimension;

        System.out.println("Please insert the dimension of the pot luck game");
        dimension = scan.nextInt();

        JFrame frame = new JFrame("Button Matrix Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.getContentPane().add( new PotLuckPanel( dimension) );
        frame.pack();
        frame.setVisible(true);

    }
}

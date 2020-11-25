import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class PotLuckPanel extends JPanel {
    private JPanel tryPanel;
    private JPanel buttonPanel;
    private int currentTries;
    private JLabel label;
    private ArrayList<JButton> buttons;
    private JButton prize;
    private JButton bomb1;
    private JButton bomb2;
    private int prizeNum;
    private int bomb1Num;
    private int bomb2Num;
    private GridLayout a;

    public PotLuckPanel(int dimension){

        currentTries = 0;

        buttons = new ArrayList<JButton>();

        ButtonListener listener = new ButtonListener();
        setBackground(Color.GREEN);
        setPreferredSize( new Dimension( 600,400));

        label = new JLabel( ""+ currentTries);

        tryPanel = new JPanel();
        tryPanel.setPreferredSize( new Dimension( 600,40));
        tryPanel.setBackground( Color.YELLOW);
        tryPanel.add( label );

        add(tryPanel);

        a = new GridLayout(dimension,dimension);

        buttonPanel = new JPanel();
        buttonPanel.setPreferredSize( new Dimension( 500, 320));
        buttonPanel.setBackground(Color.GRAY);
        buttonPanel.setLayout(a);

        prizeNum = (int)(Math.random()*(dimension*dimension) + 1);
        do{
            bomb1Num = (int)(Math.random()*(dimension*dimension) + 1);
        }while(prizeNum == bomb1Num);
        do{
            bomb2Num = (int)(Math.random()*(dimension*dimension) + 1);
        }while(bomb2Num == bomb1Num || bomb2Num == prizeNum);

        for( int i = 0; i < (dimension*dimension); i++){
            buttons.add( new JButton("Pot "+ (i+1)));
            buttonPanel.add( buttons.get(i));
            buttons.get(i).addActionListener(listener);
            if( bomb1Num == i+1)
                bomb1 = buttons.get(i);
            else if( bomb2Num == i+1)
                bomb2 = buttons.get(i);
            else if( prizeNum == i+1)
                prize = buttons.get(i);

        }
        add(buttonPanel);




    }




    private class ButtonListener implements ActionListener {

        public void actionPerformed(ActionEvent event) {
            currentTries++;
            if( event.getSource() == prize)
                label.setText( "You got it in " + currentTries + " attempts!");
            else if( event.getSource() == bomb1 || event.getSource() == bomb2)
                label.setText( "Sorry! You are blown up at attempt " + currentTries +"!");
            else
                label.setText( ""+currentTries);

        }
    }
}

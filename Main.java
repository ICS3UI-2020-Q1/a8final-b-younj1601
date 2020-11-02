import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Main implements Runnable, ActionListener{

  // Class Variables  
  JPanel mainPanel;

  JLabel counterLabel;

  JTextField outputCount;

  JButton countButton;
  JButton resetButton;

  int count;

  // Method to assemble our GUI
  public void run(){
    // Creats a JFrame that is 800 pixels by 600 pixels, and closes when you click on the X
    JFrame frame = new JFrame("Title");
    // Makes the X button close the program
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // makes the windows 800 pixel wide by 600 pixels tall
    frame.setSize(800,600);
    // shows the window
    frame.setVisible(true);
 
    //initialize the main panel 
    mainPanel = new JPanel();
    //disable any layout helpers
    mainPanel.setLayout(null);

    //initialize the label 
    counterLabel = new JLabel("Counter:");

    //set location and size of the label 
    counterLabel.setBounds(150,200,100,30);

    //initialize the text field 
    outputCount = new JTextField("0");

    //set location and size of text field 
    outputCount.setBounds(220,200,150,30);

    //disable output field so the user cant type in it
    outputCount.setEnabled(false);

    //initialize the buttons
    countButton = new JButton("Count");
    resetButton = new JButton("Reset");

    //set loation and size of buttons
    countButton.setBounds(150,150,100,30);
    resetButton.setBounds(270,150,100,30);

    //add action listener to the buttons
    countButton.addActionListener(this);
    resetButton.addActionListener(this);

    //set action command on the buttons
    countButton.setActionCommand("count");
    resetButton.setActionCommand("reset");

    //add the label to the panel 
    mainPanel.add(counterLabel);

    //add the text field to the panel 
    mainPanel.add(outputCount);

    //add the buttons to the panel 
    mainPanel.add(countButton);
    mainPanel.add(resetButton);

    //add the panel to the frame
    frame.add(mainPanel);
  }

  // method called when a button is pressed
  public void actionPerformed(ActionEvent e){
    // get the command from the action
    String command = e.getActionCommand();

    //if the count button is pressed
    if(command.equals("count")){
      //if the counter is under ten
      if(count < 10){
      //add one to count
      count = count + 1;
      //set the output text to whatever count is
      outputCount.setText("" + count);
      }
    }

    //if reset button is pressed
    if(command.equals("reset")){
      //set count to 0
      count = 0;
      //set the output text to 0
      outputCount.setText("0");
    }
  }

  // Main method to start our program
  public static void main(String[] args){
    // Creates an instance of our program
    Main gui = new Main();
    // Lets the computer know to start it in the event thread
    SwingUtilities.invokeLater(gui);
  }
}

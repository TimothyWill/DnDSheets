import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Main {

	private static class HelloWorldDisplay extends JPanel {
	      public void paintComponent(Graphics g) {
	         super.paintComponent(g);
	         g.drawString( "Hello World!", 20, 30 );
	      }
	   }
	   
	   private static class ButtonHandler implements ActionListener {
	      public void actionPerformed(ActionEvent e) {
	         System.exit(0);
	      }
	   }
	
	public static void main(String[] args) {
		
		HelloWorldDisplay displayPanel = new HelloWorldDisplay();
	    JButton okButton = new JButton("OK");
	    ButtonHandler listener = new ButtonHandler();
	    okButton.addActionListener(listener);

	    JPanel content = new JPanel();
	    content.setLayout(new BorderLayout());
	    content.add(displayPanel, BorderLayout.CENTER);
	    content.add(okButton, BorderLayout.SOUTH);
	      
		JFrame frame = new JFrame();
		frame.setContentPane(content);
	    frame.setSize(250,100);
	    frame.setLocation(100,100);
	    frame.setVisible(true);
		
		System.out.println("Hello World");

	}

}

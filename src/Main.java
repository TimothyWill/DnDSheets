import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Main {
	
	public static JTabbedPane tabbedPane;
	   
	private static class MonsterButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JLabel text = new JLabel("Monster Sheet");
		    JPanel monsterSheet = new JPanel();
		    monsterSheet.setLayout(new BorderLayout());
		    monsterSheet.add(text,BorderLayout.NORTH);
		    
			tabbedPane.addTab("Monster Sheet", monsterSheet);
			tabbedPane.setSelectedIndex(tabbedPane.getTabCount() - 1);
		}
	}
	   
	private static class CharacterButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
		    	  	
		}
	}
	   
	private static class SummonButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
		    	  	
		}
	}
	
	public static void main(String[] args) {
		
	    JButton monsterGenButton = new JButton("Generate Monster Sheet");
	    MonsterButtonHandler monsterlistener = new MonsterButtonHandler();
	    monsterGenButton.addActionListener(monsterlistener);

	    JPanel monsterSheet = new JPanel();
	    monsterSheet.setLayout(new BorderLayout());
	    monsterSheet.add(monsterGenButton, BorderLayout.SOUTH);
	    
	    JButton characterGenButton = new JButton("Generate Character Sheet");
	    CharacterButtonHandler characterlistener = new CharacterButtonHandler();
	    characterGenButton.addActionListener(characterlistener);

	    JPanel characterSheet = new JPanel();
	    characterSheet.setLayout(new BorderLayout());
	    characterSheet.add(characterGenButton, BorderLayout.SOUTH);
	    
	    JButton summonGenButton = new JButton("Generate Summon Sheet");
	    SummonButtonHandler summonlistener = new SummonButtonHandler();
	    summonGenButton.addActionListener(summonlistener);

	    JPanel summonSheet = new JPanel();
	    summonSheet.setLayout(new BorderLayout());
	    summonSheet.add(summonGenButton, BorderLayout.SOUTH);
	      
	    tabbedPane = new JTabbedPane();
	    tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
	    tabbedPane.addTab("Monster", monsterSheet);
	    tabbedPane.addTab("Character", characterSheet);
	    tabbedPane.addTab("Summon", summonSheet);
	    
		JFrame frame = new JFrame("Dungeons & Dragons Sheet Generator");
		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);;
	    frame.setSize(500,800);
	    frame.setLocation(100,100);
	    frame.setVisible(true);
	    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

	}

}

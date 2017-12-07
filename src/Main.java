import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Main {
	
	public static JTabbedPane tabbedPane;
	   
	private static class MonsterButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			JLabel name = new JLabel("Monster Name");
			JLabel armorClass = new JLabel("Armor Class ");
			JLabel hitPoints = new JLabel("Hit Points ");
			JLabel speed = new JLabel("Speed ");
			
			JLabel strStat = new JLabel("STR");
			JLabel dexStat = new JLabel("DEX");
			JLabel conStat = new JLabel("CON");
			JLabel intStat = new JLabel("INT");
			JLabel wisStat = new JLabel("WIS");
			JLabel chaStat = new JLabel("CHA");
			
			JLabel savingThrows = new JLabel("Saving Throws");
			JLabel skills = new JLabel("Skills");
			JLabel dImmunities = new JLabel("Damage Immunities");
			JLabel cImmunities = new JLabel("Condition Immunities");
			JLabel senses = new JLabel("Senses");
			JLabel languages = new JLabel("Languages");
			JLabel challenge = new JLabel("Challenge");
			
		    JPanel monsterSheet = new JPanel();    
		    Dimension dimension = new Dimension(300, 300);
		    monsterSheet.setMaximumSize(dimension);
		    monsterSheet.setMinimumSize(dimension);
		    monsterSheet.setPreferredSize(dimension);
		    monsterSheet.setLayout(new GridBagLayout());
		    GridBagConstraints c = new GridBagConstraints();
		    c.fill = GridBagConstraints.HORIZONTAL;
		    c.gridx = 0;
		    c.gridy = 0;
		    c.ipady = 10;
	        c.ipadx = 10;
		    c.gridheight = 1;
		    c.gridwidth = 1;
		    
		    monsterSheet.add(name, c);
		    
		    c.gridy = 1;
		    monsterSheet.add(armorClass, c);
		    c.gridy = 2;
		    monsterSheet.add(hitPoints, c);
		    c.gridy = 3;
		    monsterSheet.add(speed, c);
		    
		    c.gridy = 4;
		    monsterSheet.add(strStat, c);
		    c.gridx = 1;
		    monsterSheet.add(dexStat, c);
		    c.gridx = 2;
		    monsterSheet.add(conStat, c);
		    c.gridx = 3;
		    monsterSheet.add(intStat, c);
		    c.gridx = 4;
		    monsterSheet.add(wisStat, c);
		    c.gridx = 5;
		    monsterSheet.add(chaStat, c);
		    
		    c.gridx = 0;
		    c.gridy = 6;
		    monsterSheet.add(savingThrows, c);
		    c.gridy = 7;
		    monsterSheet.add(skills, c);
		    c.gridy = 8;
		    monsterSheet.add(dImmunities, c);
		    c.gridy = 9;
		    monsterSheet.add(cImmunities, c);
		    c.gridy = 10;
		    monsterSheet.add(senses, c);
		    c.gridy = 11;
		    monsterSheet.add(languages, c);
		    c.gridy = 12;
		    monsterSheet.add(challenge, c);
		    
		    JScrollPane scrPane = new JScrollPane(monsterSheet);
		    
			tabbedPane.addTab("Monster Sheet", scrPane);
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

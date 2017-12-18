import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Main {
	
	public static JTabbedPane tabbedPane;
	   
	private static class MonsterButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			MonsterStats stats = new MonsterStats();
			int cr = -1;
			stats.generate(cr);
			
			JLabel name = new JLabel("<html><font size=6><b>" + stats.getName() + "</b></font></html>");
			JLabel description = new JLabel("<html><font size=2><i>" + stats.getSize() + " " + stats.getType() + ", " + stats.getAlignment() + "</i></font></html>");
			JLabel armorClass = new JLabel("<html><b>Armor Class: </b>" + Integer.toString(stats.getAc()) + "</html>");
			JLabel hitPoints = new JLabel("<html><b>Hit Points: </b>" + Integer.toString(stats.getHp()) + "</html>");
			JLabel speed = new JLabel("<html><b>Speed: </b>" + Integer.toString(stats.getSpeed()) + "</html>");
			
			JLabel strStat = new JLabel("<html><b>STR</b></html>", SwingConstants.CENTER);
			JLabel dexStat = new JLabel("<html><b>DEX</b></html>", SwingConstants.CENTER);
			JLabel conStat = new JLabel("<html><b>CON</b></html>", SwingConstants.CENTER);
			JLabel intStat = new JLabel("<html><b>INT</b></html>", SwingConstants.CENTER);
			JLabel wisStat = new JLabel("<html><b>WIS</b></html>", SwingConstants.CENTER);
			JLabel chaStat = new JLabel("<html><b>CHA</b></html>", SwingConstants.CENTER);
			
			JLabel strStatV = new JLabel(stats.getStr() + " (" + (stats.getStrM()<0?"":"+") + stats.getStrM() + ")", SwingConstants.CENTER);
			JLabel dexStatV = new JLabel(stats.getDex() + " (" + (stats.getDexM()<0?"":"+") + stats.getDexM() + ")", SwingConstants.CENTER);
			JLabel conStatV = new JLabel(stats.getCon() + " (" + (stats.getConM()<0?"":"+") + stats.getConM() + ")", SwingConstants.CENTER);
			JLabel intStatV = new JLabel(stats.getIntel() + " (" + (stats.getIntelM()<0?"":"+") + stats.getIntelM() + ")", SwingConstants.CENTER);
			JLabel wisStatV = new JLabel(stats.getWis() + " (" + (stats.getWisM()<0?"":"+") + stats.getWisM() + ")", SwingConstants.CENTER);
			JLabel chaStatV = new JLabel(stats.getCha() + " (" + (stats.getChaM()<0?"":"+") + stats.getChaM() + ")", SwingConstants.CENTER);
			
			JLabel savingThrows = new JLabel("<html><b>Saving Throws: </b>" + stats.getSavingThrows() + "</html>");
			JLabel skills = new JLabel("<html><b>Skills: </b>" + stats.getSkills() + "</html>");
			JLabel vulnerabilities = new JLabel("<html><b>Damage Vulnerabilities: </b>" + stats.getVulnerabilities() + "</html>");
			JLabel resistances = new JLabel("<html><b>Damage Resistances: </b>" + stats.getResistances() + "</html>");
			JLabel dImmunities = new JLabel("<html><b>Damage Immunities: </b>" + stats.getImmunites() + "</html>");
			JLabel cImmunities = new JLabel("<html><b>Condition Immunities: </b>" + stats.getCondition() + "</html>");
			JLabel senses = new JLabel("<html><b>Senses: </b>" + stats.getSenses() + "</html>");
			JLabel languages = new JLabel("<html><b>Languages: </b>" + (stats.getLanguages()==""?"--":stats.getLanguages()) + "</html>");
			JLabel challenge = new JLabel("<html><b>Challenge: </b>" + "</html>");
			
			JLabel passiveAbilities = new JLabel("<html>" + stats.getPassiveAbilities() + "</html>");
			
			JLabel action = new JLabel("<html><font size=5><b>Action</b></font></html>");
			
			JLabel activeAbilities = new JLabel("<html>" + stats.getActiveAbilites() + "</html>");
			
			JPanel monsterSheet = new JPanel();    
		    Dimension dimension = new Dimension(500, 700);
		    monsterSheet.setMaximumSize(dimension);
		    monsterSheet.setMinimumSize(dimension);
		    monsterSheet.setPreferredSize(dimension);
		    monsterSheet.setLayout(new GridBagLayout());
		    
		    JButton save = new JButton("Save");
			save.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent s){
					Dimension size = monsterSheet.getSize();
					BufferedImage image = (BufferedImage)monsterSheet.createImage(size.width, size.height);
					Graphics g = image.getGraphics();
				    monsterSheet.paint(g);
				    g.dispose();
					String monsterName = "Test";
					String fileName = monsterName + ".png";
					try{
						ImageIO.write(image, "png", new File(fileName));
				    }
				    catch (IOException error){
				    	error.printStackTrace();
				    }
				}
			});
		    
		    GridBagConstraints c = new GridBagConstraints();
		    c.fill = GridBagConstraints.BOTH;
		    c.gridx = 0;
		    c.gridy = 0;
		    c.ipady = 10;
	        c.ipadx = 25;
		    c.gridheight = 1;
		    c.gridwidth = 6;
		    
		    monsterSheet.add(name, c);
		    c.gridy = 1;
		    monsterSheet.add(description, c);
		    
		    c.gridy = 2;
		    monsterSheet.add(new JSeparator(JSeparator.HORIZONTAL), c);
		    
		    c.gridy = 3;
		    monsterSheet.add(armorClass, c);
		    c.gridy = 4;
		    monsterSheet.add(hitPoints, c);
		    c.gridy = 5;
		    monsterSheet.add(speed, c);
		    
		    c.gridy = 6;
		    monsterSheet.add(new JSeparator(JSeparator.HORIZONTAL), c);
		    
		    c.gridy = 7;
		    c.gridwidth = 1;
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
		    
		    c.gridy = 8;
		    c.gridx = 0;
		    c.gridwidth = 1;
		    monsterSheet.add(strStatV, c);
		    c.gridx = 1;
		    monsterSheet.add(dexStatV, c);
		    c.gridx = 2;
		    monsterSheet.add(conStatV, c);
		    c.gridx = 3;
		    monsterSheet.add(intStatV, c);
		    c.gridx = 4;
		    monsterSheet.add(wisStatV, c);
		    c.gridx = 5;
		    monsterSheet.add(chaStatV, c);
		    
		    c.gridx = 0;
		    c.gridy = 9;
		    c.gridwidth = 6;
		    monsterSheet.add(new JSeparator(JSeparator.HORIZONTAL), c);
		    
		    c.gridy = 10;
		    if (stats.getSavingThrows() != "")
		    		monsterSheet.add(savingThrows, c);
		    c.gridy = 11;
		    if (stats.getSkills() != "")
		    		monsterSheet.add(skills, c);
		    c.gridy = 12;
		    if (stats.getVulnerabilities() != "")
		    		monsterSheet.add(vulnerabilities, c);
		    c.gridy = 13;
		    if (stats.getResistances() != "")
		    		monsterSheet.add(resistances, c);
		    c.gridy = 14;
		    if (stats.getImmunites() != "")
		    		monsterSheet.add(dImmunities, c);
		    c.gridy = 15;
		    if (stats.getCondition() != "")
		    		monsterSheet.add(cImmunities, c);
		    c.gridy = 16;
		    if (stats.getSenses() != "")
		    		monsterSheet.add(senses, c);
		    c.gridy = 17;
		    monsterSheet.add(languages, c);
		    c.gridy = 18;
		    monsterSheet.add(challenge, c);
		    
		    c.gridy = 19;
		    monsterSheet.add(new JSeparator(JSeparator.HORIZONTAL), c);
		    
		    c.gridy = 20;
		    monsterSheet.add(passiveAbilities, c);
		    
		    c.gridy = 21;
		    monsterSheet.add(action, c);
		    
		    c.gridy = 22;
		    monsterSheet.add(activeAbilities, c);
		    
		    c.gridy = 23;
		    monsterSheet.add(new JSeparator(JSeparator.HORIZONTAL), c);
		    
		    c.gridy = 24;
		    c.gridx = 5;
		    c.gridwidth = 1;
		    monsterSheet.add(save, c);
		    
		    JPanel scrollPaneContainer = new JPanel( new BorderLayout() );
		    scrollPaneContainer.add(monsterSheet, BorderLayout.PAGE_START);
		    JScrollPane scrPane = new JScrollPane(scrollPaneContainer);
		    
			tabbedPane.addTab("Monster Sheet", scrPane);
			tabbedPane.setSelectedIndex(tabbedPane.getTabCount() - 1);
		}
	}
	   
	private static class CharacterButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			characterSheet chara = new characterSheet();
			chara.character();
			
			//JLabel name = new JLabel("<html><font size=6><b>Character Name</b></font></html>");
			JLabel name = new JLabel("<html><font size=6><b>"+chara.getName()+"</b></font></html>");
			JLabel back = new JLabel("<html><b>A <b>"+chara.getTrait()+"<b> <b>"+chara.getRace()+"<b> <b>"+
					chara.getClas()+"<b> from <b>"+chara.getLoc()+"<html>");
			JLabel ac = new JLabel("<html><b>Armor Class </b>" + Integer.toString(chara.getAc()) + 
					"</html>");
			JLabel hp = new JLabel("<html><b>Hit Points </b>" + Integer.toString(chara.getHp()) + 
					"</html>");
			JLabel strStat = new JLabel("<html><b>STR</b></html>", SwingConstants.CENTER);
			JLabel dexStat = new JLabel("<html><b>DEX</b></html>", SwingConstants.CENTER);
			JLabel conStat = new JLabel("<html><b>CON</b></html>", SwingConstants.CENTER);
			JLabel intStat = new JLabel("<html><b>INT</b></html>", SwingConstants.CENTER);
			JLabel wisStat = new JLabel("<html><b>WIS</b></html>", SwingConstants.CENTER);
			JLabel chaStat = new JLabel("<html><b>CHA</b></html>", SwingConstants.CENTER);
			
			JLabel strStatV = new JLabel(chara.getStr() + " (" + (chara.getStrM()<0?"":"+") + chara.getStrM() + 
					")", SwingConstants.CENTER);
			JLabel dexStatV = new JLabel(chara.getDex() + " (" + (chara.getDexM()<0?"":"+") + chara.getDexM() + 
					")", SwingConstants.CENTER);
			JLabel conStatV = new JLabel(chara.getCon() + " (" + (chara.getConM()<0?"":"+") + chara.getConM() + 
					")", SwingConstants.CENTER);
			JLabel intStatV = new JLabel(chara.getIntel() + " (" + (chara.getIntelM()<0?"":"+") + chara.getIntelM() + 
					")", SwingConstants.CENTER);
			JLabel wisStatV = new JLabel(chara.getWis() + " (" + (chara.getWisM()<0?"":"+") + chara.getWisM() + 
					")", SwingConstants.CENTER);
			JLabel chaStatV = new JLabel(chara.getCha() + " (" + (chara.getChaM()<0?"":"+") + chara.getChaM() + 
					")", SwingConstants.CENTER);
			
			JLabel save = new JLabel("<html><b>Saving Throws: <b>"+chara.getSave()+"</html>");
			
			JPanel charSheet = new JPanel();    
		    Dimension dimension = new Dimension(300, 500);
		    charSheet.setMaximumSize(dimension);
		    charSheet.setMinimumSize(dimension);
		    charSheet.setPreferredSize(dimension);
		    charSheet.setLayout(new GridBagLayout());
		    GridBagConstraints c = new GridBagConstraints();
		    c.fill = GridBagConstraints.BOTH;
		    c.gridx = 0;
		    c.gridy = 0;
		    c.ipady = 10;
	        c.ipadx = 10;
		    c.gridheight = 1;
		    c.gridwidth = 6;
		    
		    charSheet.add(name, c);
		    c.gridy = 1;
		    charSheet.add(new JSeparator(JSeparator.HORIZONTAL), c);
		    c.gridy = 2;
		    charSheet.add(back, c);
		    c.gridy = 3;
		    charSheet.add(new JSeparator(JSeparator.HORIZONTAL), c);
		    c.gridy = 4;
		    charSheet.add(ac, c);
		    c.gridy = 5;
		    charSheet.add(hp, c);
		    c.gridy = 6;
		    charSheet.add(new JSeparator(JSeparator.HORIZONTAL), c);
		    
		    c.gridy = 7;
		    c.gridwidth = 1;
		    charSheet.add(strStat, c);
		    c.gridx = 1;
		    charSheet.add(dexStat, c);
		    c.gridx = 2;
		    charSheet.add(conStat, c);
		    c.gridx = 3;
		    charSheet.add(intStat, c);
		    c.gridx = 4;
		    charSheet.add(wisStat, c);
		    c.gridx = 5;
		    charSheet.add(chaStat, c);
		    
		    c.gridy = 8;
		    c.gridwidth = 1;
		    c.gridx = 0;
		    charSheet.add(strStatV, c);
		    c.gridx = 1;
		    charSheet.add(dexStatV, c);
		    c.gridx = 2;
		    charSheet.add(conStatV, c);
		    c.gridx = 3;
		    charSheet.add(intStatV, c);
		    c.gridx = 4;
		    charSheet.add(wisStatV, c);
		    c.gridx = 5;
		    charSheet.add(chaStatV, c);
		    c.gridy = 9;
		    c.gridx = 0;
		    c.gridwidth = 6;
		    charSheet.add(new JSeparator(JSeparator.HORIZONTAL), c);
		    
		    c.gridy = 10;
		    charSheet.add(save, c);
		    
		    
		    JScrollPane scrPane = new JScrollPane(charSheet);
		    
			tabbedPane.addTab("Character Sheet", scrPane);
			tabbedPane.setSelectedIndex(tabbedPane.getTabCount() - 1);
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
	      
	    tabbedPane = new JTabbedPane();
	    tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
	    tabbedPane.addTab("Monster", monsterSheet);
	    tabbedPane.addTab("Character", characterSheet);
	    
		JFrame frame = new JFrame("Dungeons & Dragons Sheet Generator");
		frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);;
	    frame.setSize(500,800);
	    frame.setLocation(100,100);
	    frame.setVisible(true);
	    frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}

}

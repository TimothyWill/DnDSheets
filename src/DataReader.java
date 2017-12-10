import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class DataReader {
	
	/**
	 * Constructor
	 */
	public DataReader() {}
	
	/**
	 * Returns a random line from the given file
	 * @param fr A string with the current file's path
	 * @return The randomly selected line in a String
	 */
	private String getRandomLine(String file) {
		Random r = new Random(System.currentTimeMillis());
		
		try(BufferedReader br = new BufferedReader(new FileReader(file))) {
		    ArrayList<String> lines = new ArrayList<String>();
		    String line = br.readLine();

		    while (line != null) {
		    	lines.add(line);
		        line = br.readLine();
		    }
		    
		    String randomString = lines.get(r.nextInt(lines.size()));
		    
		    return randomString;
		    
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return "Error: " + e;
		} catch (IOException e) {
			e.printStackTrace();
			return "Error: " + e;
		}
	}
	
	/**
	 * Returns a random alignment, read from the alignment text file
	 * @return The random alignment in a string
	 */
	public String getAlignment() {
		String randomAlignment = getRandomLine("./src/alignments.txt");
		return randomAlignment;
	}
	
	/**
	 * Returns a random conditional immunity, read from the conditional immunities text file
	 * @return The conditional immunity in a string
	 */
	public String getConditionalImmunity() {
		String randomConditionalImmunity = getRandomLine("./src/conditionalImmunities.txt");
		return randomConditionalImmunity;
	}
	
	/**
	 * Returns a random damage immunity, read from the damages text file
	 * @return The damage immunity in a string
	 */
	public String getDamage() {
		String randomDamage = getRandomLine("./src/damages.txt");
		return randomDamage;
	}
	
	/**
	 * Returns a random language, read from the languages text file
	 * @return The language in a string
	 */
	public String getLanguage() {
		String randomLanguage = getRandomLine("./src/languages.txt");
		return randomLanguage;
	}
	
	/**
	 * Returns a random monster type, read from the monster types text file
	 * @return The monster type in a string
	 */
	public String getMonsterType() {
		String randomType = getRandomLine("./src/monsterTypes.txt");
		return randomType;
	}
	
	/**
	 * Returns a random sense, read from the senses text file
	 * @return The sense in a string
	 */
	public String getSense() {
		String randomSense = getRandomLine("./src/senses.txt");
		return randomSense;
	}
	
	/**
	 * Returns a random size, read from the sizes text file
	 * @return The size in a string
	 */
	public String getSize() {
		String randomSize = getRandomLine("./src/size.txt");
		return randomSize;
	}
	
	/**
	 * Returns a random skill, read from the skills text file
	 * @return The skill in a string
	 */
	public String getSkill() {
		String randomSkill = getRandomLine("./src/skills.txt");
		return randomSkill;
	}
}

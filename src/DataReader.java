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
	 * @param file - A string with the current file's path
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
	 * Returns a list of conditional immunities, read from the conditional immunities text file
	 * @param numConImms - The number of conditional immunities to be returned
	 * @return An array of conditional immunities
	 */
	public String[] getConditionalImmunity(int numConImms) {
		// list
		ArrayList<String> conImms = new ArrayList<String>();
		
		// temps
		String currString;
		boolean duplicate = true;
		
		for (int i = 0; i < numConImms; i++) {
			do {
				currString = getRandomLine("./src/conditionalImmunities.txt");
				if (!conImms.contains(currString)) {
					conImms.add(currString);
					duplicate = false;
				} else {
					duplicate = true;
				}
			} while (duplicate);
		}
		
		// create return array
		String[] conImmsArr = conImms.toArray(new String[conImms.size()]);
		
		return conImmsArr;
	}
	
	/**
	 * Generates a list of damage vulnerabilites, resistances, and immunities and returns it
	 * @param numValues - An array of three values which correspond to how many of each damage
	 * 					item should be returned
	 * @return A 2D string array of the list of damage items
	 */
	public String[][] getDamage(int[] numValues) {
		int numVulnerabilities = numValues[0];
		int numResistances = numValues[1];
		int numImmunities = numValues[2];
		
		// lists
		ArrayList<String> vulns = new ArrayList<String>();
		ArrayList<String> resis = new ArrayList<String>();
		ArrayList<String> imms = new ArrayList<String>();
		
		// temps
		String currString = new String();
		boolean duplicate = true;
		
		// generate vulnerabilities
		for (int i = 0; i < numVulnerabilities; i++) {
			do {
				currString = getRandomLine("./src/damages.txt");
				if (!vulns.contains(currString)) {
					vulns.add(currString);
					duplicate = false;
				} else {
					duplicate = true;
				}
			} while (duplicate);
		}
		
		// generate resistances
		for (int i = 0; i < numResistances; i++) {
			do {
				currString = getRandomLine("./src/damages.txt");
				if (!resis.contains(currString) && !vulns.contains(currString)) {
					resis.add(currString);
					duplicate = false;
				} else {
					duplicate = true;
				}
			} while (duplicate);
		}
		
		// generate resistances
		for (int i = 0; i < numImmunities; i++) {
			do {
				currString = getRandomLine("./src/damages.txt");
				if (!imms.contains(currString) && !resis.contains(currString) && !vulns.contains(currString)) {
					imms.add(currString);
					duplicate = false;
				} else {
					duplicate = true;
				}
			} while (duplicate);
		}
		
		// create return array
		String[][] damages = {
				vulns.toArray(new String[vulns.size()]),
				resis.toArray(new String[resis.size()]),
				imms.toArray(new String[imms.size()])};
		
		return damages;
	}
	
	/**
	 * Returns a random list of languages, read from the languages text file
	 * @param numLangs - The number of languages to be returned
	 * @return An array of languages
	 */
	public String[] getLanguage(int numLangs) {
		// list
		ArrayList<String> langs = new ArrayList<String>();
		
		// temps
		String currString;
		boolean duplicate = true;
		
		for (int i = 0; i < numLangs; i++) {
			do {
				currString = getRandomLine("./src/languages.txt");
				if (!langs.contains(currString)) {
					langs.add(currString);
					duplicate = false;
				} else {
					duplicate = true;
				}
			} while (duplicate);
		}
		
		// create return array
		String[] langsArr = langs.toArray(new String[langs.size()]);
		
		return langsArr;
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
	 * Returns a list of random senses, read from the senses text file
	 * @param numSenses - The number of senses to be returned
	 * @return An array of senses
	 */
	public String[] getSense(int numSenses) {
		// list
		ArrayList<String> senses = new ArrayList<String>();
		
		// temps
		String currString;
		boolean duplicate = true;
		
		for (int i = 0; i < numSenses; i++) {
			do {
				currString = getRandomLine("./src/senses.txt");
				if (!senses.contains(currString)) {
					senses.add(currString);
					duplicate = false;
				} else {
					duplicate = true;
				}
			} while (duplicate);
		}
		
		// create return array
		String[] sensesArr = senses.toArray(new String[senses.size()]);
		
		return sensesArr;
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
	 * Returns a list of random skills, read from the skills text file
	 * @param numSkills - The number of skills to be returned
	 * @return An array of skills
	 */
	public String[] getSkill(int numSkills) {
		// list
		ArrayList<String> skills = new ArrayList<String>();
		
		// temps
		String currString;
		boolean duplicate = true;
		
		for (int i = 0; i < numSkills; i++) {
			do {
				currString = getRandomLine("./src/skills.txt");
				if (!skills.contains(currString)) {
					skills.add(currString);
					duplicate = false;
				} else {
					duplicate = true;
				}
			} while (duplicate);
		}
		
		// create return array
		String[] skillsArr = skills.toArray(new String[skills.size()]);
		
		return skillsArr;
	}
	
	/**
	 * Returns a list of random actions, read from the actions text file
	 * @param numActions - The number of actions to be returned
	 * @return An array of actions
	 */
	public String[] getActions(int numActions) {
		// list
		ArrayList<String> actions = new ArrayList<String>();
		
		// temps
		String currString;
		boolean duplicate = true;
		
		for (int i = 0; i < numActions; i++) {
			do {
				currString = getRandomLine("./src/actions.txt");
				if (!actions.contains(currString)) {
					actions.add(currString);
					duplicate = false;
				} else {
					duplicate = true;
				}
			} while (duplicate);
		}
		
		// create return array
		String[] actionsArr = actions.toArray(new String[actions.size()]);
		
		return actionsArr;
	}
	
	/**
	 * Returns random adjectives, concatenated to a single string
	 * @param numAdj - The number of adjectives to be generated (0, 1 or 2)
	 * @return The adjective(s) in a single string
	 */
	public String getAdjectives(int numAdj) {
		// list
		ArrayList<String> adjectives = new ArrayList<String>();
		
		// temps
		String currString;
		boolean duplicate = true;
		
		for (int i = 0; i < numAdj; i++) {
			do {
				currString = getRandomLine("./src/adjective.txt");
				if (!adjectives.contains(currString)) {
					adjectives.add(currString);
					duplicate = false;
				} else {
					duplicate = true;
				}
			} while (duplicate);
		}
		
		String adjectivesStr = "";
		
		// create return string
		for(String adjective:adjectives) {
			adjectivesStr += adjective + " ";
		}
		
		// get rid of trailing space
		adjectivesStr = adjectivesStr.substring(0, adjectivesStr.length()-1);
		
		return adjectivesStr;
	}
	
	/**
	 * Returns a random name, read from the name text file
	 * @return A random name
	 */
	public String getName() {
		String randomName = getRandomLine("./src/name.txt");
		return randomName;
	}
}

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DataReader {
	
	/**
	 * Temp main for testing this class
	 */
	/*public static void main(String[] args) {
		String test = getRandomSkills();
		System.out.println(test);
	}*/
	
	/**
	 * Returns a random passive ability, read from the abilities text file
	 * @return The passive ability in a string
	 */
	public static String getRandomSkills() {
		try(BufferedReader br = new BufferedReader(new FileReader("./src/senses.txt"))) {
		    StringBuilder sb = new StringBuilder();
		    String line = br.readLine();

		    while (line != null) {
		        sb.append(line);
		        sb.append(System.lineSeparator());
		        line = br.readLine();
		    }
		    String everything = sb.toString();
		    return everything;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Error: " + e;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Error: " + e;
		}
	}
}

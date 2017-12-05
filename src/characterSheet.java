import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class characterSheet {
	public void character() {
		/*************Name********************/
		String line = null;
		String file = "names.txt";
		try {
			FileInputStream fs= new FileInputStream(file);
			BufferedReader br = new BufferedReader(new InputStreamReader(fs));
			ArrayList<String> array = new ArrayList<>();
			while((line = br.readLine()) != null) {
				array.add(line);
			}
			// variable so that it is not re-seeded every call.
			Random rand = new Random();

			// nextInt is exclusive. 
			int randomIndex = rand.nextInt(array.size());

			// Print your random name... 
			System.out.print(array.get(randomIndex));
			br.close();
		}
		catch(FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" + 
                    file + "'");                
        }
		catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + file + "'");                  
        }
		System.out.print(" a ");
		/*************Traits********************/
		line = null;
		file = "traits.txt";
		try {
			FileInputStream fs= new FileInputStream(file);
			BufferedReader br = new BufferedReader(new InputStreamReader(fs));
			ArrayList<String> array = new ArrayList<>();
			while((line = br.readLine()) != null) {
				array.add(line);
			}
			// variable so that it is not re-seeded every call.
			Random rand = new Random();

			// nextInt is exclusive. 
			int randomIndex = rand.nextInt(array.size());

			// Print your random name... 
			System.out.print(array.get(randomIndex));
			br.close();
		}
		catch(FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" + 
                    file + "'");                
        }
		catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + file + "'");                  
        }
		System.out.print(" ");
		/****************Race*****************/
		line = null;
		file = "race.txt";
		try {
			FileInputStream fs= new FileInputStream(file);
			BufferedReader br = new BufferedReader(new InputStreamReader(fs));
			ArrayList<String> array = new ArrayList<>();
			while((line = br.readLine()) != null) {
				array.add(line);
			}
			// variable so that it is not re-seeded every call.
			Random rand = new Random();

			// nextInt is exclusive. 
			int randomIndex = rand.nextInt(array.size());

			// Print your random name... 
			System.out.print(array.get(randomIndex));
			br.close();
		}
		catch(FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" + 
                    file + "'");                
        }
		catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + file + "'");                  
        }
		System.out.print(" ");
		/***************Class***************/
		line = null;
		file = "class.txt";
		Random randd = new Random();
		int randomIn = randd.nextInt(12);
		int hitDice[] = new int[12];
		try {
			FileInputStream fs= new FileInputStream(file);
			BufferedReader br = new BufferedReader(new InputStreamReader(fs));
			ArrayList<String> array = new ArrayList<>();
			while((line = br.readLine()) != null) {
				array.add(line);
			}
			// Print your random class... 
			System.out.print(array.get(randomIn));
			br.close();
		}
		catch(FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" + 
                    file + "'");                
        }
		catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + file + "'");                  
        }
		try {
			FileInputStream fs= new FileInputStream(file);
			BufferedReader br = new BufferedReader(new InputStreamReader(fs));
			int i = 0;
			while((line = br.readLine()) != null) {
				int d = Integer.parseInt(line);
				hitDice[i]=d;
				i++;
			}
			
			br.close();
		}
		catch(FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" + 
                    file + "'");                
        }
		catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + file + "'");                  
        }
		int hit = hitDice[randomIn];
		System.out.print(" from ");
		/****************Location*****************/
		line = null;
		file = "place.txt";
		try {
			FileInputStream fs= new FileInputStream(file);
			BufferedReader br = new BufferedReader(new InputStreamReader(fs));
			ArrayList<String> array = new ArrayList<>();
			while((line = br.readLine()) != null) {
				array.add(line);
			}
			// variable so that it is not re-seeded every call.
			Random rand = new Random();

			// nextInt is exclusive. 
			int randomIndex = rand.nextInt(array.size());

			// Print your random name... 
			System.out.print(array.get(randomIndex));
			br.close();
		}
		catch(FileNotFoundException ex) {
            System.out.println(
                    "Unable to open file '" + 
                    file + "'");                
        }
		catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + file + "'");                  
        }
		System.out.print(" ");
		/***********Generates Abilities********/
		Generator gen1 = new Generator();
		int array[] = new int[6];
		array = gen1.generateAbilities(false);
		int mod[] = new int[6];
		for(int i=0; i<6; i++) {
			mod[i]=(array[i]-10)/2;
		}
		int hp = hit+mod[2];
		int ac = 10+mod[1];
	}
}

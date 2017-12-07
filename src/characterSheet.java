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
			System.out.print(array.get(randomIndex));//print to the jframe
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
		System.out.print(" a ");//print to the jframe
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

			// Print your random trait... 
			System.out.print(array.get(randomIndex));//print to the jframe
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
		System.out.print(" ");//print to the jframe
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

			// Print your random race... 
			System.out.print(array.get(randomIndex));//print to the jframe
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
		System.out.print(" ");//print to the jframe
		/***************Class***************/
		line = null;
		file = "class.txt";
		Random randd = new Random();
		//declared outside so it can use that same number as the hitDice
		//matches up the class with how much hp it should recieve
		int randomIn = randd.nextInt(12);
		//hitDice is an array that will be used to calculate hp
		int hitDice[] = new int[12];
		try {
			FileInputStream fs= new FileInputStream(file);
			BufferedReader br = new BufferedReader(new InputStreamReader(fs));
			ArrayList<String> array = new ArrayList<>();
			while((line = br.readLine()) != null) {
				array.add(line);
			}
			// Print your random class... 
			System.out.print(array.get(randomIn));//print to the jframe
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
		//hitDice file will match up with the class
		//determines hp of a character
		file = "hitDice";
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
		System.out.print(" from ");//print to the jframe
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

			// Print your random location... 
			System.out.println(array.get(randomIndex));//print to the jframe
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
		System.out.print(" ");//print to the jframe
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
		//Prints out the stats******Needs to be put in jframe
		System.out.println("Hp: "+hp+" Ac: "+ac);//print to the jframe
		for(int i=0; i<6; i++) {
			if(i==0)
				System.out.print("Strength: ");		/*					*/
			else if(i==1)							/*					*/
				System.out.print("Dexterity: ");	/*					*/
			else if(i==2)							/*		Print		*/
				System.out.print("Constitution: ");	/*		To			*/
			else if(i==3)							/*		The			*/
				System.out.print("Intelegence: ");	/*		jframe		*/
			else if(i==4)							/*					*/
				System.out.print("Wisdom: ");		/*					*/
			else if(i==5)							/*					*/
				System.out.print("Charisma: ");		/*					*/
			System.out.print(array[i]+" ("+mod[i]+")");//print to the jframe
		}
		
	}
}

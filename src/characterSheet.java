import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class characterSheet {
	private int str, dex, con, intel, wis, cha;
	private int strM, dexM, conM, intelM, wisM, chaM;
	private String name, trait, race, clas, loc;
	private int hp, ac;
	private String save;
	public int getStr() {
		return str;
	}
	public int getStrM() {
		return strM;
	}
	public int getDex() {
		return dex;
	}
	public int getDexM() {
		return dexM;
	}
	public int getCon() {
		return con;
	}
	public int getConM() {
		return conM;
	}
	public int getIntel() {
		return intel;
	}
	public int getIntelM() {
		return intelM;
	}
	public int getWis() {
		return wis;
	}
	public int getWisM() {
		return wisM;
	}
	public int getCha() {
		return cha;
	}
	public int getChaM() {
		return chaM;
	}
	public int getHp() {
		return hp;
	}
	public int getAc() {
		return ac;
	}
	public String getName() {
		return name;
	}
	public String getTrait() {
		return trait;
	}
	public String getRace() {
		return race;
	}
	public String getClas() {
		return clas;
	}
	public String getLoc() {
		return loc;
	}
	public String getSave() {
		return save;
	}
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

			// Set your random name...
			name = array.get(randomIndex);
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

			// set your random trait...
			trait = array.get(randomIndex);
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

			// set your random race...
			race = array.get(randomIndex);
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
		String cla[] = new String[12];
		Random randd = new Random();
		//declared outside so it can use that same number as the hitDice
		//matches up the class with how much hp it should recieve
		int randomIn = randd.nextInt(12);
		//hitDice is an array that will be used to calculate hp
		int hitDice[] = new int[12];
		try {
			FileInputStream fs= new FileInputStream(file);
			BufferedReader br = new BufferedReader(new InputStreamReader(fs));
			int i = 0;
			while((line = br.readLine()) != null) {
				cla[i] = line;
				i++;
			}
			// Print your random class... 
			
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
		clas = cla[randomIn];
		//hitDice file will match up with the class
		//determines hp of a character
		file = "hitDice.txt";
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
		String st[] = new String[12];
		file = "savingThrow.txt";
		try {
			FileInputStream fs= new FileInputStream(file);
			BufferedReader br = new BufferedReader(new InputStreamReader(fs));
			int i = 0;
			while((line = br.readLine()) != null) {
				st[i]=line;
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
		save = st[randomIn];
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
			loc = array.get(randomIndex);
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
		/***********Generates Abilities********/
		Generator gen1 = new Generator();
		int array[] = new int[6];
		array = gen1.generateAbilities(false);
		int mod[] = new int[6];
		for(int i=0; i<6; i++) {
			mod[i]=(array[i]-10)/2;
		}
		hp = hit+mod[2];
		ac = 10+mod[1];
		str = array[0];
		strM = mod[0];
		dex = array[1];
		dexM = mod[1];
		con = array[2];
		conM = mod[2];
		intel = array[3];
		intelM = mod[3];
		cha = array[4];
		chaM = mod[4];
		}
		//System.out.println("\nSaving Throw Proficiencies: "+st);//print to the jframe
	}


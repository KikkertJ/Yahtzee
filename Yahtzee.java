import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Yahtzee {
	public static void main(String[] args) {
		YahtzeeSpel Start = new YahtzeeSpel();

		Start.spelen();

	}

}

class YahtzeeSpel {
	final ArrayList<Dobbelsteen> Dobbelstenen = new ArrayList<Dobbelsteen>();
	int blokkeerarray[] = { 0, 0, 0, 0, 0 };
	Scanner scanner = new Scanner(System.in);
	boolean doorgaan = true;
	Worp worpwaarde = new Worp();
	Speler henk = new Speler();
	int uitslag [] = worpwaarde.uitslagworp;

	YahtzeeSpel() {

		for (int a = 0; a < 5; a++) {
			Dobbelstenen.add(a, new Dobbelsteen());
		}

	}

	public void spelen() {
		System.out.println("Wil je doorgaan, druk dan op 'Enter'. Om te stoppen druk je op 'q'");

		while (doorgaan) {
			String invoer = scanner.nextLine();
			switch (invoer) {

			case "q":
				doorgaan = false;
				System.out.println("Je hebt het spel gestopt");
				break;
			case "":
				doorgaan = true;
				System.out.println("Je gaat nog een keer gooien.");
				System.out.println("Je hebt nu de volgende stenen gegooid:");
				System.out.println("1 2 3 4 5 ");
				
				for (int a = 0; a < Dobbelstenen.size(); a++) {
					Dobbelsteen deHuidigeSteen = Dobbelstenen.get(a);
					if (blokkeerarray[a] == 0) {

						deHuidigeSteen.steen1 = deHuidigeSteen.werpen();
					}
					worpwaarde.uitslag(deHuidigeSteen.steen1);
					
				}
				henk.Geschiedenis(uitslag);
				System.out.println("");
				System.out.println("Welke stenen wil je vasthouden?");
				vasthouden();
				
				
				break;
			default:
				System.out.println(
						"Foute invoer, druk op de 'Enter' toets om te gooien. Druk op de 'q' toets om het spel te stoppen.");
			}
		}
	}

	void vasthouden() {
		Scanner invoer = new Scanner(System.in);
		int plaats;
		String plekken = invoer.next();
		System.out.println("Je wilt de volgende dobbelstenen vasthouden:" + plekken);
		
		for (int i = 0; i < plekken.length(); i++) {
			String positie = plekken.substring(i, i + 1);
			plaats = Integer.parseInt(positie) - 1;
			this.blokkeerarray[plaats] = 1;

		}
	}

}

class Dobbelsteen {
	int steen1;

	int werpen() {
		Random dobbelsteen = new Random();
		steen1 = 1 + dobbelsteen.nextInt(6);
		return steen1;
	}
}

class Worp {

	int uitslagworp [] = new int [5];
	void uitslag (int steenwaarde) {
		for (int i = 0 ; i < uitslagworp.length ; i++) {
			uitslagworp[i] =  steenwaarde; 
		}
		System.out.print(steenwaarde + " ");
	}
}

class Speler {
	ArrayList worpGeschiedenis = new ArrayList();
	
	void Geschiedenis (int worpuitslag[]){
		worpGeschiedenis.add(worpuitslag);
		for (int p = 0 ; p < worpGeschiedenis.size(); p++) {
		System.out.println(worpuitslag);
		}
	}
	
}

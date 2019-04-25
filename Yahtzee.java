import java.util.ArrayList;
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

	YahtzeeSpel() {

		for (int a = 0; a < 5; a++) {
			Dobbelstenen.add(a, new Dobbelsteen());
		}

	}

	public void spelen() {
		System.out.println("Wil je doorgaan, druk dan op 'Enter'. Om te stoppen druk je op 'q'");
		Scanner scanner = new Scanner(System.in);
		boolean doorgaan = true;
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
				// int a = 0;

				for (int a = 0; a < Dobbelstenen.size(); a++) {
					// System.out.println("in loop dobbelstenen!");
					// for (int a = 0; a < blokkeerarray.length; a++) {
					Dobbelsteen deHuidigeSteen = Dobbelstenen.get(a);
					if (blokkeerarray[a] == 0) {
						
						deHuidigeSteen.werpen();

					}
					System.out.println(deHuidigeSteen.steen1 + " ");
				}

				System.out.println("Welke stenen wil je vasthouden?");
				vasthouden();

				break;
			default:
				System.out.println(
						"Foute invoer, druk op de 'Enter' toets om te gooien. Druk op de 'q' toets om het spel te stoppen.");
			}
		}
	}

	int blokkeerarray[] = { 0, 0, 0, 0, 0 };

	void vasthouden() {
		// int blokkeerarray [] = {0,0,0,0,0};
		Scanner invoer = new Scanner(System.in);
		int plaats;
		// int blok = 1;
		String plekken = invoer.next();
		System.out.println("Je wilt de volgende dobbelstenen vasthouden:");
		for (int i = 0; i < plekken.length(); i++) {
			String positie = plekken.substring(i, i + 1);
			plaats = Integer.parseInt(positie) - 1;
			this.blokkeerarray[plaats] = 1;

		}

		// blokkeerarray.add(blok, plaats);
		// System.out.println(blokkeerarray);

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
	int uitslagworp []; 

}

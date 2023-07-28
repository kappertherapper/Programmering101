package Model;

import Controller.Controller;

public class TilstandeTest {

	public static void main(String[] args) {

		KontoType kontotype = Controller
				.createKontoType(
						"Ungdomskonto",
						"En kontotype til unge under 25, som for at beskytte du unge ikke tillader at der hæves på en konto med saldo under 0");

		Konto k1 = Controller.createKonto(kontotype);
		k1.closeKonto();


		// Controller.foretagTransaktion(k1, 100);


	}
}

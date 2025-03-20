package frontiere;

import controleur.ControlAcheterProduit;
import personnages.Gaulois;
import villagegaulois.Etal;
import java.util.Scanner;

public class BoundaryAcheterProduit {
	private ControlAcheterProduit controlAcheterProduit;
	private Scanner scanner = new Scanner(System.in);

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
	    System.out.print("Quel produit voulez-vous acheter ? ");
	    String produit = scanner.nextLine();
	    Gaulois[] vendeurs = controlAcheterProduit.getVendeursProduit(produit);

	    if (vendeurs == null || vendeurs.length == 0) {
	        System.out.println("Désolé, personne ne vend ce produit au marché.");
	        return;
	    }
	    System.out.println("Vendeurs disponibles pour " + produit + " :");
	    for (int i = 0; i < vendeurs.length; i++) {
	        System.out.println((i + 1) + " - " + vendeurs[i].getNom());
	    }
	    System.out.print("Entrez le numéro du vendeur choisi : ");
	    int choixVendeur = scanner.nextInt();
	    scanner.nextLine();

	    if (choixVendeur < 1 || choixVendeur > vendeurs.length) {
	        System.out.println("Choix invalide.");
	        return;
	    }

	    String nomVendeur = vendeurs[choixVendeur - 1].getNom();
	    Etal etalVendeur = controlAcheterProduit.trouverEtalVendeur(nomVendeur);
	    if (etalVendeur == null || !etalVendeur.getProduit().equalsIgnoreCase(produit) || etalVendeur.getQuantite() == 0) {
	        System.out.println("Désolé, ce commerçant ne vend pas de " + produit + ".");
	        return;
	    }
	    System.out.print("Combien de " + produit + " voulez-vous acheter ? ");
	    int quantite = scanner.nextInt();
	    scanner.nextLine();
	    String resultat = controlAcheterProduit.acheterProduit(nomAcheteur, nomVendeur, quantite);
	    System.out.println(resultat);
	}

}


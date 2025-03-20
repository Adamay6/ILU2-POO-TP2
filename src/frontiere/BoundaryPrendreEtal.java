package frontiere;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;
	
	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		if (!controlPrendreEtal.verifierIdentite(nomVendeur)) {
			System.out.println("je suis desolé "+nomVendeur+" mais il faut etre un habitant de notre village pour commercer ici");
		}else {
			System.out.println("Bonjour "+nomVendeur+" , je vais regarder si je peux vous trouver un etal.");
			if (!controlPrendreEtal.resteEtals()) {
				System.out.println("Désolé "+ nomVendeur+" je n'ai plus d'étal qui ne soit pas déja occupé.");
			}else {
				installerVendeur(nomVendeur);
				
			}
		}
	}

	private void installerVendeur(String nomVendeur) {
		System.out.println("C'est parfait , il me reste un étal pour vous !");
		System.out.println("il me faut bquelque renseignements:");
		String produit = Clavier.entrerChaine("Quel produit souhaitez vous vendre");
		int nbProduit = Clavier.entrerEntier("Combien souhaitez vous vendre");
		int numeroEtal=controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit);
		if (numeroEtal!=-1) {
			int numero = numeroEtal+1;
			System.out.println("Le vendeur "+nomVendeur+" s'est installé a l'etal n°"+numero);
		}
	}
}

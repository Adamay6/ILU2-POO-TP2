package controleur;

import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;
	
	public Gaulois[] getVendeursProduit(String produit) {
	    return village.rechercherVendeursProduit(produit);
	}

	
	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur,
			Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	public Boolean verifierIdentiteAcheteur(String nomAcheteur) {
		return controlVerifierIdentite.verifierIdentite(nomAcheteur);
	}
	public Boolean isVendeur(String nomVendeur) {
		return controlVerifierIdentite.verifierIdentite(nomVendeur);
	}
	public Etal trouverEtalVendeur(String nomVendeur) {
		return controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
	}
	
	public int acheterProduit(String nomVendeur, int quantite) {
		if (!isVendeur(nomVendeur)) {
			return -1;
		}
		Etal etal = trouverEtalVendeur(nomVendeur);
		if (etal == null) {
			return -2;
		}
		

		return etal.acheterProduit(quantite);
	}
}


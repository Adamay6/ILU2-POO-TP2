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

	public Boolean isVendeur(String nomVendeur) {
		return controlVerifierIdentite.verifierIdentite(nomVendeur);
	}
	public Etal trouverEtalVendeur(String nomVendeur) {
		return controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
	}
	
	public String acheterProduit(String nomAcheteur, String nomVendeur, int quantite) {
		if (!controlVerifierIdentite.verifierIdentite(nomAcheteur)) {
			return "Je suis désolé " + nomAcheteur + ", mais il faut être un habitant du village pour commercer ici.";
		}
		if (!controlVerifierIdentite.verifierIdentite(nomVendeur)) {
			return "Je suis désolé " + nomVendeur + ", mais il faut être un habitant du village pour commercer ici.";
		}
		Etal etal = controlTrouverEtalVendeur.trouverEtalVendeur(nomVendeur);
		if (etal == null) {
			return "Désolé, " + nomVendeur + " ne vend rien sur le marché.";
		}
		int quantiteAchetee = etal.acheterProduit(quantite);
		
		if (quantiteAchetee == 0) {
			return nomAcheteur + " veut acheter " + quantite + " " + etal.getProduit() + 
			       ", malheureusement il n'y en a plus !";
		} else if (quantiteAchetee < quantite) {
			return nomAcheteur + " veut acheter " + quantite + " " + etal.getProduit() + 
			       ", mais il n'en reste que " + quantiteAchetee + ". " + 
			       nomAcheteur + " achète tout le stock de " + nomVendeur + ".";
		} else {
			return nomAcheteur + " achète " + quantite + " " + etal.getProduit() + " à " + nomVendeur + ".";
		}
	}
}


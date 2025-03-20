package frontiere;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		Boolean etalLibre = controlLibererEtal.isVendeur(nomVendeur);
		if(Boolean.FALSE.equals(etalLibre)) {
			System.out.println("Mais vous n'etes pas inscrit sur note marche aujourd'hui! \n");
		}else {
			String[] donneEtal = controlLibererEtal.libererEtal(nomVendeur);
			if(donneEtal[0]!=null) {
				System.out.println("Vous avez vendu "+ donneEtal[4]+" sur "+ donneEtal[3]+ " "+
						donneEtal[2] +"\nEn revoir "+donneEtal[1]+" ,passez une bonne journee \n");
			}
			
		}
	}

}

/*
 * Créé le 3 mars 2015
 *
 * TODO Pour changer le modèle de ce fichier généré, allez à :
 * Fenêtre - Préférences - Java - Style de code - Modèles de code
 */
package gsb.tests;

import gsb.modele.Medecin;
import gsb.modele.dao.MedecinDao;



/**
 * @author Isabelle
 * 3 mars 2015
 * TODO Pour changer le modèle de ce commentaire de type généré, allez à :
 * Fenêtre - Préférences - Java - Style de code - Modèles de code
 */
public class MedecinDaoTestRetournerDictionnaire {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Medecin unMed =MedecinDao.rechercher("m001");
		System.out.println(unMed.getLaLocalite().getVille());
	}

}
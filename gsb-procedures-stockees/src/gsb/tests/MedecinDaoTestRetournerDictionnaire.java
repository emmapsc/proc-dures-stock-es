/*
 * Cr�� le 3 mars 2015
 *
 * TODO Pour changer le mod�le de ce fichier g�n�r�, allez � :
 * Fen�tre - Pr�f�rences - Java - Style de code - Mod�les de code
 */
package gsb.tests;

import gsb.modele.Medecin;
import gsb.modele.dao.MedecinDao;



/**
 * @author Isabelle
 * 3 mars 2015
 * TODO Pour changer le mod�le de ce commentaire de type g�n�r�, allez � :
 * Fen�tre - Pr�f�rences - Java - Style de code - Mod�les de code
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
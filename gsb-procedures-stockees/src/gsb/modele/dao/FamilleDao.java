package gsb.modele.dao;

import java.sql.ResultSet;

import gsb.modele.Famille;

public class FamilleDao {
	
	public static Famille rechercher(String codeFamille){
		Famille uneFamille= null;
		ResultSet reqSelection = ConnexionMySql.execReqSelection("select * from FAMILLE where CODEFAM ='"+codeFamille+"'");
		try {
			if (reqSelection.next()) {
				uneFamille = new Famille(reqSelection.getString(1), reqSelection.getString(2));
			}
		}
			catch(Exception e) {
				System.out.println("erreur reqSelection.next() pour la requête - select * from MEDICAMENT where CODEFAM ='"+codeFamille+"'");
				e.printStackTrace();
				}
			ConnexionMySql.fermerConnexionBd();
			return uneFamille;
		}

}
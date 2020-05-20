package gsb.modele.dao;

import java.sql.ResultSet;

import gsb.modele.Unite;

public class UniteDao {

	public static Unite rechercher(String CodeUnite) {
		
				Unite uneUnite= null;
				ResultSet reqSelection = ConnexionMySql.execReqSelection("select * from UNITE where CODEUNITE ='"+CodeUnite+"'");
				try {
					if (reqSelection.next()) {
						uneUnite = new Unite(reqSelection.getString(1),reqSelection.getString(2));
					};
					}
				catch(Exception e) {
					System.out.println("erreur reqSelection.next() pour la requête - select * from CODEUNITE where CODEUNITE ='"+CodeUnite+"'");
					e.printStackTrace();
					}
				ConnexionMySql.fermerConnexionBd();
				return uneUnite;
			}
	
	public static int creer(Unite uneUnite) {
		String reqInsert;
		String code=uneUnite.getCodeUnite();
		String nom=uneUnite.getNom();
		
		reqInsert="Insert into UNITE values('"+code+"','"+nom+"')";
		
		int result =ConnexionMySql.execReqMaj(reqInsert);
		ConnexionMySql.fermerConnexionBd();
		return result;
	}
	
}
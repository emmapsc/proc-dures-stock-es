package gsb.modele.dao;

import java.sql.ResultSet;

import gsb.modele.*;

public class VisiteDao {

	public static Visite rechercher(String Matricule) {
		
		Visite uneVisite=null;
		Medecin unMedecin =null;
		Visiteur unVisiteur=null;
		
		ResultSet reqSelection = ConnexionMySql.execReqSelection("select * from VISITE where MATRICULE ='"+Matricule+"'");
		try {
			if (reqSelection.next()) {
				// public Visite(String reference1,String date2,String commentaire3,Medecin4 unMedecin,Visiteur5 unVisiteur) 
				unMedecin = MedecinDao.rechercher(reqSelection.getString(4));
				unVisiteur =VisiteurDao.rechercher(reqSelection.getString(5));
				uneVisite = new Visite(reqSelection.getString(1),reqSelection.getString(2),reqSelection.getString(3),unMedecin,unVisiteur);
			};
			}
		catch(Exception e) {
			System.out.println("erreur reqSelection.next() pour la requête - select * from VISITE where MATRICULE ='"+Matricule+"'");
			e.printStackTrace();
			}
		ConnexionMySql.fermerConnexionBd();
		return uneVisite;
	}
	
	public static int creer(Visite uneVisite) {

		String reqInsert;
		String reference=uneVisite.getReference();
		String date=uneVisite.getDate();
		String commentaire=uneVisite.getCommentaire();
		String codeMed= uneVisite.getUnMedecin().getCodeMed();
		String matricule =uneVisite.getUnVisiteur().getMatricule();
		
		reqInsert="Insert into VISITE values('"+reference+"','"+date+"','"+commentaire+"','"+codeMed+"','"+matricule+"')";
		
		int result =ConnexionMySql.execReqMaj(reqInsert);
		ConnexionMySql.fermerConnexionBd();
		return result;
	}
	
	public static int supprimer(String reference){
		String requeteSuppression = "delete from VISITE where REFERENCE='"+reference+"'";
		int result = ConnexionMySql.execReqMaj(requeteSuppression);
		ConnexionMySql.fermerConnexionBd();
		return result;	
	}
}
/*
 * Cr�� le 22 f�vr. 2015
 *
 * TODO Pour changer le mod�le de ce fichier g�n�r�, allez � :
 * Fen�tre - Pr�f�rences - Java - Style de code - Mod�les de code
 */
package gsb.modele.dao;

import gsb.modele.Localite;
import gsb.modele.Medecin;
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;



/**
 * @author Isabelle
 * 22 f�vr. 2015
 * TODO Pour changer le mod�le de ce commentaire de type g�n�r�, allez � :
 * Fen�tre - Pr�f�rences - Java - Style de code - Mod�les de code
 */
public class MedecinDao {
	
	public static Medecin rechercher(String codeMedecin){
		Medecin unMedecin=null;
		Localite uneLocalite= null;
		ResultSet reqSelection = ConnexionMySql.execReqSelection("select * from MEDECIN where CODEMED ='"+codeMedecin+"'");
		try {
			if (reqSelection.next()) {
				uneLocalite = LocaliteDao.rechercher(reqSelection.getString(5));
				unMedecin = new Medecin(reqSelection.getString(1), reqSelection.getString(2), reqSelection.getString(3), reqSelection.getString(4), reqSelection.getString(6), reqSelection.getString(7), reqSelection.getString(8),uneLocalite );	
			};
			}
		catch(Exception e) {
			System.out.println("erreur reqSelection.next() pour la requ�te - select * from MEDECIN where CODEMED ='"+codeMedecin+"'");
			e.printStackTrace();
			}
		ConnexionMySql.fermerConnexionBd();
		return unMedecin;
	}
	
	public static ArrayList<Medecin> retournerCollectionDesMedecins(){
		ArrayList<Medecin> collectionDesMedecins = new ArrayList<Medecin>();
		ResultSet reqSelection = ConnexionMySql.execReqSelection("select CODEMED from MEDECIN");
		try{
		while (reqSelection.next()) {
			String codeMed = reqSelection.getString(1);
		    collectionDesMedecins.add(MedecinDao.rechercher(codeMed));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("erreur retournerCollectionDesMedecins()");
		}
		return collectionDesMedecins;
	}
	
	public static HashMap<String,Medecin> retournerDictionnaireDesMedecins(){
		HashMap<String, Medecin> diccoDesMedecins = new HashMap<String, Medecin>();
		ResultSet reqSelection = ConnexionMySql.execReqSelection("select CODEMED from MEDECIN");
		try{
		while (reqSelection.next()) {
			String codeMed = reqSelection.getString(1);
		    diccoDesMedecins.put(codeMed, MedecinDao.rechercher(codeMed));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
			System.out.println("erreur retournerDiccoDesMedecins()");
		}
		return diccoDesMedecins;
	}
	
	
	public static ArrayList<Medecin> retournerMedecinVisiteDepuis(int nombreDeMois){
		ConnexionMySql.connecterBd();
		ArrayList<Medecin> medecins = new ArrayList<>();
		
		String call = "{call PACKAGE_REGLE_GESTION_UNE.GET_MEDECIN_VISITE(?, ?)}";
		OracleCallableStatement callable;
		try {
			callable = (OracleCallableStatement) ConnexionMySql.cnx.prepareCall(call);

			/* On d�fini le premier param�tre d'entr�e au nombre de mois */
			callable.setInt(1, nombreDeMois);
			
			/* On pr�vient le driver jdbc qu'il va falloir
			 * r�cup�rer un param�tre de sortie (le deuxi�me) de type REF_CURSOR */
			callable.registerOutParameter(2, OracleTypes.CURSOR);
			
			/* Ex�cution de la proc�dure */
			callable.execute();
			
			/* R�cup�ration des valeurs des param�tres de sorties */
			ResultSet resultSet = callable.getCursor(2);
			
			while(resultSet.next()) {
				String codeMed = resultSet.getString(1);
				String dateDerniereVisite = resultSet.getString(2);
				System.out.println(codeMed+"  "+dateDerniereVisite); 
				Medecin medecin = MedecinDao.rechercher(codeMed);
				medecin.setDateDerniereVisite(dateDerniereVisite);
			    medecins.add(medecin);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return medecins;
	}

}
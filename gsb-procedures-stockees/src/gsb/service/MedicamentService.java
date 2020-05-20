package gsb.service;

import gsb.modele.Medicament;
import gsb.modele.dao.ConnexionMySql;
import gsb.modele.dao.MedicamentDao;
import gsb.modele.dao.VisiteurDao;

public class MedicamentService {
	
	/**
	 * Fonction de recherche d'un médicament
	 * @param depotLegal Dépot légal du médicament
	 * @return Renvoie le médicament recherché s'il existe en base, sinon null
	 */
	public static Medicament rechercherMedicament(String depotLegal) {
		Medicament unMedicament = null;
		try{
		if (depotLegal==null) {
            throw new Exception("Donnée obligatoire : dépot légal");
        }
		unMedicament = MedicamentDao.rechercher(depotLegal);
		}
		catch(Exception e){
			System.out.println( e.getMessage());
		}
		return unMedicament;
	}
	
	public static boolean ajouterEchantillon(String depotLegal, String matricule, int qteStock) throws Exception{
		if (!MedicamentDao.retournerDictionnaireDesMedicaments().containsKey(depotLegal))
			throw new Exception("Le dépôt légal n'existe pas");

		if (!VisiteurDao.retournerDictionnaireDesVisiteurs().containsKey(matricule))
			throw new Exception("Le matricule n'existe pas");

		String requeteInsertion = "insert into STOCKER values('" + depotLegal + "','"+ matricule +"','" + qteStock + "')";
		if (ConnexionMySql.execReqMaj(requeteInsertion) == 0){
			String requeteUpdate = "update STOCKER set QTESTOCK = QTESTOCK +"+qteStock + " WHERE MATRICULE ='" +matricule +"' AND DEPOTLEGAL = '" +depotLegal+"'";
			return  ConnexionMySql.execReqMaj(requeteUpdate) > 0;
 }
		else
			return true;
	}
}
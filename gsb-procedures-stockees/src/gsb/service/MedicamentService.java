package gsb.service;

import gsb.modele.Medicament;
import gsb.modele.dao.ConnexionMySql;
import gsb.modele.dao.MedicamentDao;
import gsb.modele.dao.VisiteurDao;

public class MedicamentService {
	
	/**
	 * Fonction de recherche d'un m�dicament
	 * @param depotLegal D�pot l�gal du m�dicament
	 * @return Renvoie le m�dicament recherch� s'il existe en base, sinon null
	 */
	public static Medicament rechercherMedicament(String depotLegal) {
		Medicament unMedicament = null;
		try{
		if (depotLegal==null) {
            throw new Exception("Donn�e obligatoire : d�pot l�gal");
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
			throw new Exception("Le d�p�t l�gal n'existe pas");

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
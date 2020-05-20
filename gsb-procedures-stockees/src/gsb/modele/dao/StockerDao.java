package gsb.modele.dao;
import gsb.modele.Stock;

public class StockerDao {
	
	public static int ajouter(Stock unStock){
		int result = 0;
		String unVisiteur = unStock.getUnVisiteur().getMatricule();
		String unMedicament = unStock.getUnMedicament().getDepotLegal();
		int qteStock = unStock.getQteStock();
		String requeteInsertion;
		requeteInsertion = "insert into STOCK values('"+ unMedicament + "','"+unVisiteur+"','"+qteStock+"')";
				
		try {
			result = ConnexionMySql.execReqMaj(requeteInsertion);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		ConnexionMySql.fermerConnexionBd();
		return result;
	}
	

}
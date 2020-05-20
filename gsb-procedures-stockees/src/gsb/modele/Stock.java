package gsb.modele;

public class Stock {
	protected Medicament unMedicament;
	protected Visiteur unVisiteur;
	protected int qteStock;
	public Stock(Medicament unMedicament, Visiteur unVisiteur, int qteStock) {
		super();
		this.unMedicament = unMedicament;
		this.unVisiteur = unVisiteur;
		this.qteStock = qteStock;
	}
	public Medicament getUnMedicament() {
		return unMedicament;
	}
	public void setUnMedicament(Medicament unMedicament) {
		this.unMedicament = unMedicament;
	}
	public Visiteur getUnVisiteur() {
		return unVisiteur;
	}
	public void setUnVisiteur(Visiteur unVisiteur) {
		this.unVisiteur = unVisiteur;
	}
	public int getQteStock() {
		return qteStock;
	}
	public void setQteStock(int qteStock) {
		this.qteStock = qteStock;
	}
	
	
}
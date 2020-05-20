package gsb.tests;

import gsb.modele.Medicament;
import gsb.service.MedicamentService;

public class MedicamentServiceTest {

	public static void main(String[] args) {
		Medicament unMedicament = MedicamentService.rechercherMedicament("ADIMOL9");
		System.out.println(unMedicament.getDepotLegal());
		System.out.println(unMedicament.getNomCommercial());
		System.out.println(unMedicament.getComposition());
		System.out.println(unMedicament.getEffets());
		System.out.println(unMedicament.getContreIndications());
		System.out.println(unMedicament.getPrixEchantillon());
		System.out.println(unMedicament.getUneFamille().getCodeFamille());
		System.out.println(unMedicament.getUneFamille().getLibelleFamille());
		

	}

}
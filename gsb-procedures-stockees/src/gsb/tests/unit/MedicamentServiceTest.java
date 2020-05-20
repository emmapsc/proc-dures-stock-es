/**
 * 
 */
package gsb.tests.unit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import gsb.modele.Medicament;
import gsb.service.MedicamentService;
import junit.framework.TestCase;

/**
 * @author manou
 *
 */
class MedicamentServiceTest extends TestCase {
	/* (non-Javadoc)
	 * @see junit.framework.TestCase#setUp()
	 */
	@BeforeEach
	protected void setUp() throws Exception {
		super.setUp();		
	}

	/* (non-Javadoc)
	 * @see junit.framework.TestCase#tearDown()
	 */
	@AfterEach
	protected void tearDown() throws Exception {
		super.tearDown();
	}

	/**
	 * Test method for {@link gsb.service.MedicamentService#rechercherMedicament(java.lang.String)}.
	 */
	
	
	Medicament medicament = MedicamentService.rechercherMedicament("3MYC7");
	String depotLegal = "3MYC7";
	String nomCommercial = "TRIMYCINE";
	String composition = "Triamcinolone (ac�tonide) + N�omycine + Nystatine";
	String effets = "Ce m�dicament est un cortico�de �  activit� forte ou tr�s forte associ� �  un antibiotique et un antifongique, utilis� en application locale dans certaines atteintes cutan�es surinfect�es.";
	String contreIndications = "Ce m�dicament est contre-indiqu� en cas d'allergie �  l'un des constituants, d'infections de la peau ou de parasitisme non trait�s, d'acn�. Ne pas appliquer sur une plaie, ni sous un pansement occlusif.";
	String codeFamille = "CRT";
	
	@Test
	final void testRechercherMedicamentNull() {		
		assertNotNull(medicament);
	}
	
	@Test
	final void testRechercherMedicament() {
		assertEquals(depotLegal, medicament.getDepotLegal());
		
	}
	@Test
	final void testRechercherNomCommercial() {

		assertEquals(nomCommercial, medicament.getNomCommercial());
		
	}
	@Test
	final void testRechercherComposition() {
		
		assertEquals(composition, medicament.getComposition());
	}
	@Test
	final void testRechercherEffets() {

		assertEquals(effets, medicament.getEffets());
		
	}
	@Test
	final void testRechercherContreIndications() {

		assertEquals(contreIndications, medicament.getContreIndications());
	}
	@Test
	final void testRechercherPrixEchantillonNull() {

		assertNull(medicament.getPrixEchantillon());
		
	}
	@Test
	final void testRechercherUneFamilleNotNull() {

		assertNotNull(medicament.getUneFamille());
		
	}
	@Test
	final void testRechercherCodeFamille() {

		assertEquals(codeFamille, medicament.getUneFamille().getCodeFamille());
	}
}
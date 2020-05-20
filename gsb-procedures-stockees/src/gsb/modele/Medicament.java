package gsb.modele;

public class Medicament{

		protected String depotLegal ;
		protected String nomCommercial;
		protected String composition;
		protected String effets;
		protected String contreIndications;
		protected String prixEchantillon;
		protected Famille uneFamille;
		
		public Medicament(String depotLegal, String nomCommercial, String composition, String effets,
				String contreIndications, String prixEchantillon, Famille uneFamille) {
			super();
			this.depotLegal = depotLegal;
			this.nomCommercial = nomCommercial;
			this.composition = composition;
			this.effets = effets;
			this.contreIndications = contreIndications;
			this.prixEchantillon = prixEchantillon;
			this.uneFamille = uneFamille;
			
		}

		public String getDepotLegal() {
			return depotLegal;
		}

		public void setDepotLegal(String depotLegal) {
			this.depotLegal = depotLegal;
		}

		public String getNomCommercial() {
			return nomCommercial;
		}

		public void setNomCommercial(String nomCommercial) {
			this.nomCommercial = nomCommercial;
		}

		public String getComposition() {
			return composition;
		}

		public void setComposition(String composition) {
			this.composition = composition;
		}

		public String getEffets() {
			return effets;
		}

		public void setEffets(String effets) {
			this.effets = effets;
		}

		public String getContreIndications() {
			return contreIndications;
		}

		public void setContreIndications(String contreIndications) {
			this.contreIndications = contreIndications;
		}

		public String getPrixEchantillon() {
			return prixEchantillon;
		}

		public void setPrixEchantillon(String prixEchantillon) {
			this.prixEchantillon = prixEchantillon;
		}
		
		public Famille getUneFamille() {
			return uneFamille;
		}

		public void setUneFamille(Famille uneFamille) {
			this.uneFamille = uneFamille;
		}
		
		
	}
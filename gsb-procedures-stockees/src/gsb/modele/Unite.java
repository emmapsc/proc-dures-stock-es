package gsb.modele;

public class Unite {
	
	protected String CodeUnite;
	protected String Nom;
	
	public Unite(String CodeUnite, String Nom){
		this.CodeUnite=CodeUnite;
		this.Nom=Nom;
	}

	public String getCodeUnite() {
		return CodeUnite;
	}

	public void setCodeUnite(String codeUnite) {
		CodeUnite = codeUnite;
	}

	public String getNom() {
		return Nom;
	}

	public void setNom(String nom) {
		Nom = nom;
	}
}
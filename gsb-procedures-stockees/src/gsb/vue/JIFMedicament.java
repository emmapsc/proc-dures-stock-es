package gsb.vue;

import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import gsb.modele.Medicament;

public class JIFMedicament extends JInternalFrame{
	/**
	 * Commentaire pour <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = 1L;
	protected JPanel p;  
	protected JPanel pTexte;
	protected JPanel pBoutons;
	

	protected JLabel JLdepot;
	protected JLabel JLnom;
	protected JLabel JLcomposition;
	protected JLabel JLeffets;
	protected JLabel JLcontreInd;
	protected JLabel JLprixEchantillon;
	protected JLabel JLcodeFamille;
    
    
	protected JTextField JTdepot;
	protected JTextField JTnom;
	protected JTextField JTcomposition;
	protected JTextField JTeffets;
	protected JTextField JTcontreInd;
	protected JTextField JTprixEchantillon;
	protected JTextField JTcodeFamille;
    
	
    public JIFMedicament() {
    	p = new JPanel();  // panneau principal de la fenêtre
        pBoutons = new JPanel();    // panneau supportant les boutons
        pTexte = new JPanel(new GridLayout(9,2));
    	
    	 JLdepot = new JLabel("Depot Légal");
         JLnom = new JLabel("Nom Commercial");
         JLcomposition = new JLabel("Composition");
         JLeffets = new JLabel("Effets");
         JLcontreInd = new JLabel("Contre Indications");
         JLprixEchantillon = new JLabel("Prix Echantillon ");
         JLcodeFamille = new JLabel("Code Famille");

         
         
         JTdepot = new JTextField(20);
         JTdepot.setMaximumSize(JTdepot.getPreferredSize());
         JTnom = new JTextField(20);
         JTcomposition = new JTextField(20);
         JTeffets = new JTextField(20);    
         JTcontreInd = new JTextField(20);
         JTprixEchantillon = new JTextField(20);
         JTcodeFamille = new JTextField(20);

         
         
         
         pTexte.add(JLdepot);
         pTexte.add(JTdepot);
         pTexte.add(JLnom);
         pTexte.add(JTnom);
         pTexte.add(JLcomposition);
         pTexte.add(JTcomposition);
         pTexte.add(JLeffets);
         pTexte.add(JTeffets);
         pTexte.add(JLcontreInd);
         pTexte.add(JTcontreInd);
         pTexte.add(JLprixEchantillon);
         pTexte.add(JTprixEchantillon);
         pTexte.add(JLcodeFamille);
         pTexte.add(JTcodeFamille);
         
		
        // mise en forme de la fenêtre

         p.add(pTexte);
         p.add(pBoutons);
         Container contentPane = getContentPane();
         contentPane.add(p);

	}
    
    public void remplirText(Medicament unMedicament) 	
    {  // méthode qui permet de remplir les zones de texte à partir des valeurs passées en paramètres
        JTdepot.setText(unMedicament.getDepotLegal());        
        JTnom.setText(unMedicament.getNomCommercial());
        JTcomposition.setText(unMedicament.getComposition());
        JTeffets.setText(unMedicament.getEffets());    
        JTcontreInd.setText(unMedicament.getContreIndications());
        JTprixEchantillon.setText(unMedicament.getPrixEchantillon());
        JTcodeFamille.setText(unMedicament.getUneFamille().getCodeFamille());

    }

      public void viderText() 	
    {  // méthode qui permet de vider les zones de texte 
    	JTdepot.setText("");        
        JTnom.setText("");
        JTcomposition.setText("");
        JTeffets.setText("");    
        JTcontreInd.setText("");
        JTprixEchantillon.setText("");
        JTcodeFamille.setText("");
    
     }


    
}
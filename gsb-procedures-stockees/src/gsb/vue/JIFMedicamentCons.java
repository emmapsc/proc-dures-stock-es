package gsb.vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import gsb.modele.Medicament;
import gsb.modele.dao.MedicamentDao;
import javax.swing.JButton;

import java.util.ArrayList;

import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

public class JIFMedicamentCons  extends JIFMedicament  implements ActionListener {

		private static final long serialVersionUID = 1L;
		private JButton premier;
	    private JButton precedent; 
	    private JButton suivant;
	    private JButton dernier; 
	    private ArrayList<Medicament> lesMedicaments;
		private int indiceEnCours;
	        
	    public JIFMedicamentCons() {
	        super();
	        premier = new JButton("Premier");
	        pBoutons.add(premier);
	        precedent = new JButton("Precedent");
	        pBoutons.add(precedent);
	        suivant = new JButton("Suivant");
	        pBoutons.add(suivant);
	        dernier = new JButton("Dernier");
	        pBoutons.add(dernier);
	        // déclaration des sources d'évènements
	        premier.addActionListener(this);
	        precedent.addActionListener(this);
	        suivant.addActionListener(this);
	        dernier.addActionListener(this);
	        setDefaultCloseOperation(HIDE_ON_CLOSE);
	        setTitle("Consultation données Medicament");
	        
	        // récupération des données Medecin dans la collection
	        lesMedicaments = MedicamentDao.retournerCollectionDesMedicaments();
	        indiceEnCours = 0;
	        
	        if (lesMedicaments.size()!=0){ // si collection non vide, affichage des données du premier Medecin
	        	Medicament unMedicament = lesMedicaments.get(0);
		    	remplirText(unMedicament);
		    	}
	        
	        // ajout d'un écouteur d'évènement pour la fermeture de la fenêtre
	        addInternalFrameListener(new InternalFrameAdapter(){
	            public void  internalFrameClosing(InternalFrameEvent e) {
	                          //le code que tu veux exécuter à la fermeture de la JInternalFrame
	            }
	        });
	    }
		
	    public void actionPerformed(ActionEvent evt) { 
			Object source = evt.getSource();
	   		if (source == premier){
					indiceEnCours = 0;
					Medicament unMedicament = lesMedicaments.get(indiceEnCours);
			    	remplirText(unMedicament);				}
			 else if (source == dernier){
					indiceEnCours = lesMedicaments.size() - 1;
					Medicament unMedicament = lesMedicaments.get(indiceEnCours);
			    	remplirText(unMedicament);
					}
			 else if (source == precedent){
					if (indiceEnCours > 0) indiceEnCours = indiceEnCours - 1;
					Medicament unMedicament = lesMedicaments.get(indiceEnCours);
			    	remplirText(unMedicament);				}
			 else if (source == suivant){
					if (indiceEnCours < (lesMedicaments.size() - 1)) indiceEnCours = indiceEnCours + 1;
					Medicament unMedicament = lesMedicaments.get(indiceEnCours);
			    	remplirText(unMedicament);		    	}
	 } // fin actionPerformed

	}
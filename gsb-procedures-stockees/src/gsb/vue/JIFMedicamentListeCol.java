package gsb.vue;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import gsb.modele.Medicament;
import gsb.modele.dao.MedicamentDao;

public class JIFMedicamentListeCol extends JInternalFrame implements ActionListener {


	private static final long serialVersionUID = 1L;

	private ArrayList<Medicament> lesMedicaments;


	protected JPanel p;
	protected JScrollPane scrollPane;
	protected JPanel pSaisie;
	protected JTextField JTdepot;
	protected JButton JBafficherFiche;
	protected MenuPrincipal fenetreContainer;

	public JIFMedicamentListeCol(MenuPrincipal uneFenetreContainer) {
		fenetreContainer = uneFenetreContainer;
		// récupération des données Medecin dans la collection
		lesMedicaments = MedicamentDao.retournerCollectionDesMedicaments();

		int nbLignes = lesMedicaments.size();

		JTable table;
		
		this.setSize(620, 400);
		

		p = new JPanel(); // panneau principal de la fenêtre

		int i=0;
		String[][] data = new String[nbLignes][3] ;
		for(Medicament unMedicament : lesMedicaments){
			data[i][0] = unMedicament.getDepotLegal();
			data[i][1] = unMedicament.getNomCommercial();
			data[i][2] = unMedicament.getUneFamille().getLibelleFamille() ;
			i++;
			}
		String[] columnNames = {"Dépot Légal", "Nom Commercial","Libelle"};
		table = new JTable(data, columnNames);
		
		scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(600, 200));
		p.add(scrollPane);
		
		pSaisie = new JPanel();
		JTdepot = new JTextField(20);
		JTdepot.setMaximumSize(JTdepot.getPreferredSize());
		JBafficherFiche = new JButton("Afficher Fiche Médicament Complète");
		JBafficherFiche.addActionListener(this);
		pSaisie.add(JTdepot);
		pSaisie.add(JBafficherFiche);
		p.add(pSaisie);
		
		// mise en forme de la fenêtre
		Container contentPane = getContentPane();
		contentPane.add(p);
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent arg0) {
		Object source = arg0.getSource();
   		if (source == JBafficherFiche){
   			Medicament unMedicament = MedicamentDao.rechercher(JTdepot.getText());
   			if (unMedicament!=null){
   	   			fenetreContainer.ouvrirFenetre(new JIFMedicamentFiche(unMedicament));
   			}
   			
   		
   		}	
	}
}
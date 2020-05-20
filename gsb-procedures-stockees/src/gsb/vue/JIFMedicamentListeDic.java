package gsb.vue;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import gsb.modele.Medicament;
import gsb.modele.dao.MedicamentDao;

public class JIFMedicamentListeDic extends JInternalFrame implements ActionListener { 

	private static final long serialVersionUID = 1L;

	//private ArrayList<Medecin> lesMedecins;
	private HashMap<String,Medicament> diccoMedicament;


	protected JPanel p;
	protected JScrollPane scrollPane;
	protected JPanel pSaisie;
	protected JTextField JTdepot;
	protected JButton JBafficherFiche;
	protected MenuPrincipal fenetreContainer;
	protected JTable table;

	public JIFMedicamentListeDic() {

		
		// récupération des données Medecin dans la collection
		//lesMedecins = MedecinDao.retournerCollectionDesMedecins();

		//int nbLignes = lesMedecins.size();
		diccoMedicament = MedicamentDao.retournerDictionnaireDesMedicaments();
		int nbLignes= diccoMedicament.size();
		
		p = new JPanel(); // panneau principal de la fenêtre

		int i=0;
		String[][] data = new String[nbLignes][3] ;
		
		for (Map.Entry<String,Medicament> uneEntree : diccoMedicament.entrySet()){
			data[i][0] = uneEntree.getValue().getDepotLegal();
			data[i][1] = uneEntree.getValue().getNomCommercial();
			data[i][2] = uneEntree.getValue().getUneFamille().getLibelleFamille();
			i++;
			}
		String[] columnNames = {"Dépot Légal", "Nom Commercial","Libelle"};
		table = new JTable(data, columnNames);
		table.getSelectionModel().addListSelectionListener(table);
		
		scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(400, 200));
		p.add(scrollPane);
		
		pSaisie = new JPanel();
		JTdepot = new JTextField(20);
		JTdepot.setMaximumSize(JTdepot.getPreferredSize());
		JBafficherFiche = new JButton("Afficher Fiche médicament");
		JBafficherFiche.addActionListener(this); // source d'évenement
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
	public void actionPerformed(ActionEvent arg0) {
		Object source = arg0.getSource();
   		if (source == JBafficherFiche){
   			if (diccoMedicament.containsKey(JTdepot.getText())){
   	   			Medicament unMedicament = diccoMedicament.get(JTdepot.getText());
   	   			fenetreContainer.ouvrirFenetre(new JIFMedicamentFiche(unMedicament));
   			}
   		}
   		if(source == table){
   			JTdepot.setText((String)table.getValueAt(table.getSelectedRow(), table.getSelectedColumn()));
   			
   		}
	}
}
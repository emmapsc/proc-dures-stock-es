/*
 * Cr�� le 23 f�vr. 2015
 *
 * TODO Pour changer le mod�le de ce fichier g�n�r�, allez � :
 * Fen�tre - Pr�f�rences - Java - Style de code - Mod�les de code
 */
package gsb.vue;

import gsb.modele.Medecin;
import gsb.modele.dao.MedecinDao;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableCellRenderer;

/**
 * @author Isabelle 23 f�vr. 2015 TODO Pour changer le mod�le de ce commentaire
 *         de type g�n�r�, allez � : Fen�tre - Pr�f�rences - Java - Style de
 *         code - Mod�les de code
 */
public class JIFMedecinRapportVisite extends JInternalFrame {

	private static final long serialVersionUID = 1L;

	//private ArrayList<Medecin> lesMedecins;
	ArrayList<Medecin> medecins;

	protected JPanel p;
	protected JScrollPane scrollPane;
	protected JPanel pSaisie;
	protected MenuPrincipal fenetreContainer;
	protected JTable table;

	
	public JIFMedecinRapportVisite() {

		// r�cup�ration des donn�es Medecin dans la collection
		//lesMedecins = MedecinDao.retournerCollectionDesMedecins();


		
		/* Cr�ation des onglets */
		JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.add("6 mois", retournerOngletRapport(6,Color.green));
		tabbedPane.add("12 mois", retournerOngletRapport(12, Color.yellow));
		tabbedPane.add("18 mois", retournerOngletRapport(18, Color.red));
		

		// mise en forme de la fen�tre
		Container contentPane = getContentPane();
		contentPane.add(tabbedPane);
	}
	
	
	public JPanel retournerOngletRapport(int nombreMois, Color color) {
		//int nbLignes = lesMedecins.size();
		medecins = MedecinDao.retournerMedecinVisiteDepuis(nombreMois);
		int nbLignes= medecins.size();
		

		
		/* On cr�e un tableau � 2 dimensions avec 4 colonnes
		 * Pour chaque m�decin on rajoute une ligne */
		String[] columnNames = {"Code", "Nom", "Prenom", "Date derni�re visite"};
		String[][] data = new String[nbLignes][4] ;
		int i=0;
		for (Medecin medecin: medecins){
			data[i][0] = medecin.getCodeMed();
			data[i][1] = medecin.getNom();
			data[i][2] = medecin.getPrenom();
			data[i][3] = medecin.getDateDerniereVisite();
			i++;
		}
		
		table = new JTable(data, columnNames);
		scrollPane = new JScrollPane(table);
		scrollPane.setPreferredSize(new Dimension(400, 200));
		
		table.setBackground(color);

		p = new JPanel();
		p.add(scrollPane);
		return p;
	}

}
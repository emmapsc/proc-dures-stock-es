package gsb.vue;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import gsb.service.MedicamentService;

public class JIFMedicamentAjout extends JInternalFrame implements ActionListener {
	/**
	 * Commentaire pour <code>serialVersionUID</code>
	 */
	private static final long serialVersionUID = 1L;
	protected JPanel p;
	protected JPanel pTexte;
	protected JPanel pBoutons;
	protected JPanel pSaisie;
	protected JButton JBajout;

	protected JLabel JLunMedicament;
	protected JLabel JLunVisiteur;
	protected JLabel JLqteStock;
	
	protected JTextField JTunMedicament;
	protected JTextField JTunVisiteur;
	protected JSpinner JTqteStock;

	public JIFMedicamentAjout() {
		p = new JPanel(); // panneau principal de la fenêtre
		pBoutons = new JPanel(); // panneau supportant les boutons
		pTexte = new JPanel(new GridLayout(3, 2));

		JLunVisiteur = new JLabel("Code visiteur");
		JLunMedicament = new JLabel("Dépot légal");
		JLqteStock = new JLabel("Quantité");

		JTunVisiteur = new JTextField(20);
		JTunMedicament = new JTextField(20);
		//JTqteStock = new JTextField(20);
		
		SpinnerModel model = new SpinnerNumberModel(0, 0, 1000000, 1);
		JTqteStock = new JSpinner(model);

		pTexte.add(JLunVisiteur);
		pTexte.add(JTunVisiteur);
		pTexte.add(JLunMedicament);
		pTexte.add(JTunMedicament);
		pTexte.add(JLqteStock);
		pTexte.add(JTqteStock);

		pSaisie = new JPanel();
		JBajout = new JButton("Ajouter Echantillon");
		JBajout.addActionListener(this);

		// mise en forme de la fenêtre

		p.add(pTexte);
		p.add(pBoutons);
		pBoutons.add(JBajout);
		Container contentPane = getContentPane();
		contentPane.add(p);

	}

	public void actionPerformed(ActionEvent arg0) {
		Object source = arg0.getSource();
		if (source == JBajout) {
			
			try {
				String depotLegal = JTunMedicament.getText();
				String matricule = JTunVisiteur.getText();
				Integer quantite = (Integer) JTqteStock.getValue();
				
				/*System.out.println(depotLegal);
				System.out.println(matricule);
				System.out.println(quantite);
				 */
				if (MedicamentService.ajouterEchantillon(depotLegal, matricule, quantite))
					JOptionPane.showMessageDialog(null, "L'échantillon a été ajouté", "Information", JOptionPane.INFORMATION_MESSAGE);
				else
					JOptionPane.showMessageDialog(null, "L'échantillon de ce médicament a été mis à jour","Information", JOptionPane.INFORMATION_MESSAGE);
				
			}
			catch(Exception e) {

				JOptionPane.showMessageDialog(null, e.getMessage(), "Erreur",
						JOptionPane.ERROR_MESSAGE);
			}
			
		}
	}

}
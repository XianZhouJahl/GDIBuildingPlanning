package zhou.xian.gUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import javax.swing.JButton;

import zhou.xian.raemlicheObjekte.Gebaeude;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GebaeudeplanerGUI {

	public JFrame frmGebaeudeplaner;
	private Gebaeude gebaeude;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GebaeudeplanerGUI window = new GebaeudeplanerGUI();
					window.frmGebaeudeplaner.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GebaeudeplanerGUI() {
		initialize();
	}

	public GebaeudeplanerGUI(Gebaeude gebaeude) {
		this();
		this.gebaeude = gebaeude;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmGebaeudeplaner = new JFrame();
		frmGebaeudeplaner.getContentPane().setEnabled(false);
		frmGebaeudeplaner.setTitle("Gebäudeplaner");
		frmGebaeudeplaner.setBounds(100, 100, 319, 225);
		frmGebaeudeplaner.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmGebaeudeplaner.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Ausgabeumfang");
		lblNewLabel.setBounds(18, 39, 122, 15);
		frmGebaeudeplaner.getContentPane().add(lblNewLabel);
		
		JCheckBox betonUndBewehrungsmengeCheckBox = new JCheckBox("Beton- und Bewehrungsmenge");
		betonUndBewehrungsmengeCheckBox.setFont(new Font("Dialog", Font.PLAIN, 12));
		betonUndBewehrungsmengeCheckBox.setBounds(18, 89, 210, 23);
		frmGebaeudeplaner.getContentPane().add(betonUndBewehrungsmengeCheckBox);
		
		JCheckBox seitlicheWandflaecheCheckBox = new JCheckBox("Seitliche Wandfläche");
		seitlicheWandflaecheCheckBox.setFont(new Font("Dialog", Font.PLAIN, 12));
		seitlicheWandflaecheCheckBox.setBounds(18, 62, 182, 23);
		frmGebaeudeplaner.getContentPane().add(seitlicheWandflaecheCheckBox);
		
		JCheckBox fensterUndTuerAnzahlCheckbox = new JCheckBox("Fenster- und Türanzahl");
		fensterUndTuerAnzahlCheckbox.setFont(new Font("Dialog", Font.PLAIN, 12));
		fensterUndTuerAnzahlCheckbox.setBounds(18, 116, 211, 23);
		frmGebaeudeplaner.getContentPane().add(fensterUndTuerAnzahlCheckbox);
		
		JButton berichtErstellenButton = new JButton("Bericht erstellen");
		berichtErstellenButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if (gebaeude != null) {
					String bericht = gebaeude.erstelleBericht(seitlicheWandflaecheCheckBox.isSelected(), 
							betonUndBewehrungsmengeCheckBox.isSelected(), fensterUndTuerAnzahlCheckbox.isSelected());
					gebaeude.schreibeInDatei("Bericht.txt", bericht);
				}
			}
		});
		berichtErstellenButton.setFont(new Font("Dialog", Font.PLAIN, 12));
		berichtErstellenButton.setBounds(48, 147, 128, 25);
		frmGebaeudeplaner.getContentPane().add(berichtErstellenButton);
		
		JButton beendenButton = new JButton("Beenden");
		beendenButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		beendenButton.setFont(new Font("Dialog", Font.PLAIN, 12));
		beendenButton.setBounds(187, 147, 98, 25);
		frmGebaeudeplaner.getContentPane().add(beendenButton);
		
		JLabel ueberschriftLabel = new JLabel("Gebäudeplaner");
		ueberschriftLabel.setHorizontalAlignment(SwingConstants.CENTER);
		ueberschriftLabel.setFont(new Font("Dialog", Font.BOLD, 16));
		ueberschriftLabel.setBounds(71, 0, 128, 38);
		frmGebaeudeplaner.getContentPane().add(ueberschriftLabel);
	}
}

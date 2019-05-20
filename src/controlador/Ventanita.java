package controlador;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Ventanita extends JFrame {

	private JPanel contentPane;
	JLabel lblPrincipal, lblHilo1, lblHilo2;

	/**
	 * Create the frame.
	 */
	public Ventanita() {
		setType(Type.UTILITY);
		setTitle("Ventanita");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 252, 198);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		lblPrincipal = new JLabel("");
		lblPrincipal.setBounds(10, 0, 151, 25);
		contentPane.add(lblPrincipal);

		lblHilo1 = new JLabel("");
		lblHilo1.setBounds(10, 43, 151, 25);
		contentPane.add(lblHilo1);

		lblHilo2 = new JLabel("");
		lblHilo2.setBounds(10, 97, 151, 25);
		contentPane.add(lblHilo2);

		JButton btnBotoncito = new JButton("Botoncito");

		btnBotoncito.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				HiloSonido hs = new HiloSonido("sonido.wav");
				Thread musica = new Thread(hs);
				musica.start();
			}
		});
		btnBotoncito.setBounds(137, 125, 89, 23);
		contentPane.add(btnBotoncito);
	}
}

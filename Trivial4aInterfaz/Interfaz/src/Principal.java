import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;
import java.util.Random;

public class Principal extends JFrame {

	private JPanel contentPane;
	private JPanel panelPrincipal;
	private Casilla[][] tablero = new Casilla[9][9];
	private Color colores[]={Color.CYAN,Color.YELLOW,Color.ORANGE,Color.GREEN,Color.PINK,Color.RED,Color.gray,Color.BLUE,Color.black};
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 932, 631);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		panelPrincipal = new JPanel();
		panelPrincipal.setBounds(139, 60, 649, 431);
		panelPrincipal.setLayout(new GridLayout(9, 9));
		setMatriz();
		setInterface();

		mostrarMatriz();
		contentPane.add(panelPrincipal);

	}

	// Genera dinamicamente el tablero para facilitar la redimension si se
	// cambia el total de casillas
	public void setInterface() {
		JButton bt = null;
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero.length; j++) {
				if (tablero[i][j] != null) {
					bt = new JButton();
					bt.setVisible(true);
					bt.setBackground((colores[tablero[i][j].getCategoria()]));
					panelPrincipal.add(bt);

				} else {
					bt = new JButton();
					bt.setVisible(false);
					panelPrincipal.add(bt);

				}
			}
		}
	}

	// Se inicializa el tablero por donde se controla el desarrollo del juego
	public void setMatriz() {
		Random r =new Random();
		for (int i = 0; i < tablero.length; i++) {
			tablero[0][i] = new Casilla(i);
			tablero[tablero.length - 1][i] =  new Casilla(i);
			tablero[i][0] =  new Casilla(i);
			tablero[i][tablero.length - 1] = new Casilla(i);
			tablero[i][tablero.length / 2] = new Casilla(i);
			tablero[tablero.length / 2][i] =new Casilla(i);
		}

	}

	public void mostrarMatriz() {
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero.length; j++) {
				System.out.print(tablero[i][j]!=null ? 1+" ":0+" " );;
			}
			System.out.println();
		}

	}

}

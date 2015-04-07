package es.uniovi.asw.interfaz;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;

import es.uniovi.asw.componentesDeInterfaz.Panel_Jugador;
import es.uniovi.asw.main.GameLoader;
import es.uniovi.asw.trivial.game.Game;
import es.uniovi.asw.trivial.game.GameFactory;
import es.uniovi.asw.trivial.model.User;

import javax.swing.JScrollPane;
import javax.swing.JButton;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.border.TitledBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.net.UnknownHostException;

import javax.swing.SpinnerNumberModel;

import java.awt.BorderLayout;

@SuppressWarnings("serial")
public class VentanaConfig extends JFrame {

	private JPanel contentPane;
	public GameLoader configuracion;
	private JPanel panelCentro;
	private JPanel panelTamanyos;
	private JPanel panelSur;
	private JScrollPane scrJugadores;
	private JPanel panelJugadores;
	private JButton btnJugar;
	private JButton btnLogin;
	private JButton btnAdmin;
	private JButton btnSalir;
	private JPanel panelDado;
	private JPanel panelTamanyo;
	private JPanel panelMax;
	private JPanel panelMin;
	private JLabel lblMaximo;
	private JLabel lblMinimo;
	private JSpinner spMax;
	private JSpinner spMin;
	private JSpinner spCasillas;
	private JLabel lblCasillas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					VentanaConfig frame = new VentanaConfig();
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
	public VentanaConfig() {
		setIconImage(new ImageIcon("img/trivial_logo.png").getImage());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 527, 272);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPanelCentro());
		contentPane.add(getPanelSur(), BorderLayout.SOUTH);

		try {
			configuracion = new GameLoader();
		} catch (UnknownHostException e) {
			JOptionPane.showMessageDialog(this, "Error en la base de datos",
					"Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private JPanel getPanelCentro() {
		if (panelCentro == null) {
			panelCentro = new JPanel();
			panelCentro.setLayout(new BorderLayout(0, 0));
			panelCentro.add(getPanelTamanyos(), BorderLayout.EAST);
			panelCentro.add(getScrJugadores());
		}
		return panelCentro;
	}
	private JPanel getPanelTamanyos() {
		if (panelTamanyos == null) {
			panelTamanyos = new JPanel();
			panelTamanyos.setLayout(new BorderLayout(0, 0));
			panelTamanyos.add(getPanelDado());
			panelTamanyos.add(getPanelTamanyo(), BorderLayout.SOUTH);
		}
		return panelTamanyos;
	}
	private JPanel getPanelSur() {
		if (panelSur == null) {
			panelSur = new JPanel();
			panelSur.setLayout(new GridLayout(0, 4, 50, 0));
			panelSur.add(getBtnJugar());
			panelSur.add(getBtnLogin());
			panelSur.add(getBtnAdmin());
			panelSur.add(getBtnSalir());
		}
		return panelSur;
	}
	private JScrollPane getScrJugadores() {
		if (scrJugadores == null) {
			scrJugadores = new JScrollPane();
			scrJugadores.setViewportView(getPanelJugadores());
		}
		return scrJugadores;
	}
	private JPanel getPanelJugadores() {
		if (panelJugadores == null) {
			panelJugadores = new JPanel();
			panelJugadores.setLayout(new GridLayout(50, 0, 0, 0));
		}
		return panelJugadores;
	}
	
	/**
	 * Anyade jugadores a la interfaz
	 */
	public void actualizarJugadores(){
		panelJugadores.removeAll();
		for(int i=0; i<configuracion.getUsuarios().size(); i++)
			panelJugadores.add(new Panel_Jugador(configuracion.getUsuarios().get(i).get_id(),this));
		panelJugadores.revalidate();
		panelJugadores.repaint();
	}
	
	private JButton getBtnJugar() {
		if (btnJugar == null) {
			btnJugar = new JButton("Jugar");
			btnJugar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					mostrarVentanaJuego();
				}
			});
		}
		return btnJugar;
	}
	
	private void mostrarVentanaJuego(){
		Game juego = jugar();
		if(juego!=null){
			VentanaJuego vj = new VentanaJuego(juego);
			vj.setLocationRelativeTo(this);
			vj.setVisible(true);
			cerrar();
		}
	}
	
	private Game jugar(){
		if(configuracionValida()){
			try {
				Game juego = GameFactory.getNewGame();
				int tam = (Integer) getSpCasillas().getValue();
				juego.startGame(configuracion.getUsuarios(), configuracion.getPreguntas(),
						tam, configuracion.getDado(), configuracion.getConexion());
				return juego;
			} catch (UnknownHostException e) {
				JOptionPane.showMessageDialog(this, "La base de datos esta vacia", 
						"Atencion", JOptionPane.ERROR_MESSAGE);
				return null;
			}
		}
		return null;
	}
	
	private boolean configuracionValida(){
		int max = (Integer) getSpMax().getValue();
		int min = (Integer) getSpMin().getValue();		
		if(max<min){
			JOptionPane.showMessageDialog(this, "Numero maximo del dado tiene que ser"
					+ "\nigual o mayor que el minimo", "Atencion", JOptionPane.WARNING_MESSAGE);
			return false;
		}		
		configuracion.DadoSize(min,max);
		return true;
	}
	
	private void cerrar(){
		this.dispose();
	}
	
	
	private JButton getBtnLogin() {
		if (btnLogin == null) {
			btnLogin = new JButton("Login");
			btnLogin.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					mostrarVentanaLogin();
				}
			});
		}
		return btnLogin;
	}
	
	private void mostrarVentanaLogin(){
		VentanaLogin vl = new VentanaLogin(this);
		vl.setVisible(true);
		vl.setLocationRelativeTo(this);
	}
	
	private JButton getBtnAdmin() {
		if (btnAdmin == null) {
			btnAdmin = new JButton("Admin");
			btnAdmin.setEnabled(false);
		}
		return btnAdmin;
	}
	private JButton getBtnSalir() {
		if (btnSalir == null) {
			btnSalir = new JButton("Salir");
		}
		return btnSalir;
	}
	private JPanel getPanelDado() {
		if (panelDado == null) {
			panelDado = new JPanel();
			panelDado.setBorder(new TitledBorder(null, "Dado", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelDado.setLayout(new GridLayout(0, 1, 0, 0));
			panelDado.add(getPanelMax());
			panelDado.add(getPanelMin());
		}
		return panelDado;
	}
	private JPanel getPanelTamanyo() {
		if (panelTamanyo == null) {
			panelTamanyo = new JPanel();
			panelTamanyo.setBorder(null);
			panelTamanyo.setLayout(new GridLayout(0, 1, 0, 0));
			panelTamanyo.add(getLblCasillas());
			panelTamanyo.add(getSpCasillas());
		}
		return panelTamanyo;
	}
	private JPanel getPanelMax() {
		if (panelMax == null) {
			panelMax = new JPanel();
			panelMax.setLayout(new GridLayout(0, 1, 0, 0));
			panelMax.add(getLblMaximo());
			panelMax.add(getSpMax());
		}
		return panelMax;
	}
	private JPanel getPanelMin() {
		if (panelMin == null) {
			panelMin = new JPanel();
			panelMin.setLayout(new GridLayout(0, 1, 0, 0));
			panelMin.add(getLblMinimo());
			panelMin.add(getSpMin());
		}
		return panelMin;
	}
	private JLabel getLblMaximo() {
		if (lblMaximo == null) {
			lblMaximo = new JLabel("Maximo");
		}
		return lblMaximo;
	}
	private JLabel getLblMinimo() {
		if (lblMinimo == null) {
			lblMinimo = new JLabel("Minimo");
		}
		return lblMinimo;
	}
	private JSpinner getSpMax() {
		if (spMax == null) {
			spMax = new JSpinner();
			spMax.setModel(new SpinnerNumberModel(new Integer(6), new Integer(1), null, new Integer(1)));
		}
		return spMax;
	}
	private JSpinner getSpMin() {
		if (spMin == null) {
			spMin = new JSpinner();
			spMin.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		}
		return spMin;
	}
	private JSpinner getSpCasillas() {
		if (spCasillas == null) {
			spCasillas = new JSpinner();
			spCasillas.setModel(new SpinnerNumberModel(new Integer(10), new Integer(10), null, new Integer(1)));
		}
		return spCasillas;
	}
	private JLabel getLblCasillas() {
		if (lblCasillas == null) {
			lblCasillas = new JLabel("Casillas");
		}
		return lblCasillas;
	}
}

package es.uniovi.asw.interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import es.uniovi.asw.componentesDeInterfaz.Colores;
import es.uniovi.asw.componentesDeInterfaz.Panel_Quesitos;
import es.uniovi.asw.componentesDeInterfaz.Panel_TableroCuadrado;
import es.uniovi.asw.trivial.game.Game;
import es.uniovi.asw.trivial.model.Player;
import es.uniovi.asw.trivial.model.Pregunta;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.border.TitledBorder;

import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Color;
import java.awt.FlowLayout;

@SuppressWarnings("serial")
public class VentanaJuego extends JFrame {

	public static Game juego;
	public static Colores colores;
	
	private static Player jugadorActual;
	
	private Panel_Quesitos panelQuesitos;
	private Panel_TableroCuadrado panelTablero;
	
	private JPanel contentPane;
	private JPanel panelCentro;
	private JPanel panelJugador;
	private JTextField txtJugador;
	private JPanel panelNorte;
	private JPanel panelMovimiento;
	private JPanel panelDado;
	private JButton btnDado;
	private JPanel panelFlechas;
	private JButton btnDerecha;
	private JButton btnIzquierda;
	private JLabel lblDado;
	private JPanel panelSur;
	private JButton btnSalir;
	

	/**
	 * Launch the application.
	 * 
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaJuego frame = new VentanaJuego(juego);
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
	public VentanaJuego(Game g) {
		setIconImage(new ImageIcon("img/trivial_logo.png").getImage());
		setTitle("Trivial Pursuit");
		inicializarJuego(g);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPanelCentro(), BorderLayout.CENTER);
		contentPane.add(getPanelNorte(), BorderLayout.NORTH);
		contentPane.add(getPanelSur(), BorderLayout.SOUTH);
	}
	
	/**
	 * Inicializa el juego
	 * @param Game g habiendo ejecutado el metodo start game
	 */
	private void inicializarJuego(Game g){
		juego = g;
		VentanaJuego.colores = new Colores(g.getCategorias());
		juego.getPlayers();
		jugadorActual = juego.getCurrentPlayer();
	}
	
	private JPanel getPanelCentro() {
		if (panelCentro == null) {
			this.panelTablero = new Panel_TableroCuadrado();
			panelCentro = this.panelTablero;
		}
		return panelCentro;
	}
	private JPanel getPanelJugador() {
		if (panelJugador == null) {
			panelJugador = new JPanel();
			panelJugador.setBorder(new TitledBorder(null, "Jugador Actual:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelJugador.setLayout(new BoxLayout(panelJugador, BoxLayout.Y_AXIS));
			panelJugador.add(getTxtJugador());
		}
		return panelJugador;
	}
	private JTextField getTxtJugador() {
		if (txtJugador == null) {
			txtJugador = new JTextField();
			txtJugador.setHorizontalAlignment(SwingConstants.CENTER);
			txtJugador.setEditable(false);
			txtJugador.setFont(new Font("Adobe Arabic", Font.PLAIN, 34));
			txtJugador.setText(jugadorActual.getUser().get_id());
			txtJugador.setColumns(10);
			txtJugador.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		}
		return txtJugador;
	}
	private JPanel getPanelNorte() {
		if (panelNorte == null) {
			panelNorte = new JPanel();
			panelNorte.setLayout(new GridLayout(0, 3, 0, 0));
			panelNorte.add(getPanelMovimiento());
			panelNorte.add(getQuesitos());
			panelNorte.add(getPanelJugador());
		}
		return panelNorte;
	}
	
	
	private Panel_Quesitos getQuesitos(){
		if(panelQuesitos==null){
			panelQuesitos = new Panel_Quesitos();
			panelQuesitos.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), 
					"Quesitos ganados:", TitledBorder.LEADING, 
					TitledBorder.TOP, null, new Color(0, 0, 0)));
		}
		return panelQuesitos;
	}
	
	private JPanel getPanelMovimiento() {
		if (panelMovimiento == null) {
			panelMovimiento = new JPanel();
			panelMovimiento.setBorder(new TitledBorder(null, "Tirada", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelMovimiento.setLayout(new GridLayout(0, 1, 0, 0));
			panelMovimiento.add(getPanelDado());
			panelMovimiento.add(getPanelFlechas());
		}
		return panelMovimiento;
	}
	private JPanel getPanelDado() {
		if (panelDado == null) {
			panelDado = new JPanel();
			panelDado.setLayout(new GridLayout(0, 2, 5, 0));
			panelDado.add(getBtnDado());
			panelDado.add(getLblDado());
		}
		return panelDado;
	}
	private JLabel getLblDado() {
		if (lblDado == null) {
			lblDado = new JLabel("");
			lblDado.setForeground(Color.ORANGE);
			lblDado.setHorizontalAlignment(SwingConstants.CENTER);
			lblDado.setFont(new Font("Wide Latin", Font.PLAIN, 30));
			lblDado.setOpaque(true);
			lblDado.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		}
		return lblDado;
	}
	private JButton getBtnDado() {
		if (btnDado == null) {
			btnDado = new JButton();
			btnDado.setIcon(ajustarImagen("img/dado.png", btnDado));
			btnDado.setContentAreaFilled(false);
			btnDado.setBorderPainted(false);
			btnDado.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int num=juego.diceGetNumer();
					lblDado.setText(String.valueOf(num));
					btnDado.setEnabled(false);
				}				
			});
		}		
		return btnDado;
	}
	
	/**
	 * Redimensiona una imagen para un componente dado
	 * @param Direccion
	 * @param Componente
	 * @return Imagen redimensionada
	 */
	protected Icon ajustarImagen(String direccion, Component componente) {
		Image imgOriginal =  new ImageIcon(direccion).getImage();
		Image imgEscalada = imgOriginal.getScaledInstance(componente.getWidth()-34,componente.getHeight()-10, Image.SCALE_SMOOTH);
		return new ImageIcon(imgEscalada);
	}
	
	private JPanel getPanelFlechas() {
		if (panelFlechas == null) {
			panelFlechas = new JPanel();
			panelFlechas.setLayout(new GridLayout(0, 2, 5, 0));
			panelFlechas.add(getBtnIzquierda());
			panelFlechas.add(getBtnDerecha());
		}
		return panelFlechas;
	}
	private JButton getBtnDerecha() {
		if (btnDerecha == null) {
			btnDerecha = new JButton();
			btnDerecha.setIcon(ajustarImagen("img/flecha_derecha.png",btnDerecha));
			btnDerecha.setContentAreaFilled(false);
			btnDerecha.setBorderPainted(false);
			btnDerecha.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					moverse(1);
				}
			});
			
		}
		return btnDerecha;
	}
	private JButton getBtnIzquierda() {
		if (btnIzquierda == null) {
			btnIzquierda = new JButton();
			btnIzquierda.setIcon(ajustarImagen("img/flecha_izquierda.png",btnIzquierda));
			btnIzquierda.setContentAreaFilled(false);
			btnIzquierda.setBorderPainted(false);
			btnIzquierda.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					moverse(-1);
				}
			});
		}
		return btnIzquierda;
	}
	
	/**
	 * Mueve al jugador segun:
	 * 	Orientacion (IZQ -1   DER 1)
	 *  Valor de la tirada del dado
	 * @param orientacion
	 */
	private void moverse(int orientacion){
		if(orientacion!=-1 && orientacion!=1)
			return;
		try{
			int movimientos = Integer.parseInt(getLblDado().getText());
			getLblDado().setText("");
			juego.movePlayer(movimientos*orientacion);
			actualizarPanelesDeJugador();
			mostrarVentanaPregunta();
		}
		catch(NumberFormatException e){}
	}
	
	/**
	 * Muestra una ventana con la pregunta y una serie de respuestas a elegir
	 */
	private void mostrarVentanaPregunta(){
		Pregunta p = juego.getQuestionSet(juego.getCurrentPlayer().getPosicion());
		VentanaPreguntaRespuesta vpr = new VentanaPreguntaRespuesta(p);
		vpr.setLocationRelativeTo(this);
		vpr.setModal(true);
		vpr.setVisible(true);
		String veredicto = juego.answerQuestionSet(p, vpr.getRespElegida());
		siJuegoAcabado(veredicto);
		jugadorActual = juego.getCurrentPlayer();
		actualizarPanelesDeJugador();
	}
	
	/**
	 * Actualiza los paneles Tablero, Quesito
	 * y campo de texto de jugador
	 */
	private void actualizarPanelesDeJugador(){
		this.panelTablero.actualizarCasillas();
		this.panelQuesitos.actualizarQuesitos(jugadorActual);
		getTxtJugador().setText(jugadorActual.getUser().get_id());
		actualizarPaneles(this.panelTablero);
		actualizarPaneles(this.panelQuesitos);
		getBtnDado().setEnabled(true);
	}
	
	/**
	 * Actualiza cualquier panel
	 * @param panel actualizado
	 */
	private void actualizarPaneles(JPanel panel){
		panel.revalidate();
		panel.repaint();
	}
	
	/**
	 * Al finalizar el juego:
	 * 	devuelve un mensaje diciendo quien gano
	 * 	llama a endGame() de juego
	 * 	y cierra la aplicacion
	 * @param veredicto (mensaje que decide si acaba el juego o no)
	 */
	private void siJuegoAcabado(String veredicto) {
		if (veredicto.equals("End")) {
			JOptionPane.showMessageDialog(this, "¡¡Jugador "
					+ jugadorActual.getUser().get_id() + " ha ganado!!", "Fin",
					JOptionPane.INFORMATION_MESSAGE);
			juego.endGame();
			System.exit(0);
		}
	}

	private JPanel getPanelSur() {
		if (panelSur == null) {
			panelSur = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panelSur.getLayout();
			flowLayout.setAlignment(FlowLayout.RIGHT);
			panelSur.add(getBtnSalir());
		}
		return panelSur;
	}
	private JButton getBtnSalir() {
		if (btnSalir == null) {
			btnSalir = new JButton("Salir");
			btnSalir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					System.exit(0);
				}
			});
		}
		return btnSalir;
	}
}

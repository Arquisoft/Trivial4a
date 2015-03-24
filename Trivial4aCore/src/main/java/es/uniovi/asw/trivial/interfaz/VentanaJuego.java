package es.uniovi.asw.trivial.interfaz;

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
import javax.swing.JTextField;

import es.uniovi.asw.trivial.game.Game;
import es.uniovi.asw.trivial.model.Player;
import es.uniovi.asw.trivial.model.User;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.border.TitledBorder;

import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.UIManager;
import java.awt.Color;

@SuppressWarnings("serial")
public class VentanaJuego extends JFrame {

	private int tam;
	public static Game juego;
	public static Colores colores;
	public static final String[] pruebaCategorias =
			new String[]{"Categoria A",
		"Categoria B","Categoria C","Categoria D"};
	
	private Panel_Quesitos pq;
	
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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaJuego frame = new VentanaJuego(40, new Colores(pruebaCategorias));
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
	public VentanaJuego(int n, Colores c) {
		this.tam = n;
		//Esto es una prueba
		VentanaJuego.colores = c;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 614, 501);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPanelCentro(), BorderLayout.CENTER);
		contentPane.add(getPanelNorte(), BorderLayout.NORTH);
	}
	
	private JPanel getPanelCentro() {
		if (panelCentro == null) {
			panelCentro = new Panel_TableroCuadrado(tam, juego);
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
			txtJugador.setText("Pepe");
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
		if(pq==null){
			Player prueba = new Player(new User("Pepe"),0);
			pq = new Panel_Quesitos(prueba,pruebaCategorias);
			pq.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Quesitos ganados:", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		}
		return pq;
	}
	
	private JPanel getPanelMovimiento() {
		if (panelMovimiento == null) {
			panelMovimiento = new JPanel();
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
					System.out.println(num);
					switch(num){
					case 1:
						lblDado.setIcon(ajustarImagen("img/dado1.png",lblDado));
						break;
					case 2:
						lblDado.setIcon(ajustarImagen("img/dado2.png",lblDado));
						break;
					case 3:
						lblDado.setIcon(ajustarImagen("img/dado3.png",lblDado));
						break;
					case 4:
						lblDado.setIcon(ajustarImagen("img/dado4.png",lblDado));
						break;
					case 5:
						lblDado.setIcon(ajustarImagen("img/dado5.png",lblDado));
						break;
					case 6:
						lblDado.setIcon(ajustarImagen("img/dado6.png",lblDado));
						break;
					}					
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
			
		}
		return btnDerecha;
	}
	private JButton getBtnIzquierda() {
		if (btnIzquierda == null) {
			btnIzquierda = new JButton();
			btnIzquierda.setIcon(ajustarImagen("img/flecha_izquierda.png",btnIzquierda));
			btnIzquierda.setContentAreaFilled(false);
			btnIzquierda.setBorderPainted(false);
		}
		return btnIzquierda;
	}

}

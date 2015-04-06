package es.uniovi.asw.interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.FlowLayout;
import java.awt.Color;

import javax.swing.border.CompoundBorder;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.UnknownHostException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JList;

import es.uniovi.asw.componentesDeInterfaz.ClaseParaPruebas;
import es.uniovi.asw.trivial.game.Game;
import es.uniovi.asw.trivial.game.GameFactory;
import es.uniovi.asw.trivial.model.Player;
import es.uniovi.asw.trivial.model.Pregunta;
import es.uniovi.asw.trivial.model.User;
import es.uniovi.asw.trivial.persistence.MongoDB;

public class VentanaConfig extends JFrame {

	private JPanel contentPane;
	private Game game;
	private JList lsJugadores;
	private VentanaConfig ventana;
	private DefaultListModel model;
	private User[] jugadores = new User[4];
	private int counter = 0;
	private MongoDB mdb = new MongoDB();
	private JSpinner spntablero;
	private JSpinner spnMin;
	private JSpinner spnMax;
	private JButton btJugar;
	private JOptionPane option;

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
		ventana = this;
		option = new JOptionPane();
		model = new DefaultListModel();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 801, 564);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel pnJugadores = new JPanel();
		pnJugadores.setBounds(43, 49, 385, 305);
		contentPane.add(pnJugadores);
		pnJugadores.setLayout(null);

		JScrollPane scJugadores = new JScrollPane();
		scJugadores.setBounds(21, 31, 167, 249);
		pnJugadores.add(scJugadores);

		lsJugadores = new JList();
		scJugadores.setViewportView(lsJugadores);

		JButton btBorrarJugador = new JButton("Borrar");
		btBorrarJugador.setBounds(229, 143, 89, 23);
		btBorrarJugador.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (lsJugadores.getSelectedIndex() != -1) {
					model.remove(lsJugadores.getSelectedIndex());
					for(int i= lsJugadores.getSelectedIndex();i<jugadores.length-1;i++){
					jugadores[i]=jugadores[i+1];
					}
					jugadores[jugadores.length]=null;
					lsJugadores.setModel(model);
					if(lsJugadores.getModel().getSize()<2)
						btJugar.setEnabled(false);
				}
			}
		});
		pnJugadores.add(btBorrarJugador);

		JLabel lblJugadores = new JLabel("Jugadores");
		lblJugadores.setBounds(68, 21, 68, 14);
		contentPane.add(lblJugadores);

		JPanel panel = new JPanel();
		panel.setBounds(617, 69, 115, 182);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblMin = new JLabel("Min");
		lblMin.setBounds(10, 63, 25, 14);
		panel.add(lblMin);

		spnMin = new JSpinner();
		spnMin.setBounds(42, 60, 50, 20);
		panel.add(spnMin);

		JLabel lblMax = new JLabel("Max");
		lblMax.setBounds(10, 120, 25, 14);
		panel.add(lblMax);

		spnMax = new JSpinner();
		spnMax.setBounds(46, 117, 46, 20);
		panel.add(spnMax);

		JLabel lblTamDado = new JLabel("Tamaño del dado");
		lblTamDado.setBounds(10, 11, 95, 14);
		panel.add(lblTamDado);

		JButton btLogin = new JButton("Login");
		btLogin.setBounds(81, 435, 89, 23);
		btLogin.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				VentanaLogin l = new VentanaLogin(ventana);
				l.setVisible(true);
			}
		});
		contentPane.add(btLogin);

		JButton btRegister = new JButton("Register");
		btRegister.setBounds(284, 435, 89, 23);

		btRegister.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				VentanaRegister r = new VentanaRegister();
				r.setVisible(true);

			}
		});
		contentPane.add(btRegister);

		btJugar = new JButton("Jugar");
		btJugar.setBounds(476, 435, 89, 23);
		btJugar.setEnabled(false);

		btJugar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Game juego = GameFactory.getNewGame();

				try {
					Pregunta[] preguntas = mdb.getPreguntas();
					int tam = (Integer) spntablero.getValue();
					int min = (Integer) spnMin.getValue();
					int max = (Integer) spnMax.getValue();
					if (tam < 20) {
						option.showMessageDialog(ventana,
								"El tamaño del tablero debe ser mayor que 20");
					} else if (min < 1) {
						option.showMessageDialog(ventana,
								"El numero minimo del dado debe ser 1");
					} else if (max <= min) {
						option.showMessageDialog(ventana,
								"el maximo del dado no puede ser igual que el minimo");
					} else {
						juego.startGame(jugadores, preguntas, tam, min, max);
						VentanaJuego j = new VentanaJuego(juego);
						j.setVisible(true);
					}
				} catch (UnknownHostException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		contentPane.add(btJugar);

		JButton btAdmin = new JButton("Admin");
		btAdmin.setBounds(643, 435, 89, 23);
		contentPane.add(btAdmin);

		JLabel lblTamTablero = new JLabel("Tamaño del tablero");
		lblTamTablero.setBounds(566, 325, 104, 14);
		contentPane.add(lblTamTablero);

		spntablero = new JSpinner();
		spntablero.setBounds(680, 322, 52, 20);
		contentPane.add(spntablero);

	}

	protected void setPlayers(String id) {
		try {
			model.addElement(id);
			lsJugadores.setModel(model);
			if (lsJugadores.getModel().getSize() >= 2)
				btJugar.setEnabled(true);
			if (counter < jugadores.length)
				jugadores[counter] = mdb.getUser(id);
			counter++;
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

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
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JLabel;
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
import es.uniovi.asw.trivial.model.User;

public class VentanaConfig extends JFrame {

	private JPanel contentPane;
	private Game game;
	private JList lsJugadores;
	private VentanaConfig ventana;
	private DefaultListModel model;
	private ArrayList<User> jugadores;
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
		ventana=this;
	 game= ClaseParaPruebas.juegoPruebaSinBBDD(20, 2, 1, 6);
	 model= new DefaultListModel();
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
				if(lsJugadores.getSelectedIndex()!=-1){
				model.remove(lsJugadores.getSelectedIndex());
				lsJugadores.setModel(model);
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
		
		JSpinner spnMin = new JSpinner();
		spnMin.setBounds(42, 60, 50, 20);
		panel.add(spnMin);
		
		JLabel lblMax = new JLabel("Max");
		lblMax.setBounds(10, 120, 25, 14);
		panel.add(lblMax);
		
		JSpinner spnMax = new JSpinner();
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
				VentanaLogin l= new VentanaLogin(ventana);
				l.setVisible(true);
			}
		});
		contentPane.add(btLogin);
		
		JButton btRegister = new JButton("Register");
		btRegister.setBounds(284, 435, 89, 23);
		
		btRegister.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				VentanaRegister r= new VentanaRegister();
				r.setVisible(true);
				
			}
		});
		contentPane.add(btRegister);
		
		JButton btJugar = new JButton("Jugar");
		btJugar.setBounds(476, 435, 89, 23);
		btJugar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				VentanaJuego j= new VentanaJuego(GameFactory.getNewGame().startGame((User[])jugadores.toArray(), preguntas, , spnMin.getValue(), spnMax.getValue().);)
			}
		});
		contentPane.add(btJugar);
		
		JButton btAdmin = new JButton("Admin");
		btAdmin.setBounds(643, 435, 89, 23);
		contentPane.add(btAdmin);
		
		JLabel lblTamTablero = new JLabel("Tamaño del tablero");
		lblTamTablero.setBounds(566, 325, 104, 14);
		contentPane.add(lblTamTablero);
		
		JSpinner spnTablero = new JSpinner();
		spnTablero.setBounds(680, 322, 52, 20);
		contentPane.add(spnTablero);
		
	}
	
	protected void setPlayers(String id){
		
			model.addElement(id);
		lsJugadores.setModel(model);
		
	
	}
}

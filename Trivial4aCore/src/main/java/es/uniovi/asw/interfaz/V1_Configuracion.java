package es.uniovi.asw.interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.GridLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JLabel;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class V1_Configuracion extends JFrame {

	private JPanel contentPane;
	private PanelCredenciales credenciales;
	private JButton btnSiguiente;
	private JComboBox<Integer> cbxNumJugadores;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					V1_Configuracion frame = new V1_Configuracion();
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
	public V1_Configuracion() {
		setTitle("Trivial");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 279, 364);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelNavegacion = new JPanel();
		contentPane.add(panelNavegacion, BorderLayout.SOUTH);
		panelNavegacion.setLayout(new GridLayout(0, 2, 50, 0));
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		panelNavegacion.add(btnSalir);
		
		
		
		btnSiguiente = new JButton("Siguiente");
		btnSiguiente.setEnabled(false);
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i=0; i<credenciales.lista.length; i++){
					System.out.println(credenciales.lista[i].toString());
					System.out.println("-------");
				}
				System.out.println("\nAbriendo ventana juego (Por completar)");
			}
		});
		panelNavegacion.add(btnSiguiente);
		
		JPanel panelSeleccionarJugadores = new JPanel();
		contentPane.add(panelSeleccionarJugadores, BorderLayout.NORTH);
		panelSeleccionarJugadores.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panelNumJugadores = new JPanel();
		panelSeleccionarJugadores.add(panelNumJugadores);
		panelNumJugadores.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNumeroDeJugadores = new JLabel("Numero de Jugadores:");
		panelNumJugadores.add(lblNumeroDeJugadores);
		
		panelNumJugadores.add(getCbxNumJugadores());		
		
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int numJug = (Integer) getCbxNumJugadores().getSelectedItem();
				credenciales = new PanelCredenciales(numJug, btnSiguiente);
				contentPane.add(credenciales, BorderLayout.CENTER);
				contentPane.validate();
				contentPane.repaint();
				setEnabled(false);
				cbxNumJugadores.setEnabled(false);
			}
		});
		panelSeleccionarJugadores.add(btnActualizar);
	}
	
	
	private Integer[] numJugadores(int limite){
		Integer[] numJugadores = new Integer[limite];
		for(int i=0; i<numJugadores.length; i++)
			numJugadores[i] = (i+1);
		return numJugadores;
	}
	
	private JComboBox<Integer> getCbxNumJugadores(){
		if(cbxNumJugadores==null){
			cbxNumJugadores = new JComboBox<Integer>();
			cbxNumJugadores.setModel(new DefaultComboBoxModel<Integer>(numJugadores(6)));
		}
		return cbxNumJugadores;
	}
}

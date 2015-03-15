package es.uniovi.asw.interfaz;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import es.uniovi.asw.trivial.Jugador;

@SuppressWarnings("serial")
public class PanelCredenciales extends JPanel{

	private JPanel panelDatos;
	private JPanel panelNombre;
	private JPanel panelContrasenya;
	private JLabel lblNombreDeUsuario;
	private JLabel lblContrasenya;
	private JButton btnNext;
	private JTextField txtNombreDeUsuario;
	private JPasswordField pswContrasenya;
	
	private int index;
	public Jugador[] lista;
	private JButton btnSiguiente;
	
	
	
	public PanelCredenciales(int numJugadores, JButton btn){
		btnSiguiente = btn;
		index = 0;
		lista = new Jugador[numJugadores];
		this.setVisible(true);
		this.setLayout(new BorderLayout(0, 0));
		this.add(getBtnNext(), BorderLayout.SOUTH);
		this.add(getPanelDatos(), BorderLayout.CENTER);
	}
	
	
	private JPanel getPanelDatos(){
		if(panelDatos==null){
			panelDatos = new JPanel();
			panelDatos.setLayout(new GridLayout(0, 1, 0, 0));
			panelDatos.add(getPanelNombre());
			panelDatos.add(getPanelContrasenya());
		}
		return panelDatos;		
	}
	
	private JPanel getPanelNombre(){
		if(panelNombre==null){
			panelNombre = new JPanel();
			panelNombre.setLayout(new GridLayout(0, 1, 0, 0));
			panelNombre.add(getLblNombreDeUsuario());
			panelNombre.add(getTxtNombreDeUsuario());
		}
		return panelNombre;
	}
	
	private JPanel getPanelContrasenya(){
		if(panelContrasenya==null){
			panelContrasenya = new JPanel();
			panelContrasenya.setLayout(new GridLayout(0, 1, 0, 0));
			panelContrasenya.add(getLblContrasenya());
			panelContrasenya.add(getPswContrasenya());
		}
		return panelContrasenya;
	}
	
	private JLabel getLblNombreDeUsuario(){
		if(lblNombreDeUsuario == null){
			lblNombreDeUsuario = new JLabel("Nombre de Usuario:");
		}
		return lblNombreDeUsuario;		
	}
	
	private JLabel getLblContrasenya(){
		if(lblContrasenya == null){
			lblContrasenya = new JLabel("Contrasenya");
		}
		return lblContrasenya;		
	}
	
	private JButton getBtnNext(){
		if(btnNext == null){
			btnNext = new JButton("Siguiente");
			btnNext.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					actualizar();
				}
			});
		}
		return btnNext;		
	}
	
	private JTextField getTxtNombreDeUsuario(){
		if(txtNombreDeUsuario == null){
			txtNombreDeUsuario = new JTextField();
		}
		return txtNombreDeUsuario;
	}
	
	private JPasswordField getPswContrasenya(){
		if(pswContrasenya == null){
			pswContrasenya = new JPasswordField();
		}
		return pswContrasenya;
	}
	
	private void actualizar(){
		if(getTxtNombreDeUsuario().getText().equals("") || 
				getPswContrasenya().getPassword() == null ||
					getPswContrasenya().getPassword().length == 0)
			return;
		if (index<lista.length){
			guardarDatos();
			if(index==lista.length)
				ultimoPaso();
		}
	}
	
	private void guardarDatos(){
		lista[index] = new Jugador(
				getTxtNombreDeUsuario().getText(),
				new String(getPswContrasenya().getPassword()));
		index++;
		getTxtNombreDeUsuario().setText("");
		getPswContrasenya().setText("");
	}
	
	private void ultimoPaso(){
		JOptionPane.showMessageDialog(this, "Datos Actualizados");
		getTxtNombreDeUsuario().setText("");
		getTxtNombreDeUsuario().setEditable(false);
		getPswContrasenya().setText("");
		getPswContrasenya().setEditable(false);
		getBtnNext().setEnabled(false);
		btnSiguiente.setEnabled(true);
	}
}

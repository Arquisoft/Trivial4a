package es.uniovi.asw.componentesDeInterfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import es.uniovi.asw.interfaz.VentanaConfig;

@SuppressWarnings("serial")
public class Panel_Jugador extends JPanel{

	private VentanaConfig vConfiguracion;
	private JTextField txtJugador;
	private JButton btnBorrar;
	
	public Panel_Jugador(String nombre, VentanaConfig vc){
		this.vConfiguracion = vc;
		this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		this.add(getTxtJugador(nombre));
		this.add(getBtnBorrar());
	}
	
	private JTextField getTxtJugador(String nombre) {
		if (txtJugador == null) {
			txtJugador = new JTextField();
			txtJugador.setColumns(10);
			txtJugador.setText(nombre);
		}
		return txtJugador;
	}
	
	private JButton getBtnBorrar() {
		if (btnBorrar == null) {
			btnBorrar = new JButton("X");
			btnBorrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					vConfiguracion.configuracion.deletePlayer(txtJugador.getText());
					vConfiguracion.actualizarJugadores();
				}
			});
		}
		return btnBorrar;
	}
}

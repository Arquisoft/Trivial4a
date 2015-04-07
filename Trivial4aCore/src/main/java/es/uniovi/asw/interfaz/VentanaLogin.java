package es.uniovi.asw.interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class VentanaLogin extends JDialog {
	private JPanel panelCentro;
	private JPanel panelSur;
	private JButton btnAcceder;
	private JButton btnRegistrar;
	private JButton btnCancelar;
	private JPanel panelUsuario;
	private JPanel panelContrasenya;
	private JLabel lblUsuario;
	private JLabel lblContrasenya;
	private JTextField textUsuario;
	private JTextField txtContrasenya;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VentanaLogin dialog = new VentanaLogin();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VentanaLogin() {
		setBounds(100, 100, 313, 300);
		getContentPane().setLayout(new BorderLayout(0, 10));
		getContentPane().add(getPanelCentro());
		getContentPane().add(getPanelSur(), BorderLayout.SOUTH);
	}

	private JPanel getPanelCentro() {
		if (panelCentro == null) {
			panelCentro = new JPanel();
			panelCentro.setLayout(new GridLayout(2, 1, 0, 22));
			panelCentro.add(getPanelUsuario());
			panelCentro.add(getPanelContrasenya());
		}
		return panelCentro;
	}
	private JPanel getPanelSur() {
		if (panelSur == null) {
			panelSur = new JPanel();
			panelSur.setLayout(new GridLayout(0, 3, 5, 0));
			panelSur.add(getBtnAcceder());
			panelSur.add(getBtnRegistrar());
			panelSur.add(getBtnCancelar());
		}
		return panelSur;
	}
	private JButton getBtnAcceder() {
		if (btnAcceder == null) {
			btnAcceder = new JButton("Acceder");
			btnAcceder.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
		}
		return btnAcceder;
	}
	private JButton getBtnRegistrar() {
		if (btnRegistrar == null) {
			btnRegistrar = new JButton("Registrar");
			btnRegistrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				}
			});
		}
		return btnRegistrar;
	}
	private JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton("Cancelar");
			btnCancelar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					atras();
				}
			});
		}
		return btnCancelar;
	}
	
	private void atras(){
		this.dispose();
	}
	
	private JPanel getPanelUsuario() {
		if (panelUsuario == null) {
			panelUsuario = new JPanel();
			panelUsuario.setLayout(new GridLayout(0, 1, 0, 0));
			panelUsuario.add(getLblUsuario());
			panelUsuario.add(getTextUsuario());
		}
		return panelUsuario;
	}
	private JPanel getPanelContrasenya() {
		if (panelContrasenya == null) {
			panelContrasenya = new JPanel();
			panelContrasenya.setLayout(new GridLayout(0, 1, 0, 0));
			panelContrasenya.add(getLblContrasenya());
			panelContrasenya.add(getTextField_1());
		}
		return panelContrasenya;
	}
	private JLabel getLblUsuario() {
		if (lblUsuario == null) {
			lblUsuario = new JLabel("Usuario");
			lblUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblUsuario;
	}
	private JLabel getLblContrasenya() {
		if (lblContrasenya == null) {
			lblContrasenya = new JLabel("Contraseña");
			lblContrasenya.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblContrasenya;
	}
	private JTextField getTextUsuario() {
		if (textUsuario == null) {
			textUsuario = new JTextField();
			textUsuario.setColumns(10);
		}
		return textUsuario;
	}
	private JTextField getTextField_1() {
		if (txtContrasenya == null) {
			txtContrasenya = new JTextField();
			txtContrasenya.setColumns(10);
		}
		return txtContrasenya;
	}
}

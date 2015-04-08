package es.uniovi.asw.interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.UnknownHostException;

import javax.swing.JButton;

import es.uniovi.asw.trivial.model.User;
import es.uniovi.asw.trivial.persistence.MongoDB;

public class VentanaRegister extends JFrame {

	private JPanel contentPane;
	private JTextField txtUser;
	private JTextField txtPass;
	private JLabel lblPass;
	private JLabel lblRegistroDeUsuario;
	private MongoDB mdb= new MongoDB();
	private JOptionPane options;
	private JFrame ventana;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaRegister frame = new VentanaRegister();
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
	public VentanaRegister() {
		ventana=this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 308, 226);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtUser = new JTextField();
		txtUser.setBounds(127, 81, 86, 20);
		contentPane.add(txtUser);
		txtUser.setColumns(10);
		
		txtPass = new JTextField();
		txtPass.setBounds(127, 112, 86, 20);
		contentPane.add(txtPass);
		txtPass.setColumns(10);
		
		JLabel lblUser = new JLabel("Usuario: ");
		lblUser.setBounds(47, 81, 86, 20);
		contentPane.add(lblUser);
		
		lblPass = new JLabel("Password:");
		lblPass.setBounds(47, 112, 86, 20);
		contentPane.add(lblPass);
		
		lblRegistroDeUsuario = new JLabel("Registro de usuario");
		lblRegistroDeUsuario.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblRegistroDeUsuario.setBounds(47, 11, 200, 50);
		contentPane.add(lblRegistroDeUsuario);
		
		JButton btOk = new JButton("OK");
		btOk.setBounds(95, 154, 89, 23);
		btOk.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(!isRegistered(txtUser.getText())){
					try {
						mdb.guardarUsuario(txtUser.getText(), txtPass.getText());
						dispose();
					} catch (UnknownHostException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else{
					options.showMessageDialog(ventana,"El nombre de usuario no está disponible");
				}
				
			}
		});
		contentPane.add(btOk);
	}
	
	private boolean isRegistered(String user){
		try {
			User usuario = mdb.getUser(user);
			if(usuario!=null){
				return true;
			}
			return false;
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
}

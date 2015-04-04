package es.uniovi.asw.interfaz;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.UnknownHostException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import es.uniovi.asw.trivial.model.User;
import es.uniovi.asw.trivial.persistence.MongoDB;

public class VentanaLogin extends JFrame {

	private JPanel contentPane;
	private JTextField txtUser;
	private JTextField txtPass;
	private MongoDB mdb= new MongoDB();
	private JOptionPane options;
	private static VentanaConfig padre;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaLogin frame = new VentanaLogin(padre);
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
	public VentanaLogin(final VentanaConfig padre) {
		this.padre=padre;
		final JFrame frame= this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 301, 236);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUser = new JLabel("User: ");
		lblUser.setBounds(54, 69, 46, 14);
		contentPane.add(lblUser);
		
		JLabel lblNewLabel = new JLabel("Password:");
		lblNewLabel.setBounds(34, 115, 66, 14);
		contentPane.add(lblNewLabel);
		
		txtUser = new JTextField();
		txtUser.setBounds(110, 66, 86, 20);
		contentPane.add(txtUser);
		txtUser.setColumns(10);
		
		txtPass = new JTextField();
		txtPass.setBounds(110, 112, 86, 20);
		contentPane.add(txtPass);
		txtPass.setColumns(10);
		
		options= new JOptionPane();
		JButton btOk = new JButton("OK");
		btOk.setBounds(90, 164, 89, 23);
		btOk.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(isLogued(txtUser.getText())){
					dispose();
				padre.setPlayers(txtUser.getText());
				}else{
				options.showMessageDialog(frame,"Error de autenticación de usuario");
				}
			}
		});
		contentPane.add(btOk);
	}
	public boolean isLogued(String user){
		try {
			User usuario=mdb.getUser(user);
			System.out.println(usuario.toString());
			if(usuario!=null&&usuario.getContrasena().compareTo(txtPass.getText())==0)
				return true;
				return false;
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	
	}
}

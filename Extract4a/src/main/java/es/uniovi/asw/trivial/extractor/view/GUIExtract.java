package es.uniovi.asw.trivial.extractor.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import java.awt.BorderLayout;
import javax.swing.JTextPane;

@SuppressWarnings("serial")
public class GUIExtract extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIExtract frame = new GUIExtract();
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
	
	JCheckBox chckbxWriteOutputJson;
	public GUIExtract() {
		setTitle("GUI - Extract");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 400, 150);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JButton btnNewButton = new JButton("Run Extract");
		panel.add(btnNewButton);
		
		chckbxWriteOutputJson = new JCheckBox("Write output json files");
		panel.add(chckbxWriteOutputJson);
		
		JButton btnNewButton_1 = new JButton("Drop database");
		panel.add(btnNewButton_1);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JTextPane txtpnInputMustBe = new JTextPane();
		txtpnInputMustBe.setEditable(false);
		txtpnInputMustBe.setText("Input files must be inside of input folder.\r\nFiles must match this pattern: [Category.gift].");
		panel_1.add(txtpnInputMustBe);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				drop();
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				run();
			}
		});
	}

	protected void drop() {
		String[] args = {"clean"};
		Main.main(args);
		dispose();
		
	}

	protected void run() {
		String[] args = {};
		if(chckbxWriteOutputJson.isSelected()){
			args = new String[1];
			args[0]="output";
		}
		Main.main(args);
		dispose();
		
	}

}

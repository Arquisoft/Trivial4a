package es.uniovi.asw.interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;

import es.uniovi.asw.trivial.model.Pregunta;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Random;

/**
 * Aqui se le mostrara al jugador
 * una pregunta y debera responderla
 * @author Santiago
 *
 */
@SuppressWarnings("serial")
public class VentanaPreguntaRespuesta extends JDialog {
	private PanelRespuesta[] panelesRespuesta;
	private Pregunta pregunta;
	private String respElegida;
	
	private JScrollPane scrPregunta;
	private JTextArea txtrPregunta;
	private JPanel panelCentro;
	private JScrollPane scrRespuestas;
	private JPanel panelRespuestas;
	private JPanel panelSur;
	private JButton btnAceptar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			VentanaPreguntaRespuesta dialog = new VentanaPreguntaRespuesta(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public VentanaPreguntaRespuesta(Pregunta p) {
		this.pregunta = p;
		setBounds(100, 100, 450, 357);
		getContentPane().setLayout(new BorderLayout(0, 0));
		getContentPane().add(getPanelCentro());
		getContentPane().add(getPanelSur(), BorderLayout.SOUTH);
	}
	private JScrollPane getScrPregunta() {
		if (scrPregunta == null) {
			scrPregunta = new JScrollPane();
			scrPregunta.setViewportView(getTxtrPregunta());
		}
		return scrPregunta;
	}
	private JTextArea getTxtrPregunta() {
		if (txtrPregunta == null) {
			txtrPregunta = new JTextArea(pregunta.getPregunta());
			txtrPregunta.setLineWrap(true);
			txtrPregunta.setWrapStyleWord(true);
		}
		return txtrPregunta;
	}
	
	private JPanel getPanelCentro() {
		if (panelCentro == null) {
			panelCentro = new JPanel();
			panelCentro.setLayout(new BorderLayout(0, 0));
			panelCentro.add(getScrPregunta(), BorderLayout.NORTH);
			panelCentro.add(getScrRespuestas(), BorderLayout.CENTER);
		}
		return panelCentro;
	}
	private JScrollPane getScrRespuestas() {
		if (scrRespuestas == null) {
			scrRespuestas = new JScrollPane();
			scrRespuestas.setViewportView(getPanelRespuestas());
		}
		return scrRespuestas;
	}
	private JPanel getPanelRespuestas() {
		if (panelRespuestas == null) {
			panelRespuestas = new JPanel();
			panelRespuestas.setLayout(new GridLayout(0, 1, 0, 20));
			agregarRespuestas();
			actualizarPanelRespuestas();
		}
		return panelRespuestas;
	}
	
	/**
	 * Actualiza el panel de respuestas
	 */
	public void actualizarPanelRespuestas(){
		this.panelRespuestas.validate();
		this.panelRespuestas.repaint();
	}
	
	/**
	 * Agrega paneles respuesta al panel de las respuestas
	 */
	private void agregarRespuestas(){
		String[] respuestas = juntarRespuestas();
		this.panelesRespuesta = new PanelRespuesta[respuestas.length];
		for(int i=0; i<respuestas.length; i++){
			this.panelesRespuesta[i] = new PanelRespuesta(respuestas[i],this);
			panelRespuestas.add(this.panelesRespuesta[i]);
		}
	}
	
	/**
	 * Junta las respuestas y las ordena de forma aleatoria
	 * @return todas las respuestas
	 */
	private String[] juntarRespuestas(){
		Random r = new Random();
		String[] rCor = this.pregunta.getRespuestasCorrectas();
		String[] rInc = this.pregunta.getRespuestasIncorrectas();
		String[] respuestas = new String[rCor.length + rInc.length];
		System.arraycopy(rCor, 0, respuestas, 0, rCor.length);
		System.arraycopy(rInc, 0, respuestas, rCor.length, rInc.length);
		int numIntercambios = 10;
		
		while(numIntercambios>0){
			int i1 = r.nextInt(respuestas.length);
			int i2 = r.nextInt(respuestas.length);
			if(i1!=i2){
				String temp = respuestas[i1];
				respuestas[i1] = respuestas[i2];
				respuestas[i2] = temp;
				numIntercambios--;
			}			
		}
		return respuestas;
	}
	
	
	private JPanel getPanelSur() {
		if (panelSur == null) {
			panelSur = new JPanel();
			FlowLayout flowLayout = (FlowLayout) panelSur.getLayout();
			flowLayout.setAlignment(FlowLayout.RIGHT);
			panelSur.add(getBtnAceptar());
		}
		return panelSur;
	}
	private JButton getBtnAceptar() {
		if (btnAceptar == null) {
			btnAceptar = new JButton("Aceptar");
			btnAceptar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if(respElegida!=null)
						atras();
					else
						JOptionPane.showMessageDialog(get(), 
								"¡No has elegido ninguna respuesta!", 
								"Atencion", JOptionPane.WARNING_MESSAGE);
				}
			});
		}
		return btnAceptar;
	}
	
	/**
	 * @return Esta clase
	 */
	private VentanaPreguntaRespuesta get(){
		return this;
	}
	
	/**
	 * Cierra esta ventana
	 */
	private void atras(){
		this.dispose();
	}
	
	/**
	 * @return La respuesta elegida
	 */
	public String getRespElegida(){
		return this.respElegida;
	}
	
	/**
	 * Como solo hay una unica respuesta, al seleccionar una,
	 * si ya existe alguna/s seleccionada/s se rechazan
	 * @param respuesta elegida
	 */
	private void actualizarCheckRespuestas(String respuesta){
		for(int i=0; i<this.panelesRespuesta.length; i++){
			if(!this.panelesRespuesta[i].getRespuesta().equals(respuesta))
				panelesRespuesta[i].getChckbxMarcada().setSelected(false);
			else
				this.respElegida = panelesRespuesta[i].getRespuesta();
		}
		actualizarPanelRespuestas();
	}
	
	
	/**
	 * Almancena una unica respuesta y comprueba
	 * si se ha marcado como verdadera
	 * @author Santiago
	 */
	class PanelRespuesta extends JPanel{
		
		private String respuesta;
		private JTextArea txtrRespuesta;
		private JCheckBox chckbxMarcada;
		private VentanaPreguntaRespuesta vpr;
		
		public PanelRespuesta(String respuesta, VentanaPreguntaRespuesta vpr){
			this.vpr = vpr;
			this.respuesta = respuesta;
			this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
			this.add(getTxtrRespuesta(respuesta));
			this.add(getChckbxMarcada());
		}
		
		public String getRespuesta(){
			return respuesta;
		}
		
		private JTextArea getTxtrRespuesta(String respuesta) {
			if (txtrRespuesta == null) {
				txtrRespuesta = new JTextArea();
				txtrRespuesta.setText(respuesta);
			}
			return txtrRespuesta;
		}
		protected JCheckBox getChckbxMarcada() {
			if (chckbxMarcada == null) {
				chckbxMarcada = new JCheckBox("");
				chckbxMarcada.addItemListener(new ItemListener() {
		            public void itemStateChanged(ItemEvent e) {
		            	if(e.getStateChange() == ItemEvent.SELECTED)
		            		notificar();
		            }
		        });
			}
			return chckbxMarcada;
		}
		
		/**
		 * Notifica a la clase VentanaPreguntaRespuesta para
		 * que desmarque las otras respuestas (ya que solo
		 * puede haber una marcada)
		 */
		private void notificar(){
			vpr.actualizarCheckRespuestas(respuesta);
		}
	}
}

/**
 * 
 */
package views;

import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

/**
 * Programa para calcular o indice de Massa Corporal
 * 
 * @author Rafhael Honda da Silva
 * @author José Roberto Felix da Silva
 *
 */
public class IMCView {
	
	private JFrame f;

	private JLabel labelTitulo;
	
	private JLabel labelNome;
	
	private JFormattedTextField textNome;
	
	private JLabel labelPeso;
	private JFormattedTextField textPeso;
	
	private JButton buttonCalcular;
	private JButton buttonRelatorio;

	private JLabel labelAltura;
	private JFormattedTextField textAltura;
	
	private JLabel labelGenero;
	private JRadioButton radioSexoMasculino;
	private JRadioButton radioSexoFeminino;
	private ButtonGroup buttonGroup;	
	
	JLabel labelImagem;
	JLabel labelResultado;
	
	int posY;
	
	public JFrame getF() {
		return f;
	}

	public void setF(JFrame f) {
		this.f = f;
	}

	public JLabel getLabelTitulo() {
		return labelTitulo;
	}

	public void setLabelTitulo(JLabel labelTitulo) {
		this.labelTitulo = labelTitulo;
	}
	
	public JLabel getLabelNome() {
		return labelNome;
	}

	public void setLabelNome(JLabel labelNome) {
		this.labelNome = labelNome;
	}

	public JFormattedTextField getTextNome() {
		return textNome;
	}

	public void setTextNome(JFormattedTextField textNome) {
		this.textNome = textNome;
	}

	public JLabel getLabelPeso() {
		return labelPeso;
	}

	public void setLabelPeso(JLabel labelPeso) {
		this.labelPeso = labelPeso;
	}

	public JFormattedTextField getTextPeso() {
		return textPeso;
	}

	public void setTextPeso(JFormattedTextField textPeso) {
		this.textPeso = textPeso;
	}

	public JButton getButtonCalcular() {
		return buttonCalcular;
	}

	public void setButtonCalcular(JButton buttonCalcular) {
		this.buttonCalcular = buttonCalcular;
	}
	
	public JButton getButtonRelatorio() {
		return buttonRelatorio;
	}

	public void setButtonRelatorio(JButton buttonRelatorio) {
		this.buttonRelatorio = buttonRelatorio;
	}

	public JLabel getLabelAltura() {
		return labelAltura;
	}

	public void setLabelAltura(JLabel labelAltura) {
		this.labelAltura = labelAltura;
	}

	public JFormattedTextField getTextAltura() {
		return textAltura;
	}

	public void setTextAltura(JFormattedTextField textAltura) {
		this.textAltura = textAltura;
	}

	public JLabel getLabelGenero() {
		return labelGenero;
	}

	public void setLabelGenero(JLabel labelGenero) {
		this.labelGenero = labelGenero;
	}

	public JRadioButton getRadioSexoMasculino() {
		return radioSexoMasculino;
	}

	public void setRadioSexoMasculino(JRadioButton radioSexoMasculino) {
		this.radioSexoMasculino = radioSexoMasculino;
	}

	public JRadioButton getRadioSexoFeminino() {
		return radioSexoFeminino;
	}

	public void setRadioSexoFeminino(JRadioButton radioSexoFeminino) {
		this.radioSexoFeminino = radioSexoFeminino;
	}

	public ButtonGroup getButtonGroup() {
		return buttonGroup;
	}

	public void setButtonGroup(ButtonGroup buttonGroup) {
		this.buttonGroup = buttonGroup;
	}

	public JLabel getLabelImagem() {
		return labelImagem;
	}

	public void setLabelImagem(JLabel labelImagem) {
		this.labelImagem = labelImagem;
	}

	public JLabel getLabelResultado() {
		return labelResultado;
	}

	public void setLabelResultado(JLabel labelResultado) {
		this.labelResultado = labelResultado;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	/**
	 * @param args
	 */
	public IMCView() {
		// TODO Auto-generated method stub
		
		posY = 10;		
		
		f = new JFrame(); // cria um painel
		f.setSize(530, 600);  // seta o tamanho do painel
		f.setResizable(false);	
				
		labelTitulo = new JLabel("Calculo de IMC");
		labelTitulo.setFont(new Font("Arial", 3, 30));
		labelTitulo.setBounds(130, posY, 300, 30);
		f.add(labelTitulo);
		
		posY+= 50;
		
		labelNome = new JLabel("Nome: ");		
		labelNome.setBounds(10, posY, 300, 30);
		f.add(labelNome);
		
		textNome = new JFormattedTextField();
		textNome.setBounds(130, posY, 180, 30);
		textNome.setEditable(true);
		f.add(textNome);
		
		buttonCalcular = new JButton("Calcular");
		buttonCalcular.setBounds(320, posY, 150, 30);
		f.add(buttonCalcular);
		
		posY+= 40;

		labelPeso = new JLabel("Informe o peso: ");
		labelPeso.setBounds(10, posY, 200, 30);
		f.add(labelPeso);

		textPeso = new JFormattedTextField();
		textPeso.setBounds(130, posY, 180, 30);
		textPeso.setEditable(true);
		f.add(textPeso);
		
		buttonRelatorio = new JButton("Relatório");
		buttonRelatorio.setBounds(320, posY, 150, 30);
		f.add(buttonRelatorio);
		
		posY+= 40;
		
		labelAltura = new JLabel("Informe altura :");
		labelAltura.setBounds(10, posY, 200, 30);
		f.add(labelAltura);

		textAltura = new JFormattedTextField();
		textAltura.setBounds(130, posY, 180, 30);
		textAltura.setEditable(true);
		f.add(textAltura);
		
		posY+= 40;
		
		labelGenero = new JLabel("Sexo :");
		labelGenero.setBounds(10, posY, 200, 30);
		f.add(labelGenero);
		
		radioSexoMasculino = new JRadioButton("Masculino");		
		radioSexoMasculino.setBounds(130, posY, 100, 30);
		radioSexoMasculino.setSelected(true);		

		radioSexoFeminino = new JRadioButton("Feminino");
		radioSexoFeminino.setBounds(230, posY, 100, 30);		
		
		buttonGroup = new ButtonGroup();
		buttonGroup.add(radioSexoMasculino);
		buttonGroup.add(radioSexoFeminino);
		
		f.add(radioSexoMasculino);
		f.add(radioSexoFeminino);
		
		//posY+= 0;
		
		labelImagem = new JLabel();
		labelImagem.setBounds(10, posY, 635, 376);
		f.add(labelImagem);
		
		posY+= 340;

		labelResultado = new JLabel();
		labelResultado.setBounds(10, posY, 200, 30);
		f.add(labelResultado);		
		
		f.setLayout(null);
		f.setVisible(true);
	}
}


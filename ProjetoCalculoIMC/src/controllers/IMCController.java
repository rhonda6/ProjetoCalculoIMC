/**
 * 
 */
package controllers;

import java.text.DecimalFormat;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.text.AbstractDocument;

import models.IMC;
import util.Util;
import views.IMCView;

/**
 * Programa para calcular o indice de Massa Corporal
 * 
 * @author Rafhael Honda da Silva
 * @author José Roberto Felix da Silva
 *
 */
public class IMCController {

	private IMC model;
	private IMCView view;

	/**
	 * 
	 */
	public IMCController(IMC m, IMCView v) {
		model = m;
		view = v;		
		
	}

	public void initController() {

		try {
			((AbstractDocument) view.getTextPeso().getDocument()).setDocumentFilter(Util.somenteNumeros());
			((AbstractDocument) view.getTextAltura().getDocument()).setDocumentFilter(Util.somenteNumeros());
			
			view.getLabelImagem().setIcon(Util.obtemImagemIcon("image01.png"));
			
			view.getButtonCalcular().addActionListener(e -> buttonCalcularListener());
			view.getButtonRelatorio().addActionListener(e -> buttonRelatorioListener());
			
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	private void buttonCalcularListener() {
		
		double peso, altura, resultado;
		String nome;

		nome = view.getTextNome().getText();
		peso = Util.tryParseDouble(view.getTextPeso().getText());
		altura = Util.tryParseDouble(view.getTextAltura().getText());

		if (nome.trim().equals("")) {
			JOptionPane.showMessageDialog(null, "Preencha o campo nome");
			return;
		} else if (peso == 0) {
			JOptionPane.showMessageDialog(null, "Preencha o campo  peso");
			return;
		} else if (altura == 0) {
			JOptionPane.showMessageDialog(null, "Preencha o campo  altura");
			return;
		} else {

			model.setPeso(peso);
			model.setAltura(altura);
			resultado = model.calcular();

			var genero = view.getRadioSexoMasculino().isSelected() ? Util.genero.masculino : Util.genero.feminino;

			ImageIcon image = Util.exibeImagemIMC(genero, resultado);
			view.getLabelImagem().setIcon(image);
			
			DecimalFormat df = new DecimalFormat("#,###.00");

			String mensagem = model.mensagem(genero, resultado);
			view.getLabelResultado().setText(mensagem + " IMC: " + df.format(resultado));
		}

	}

	private void buttonRelatorioListener() {
		
		double peso, altura;
		String nome;
		boolean resultado;

		nome = view.getTextNome().getText();
		peso = Util.tryParseDouble(view.getTextPeso().getText());
		altura = Util.tryParseDouble(view.getTextAltura().getText());

		if (nome.trim().equals("")) {
			JOptionPane.showMessageDialog(null, "Preencha o campo nome");
			return;
		} else if (peso == 0) {
			JOptionPane.showMessageDialog(null, "Preencha o campo  peso");
			return;
		} else if (altura == 0) {
			JOptionPane.showMessageDialog(null, "Preencha o campo  altura");
			return;
		} else {
			model.setNome(nome);
			model.setPeso(peso);
			model.setAltura(altura);

			var genero = view.getRadioSexoMasculino().isSelected() ? Util.genero.masculino : Util.genero.feminino;
			resultado = Util.gerarRelatorio(model, genero);
			if (resultado) {
				JOptionPane.showMessageDialog(null, "Relatório gerado com sucesso.");
				
			} else {
				JOptionPane.showMessageDialog(null, "Erro: Não foi possivel gerar o relatório.");
			}
		}
	}
}

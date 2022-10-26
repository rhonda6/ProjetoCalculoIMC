/**
 * 
 */
package models;

import util.Util.genero;

/**
 * Programa para calcular o indice de Massa Corporal
 * 
 * @author Rafhael Honda da Silva
 * @author José Roberto Felix da Silva
 *
 */
public class IMC {

	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	private double altura;

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	private double peso;

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	/**
	 * 
	 */
	public IMC() {
		// TODO Auto-generated constructor stub
	}

	public double calcular() {

		return peso / Math.pow(altura, 2);

	}
	
	public String mensagem(genero g, double valor) {
		String resultado = "";

		switch (g) {
		case masculino:

			if (valor < 19.99) {
				resultado = "Abaixo do Normal";
			} else if (valor >= 20 && valor <= 24.99) {

				resultado = "Normal";
			} else if (valor >= 25 && valor <= 29.99) {

				resultado = "Obesidade leve";
			} else if (valor >= 30 && valor <= 39.99) {
				resultado = "Obesidade Moderada";
			} else if (valor >= 40) {

				resultado = "Obesidade Morbida";
			}

			break;
		case feminino:

			if (valor < 19) {
				resultado = "Abaixo do Normal";
			} else if (valor >= 19 && valor <= 23.99) {
				resultado = "Normal";
			} else if (valor >= 24 && valor <= 28.99) {

				resultado = "Obesidade leve";
			} else if (valor >= 29 && valor <= 38.99) {
				resultado = "Obesidade Moderada";
			} else if (valor >= 39) {
				resultado = "Obesidade Morbida";
			}

			break;
		default:
			break;
		}

		return resultado;
	}
}
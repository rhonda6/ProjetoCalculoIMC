package app;

import controllers.IMCController;
import models.IMC;
import views.IMCView;

public class App {
	
	/**
	 * Programa para calcular o indice de Massa Corporal
	 * 
	 * @author Rafhael Honda da Silva
	 * @author José Roberto Felix da Silva
	 *
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		IMC m = new IMC();
		IMCView v = new IMCView();
		IMCController c = new IMCController(m, v);
		c.initController();

	}

}

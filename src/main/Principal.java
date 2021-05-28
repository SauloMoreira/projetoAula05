package main;

import controllers.ClienteController;

public class Principal {

	public static void main(String[] args) {
		
		ClienteController controller = new ClienteController();
		controller.cadastrarCliente();

	}

}

package controllers;

import javax.swing.JOptionPane;

import entities.Cliente;
import repositories.ClienteRepositoryXML;
import repositories.ClienteRepositoyJSON;

public class ClienteController {

	public void cadastrarCliente() {
		try {
			Cliente cliente = new Cliente();
			cliente.setIdCliente(Integer.parseInt(JOptionPane.showInputDialog("Id do Cliente")));
			cliente.setNome(JOptionPane.showInputDialog("nome do cliente"));
			cliente.setEmail(JOptionPane.showInputDialog("email do cliente"));
			cliente.setCpf(JOptionPane.showInputDialog("cpf do cliente"));

			String opcao = JOptionPane.showInputDialog("Informe JSON ou XML:");
			switch (opcao) {
			case "XML":
				ClienteRepositoryXML xml = new ClienteRepositoryXML();
				xml.exportarDados(cliente);
				JOptionPane.showMessageDialog(null, "Arquivo XML gerado com sucesso!");
				break;
			case "JSON":
				ClienteRepositoyJSON json = new ClienteRepositoyJSON();
				json.exportarDados(cliente);
				JOptionPane.showMessageDialog(null, "Arquivo JSON gerado com sucesso!");
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opcõ invalida");
				break;
			}

		} catch (Exception e) {
			System.out.println("\nErro: " + e.getMessage());
			e.printStackTrace();
		}
	}

}

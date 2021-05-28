package repositories;

import java.io.FileWriter;
import java.util.HashMap;

import org.json.simple.JSONObject;

import abstrations.ClienteRepository;
import entities.Cliente;

public class ClienteRepositoyJSON extends ClienteRepository {

	@Override
	public void exportarDados(Cliente cliente) throws Exception {

		//Mapa <CHAVE/VALOR>
		HashMap<String, Object> mapa = new HashMap<String, Object>();

		//escrevendo os campos no documento JSON..
		mapa.put("idCliente", cliente.getIdCliente());
		mapa.put("nome", cliente.getNome());
		mapa.put("email", cliente.getEmail());
		mapa.put("cpf", cliente.getCpf());
		
		//convertendo o objeto 'mapa' para JSON..
		JSONObject json = new JSONObject(mapa);
		
		//gravar em arquivo..
		FileWriter fileWriter = new FileWriter(PATH + "cliente.json");
		fileWriter.write(json.toJSONString());
		
		fileWriter.flush(); //salvar
		fileWriter.close(); //fechar
	}

}



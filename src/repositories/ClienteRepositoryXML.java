package repositories;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import abstrations.ClienteRepository;
import entities.Cliente;

public class ClienteRepositoryXML extends ClienteRepository {

	@Override
	public void exportarDados(Cliente cliente) throws Exception {

		// iniciando a escrita do documento XML..
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document document = builder.newDocument();

		// criando o nó raiz do documento XML <CLIENTE>
		Element root = document.createElement("CLIENTE");
		document.appendChild(root);

		// criando um subnós do documento XML
		Element idCliente = document.createElement("IDCLIENTE");
		idCliente.setTextContent(cliente.getIdCliente().toString());
		root.appendChild(idCliente);

		Element nome = document.createElement("NOME");
		nome.setTextContent(cliente.getNome());
		root.appendChild(nome);

		Element email = document.createElement("EMAIL");
		email.setTextContent(cliente.getEmail());
		root.appendChild(email);

		Element cpf = document.createElement("CPF");
		cpf.setTextContent(cliente.getCpf());
		root.appendChild(cpf);

		// finalizando o documento XML e grava-lo em um arquivo..
		TransformerFactory transformerFactory = TransformerFactory.newInstance();
		Transformer transformer = transformerFactory.newTransformer();
		DOMSource domSource = new DOMSource(document);

		StreamResult stream = new StreamResult(new File(PATH + "cliente.xml"));
		transformer.transform(domSource, stream); // arquivo XML é gravado
	}



	}



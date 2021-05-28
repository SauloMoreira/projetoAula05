package abstrations;

import entities.Cliente;

public abstract class ClienteRepository {
	public static final String  PATH = "c:\\temp\\";
	public abstract void exportarDados(Cliente cliente) throws Exception;
}

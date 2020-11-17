import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class ServidorCriptografia {
	public ServidorCriptografia() {
		try {
			Criptografia obj = new CriptografiaImpl();
			System.setProperty("java.rmi.server.hostname", "localhost");
			LocateRegistry.createRegistry(1099);
			Naming.rebind("//localhost/criptoService", obj);
			System.out.println("Servidor a disposição para execução");
		}
		catch (Exception e) {
			System.err.println("Falha ao iniciar o Servidor" + e);
		}
	}
	public static void main (String[] args) {
		new ServidorCriptografia();
	}

}
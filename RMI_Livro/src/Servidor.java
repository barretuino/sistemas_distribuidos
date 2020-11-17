import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Exemplo de Servidor RMI
 * @author Paulo Barreto
 * @data 17/11/2020
 */

public class Servidor extends UnicastRemoteObject implements Interface{
	
	private static final long serialVersionUID = 1L;
	
	public static int valor = 10;
	
	protected Servidor() throws RemoteException {
		super(0);
	}

	public static void main(String[] args) {
		try {
			System.setProperty("java.rmi.server.hostname", "localhost");
			LocateRegistry.createRegistry(1099);
			Naming.rebind("//localhost/obj", new Servidor());
			System.out.println("Servidor a disposição para execução");
		}catch(Exception erro) {
			System.err.println("Falha ao iniciar o Servidor " + erro);
		}
	}
	
	@Override
	public String converterParaMaisculo(String palavra) throws Exception {
		debug();
		return palavra.toUpperCase();
	}

	@Override
	public double calculaValores(double valor) throws Exception {
		debug();
		return valor * 2;
	}
	
	private void debug() {
		//Exibirá o momento em que um Client invoca esse método de forma remota
		System.out.println("Execução solicitada: " + new Date(System.currentTimeMillis()));
	}
}
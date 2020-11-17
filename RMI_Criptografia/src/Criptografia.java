import java.rmi.Remote;
import java.rmi.RemoteException;

/** 
 * Exemplo de Servi�o RMI com Criptografia
 * Baseado na produ��o de Ed�lson da Costa do Nascimento
 * @author Paulo Barreto
 * @data 17/11/2020
 */

public interface Criptografia extends Remote{
	public String criptografar(String texto) throws RemoteException;
	public String descriptografar (String texto) throws RemoteException;
}

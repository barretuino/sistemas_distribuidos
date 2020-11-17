import java.rmi.Remote;
import java.rmi.RemoteException;

/** 
 * Exemplo de Serviço RMI com Criptografia
 * Baseado na produção de Edílson da Costa do Nascimento
 * @author Paulo Barreto
 * @data 17/11/2020
 */

public interface Criptografia extends Remote{
	public String criptografar(String texto) throws RemoteException;
	public String descriptografar (String texto) throws RemoteException;
}

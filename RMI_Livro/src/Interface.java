import java.rmi.Remote;

/**
 * Exemplo de Interface RMI
 * @author Paulo Barreto
 * @data 17/11/2020
 */
public interface Interface extends Remote{
	/**
	 * Atributo est�tico de valor
	 */
	static int valor = 10;
	/**
	 * Converter os textos para ma�sculo
	 * @param palavra
	 * @return
	 * @throws Exception
	 */
	public String  converterParaMaisculo(String palavra) throws Exception;
	/**
	 * 
	 * @param valor
	 * @return
	 * @throws Exception
	 */
	public double calculaValores(double valor) throws Exception;
}
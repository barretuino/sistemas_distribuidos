import java.rmi.Naming;
import java.util.Scanner;

/**
 * Cliente RMI
 * @author Paulo Barreto
 * @data 17/11/2020
 */

public class Cliente {
	public static void main(String[] args) throws Exception {
		Interface objetoRemoto = (Interface) Naming.lookup("//localhost/obj");
		
		Scanner digito = new Scanner(System.in);
		
		System.out.println(objetoRemoto.converterParaMaisculo(digito.nextLine()));
		System.out.println(objetoRemoto.calculaValores(digito.nextDouble()));
		System.out.println(objetoRemoto.valor);
		digito.close();
	}
}

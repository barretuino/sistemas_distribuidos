package br.barretuino.tcp;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Exemplo de uso de Socket
 * @author Paulo Barreto
 * @date 31/12/2017
 */

public class ExemploSocket {
	public static void main(String[] args) {
		try {
			// Defini��o da inst�ncia de um ServerSocket - Porta de comunica��o 8200
			ServerSocket server = new ServerSocket(8200);
			
			/* Objeto Socket, o qual ir� tratar da comunica��o com o cliente, 
			assim que um pedido de conex�o chegar ao servidor e a conex�o for aceita: */
			Socket cliente = server.accept();
			System.out.println("Chegou uma chamada. Conex�o aceita.");
			
			// Obtendo o endereco IP
			byte[] endereco = InetAddress.getByName("localhost").getAddress();
			System.out.println(endereco[0] + "." + endereco[1] + "." + endereco[2] + "." + endereco[3]);
			
			System.out.println("Endere�o: " + InetAddress.getByName("localhost").getHostAddress());
			
			// Definindo o endereco IP
			byte[] addr = {127,0,0,1};
			System.out.println(InetAddress.getByAddress(addr).getHostName());
			
			server.close();
			cliente.close();
			
		}catch (IOException erro) {
			erro.printStackTrace();
		}		
	}
}
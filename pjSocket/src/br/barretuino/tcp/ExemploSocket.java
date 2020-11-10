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
			// Definição da instância de um ServerSocket - Porta de comunicação 8200
			ServerSocket server = new ServerSocket(8200);
			
			/* Objeto Socket, o qual irá tratar da comunicação com o cliente, 
			assim que um pedido de conexão chegar ao servidor e a conexão for aceita: */
			Socket cliente = server.accept();
			System.out.println("Chegou uma chamada. Conexão aceita.");
			
			// Obtendo o endereco IP
			byte[] endereco = InetAddress.getByName("localhost").getAddress();
			System.out.println(endereco[0] + "." + endereco[1] + "." + endereco[2] + "." + endereco[3]);
			
			System.out.println("Endereço: " + InetAddress.getByName("localhost").getHostAddress());
			
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
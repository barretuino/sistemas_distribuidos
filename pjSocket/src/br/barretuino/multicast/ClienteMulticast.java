package br.barretuino.multicast;

import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

/**
 * Cliente multicast que aguarda mensagens do servidor
 * @author Paulo Barreto
 * @date 01/01/2018
 */

public class ClienteMulticast {

	public static void main(String[] args) {

		while(true) {
			try {       
				MulticastSocket mcs = new MulticastSocket(8200);
				InetAddress grp = InetAddress.getByName("239.0.0.1");
				mcs.joinGroup(grp);
				byte rec[] = new byte[256];
				DatagramPacket pkg = new DatagramPacket(rec, rec.length);
				mcs.receive(pkg);
				String data = new String(pkg.getData());
				System.out.println("Dados recebidos:" + data);
				mcs.close();
			}
			catch(Exception e) {
				System.out.println("Erro: " + e.getMessage()); 
			} 
		}
	}
}
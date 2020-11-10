package br.barretuino.tcp;

import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.Date;

import javax.swing.JOptionPane;

/**
 * Cliente TCP Básico
 * @author Paulo Barreto
 * @date 31/12/2017
 */

public class ClienteTCPBasico {
	public static void main(String[] args) {
		try {
			Socket cliente = new Socket("localhost", 8200);
			ObjectInputStream entrada = new ObjectInputStream(cliente.getInputStream());
			Date data_atual = (Date)entrada.readObject();
			JOptionPane.showMessageDialog(null,"Data recebida do servidor:" + data_atual.toString());
			entrada.close();
			cliente.close();
			System.out.println("Conexão encerrada");
		}catch(Exception erro) {
			System.out.println("Erro --> " + erro.getMessage());
		}
	}
}
package br.barretuino.tcp;

import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * Servidor TCP B�sico
 * @author Paulo Barreto
 * @date 31/12/2017
 */

public class ServidorTCPBasico {
	  public static void main(String[] args) {
	    try {
	      // Instancia o ServerSocket ouvindo a porta 8200
	      ServerSocket servidor = new ServerSocket(8200);
	      System.out.println("Servidor ouvindo a porta 8200");
	      while(true) {
	        // o m�todo accept() bloqueia a execu��o at� que
	        // o servidor receba um pedido de conex�o
	        Socket cliente = servidor.accept();
	        System.out.println("Cliente conectado: " + cliente.getInetAddress().getHostAddress());
	        ObjectOutputStream saida = new ObjectOutputStream(cliente.getOutputStream());
	        saida.flush();
	        saida.writeObject(new Date());
	        saida.close();
	        cliente.close();
	      }  
	    }catch(Exception erro) {
	       System.out.println("Erro --> " + erro.getMessage());
	    }
	  }     
	}
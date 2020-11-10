package br.barretuino.file;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Demonstração de Tranferência de Imagem usando Servidor de Arquivos
 * @author Paulo Barreto
 * @date 31/12/2017
 */

public class frmCarregaImagem extends JFrame implements ActionListener{
	
	private static final long serialVersionUID = 1L;
	
	//Atributos
	JLabel lblImagem, lblServidor, lblPorta, lblArquivo, lblSaida;
	JTextField txtServidor, txtPorta, txtArquivo, txtSaida;
	JButton btnBuscar;
	GridLayout gridCampos;
	JPanel pnCampos, pnImagem, pnBotoes;
	
	public frmCarregaImagem() {
		setSize(420, 420);
		setTitle("Sockets com Java");
		setLayout(new BorderLayout());
		
		lblImagem = new JLabel();
		lblServidor = new JLabel("Servidor:");
		lblPorta = new JLabel("Porta:");
		lblArquivo = new JLabel("Arquivo:");
		lblSaida = new JLabel("Saída:");
		
		txtServidor = new JTextField(15);
		txtPorta = new JTextField(15);
		txtArquivo = new JTextField(30);
		txtSaida = new JTextField(30);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(this);
		
		gridCampos = new GridLayout(4,3,5,5);
		
		pnCampos = new JPanel(gridCampos);
		pnImagem = new JPanel();
		pnBotoes = new JPanel(new FlowLayout());
		
		pnCampos.add(lblServidor);
		pnCampos.add(txtServidor);
		pnCampos.add(lblPorta);
		pnCampos.add(txtPorta);
		pnCampos.add(lblArquivo);
		pnCampos.add(txtArquivo);
		pnCampos.add(lblSaida);
		pnCampos.add(txtSaida);
		
		pnImagem.add(lblImagem);
		
		pnBotoes.add(btnBuscar);
		
		add(pnCampos, BorderLayout.NORTH);
		add(pnImagem, BorderLayout.CENTER);
		add(pnBotoes, BorderLayout.SOUTH);
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent evento) {
		if(evento.getSource() == btnBuscar) {
			try {
			     //Cria o Socket para buscar o arquivo no servidor 
			     Socket rec = new Socket(txtServidor.getText(),Integer.parseInt(txtPorta.getText()));

			     //Enviando o nome do arquivo a ser baixado do servidor
			     ObjectOutputStream saida = new ObjectOutputStream(rec.getOutputStream());
			     saida.writeObject(txtArquivo.getText());

			     // DataInputStream para processar os bytes recebidos
			     DataInputStream entrada = new DataInputStream(rec.getInputStream());

			     //FileOuputStream para salvar o arquivo recebido
			     FileOutputStream sarq = new FileOutputStream(txtSaida.getText());
			     byte[] br = new byte[512];
			     int leitura = entrada.read(br);
			     while(leitura != -1) {
			       if(leitura != -2) {
			         sarq.write(br,0,leitura);
			       }
			       leitura = entrada.read(br);
			     }

			     saida.close();
			     entrada.close();
			     sarq.close();
			     rec.close();
			     ImageIcon imagem = new ImageIcon(txtSaida.getText());
			     lblImagem.setText("");
			     lblImagem.setIcon(imagem);
			   }

			   catch(Exception erro) {
			       JOptionPane.showMessageDialog(null,"Exceção:" + erro.getMessage(),"Erro", 2);
			   }
		}		
	}    
	
	public static void main(String[] args) {
		frmCarregaImagem frm = new frmCarregaImagem();
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
package implementaprotocolo;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
	
	public static void main(String[] args) {
		try {
			
			ServerSocket serverSocket = new ServerSocket(8189);
			Socket socket = serverSocket.accept();
			
			ObjectOutputStream saidaDados = new ObjectOutputStream(socket.getOutputStream());
			ObjectInputStream entradaDados = new ObjectInputStream(socket.getInputStream());
			
			int contador = 0;
			
			while(socket.isConnected()) {
				Mensagem pacote = (Mensagem) entradaDados.readObject();
				
				if(pacote.mensagem.equals("SAIR")) {
					break;
				} else if(pacote.posAtual == contador) {
					System.out.println("Pacote recebido corresponde ao esperado.");
					Mensagem ack = new Mensagem(null, 0, 0, pacote.posProxima);
					saidaDados.writeObject(ack);
					contador=+1;
				} else {
					System.out.println("Pacote recebido NÃO corresponde ao esperado, solicitando o reenvio.");
					Mensagem ackN = new Mensagem(null, 0, 0, contador);
					saidaDados.writeObject(ackN);
				}
			}
			
			saidaDados.close();
			entradaDados.close();
			socket.close();
			serverSocket.close();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}

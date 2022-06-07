package implementaprotocolo;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) {
		try {
			Socket socket = new Socket("localhost", 8189);

			if (socket.isConnected()) {
				System.out.println("Conectou");
			}

			ObjectOutputStream saidaDados = new ObjectOutputStream(socket.getOutputStream());
			ObjectInputStream entradaDados = new ObjectInputStream(socket.getInputStream());

			Scanner scanner = new Scanner(System.in);

			int contador = 0;

			while (socket.isConnected()) {
				
				System.out.print("Digite a sua mensagem, caso queira sair digite 'SAIR': ");
				String textoAEnviar = scanner.nextLine();

				int tamMsg = textoAEnviar.length();

				System.out.println("Enviando pacote.");
				Mensagem msg = new Mensagem(textoAEnviar, tamMsg, contador, contador+1);
				saidaDados.writeObject(msg);
				
				if(msg.mensagem.equals("SAIR")) {
					break;
				}
				
				Mensagem pacote = (Mensagem) entradaDados.readObject();
				if(pacote.posProxima == contador+1) {
					System.out.println("Pacote enviado foi recebido.");
					contador=+1;
				} else if(pacote.posProxima == contador) {
					System.out.println("Pacote enviado NÃO foi recebido, tentando novamente.");
					saidaDados.writeObject(msg);
				}
			}

			saidaDados.close();
			entradaDados.close();
			scanner.close();
			socket.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}

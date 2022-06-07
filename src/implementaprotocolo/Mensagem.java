package implementaprotocolo;

import java.io.Serializable;

public class Mensagem implements Serializable {
	
	String mensagem;
	int tamMensagem, posAtual, posProxima;
	
	public Mensagem(String mensagem, int tamMensagem, int posAtual, int posProxima){
		this.mensagem = mensagem;
		this.tamMensagem = tamMensagem;
		this.posAtual = posAtual;
		this.posProxima = posProxima;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}

	public int getTamMensagem() {
		return tamMensagem;
	}

	public void setTamMensagem(int tamMensagem) {
		this.tamMensagem = tamMensagem;
	}

	public int getPosAtual() {
		return posAtual;
	}

	public void setPosAtual(int posAtual) {
		this.posAtual = posAtual;
	}

	public int getPosProxima() {
		return posProxima;
	}

	public void setPosProxima(int posProxima) {
		this.posProxima = posProxima;
	}
}

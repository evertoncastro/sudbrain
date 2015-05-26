package br.com.project.sudbrain.model.vo;

public class Acao {
	
	private int qtdPulo;
	private int qtdAjuda;
	private int qtdSorteio;
	
	public Acao(){
		this.qtdPulo = 3;
		this.qtdAjuda = 1;
		this.qtdSorteio = 1;
	}

	public int getQtdPulo() {
		return qtdPulo;
	}

	public void setQtdPulo(int qtdPulo) {
		this.qtdPulo = qtdPulo;
	}

	public int getQtdAjuda() {
		return qtdAjuda;
	}

	public void setQtdAjuda(int qtdAjuda) {
		this.qtdAjuda = qtdAjuda;
	}

	public int getQtdSorteio() {
		return qtdSorteio;
	}

	public void setQtdSorteio(int qtdSorteio) {
		this.qtdSorteio = qtdSorteio;
	}
	
	
}

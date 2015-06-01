package br.com.project.sudbrain.model.help;

import java.io.Serializable;
import java.util.Random;

public class Sorteio implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int sorteio = 0;
	private int imagemSorteio = 0;
	private boolean alternativa1 = true;
	private boolean alternativa2 = true;
	private boolean alternativa3 = true;
	private boolean alternativa4 = true;
	
	public Sorteio(){
		Random gerador = new Random();
		do{
			this.sorteio = gerador.nextInt(4);
		}while(this.sorteio==0);
	}

	public int getSorteio() {
		return sorteio;
	}

	public void setSorteio(int sorteio) {
		this.sorteio = sorteio;
	}

	public boolean isAlternativa1() {
		return alternativa1;
	}

	public void setAlternativa1(boolean alternativa1) {
		this.alternativa1 = alternativa1;
	}

	public boolean isAlternativa2() {
		return alternativa2;
	}

	public void setAlternativa2(boolean alternativa2) {
		this.alternativa2 = alternativa2;
	}

	public boolean isAlternativa3() {
		return alternativa3;
	}

	public void setAlternativa3(boolean alternativa3) {
		this.alternativa3 = alternativa3;
	}

	public boolean isAlternativa4() {
		return alternativa4;
	}

	public void setAlternativa4(boolean alternativa4) {
		this.alternativa4 = alternativa4;
	}

	public int getImagemSorteio() {
		return imagemSorteio;
	}

	public void setImagemSorteio(int imagemSorteio) {
		this.imagemSorteio = imagemSorteio;
	}

			
	
}

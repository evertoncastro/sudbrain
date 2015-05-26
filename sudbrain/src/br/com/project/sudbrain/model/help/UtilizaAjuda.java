package br.com.project.sudbrain.model.help;

import java.util.Random;

import br.com.project.sudbrain.model.vo.Pergunta;

public class UtilizaAjuda {
	
	boolean a1;
	boolean a2;
	boolean a3;	
	Random gerador = new Random();	
	
	public void defineResposta(){
		a1 = gerador.nextBoolean();
		a2 = gerador.nextBoolean();
		a3 = gerador.nextBoolean();
	}
	
	public Ajuda defineAlternativa(Ajuda ajuda, Pergunta pergunta){
		if(pergunta.getNivel()<=10){
			ajuda.setAjuda1(pergunta.getResposta());
			ajuda.setAjuda2(pergunta.getResposta());
			ajuda.setAjuda3(pergunta.getResposta());
		}else{
			Random gerador = new Random();
			boolean boleanoGerado = gerador.nextBoolean();
			
			if(boleanoGerado){
				int numeroGerado = 0;
				while(numeroGerado==0){
					numeroGerado = gerador.nextInt(4);
				}
				switch(numeroGerado){
					case 1: ajuda.setAjuda1(pergunta.getResposta());
							ajuda.setAjuda2(pergunta.getResposta());
							ajuda.setAjuda3(numeroGerado);
							break;
					case 2: ajuda.setAjuda1(pergunta.getResposta());
							ajuda.setAjuda2(numeroGerado);
							ajuda.setAjuda3(pergunta.getResposta());
							break;
							
					case 3: ajuda.setAjuda1(numeroGerado);
							ajuda.setAjuda2(pergunta.getResposta());
							ajuda.setAjuda3(pergunta.getResposta());
							break;
				}
			}
			
		}
		return ajuda;
	}
	public static void abreFechaJanelaAjuda(Ajuda ajuda, boolean abreFecha){
		ajuda.setJanelaAjuda(abreFecha);
	}
	
}


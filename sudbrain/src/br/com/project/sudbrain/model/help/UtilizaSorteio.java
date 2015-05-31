package br.com.project.sudbrain.model.help;


import br.com.project.sudbrain.model.vo.Pergunta;

public class UtilizaSorteio {
	
	public static Sorteio realizaSorteio(Sorteio sorteio, Pergunta pergunta){
		int numeroSorteado = sorteio.getSorteio();
						
		boolean[] array = new boolean[4];
		for(int i=0; i<array.length; i++){
			array[i] = true;
		}
		
		
		if(pergunta.getResposta()>numeroSorteado){
			for(int i=0; i<numeroSorteado; i++){
				array[i] = false;
			}
		}else{
			for(int i=0; i<numeroSorteado+1; i++){
				if(i != pergunta.getResposta()-1){
					array[i] = false;
				}
			}
		}
		sorteio.setAlternativa1(array[0]);
		sorteio.setAlternativa2(array[1]);
		sorteio.setAlternativa3(array[2]);
		sorteio.setAlternativa4(array[3]);
		sorteio.setImagemSorteio(numeroSorteado);
		
		return sorteio;
	}
	
	public static Sorteio aposSorteio(Sorteio sorteio){
		sorteio.setImagemSorteio(0);
		sorteio.setAlternativa1(true);
		sorteio.setAlternativa2(true);
		sorteio.setAlternativa3(true);
		sorteio.setAlternativa4(true);
		return sorteio;
	}
	
}

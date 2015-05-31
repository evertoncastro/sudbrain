package br.com.project.sudbrain.controller;

import java.util.List;
import br.com.project.sudbrain.model.dao.DataPerguntaDAO;
import br.com.project.sudbrain.model.vo.Pergunta;

public class TestaConexao {

	public static void main(String[] args) {
		
		
		
		DataPerguntaDAO dataPerguntaDAO = new DataPerguntaDAO();
		List<Pergunta> pergunta;
		String escritura = "mormon";
		pergunta = dataPerguntaDAO.buscaPerguntaNivel(1, escritura);
		
		Pergunta p = pergunta.get(0);
		
		System.out.println(p.getPergunta());
		
//		Random gerador = new Random();
//		int numeroSorteado = gerador.nextInt(50);
//		System.out.println(numeroSorteado);
		
//		for(Pergunta perguntaX: pergunta){
//			System.out.println(perguntaX.getIdPergunta());
//			System.out.println(perguntaX.getNivel());
//			System.out.println(perguntaX.getPergunta());
//			System.out.println(perguntaX.getResposta());
//			System.out.println(perguntaX.getAlternativa_A());
//			System.out.println(perguntaX.getAlternativa_B());
//			System.out.println(perguntaX.getAlternativa_C());
//			System.out.println(perguntaX.getAlternativa_D());
//			
//		}
		
		
	}

}

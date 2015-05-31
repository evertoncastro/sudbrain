package br.com.project.sudbrain.model.dao;

import br.com.project.sudbrain.model.vo.Acao;

public class AcaoUtiliza {
	
	public static void controlaAcao(Acao acao, String string){
		if(string.equals("pulo")){
			acao.setQtdPulo(acao.getQtdPulo()-1);
		}else if(string.equals("ajuda")){
			acao.setQtdAjuda(acao.getQtdAjuda()-1);
		}else if(string.equals("sorteio")){
			acao.setQtdSorteio(acao.getQtdSorteio()-1);
		}
	}
	
	public static int verificaAcaoUtilizada(Acao acao){
		return acao.getQtdAjuda() + acao.getQtdPulo() + acao.getQtdSorteio();
	}
}

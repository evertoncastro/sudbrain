package br.com.project.sudbrain.model.dao;

import java.util.List;

import br.com.project.sudbrain.model.vo.Pergunta;

public interface PerguntaDAO {
	
	public List<Pergunta> buscaPerguntaNivel(int perguntaSorteada, String escritura);
	public Boolean cadastraPergunta(Pergunta pergunta);
	
}

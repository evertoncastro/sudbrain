package br.com.project.sudbrain.model.dao;

import java.util.List;
import br.com.project.sudbrain.model.vo.Pontuacao;


public interface PontuacaoDAO {
	public List<Pontuacao> buscaPontuacao(int escritura);
}


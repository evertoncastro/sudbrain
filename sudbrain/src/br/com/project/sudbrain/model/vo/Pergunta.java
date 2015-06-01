package br.com.project.sudbrain.model.vo;

import java.io.Serializable;

public class Pergunta implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer idPergunta;
	private Integer nivel;
	private String pergunta;
	private Integer resposta;
	private String alternativa_A;
	private String alternativa_B;
	private String alternativa_C;
	private String alternativa_D;
	
	public Integer getIdPergunta() {
		return idPergunta;
	}
	public void setIdPergunta(Integer idPergunta) {
		this.idPergunta = idPergunta;
	}
	public Integer getNivel() {
		return nivel;
	}
	public void setNivel(Integer nivel) {
		this.nivel = nivel;
	}	
	public String getPergunta() {
		return pergunta;
	}
	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}
	public Integer getResposta() {
		return resposta;
	}
	public void setResposta(Integer resposta) {
		this.resposta = resposta;
	}
	public String getAlternativa_A() {
		return alternativa_A;
	}
	public void setAlternativa_A(String alternativa_A) {
		this.alternativa_A = alternativa_A;
	}
	public String getAlternativa_B() {
		return alternativa_B;
	}
	public void setAlternativa_B(String alternativa_B) {
		this.alternativa_B = alternativa_B;
	}
	public String getAlternativa_C() {
		return alternativa_C;
	}
	public void setAlternativa_C(String alternativa_C) {
		this.alternativa_C = alternativa_C;
	}
	public String getAlternativa_D() {
		return alternativa_D;
	}
	public void setAlternativa_D(String alternativa_D) {
		this.alternativa_D = alternativa_D;
	}
	
	
}

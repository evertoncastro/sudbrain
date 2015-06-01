package br.com.project.sudbrain.model.vo;

import java.io.Serializable;

public class Jogada implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private int id_usuario;
	private int pontos;
	private int id_escritura;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getId_usuario() {
		return id_usuario;
	}
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	public int getPontos() {
		return pontos;
	}
	public void setPontos(int pontos) {
		this.pontos = pontos;
	}
	public int getId_escritura() {
		return id_escritura;
	}
	public void setId_escritura(int id_escritura) {
		this.id_escritura = id_escritura;
	}
	
	
}

package br.edu.univas;

public class Time {
	public Time() {

	}

	private String nomeTime;
	private String estadoTime;
	private long saldoGols;
	private int pontos;

	public long getSaldoGols() {
		return saldoGols;
	}

	public void setSaldoGols(long saldoGols) {
		this.saldoGols = saldoGols;
	}

	public int getPontos() {
		return pontos;
	}

	public void setPontos(int pontos) {
		this.pontos = pontos;
	}

	public String getNomeTime() {
		return nomeTime;
	}

	public void setNomeTime(String nomeTime) {
		this.nomeTime = nomeTime;
	}

	public String getEstadoTime() {
		return estadoTime;
	}

	public void setEstadoTime(String estadoTime) {
		this.estadoTime = estadoTime;
	}



}

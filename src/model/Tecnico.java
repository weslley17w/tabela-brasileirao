package model;

import java.util.UUID;

public class Tecnico extends Funcionario {
	boolean licencaCBF;
	boolean licencaInternacional;
	int qntVitorias;
	int qntEmpates;
	int qntDerrotas;
	
	public Tecnico(String nome, String nacionalidade,String dtNascimento, float salario, float multa, boolean licencaCBF,
					Boolean licencaInternacional, int qntVitorias, int qntEmpates, int qntDerrotas) {
		
		setUuid(UUID.randomUUID().toString());
		setNome(nome);
		setNacionalidade(nacionalidade);
		setDtNascimento(dtNascimento);
		setSalario(salario);
		setMulta(multa);
		setLicencaCBF(licencaCBF);
		setLicencaInternacional(licencaInternacional);
		setQntVitorias(qntVitorias);
		setQntEmpates(qntEmpates);
		setQntDerrotas(qntDerrotas);

	}
	
	
	
	
	public int getQntVitorias() {
		return qntVitorias;
	}
	
	public int getAproveitamento() {
		int pontosConquitados = (getQntVitorias() * 3 + getQntEmpates());
		int pontosPosiveis = (getQntVitorias() + getQntEmpates() + getQntDerrotas()) * 3;
		int aproveitamento = 0;
		
		if(pontosPosiveis != 0) {
			aproveitamento = (pontosConquitados * 100) / pontosPosiveis; 
		}
		
		return aproveitamento;
	}
	
	public int getQntJogos() {
		return getQntVitorias() + getQntEmpates() + getQntDerrotas();
	}


	public void setQntVitorias(int qntVitorias) {
		this.qntVitorias = qntVitorias;
	}




	public int getQntEmpates() {
		return qntEmpates;
	}




	public void setQntEmpates(int qntEmpates) {
		this.qntEmpates = qntEmpates;
	}




	public int getQntDerrotas() {
		return qntDerrotas;
	}




	public void setQntDerrotas(int qntDerrotas) {
		this.qntDerrotas = qntDerrotas;
	}




	public boolean getLicencaCBF() {
		return licencaCBF;
	}




	public void setLicencaCBF(boolean licencaCBF) {
		this.licencaCBF = licencaCBF;
	}




	public boolean getLicencaInternacional() {
		return licencaInternacional;
	}




	public void setLicencaInternacional(boolean licencaInternacional) {
		this.licencaInternacional = licencaInternacional;
	}




	public void jogo(int qntVitorias, int qntEmpates, int qntDerrotas) {
		setQntVitorias(qntVitorias);
		setQntEmpates(qntEmpates);
		setQntDerrotas(qntDerrotas);
	}
	
	public void jogo(int jogo) {
		if(jogo == 0) {
			this.qntVitorias++;
		}else if(jogo == 1) {
			this.qntEmpates++;
		}else {
			this.qntDerrotas++;
		}
	}
}

package model;

public class Tecnico extends Funcionario {
	boolean licencaCBF;
	boolean licencaInternacional;
	int qntVitorias;
	int qntEmpates;
	int qntDerrotas;
	
	public Tecnico(String nome, String nacionalidade,String dtNascimento, Double salario, Double multa, boolean licencaCBF,
					Boolean licencaInternacional) {
		
		setNome(nome);
		setNacionalidade(nacionalidade);
		setDtNascimento(dtNascimento);
		setSalario(salario);
		setMulta(multa);
		setLicencaCBF(licencaCBF);
		setLicencaInternacional(licencaCBF);

	}
	
	
	
	
	public int getQntVitorias() {
		return qntVitorias;
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

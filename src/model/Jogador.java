package model;

public class Jogador extends Funcionario{
	
	int qntGols = 0;
	boolean passaporteEuropeu;
	
	public Jogador(String nome, String nacionalidade,String dtNascimento, float salario, float multa, boolean passaporteEuropeu) {
		setNome(nome);
		setNacionalidade(nacionalidade);
		setDtNascimento(dtNascimento);
		setSalario(salario);
		setMulta(multa);
		setPassaporteEuropeu(passaporteEuropeu);
	}
	
	public void gol() {
		
		this.qntGols++;
	}
	
	public int getQntGols() {
		return qntGols;
	}

	public void setQntGols(int qntGols) {
		this.qntGols = qntGols;
	}

	public void setPassaporteEuropeu(boolean passaporteEuropeu) {
		this.passaporteEuropeu = passaporteEuropeu;
	}

	public void gol(int gol) {
		
		this.qntGols += gol;
	}
	
	public boolean getPassaporteEuropeu() {
		return passaporteEuropeu;
	}
	public void setPassaporteEuropeu(Boolean passaporteEuropeu) {
		this.passaporteEuropeu = passaporteEuropeu;
	}
	
}
	
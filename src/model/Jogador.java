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
	
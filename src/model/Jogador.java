package model;

public class Jogador extends Funcionario {

	int qntGols;
	boolean passaporteEuropeu;

	public Jogador(String nome, String nacionalidade, String dtNascimento, float salario, float multa, int qntGols,
			boolean passaporteEuropeu) {
		setTime(null);
		setNome(nome);
		setNacionalidade(nacionalidade);
		setDtNascimento(dtNascimento);
		setSalario(salario);
		setMulta(multa);
		setQntGols(qntGols);
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

	public void update(String nome, String nacionalidade, String dtNascimento, float salario,
			float multa, int qntGols, boolean passaporteEuropeu) {

		this.setNome(nome);
		this.setNacionalidade(nacionalidade);
		this.setDtNascimento(dtNascimento);
		this.setSalario(salario);
		this.setMulta(multa);
		this.setQntGols(qntGols);
		this.setPassaporteEuropeu(passaporteEuropeu);
	}

}

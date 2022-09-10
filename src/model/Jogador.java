package model;

/**
*
* Classe responsável gerenciar os jogadores
*
* @author  Weslley Barros
* @version 1.0
*/

public class Jogador extends Funcionario {

	int qntGols;
	boolean passaporteEuropeu;
	/**
	 * contrutor jogador
	 * @author Weslley Barros
	 * @param nome String - Nome
	 * @param nacionalidade String - Nacionalidade
	 * @param dtNascimento String - data de nascimento
	 * @param salario float - Salário
	 * @param multa float - Multa
	 * @param qntGols int - Quantidade de gols
	 * @param passaporteEuropeu boolean - Passaporte Europeu
	 */
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

	/**
	 * set getQntGols
	 * @author Weslley Barros
	 * @return Quantidade de gols
	 */
	
	public int getQntGols() {
		return qntGols;
	}
	
	/**
	 * set QntGols
	 * @author Weslley Barros
	 * @param qntGols int - Quatidade de gols
	 */
	
	public void setQntGols(int qntGols) {
		this.qntGols = qntGols;
	}
	
	/**
	 * set PassaporteEuropeu
	 * @author Weslley Barros
	 * @param passaporteEuropeu boolean - Nome
	 */

	public void setPassaporteEuropeu(boolean passaporteEuropeu) {
		this.passaporteEuropeu = passaporteEuropeu;
	}
	
	/**
	 * get PassaporteEuropeu
	 * @author Weslley Barros
	 * @return passaporteEuropeu 
	 */
	
	public boolean getPassaporteEuropeu() {
		return passaporteEuropeu;
	}
	
	/**
	 * Editar jogador
	 * @author Weslley Barros
	 * @param nome String - Nome
	 * @param nacionalidade String - Nacionalidade
	 * @param dtNascimento String - data de nascimento
	 * @param salario float - Salário
	 * @param multa float - Multa
	 * @param qntGols int - Quantidade de gols
	 * @param passaporteEuropeu boolean - Passaporte Europeu
	 */
	
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

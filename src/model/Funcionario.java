package model;

/**
* Classe abstrata responsável por fornecer atributos e métodos podrões para as Classe Jogador e Técnico
* @author  Weslley Barros
* @version 1.0
*/
public abstract class Funcionario {
	private String time;
	private String nome;
	private String dtNascimento;
	private String nacionalidade;
	private float salario;
	private float multa;
	
	/**
	 * get Nome
	 * @author Weslley Barros
	 * @return String - nome
	 */
	
	public  String getNome() {
		return nome;
	}
	
	/**
	 * set Nome
	 * @author Weslley Barros
	 * @param nome String - Nome
	 */
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * get Nacionalidade
	 * @author Weslley Barros
	 * @return String - Nacionalidade
	 */
	
	public String getNacionalidade() {
		return nacionalidade;
	}
	
	/**
	 * set Nacionalidade
	 * @author Weslley Barros
	 * @param nacionalidade String - Nacionalidade
	 */
	
	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}
	
	/**
	 * get DtNascimento
	 * @author Weslley Barros
	 * @return String - Nascimento
	 */
	
	public String getDtNascimento() {
		return dtNascimento;
	}
	
	/**
	 * set DtNascimento
	 * @author Weslley Barros
	 * @param dtNascimento String - Data de Nascimento
	 */
	
	public void setDtNascimento(String dtNascimento) {
		this.dtNascimento = dtNascimento;
	}
	
	/**
	 * get DtNascimento
	 * @author Weslley Barros
	 * @return Float - Salario
	 */
	
	public float getSalario() {
		return salario;
	}
	
	/**
	 * set DtNascimento
	 * @author Weslley Barros
	 * @param salario Float - Salário
	 */
	
	public void setSalario(float salario) {
		this.salario = salario;
	}
	
	/**
	 * get Multa
	 * @author Weslley Barros
	 * @return Float - Multa
	 */
	
	public float getMulta() {
		return multa;
	}
	
	/**
	 * set Multa
	 * @author Weslley Barros
	 * @param multa Float - Multa
	 */
	
	public void setMulta(float multa) {
		this.multa = multa;
	}
	
	/**
	 * get Time
	 * @author Weslley Barros
	 * @return String - time
	 */
	
	public String getTime() {
		return time;
	}
	
	/**
	 * set Time
	 * @author Weslley Barros
	 * @param time String - Time
	 */
	
	public void setTime(String time) {
		this.time = time;
	}
	
}
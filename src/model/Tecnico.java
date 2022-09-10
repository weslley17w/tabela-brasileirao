package model;

/**
*
* Classe responsável gerenciar os técnicos
*
* @author  Weslley Barros
* @version 1.0
*/

public class Tecnico extends Funcionario {
	boolean licencaCBF;
	boolean licencaInternacional;
	int qntVitorias;
	int qntEmpates;
	int qntDerrotas;

	/**
	 * contrutor tecnico
	 * @author Weslley Barros
	 * @param nome                 - nome do jogador
	 * @param nacionalidade        - nacionalidade do jogador
	 * @param dtNascimento         - data de nascimento
	 * @param salario              - salário
	 * @param multa                - multa
	 * @param licencaCBF           - licença CBF
	 * @param licencaInternacional - licença internacional
	 * @param qntVitorias          - quantidade de vitórias
	 * @param qntEmpates           - quantidade de empates
	 * @param qntDerrotas          - quantidade de derrotas
	 */

	public Tecnico(String nome, String nacionalidade, String dtNascimento, float salario, float multa,
			boolean licencaCBF, Boolean licencaInternacional, int qntVitorias, int qntEmpates, int qntDerrotas) {

		setTime(null);
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

	/**
	 * editar jogador 
	 * @author Weslley Barros
	 * @param nome                 - nome do jogador
	 * @param nacionalidade        - nacionalidade do jogador
	 * @param dtNascimento         - data de nascimento
	 * @param salario              - salário
	 * @param multa                - multa
	 * @param licencaCBF           - licença CBF
	 * @param licencaInternacional - licença internacional
	 * @param qntVitorias          - quantidade de vitórias
	 * @param qntEmpates           - quantidade de empates
	 * @param qntDerrotas          - quantidade de derrotas
	 * @return técnico
	 */

	public Tecnico update(String nome, String nacionalidade, String dtNascimento, float salario, float multa,
			boolean licencaCBF, Boolean licencaInternacional, int qntVitorias, int qntEmpates, int qntDerrotas) {

		this.setNome(nome);
		this.setNacionalidade(nacionalidade);
		this.setDtNascimento(dtNascimento);
		this.setSalario(salario);
		this.setMulta(multa);
		this.setLicencaCBF(licencaCBF);
		this.setLicencaInternacional(licencaInternacional);
		this.setQntVitorias(qntVitorias);
		this.setQntEmpates(qntEmpates);
		this.setQntDerrotas(qntDerrotas);

		return this;
	}

	/**
	 * get QntVitorias
	 * @author Weslley Barros
	 * @return Quatidade de vitórias
	 */

	public int getQntVitorias() {
		return qntVitorias;
	}

	/**
	 * get Aproveitamento
	 * @author Weslley Barros
	 * @return aproveitamento do técnico
	 */

	public int getAproveitamento() {
		int pontosConquitados = (getQntVitorias() * 3 + getQntEmpates());
		int pontosPosiveis = (getQntVitorias() + getQntEmpates() + getQntDerrotas()) * 3;
		int aproveitamento = 0;

		if (pontosPosiveis != 0) {
			aproveitamento = (pontosConquitados * 100) / pontosPosiveis;
		}

		return aproveitamento;
	}

	/**
	 * get QntJogos
	 * @author Weslley Barros
	 * @return quantidade de jogos
	 */

	public int getQntJogos() {
		return getQntVitorias() + getQntEmpates() + getQntDerrotas();
	}

	/**
	 * set QntVitorias
	 * @author Weslley Barros
	 * @param qntVitorias - quantidade de vitórias
	 */

	public void setQntVitorias(int qntVitorias) {
		this.qntVitorias = qntVitorias;
	}

	/**
	 * get QntEmpates
	 * @author Weslley Barros
	 * @return quantidade de empates
	 */

	public int getQntEmpates() {
		return qntEmpates;
	}
	
	/**
	 * set QntEmpates
	 * @author Weslley Barros
	 * @param qntEmpates - quantidade de empates
	 */
	
	public void setQntEmpates(int qntEmpates) {
		this.qntEmpates = qntEmpates;
	}
	
	/**
	 * get Derrotas
	 * 
	 * @author Weslley Barros
	 * @return quantidade de derrotas
	 */
	
	public int getQntDerrotas() {
		return qntDerrotas;
	}
	
	/**
	 * set qntDerrotas
	 * @author Weslley Barros
	 * @param qntDerrotas - quantidade de derrotas
	 */

	public void setQntDerrotas(int qntDerrotas) {
		this.qntDerrotas = qntDerrotas;
	}
	
	/**
	 * get LicencaCBF
	 * 
	 * @author Weslley Barros
	 * @return licença CBF
	 */
	
	public boolean getLicencaCBF() {
		return licencaCBF;
	}
	
	/**
	 * set LicencaCBF
	 * 
	 * @author Weslley Barros
	 * @param licencaCBF - licença CBF
	 */
	
	public void setLicencaCBF(boolean licencaCBF) {
		this.licencaCBF = licencaCBF;
	}
	
	/**
	 * get LicencaCBF
	 * 
	 * @author Weslley Barros
	 * @return licença CBF
	 */
	
	public boolean getLicencaInternacional() {
		return licencaInternacional;
	}
	
	/**
	 * set LicencaInternacional
	 * @author Weslley Barros
	 * @param licencaInternacional - licença internacional
	 */
	
	public void setLicencaInternacional(boolean licencaInternacional) {
		this.licencaInternacional = licencaInternacional;
	}

}

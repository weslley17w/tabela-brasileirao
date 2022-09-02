package model;

public abstract class Funcionario {
	private String uuid;
	private String nome;
	private String dtNascimento;
	private String nacionalidade;
	private float salario;
	private float multa;
	
	public  String getNome() {
		return nome;
	}
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getUuid() {
		return uuid;
	}
	public String getNacionalidade() {
		return nacionalidade;
	}
	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}
	public String getDtNascimento() {
		return dtNascimento;
	}
	public void setDtNascimento(String dtNascimento) {
		this.dtNascimento = dtNascimento;
	}
	public float getSalario() {
		return salario;
	}
	public void setSalario(float salario) {
		this.salario = salario;
	}
	public float getMulta() {
		return multa;
	}
	public void setMulta(float multa) {
		this.multa = multa;
	}
}
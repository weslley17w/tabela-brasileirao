package controller;

import javax.swing.table.DefaultTableModel;

/**
*
* Classe responsável validar e gerenciar dados dos jogadores e servir a views 
*
* @author  Weslley Barros
* @version 1.0
*/

public class Jogador {
	private boolean passaporteEuropeu;
	private float   salario;
	private float   multa;
	private int     qntGols;
	private int     contador;
	private model.Database db = model.Database.getInstance();
	
	/**
	 * cadastrar jogador
	 * @author Weslley Barros
	 * @param nome - Nome do jogador
	 * @param nacionalidade - Nacionalidade do jogador
	 * @param dtNascimento - Data de nascimento do jogador
	 * @param salario - Salario do jogador
	 * @param multa - Multa do jogador
	 * @param qntGols - Quantidade de gols do jogador
	 * @param passaporteEuropeu - Passaporte europeu
	 * @return int - 0 = jogador cadastrado com sucesso, 2 = erro: campos vazios, 3 = erro: salario é multa não são floats 
	 * e 4 = erro: campo qntGols não é inteiro
	 */
	
	public int cadastrar(String nome, String nacionalidade,String dtNascimento, String salario, String multa, String qntGols, String passaporteEuropeu) {
		int saida = 0;

		if (passaporteEuropeu == "Sim") {
			this.passaporteEuropeu = true;
		} else {
			this.passaporteEuropeu = false;
		}


		try {
			this.salario = Float.parseFloat(salario);
			this.multa = Float.parseFloat(multa);
		} catch (NumberFormatException ex) {
			saida = 3;
		}

		try {
			this.qntGols = Integer.parseInt(qntGols);
		} catch (final NumberFormatException e) {
			saida = 4;
		}
		
		if (nome.isEmpty() || dtNascimento.isEmpty() || nacionalidade.isEmpty() || salario.isEmpty() || multa.isEmpty()
				|| multa.isEmpty() || qntGols.isEmpty() || passaporteEuropeu.isEmpty()) {
			saida = 2;
		}
     
		if (saida == 0) {
			model.Jogador jogador = new model.Jogador(nome,nacionalidade,dtNascimento, this.salario, this.multa, this.qntGols, this.passaporteEuropeu);
			this.db.adicionarJogador(jogador);
		}
        
		return saida;
	}
	
	/**
	 * Verificar se os dados estão corretos e editar o usuário
	 * @author Weslley Barros
	 * @param jogadorname - Jogador a ser editado
	 * @param nome - Nome do jogador
	 * @param nacionalidade - Nacionalidade do jogador
	 * @param dtNascimento - Data de nascimento do jogador
	 * @param salario - Salario do jogador
	 * @param multa - Multa do jogador
	 * @param qntGols - Quantidade de gols do jogador
	 * @param passaporteEuropeu - Passaporte europeu
	 * @return int - 0 = jogador cadastrado com sucesso, 0 = jogador cadastrado com sucesso,  2 = erro: campos vazios,  
	 * 3 = salario é multa não são floats e 4 = erro: campo qntGols não é inteiro 
	 */
	
	public int editar(model.Jogador jogadorname, String nome, String nacionalidade,String dtNascimento, String salario, String multa, String qntGols, String passaporteEuropeu) {
		int saida = 0;

		if (passaporteEuropeu == "Sim") {
			this.passaporteEuropeu = true;
		} else {
			this.passaporteEuropeu = false;
		}


		try {
			this.salario = Float.parseFloat(salario);
			this.multa = Float.parseFloat(multa);
		} catch (NumberFormatException ex) {
			saida = 3;
		}

		try {
			this.qntGols = Integer.parseInt(qntGols);
		} catch (final NumberFormatException e) {
			saida = 4;
		}
		
		if (nome.isEmpty() || dtNascimento.isEmpty() || nacionalidade.isEmpty() || salario.isEmpty() || multa.isEmpty()
				|| multa.isEmpty() || qntGols.isEmpty() || passaporteEuropeu.isEmpty()) {
			saida = 2;
		}

		if (saida == 0) {
			jogadorname.update(nome, nacionalidade, dtNascimento, this.salario, this.multa, this.qntGols, this.passaporteEuropeu);
		}

		return saida;
	}
	
	/**
	 * deleta um jogador
	 * @author Weslley Barros
	 * @param nome - Nome do jogador
	 * @return int - 0 = jogador excluído com sucesso,  1 = nome não deve ser null e 2 = você não pode excluir um jogador com contrato vigente 
	 */
	
	public int deletar(String nome) {
		int saida = 0;
		
			if(db.getJogadores(nome) == null) {
				saida = 1;
			}
			
			if(db.getJogadores(nome).getTime() != null) {
				saida = 2;
			}
			
			if(saida == 0) {
				db.removeJogador(db.getJogadores(nome));
			}

		return saida;
	}
	
	/**
	 * Gerar lista com todos jogadores
	 * @author Weslley Barros
	 * @return DefaultTableModel - Retorna o modelo de tabela com todos jogadores
	 */
	
	public DefaultTableModel gerarLista() {
		this.db.ordenarJogadores("ASC");
		DefaultTableModel modeloTabelaJogador = new DefaultTableModel();
		modeloTabelaJogador.addColumn("NOME");
		modeloTabelaJogador.addColumn("QUANTIDADE DE GOLS");

		db.getJogadores().forEach(jogador -> {
			modeloTabelaJogador
					.addRow(new Object[] {jogador.getNome(), jogador.getQntGols()});
		});

		return modeloTabelaJogador;
	}
	
	/**
	 * Gera lista com todos jogadores filtrado por nome
	 * @author Weslley Barros
	 * @param nome - Nome que você deseja filtrar
	 * @return DefaultTableModel - Retorna o modelo de tabela com todos jogadores filtrado pelo nome
	 */
	
	public DefaultTableModel gerarLista(String nome) {
		DefaultTableModel modeloTabelaJogador = new DefaultTableModel();
		modeloTabelaJogador.addColumn("NOME");
		modeloTabelaJogador.addColumn("QUANTIDADE DE GOLS");

		db.findJogador(nome).forEach(jogador -> {
			modeloTabelaJogador
					.addRow(new Object[] {jogador.getNome(), jogador.getQntGols()});
		});

		return modeloTabelaJogador;
	}
	
	/**
	 * Gerar lista com todos jogadores filta
	 * @author Weslley Barros
	 * @return DefaultTableModel - Retorna o modelo de tabela com os jogadores ordenado por ordem de que fez mais gols
	 */
	
	public DefaultTableModel dadosArtilheiros() {

		db.ordenarJogadores();
		DefaultTableModel modeloTabela = new DefaultTableModel();
		this.contador = 1;

		modeloTabela.addColumn("CLASSIFICAÇÃO");
		modeloTabela.addColumn("GOLS");
		modeloTabela.addColumn("TIME");

		this.db.getJogadores().forEach((jogador) -> {
			String time = (jogador.getTime() == null) ? "Sem time" : jogador.getTime(); 
			modeloTabela.addRow(new Object[] { contador + " - " + jogador.getNome(), jogador.getQntGols(), time});
			this.contador++;
		});
		
		return modeloTabela;
	}
	
	/**
	 * Gerar lista com todos jogadores filtrado por um time
	 * @author Weslley Barros
	 * @param time - Time que você deseja filtrar os jogadores
	 * @return DefaultTableModel - Retorna o modelo de tabela com os jogadores do time
	 */
	
	public DefaultTableModel tabelaJogadoresPorTime(model.Time time) {	
		DefaultTableModel modeloTabelaTimes = new DefaultTableModel();
		
		if(time == null) {
			this.db.ordenarJogadores("ASC");
			modeloTabelaTimes.addColumn("JOGADORES SEM TIME");
			
			this.db.getJogadores().forEach(jogador -> {
				if(jogador.getTime() ==   null) {
					modeloTabelaTimes.addRow(new Object[] {jogador.getNome()});
				}
			});
			
		}else {
			modeloTabelaTimes.addColumn("JOGADORES DO TIME");
			for(model.Jogador jogador : time.getJogadores()) {
				modeloTabelaTimes.addRow(new Object[] {jogador.getNome()});
			}	
		}
	
		return modeloTabelaTimes; 	 
	}
	
}

package controller;

import java.util.ArrayList;

import model.Time;

public class Tabela {
	private model.Tabela tabela = model.Tabela.getInstance();
	
	public ArrayList<Time> getDados() {
		tabela.ordenarTabela();
		return tabela.getTimes();	
	}
}

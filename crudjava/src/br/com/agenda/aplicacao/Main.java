package br.com.agenda.aplicacao;

import br.com.agenda.model.Contato;

import java.sql.Date;

import br.com.agenda.dao.ContatoDAO;

public class Main {

	public static void main(String[] args) {

		//insert dados no banco
		ContatoDAO contatoDao = new ContatoDAO();

		Contato contato = new Contato();
		contato.setNome("Marcia Carina apolinario");
		contato.setIdade(20);
		contato.setDataCadastro(new Date(System.currentTimeMillis()));
		
		contatoDao.save(contato);
		
		
		//update dos registros
		Contato cl = new Contato();
		cl.setNome("Marcia Carina Dias orlando");
		cl.setIdade(22);
		cl.setDataCadastro(new Date(System.currentTimeMillis()));
		cl.setId(1);
		
		contatoDao.update(cl);
		
		
		
		//Deletar id
		contatoDao.deleteById(5);
		
		
		//vizualizando dados do banco
		for(Contato c : contatoDao.getContatos()) {
			System.out.println("Contato: "+c.getNome());
		}
		
	}

}

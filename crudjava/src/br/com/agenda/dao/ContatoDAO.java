package br.com.agenda.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import br.com.agenda.factory.ConnectionFactory;
import br.com.agenda.model.Contato;


import java.sql.Date; // Importe a classe Date do pacote java.sql

public class ContatoDAO {
 
 // metodo save
 public void save(Contato contato) {

     String sql = "INSERT INTO contatos(nome, idade, dataCadastro) VALUES (?, ?, ?)";

     Connection conn = null;
     PreparedStatement pstm = null;

     try {
         // criando conexao com o banco
         conn = ConnectionFactory.createConnectionToMySQL();

         //valores esperados pela query
         pstm = conn.prepareStatement(sql);
         pstm.setString(1, contato.getNome());
         pstm.setInt(2, contato.getIdade());
         pstm.setDate(3, new Date(contato.getDataCadastro().getTime()));

         // executar
         pstm.execute();
         System.out.println("Registrado com sucesso!!");
         
     } catch (Exception e) {
         e.printStackTrace();
     } finally {

         try {
             if (pstm != null) {
                 pstm.close();
             }
             if (conn != null) {
                 conn.close();
             }
         } catch (Exception e) {
             e.printStackTrace();
         }
     }

 }

 
 // metodo select, listando dados do banco
 public List<Contato> getContatos() {
	    String sql = "SELECT * FROM contatos";

	    List<Contato> contatos = new ArrayList<Contato>();

	    Connection conn = null;
	    PreparedStatement pstm = null;
	    ResultSet rset = null;

	    try {
	        conn = ConnectionFactory.createConnectionToMySQL();
	        pstm = conn.prepareStatement(sql);
	        rset = pstm.executeQuery();

	        while (rset.next()) {
	            Contato contato = new Contato();

	            contato.setId(rset.getInt("id"));
	            contato.setNome(rset.getString("nome"));
	            contato.setIdade(rset.getInt("idade"));
	            contato.setDataCadastro(rset.getDate("dataCadastro"));

	            contatos.add(contato);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (rset != null) {
	                rset.close();
	            }

	            if (pstm != null) {
	                pstm.close();
	            }

	            if (conn != null) {
	                conn.close();
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    return contatos;
	 
 }

//metodo update
 public void update(Contato contato) {
	 String sql = "UPDATE contatos SET nome = ?, idade = ?, dataCadastro = ?"+"WHERE ID = ?";
	 
	 Connection conn = null;
	 PreparedStatement pstm = null;
	 
     try {
         // criando conexao com o banco
         conn = ConnectionFactory.createConnectionToMySQL();

         //executar a query
         pstm = (PreparedStatement) conn.prepareStatement(sql);
         
         //valores a receber os updates
         pstm.setString(1, contato.getNome());
         pstm.setInt(2, contato.getIdade());
         pstm.setDate(3, new Date(contato.getDataCadastro().getTime())); 
         
         //id a ser atualizado
         pstm.setInt(4, contato.getId());

         // executar
         pstm.execute();
         System.out.println("Atualizado com sucesso!!");
         
     } catch (Exception e) {
         e.printStackTrace();
     } finally {

         try {
             if (pstm != null) {
                 pstm.close();
             }
             if (conn != null) {
                 conn.close();
             }
         } catch (Exception e) {
             e.printStackTrace();
         }
     }

 }
    
 

// metodo delete
public void deleteById(int id){
	String sql = "DELETE FROM contatos WHERE id = ?";
	
	Connection conn = null;
	PreparedStatement pstm = null;
	
    try {
        // criando conexao com o banco
        conn = ConnectionFactory.createConnectionToMySQL();

        //executar a query
        pstm = (PreparedStatement) conn.prepareStatement(sql);

        //id a ser atualizado
        pstm.setInt(1, id);

        // executar
        pstm.execute();
        System.out.println("Id deletado!!");
        
    } catch (Exception e) {
        e.printStackTrace();
    } finally {

        try {
            if (pstm != null) {
                pstm.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
}

package br.com.caelum.leilao.dominio;

public class RespostaQuestao {

	   private String avaliacao;

	   private String aluno;

	   private int nota;


	   //construtor

	   public RespostaQuestao(String avaliacao,String aluno,int nota){

	       if(avaliacao == null){

	           throw new IllegalArgumentException("A avalia��o n�o pode ser nula");

	       }


	       if(aluno == null){

	           throw new IllegalArgumentException("O aluno n�o pode ser nula");

	       }

	       

	       if(nota < 0){

	           throw new IllegalArgumentException("A nota n�o pode ser menor que zero");

	       }


	       if(nota > 10){

	           throw new IllegalArgumentException("A nota n�o pode ser maior que10");

	       }


	      //resto do c�digo de atribui��o aqui

	   }

	}

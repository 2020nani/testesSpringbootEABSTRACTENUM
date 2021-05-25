package br.com.caelum.leilao.teste;

import org.junit.Test;

import br.com.caelum.leilao.dominio.RespostaQuestao;

public class RespostaQuestaoTest {
	
	@Test(expected = IllegalArgumentException.class)
	public void deveReceberNotaMenorque0(){
		
		RespostaQuestao resposta = new RespostaQuestao("TDD", "Hernani",-1);
		
	}
	@Test(expected = IllegalArgumentException.class)
	public void deveReceberNotaMaiorque10(){
		
		RespostaQuestao resposta = new RespostaQuestao("TDD", "Hernani",11);
		
	}
	@Test(expected = IllegalArgumentException.class)
	public void avaliacaoNaoPodeSerNula(){
		
		RespostaQuestao resposta = new RespostaQuestao(null, "Hernani",10);
		
	}
	@Test(expected = IllegalArgumentException.class)
	public void alunoNaoPodeSerNula(){
		
		RespostaQuestao resposta = new RespostaQuestao("TDD", null,10);
		
	}

}

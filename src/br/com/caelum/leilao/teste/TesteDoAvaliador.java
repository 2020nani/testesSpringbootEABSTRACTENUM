package br.com.caelum.leilao.teste;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Usuario;
import br.com.caelum.leilao.servico.Avaliador;

public class TesteDoAvaliador {
	
	private Avaliador leiloeiro;
	
	@Before
	public void criaAvaliador() {
		this.leiloeiro = new Avaliador();
	}
	
    @Test
	public void deveEntenderLanceEmOrdemDecrescente() {
		Usuario joao = new Usuario("Joao");
		Usuario jose = new Usuario("Jose");
		Usuario maria = new Usuario("Maria");
		
		Leilao leilao = new Leilao("Play novo");
		
		leilao.propoe(new Lance(joao, 300.0));
		leilao.propoe(new Lance(jose, 200.0));
		leilao.propoe(new Lance(maria, 350.0));
		
		leiloeiro.avalia(leilao);
		
		double maiorEsperado = 350;
		double menorEsperado = 200;
		
		assertEquals(maiorEsperado, leiloeiro.getMaiorLance(),0.00001);
		assertEquals(menorEsperado, leiloeiro.getMenorLance(),0.00001);

	}
    
    @Test
   	public void deveEntenderLeilaoComApenasUmLance() {
   		Usuario joao = new Usuario("Joao");
   		
   		Leilao leilao = new Leilao("Play novo");
   		
   		leilao.propoe(new Lance(joao, 3000.0));
   		
   		leiloeiro.avalia(leilao);
   		
   		assertEquals(3000, leiloeiro.getMaiorLance(),0.00001);
   		

   	}
    
    @Test(expected = RuntimeException.class)
   	public void naoDeveAvaliarLeilaoSemLances() {
   		
   			Usuario joao = new Usuario("Joao");
   	   		
   	   		Leilao leilao = new Leilao("Play novo");
   	   		
   	   		
   	   		leiloeiro.avalia(leilao);

   	}
    
    @Test(expected = IllegalArgumentException.class)
   	public void naoDeveAceitarLeilaoComLancesNegativos() {
   		
   			Usuario joao = new Usuario("Joao");
   	   		
   	   		Leilao leilao = new Leilao("Play novo");
   	   		
   	   	    leilao.propoe(new Lance(joao, -3000.0));
   	   		
   	   		leiloeiro.avalia(leilao);

   	}
    
    @Test
   	public void deveEncontrarTresMaioresLances() {
   		Usuario joao = new Usuario("Joao");
   		Usuario jose = new Usuario("Jose");
   		
   		
   		Leilao leilao = new Leilao("Play novo");
   		
   		leilao.propoe(new Lance(joao, 300.0));
   		leilao.propoe(new Lance(jose, 200.0));
   		leilao.propoe(new Lance(joao, 400.0));
   		leilao.propoe(new Lance(jose, 500.0));
   		leilao.propoe(new Lance(joao, 600.0));
   		leilao.propoe(new Lance(jose, 700.0));
   		

   		leiloeiro.avalia(leilao);
   		
   		List<Lance> maiores = leiloeiro.getTresMaiores();
   		
   		assertEquals(3, maiores.size());
   		assertEquals(700,maiores.get(0).getValor(),0.00001 );
   		assertEquals(600,maiores.get(1).getValor(), 0.00001);
   		assertEquals(500,maiores.get(2).getValor(), 0.00001);
   		
   		
   	}

    @After
    public void finaliza() {
      System.out.println("fim");
    }

}

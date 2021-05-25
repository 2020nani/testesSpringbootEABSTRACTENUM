package br.com.caelum.leilao.teste;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.caelum.leilao.dominio.Lance;
import br.com.caelum.leilao.dominio.Leilao;
import br.com.caelum.leilao.dominio.Usuario;

public class LeilaoTest {
	
	@Test
	public void deveReceberUmLance() {
		Leilao leilao = new Leilao("Macbook");
		assertEquals(0, leilao.getLances().size());
		
		leilao.propoe(new Lance(new Usuario("Steve Jobs"), 2000));
		assertEquals(1, leilao.getLances().size());
		assertEquals(2000, leilao.getLances().get(0).getValor(), 0.00001);
	}
	
	@Test
	public void deveReceberVariosLances() {
		Leilao leilao = new Leilao("Macbook");
		assertEquals(0, leilao.getLances().size());
		
		leilao.propoe(new Lance(new Usuario("Steve Jobs"), 2000));
		leilao.propoe(new Lance(new Usuario("Steve irne"), 3000));
		leilao.propoe(new Lance(new Usuario("michael Jobs"), 4000));
		leilao.propoe(new Lance(new Usuario("filip Jobs"), 5000));
		
		assertEquals(4, leilao.getLances().size());
		
		assertEquals(2000, leilao.getLances().get(0).getValor(), 0.00001);
		assertEquals(3000, leilao.getLances().get(1).getValor(), 0.00001);
		assertEquals(4000, leilao.getLances().get(2).getValor(), 0.00001);
		assertEquals(5000, leilao.getLances().get(3).getValor(), 0.00001);
	}
	
	@Test
	public void naoDeveAceitarDoisLancesSeguidosMesoUsuario() {
		Leilao leilao = new Leilao("Macbook");
		Usuario stevejobs = new Usuario("Steve Jobs");
		
		leilao.propoe(new Lance(stevejobs, 2000));
		leilao.propoe(new Lance(stevejobs, 3000));
		assertEquals(1, leilao.getLances().size());
		assertEquals(2000, leilao.getLances().get(0).getValor(), 0.00001);
	}
	
	@Test
	public void naoDeveAceitarMaisQue5LancesMesmoUsuario() {
		Leilao leilao = new Leilao("Macbook");
		Usuario stevejobs = new Usuario("Steve Jobs");
		Usuario gates = new Usuario("gates");
		
		leilao.propoe(new Lance(stevejobs, 2000));
		leilao.propoe(new Lance(gates, 3000));
		leilao.propoe(new Lance(stevejobs, 4000));
		leilao.propoe(new Lance(gates, 5000));
		leilao.propoe(new Lance(stevejobs, 6000));
		leilao.propoe(new Lance(gates, 7000));
		leilao.propoe(new Lance(stevejobs, 8000));
		leilao.propoe(new Lance(gates, 9000));
		leilao.propoe(new Lance(stevejobs, 10000));
		leilao.propoe(new Lance(gates, 11000));
		//deve ser ignorado
		leilao.propoe(new Lance(stevejobs, 12000));
		assertEquals(10, leilao.getLances().size());
		assertEquals(11000, leilao.getLances().get(9).getValor(), 0.00001);
	}

}

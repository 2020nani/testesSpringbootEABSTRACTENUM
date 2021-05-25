package br.com.caelum.leilao.testeEnum;

import java.math.BigDecimal;

import br.com.caelum.leilao.dominio.CalculaPrecoEnumEntrada;
import br.com.caelum.leilao.dominio.Tipo;

public class MetodoAbstratoEnumTeste {

	public static void main(String[] args) {
	 CalculaPrecoEnumEntrada valor = new CalculaPrecoEnumEntrada(50, 50);
	 System.out.println(valor.getPreco() + valor.getPreco2());
	}

}

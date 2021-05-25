package br.com.caelum.leilao.dominio;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leilao {

	private String descricao;
	private List<Lance> lances;
	private Enum<Tipo> tipo;
	private BigDecimal preco;
	
	public Leilao(String descricao) {
		this.descricao = descricao;
		this.lances = new ArrayList<Lance>();
	}
	
	public void propoe(Lance lance) {
		lances.add(lance);
	}
	
	

	public List<Lance> getLances() {
		return Collections.unmodifiableList(lances);
	}

	public BigDecimal getPreco() {
		return preco;
	}
	
}

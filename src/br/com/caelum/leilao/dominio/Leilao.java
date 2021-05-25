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
		if(lance.getValor() <=0) {
			throw new IllegalArgumentException("valor negativo");
		}
		if(lances.isEmpty() || podeDarLance(lance.getUsuario())) {
			lances.add(lance);
		}
		
	}

	private boolean podeDarLance(Usuario usuario) {
		return !ultimoLanceDado().getUsuario().equals(usuario)&& quantidadeLancesDO(usuario) < 5;
	}

	private int quantidadeLancesDO(Usuario usuario) {
		int total = 0;
		
		for (Lance l : lances) {
			if(l.getUsuario().equals(usuario)) total++;
		}
		return total;
	}

	private Lance ultimoLanceDado() {
		return lances.get(lances.size()-1);
	}
	
	

	public List<Lance> getLances() {
		return Collections.unmodifiableList(lances);
	}

	public BigDecimal getPreco() {
		return preco;
	}
	
}

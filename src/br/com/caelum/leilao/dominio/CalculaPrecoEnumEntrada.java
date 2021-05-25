package br.com.caelum.leilao.dominio;

public class CalculaPrecoEnumEntrada {
	
	private Enum<Tipo> tipo;
	private double preco;
	private double preco2;
	
	

	public CalculaPrecoEnumEntrada(double preco, double preco2) {
		super();
		this.preco = Tipo.INTEIRA.calcula(preco);
		this.preco2 = Tipo.MEIA_ENTRADA.calcula(preco2);
	}
	public double getPreco() {
		return preco;
	}
	public double getPreco2() {
		return preco2;
	}
	

}

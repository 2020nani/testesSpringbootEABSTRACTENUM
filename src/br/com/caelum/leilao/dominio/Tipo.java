package br.com.caelum.leilao.dominio;



public enum Tipo {

	INTEIRA {
		@Override
		public Double calcula(Double preco) {
			// TODO Auto-generated method stub
			return preco;
		}
	},
	MEIA_ENTRADA {
		@Override
		public Double calcula(Double preco) {
			// TODO Auto-generated method stub
			return preco * 2;
		}
	};
	
	public abstract Double calcula(Double preco);
	
	
}

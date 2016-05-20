import java.io.Serializable;

public class Licitador implements Serializable {
	private String idComprador;
	private double montante, limite, incrementos, minutos;
	private long ultimaLicitacao;

	/**
  	 * Construtor por argumentos
  	 * @param idComprador
  	 * @param limite
  	 * @param incrementos
  	 * @param minutos
  	 */	
	public Licitador(String idComprador, double limite, double incrementos, double minutos){
		this.idComprador = idComprador;
		this.limite = limite;
		this.incrementos = incrementos;
		this.minutos = minutos;
		this.ultimaLicitacao = 0;
		this.montante = 0.0;
	}

	/**
 	 * Construtor padrão
 	 */
	public Licitador() {
		idComprador = "n/a";
		limite = 0.0;
		this.ultimaLicitacao = 0;
		this.montante = 0.0;
		incrementos = 0.0;
		minutos = 0.0;
	}

	/**
 	 * Construtor por cópia
 	 * @param l
 	 */
	public Licitador(Licitador l) {
		idComprador = l.getComprador();
		limite = l.getLimite();
		incrementos = l.getIncrementos();
		minutos = l.getMinutos();
		this.ultimaLicitacao = 0;
		this.montante = 0.0;
	}

	/**
 	 * Obtem o id do licitador
 	 * @return String
 	 */
	public String getComprador() {
		return idComprador;
	}

	/**
 	 * Obter limite máximo do licitador
 	 * @return double
 	 */
	public double getLimite() {
		return limite;
	}

	public double getMontante() {
		return this.montante;
	}

	public long getUltimaLicitacao() {
		return this.ultimaLicitacao;
	}

	/**
 	 * Obter o valor incremento a cada intervalo
 	 * @return double
 	 */
	public double getIncrementos() {
		return incrementos;
	}

	/**
 	 * Obter o intervalo de tempo entre licitações
 	 * @return double
 	 */
	public double getMinutos() {
		return minutos;
	}

	/**
 	 * Define o licitador 
 	 * @param idComprador
 	 */
	public void setComprador(String idComprador) {
		this.idComprador = idComprador;
	}

	/**
 	 * Define o limite máximo
 	 * @param limite
 	 */
	public void setLimite(double limite) {
		this.limite = limite;
	}

	/**
 	 * Define o valor incrementado a cada intervalo
 	 * @param incrementos
 	 */
	public void setIncrementos(double incrementos) {
		this.incrementos = incrementos;
	}

	public void setMontante(double montante) {
		this.montante = montante;
	}

	public void setUltimaLicitacao(long ultimaLicitacao) {
		this.ultimaLicitacao = ultimaLicitacao;
	}
	
	/**
  	 * Define o intervalo de tempo entre licitações
  	 * @param minutos
  	 */
	public void setMinutos(double minutos) {
		this.minutos = minutos;
	}

	/**
 	 * Cria uma cópia do licitador
 	 * @return Licitador
 	 */
	public Licitador clone() {
		return new Licitador(this);
	}

	/**
 	 * Converte um licitador numa String
 	 * @return String
 	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("Id do Comprador: ").append(idComprador).append("\n");
		sb.append("Limite máximo: ").append(limite).append("\n");
		sb.append("Incrementos: ").append(incrementos).append("\n");
		sb.append("Intervalo em minutos: ").append(minutos).append("\n");

		return sb.toString();
	}

	/**
 	 * Compara dois objetos
 	 * @param Objeto
 	 * @return boolean
 	 */
	public boolean equals(Object o) {
		if (o == this)
			return true;

		if (o == null || this.getClass() != o.getClass())
			return false;

		Licitador l = (Licitador) o;
		return idComprador.equals(l.idComprador) &&
               limite == l.limite &&
               incrementos == l.incrementos &&
               minutos == l.minutos;
	}

}

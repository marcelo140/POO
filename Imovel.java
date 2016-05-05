import java.util.*;
/**
 * Abstract class Imovel - write a description of the class here
 */
public abstract class Imovel
{
	private String rua, estado;
	private double precoMinimo;
	private double precoPedido;
	private List<Consulta> consultas;

	/**
     * Construtor por parâmetros
     * @param rua
	 * @param estado
     * @param precoMinimo
     * @param precoPedido
	 * @param consultas
     */	
	public Imovel(String rua, String estado, double precoMinimo, double precoPedido, List<Consulta> consultas) {
		this.rua = rua;
		this.estado = estado;
		this.precoMinimo = precoMinimo;
		this.precoPedido = precoPedido;
		this.consultas = new ArrayList<Consulta>(consultas);
	}

	/**
     * Construtor padrão
     */	
	public Imovel() {
		this("n/a", "n/a", 0.0, 0.0, null);
	}

	/**
     * Construtor por cópia
     */
	public Imovel(Imovel i) {
		this.rua = i.getRua();
		this.estado = i.getEstado();
		this.precoMinimo = i.getPrecoMinimo();
		this.precoPedido = i.getPrecoPedido();
		this.consultas = new ArrayList<Consulta> (i.getConsultas());
	}

	/**
 	 * Obter nome da rua
 	 * @return
 	 */
	public String getRua() {
		return this.rua;
	}

	/**
 	 * Obter preço mínimo
 	 * @return
 	 */
	public double getPrecoMinimo() {
		return this.precoMinimo;
	}

	/**
     * Obter preço pedido
     * @return
     */
	public double getPrecoPedido() {
		return this.precoPedido;
	}

	/**
	 * Obter o estado do imóvel
	 * @return estado
	 */
	public String getEstado() {
		return this.estado;
	}

	/**
	 * Obter consultas do imóvel
	 * @return consultas
	 */
	public List<Consulta> getConsultas(  ) {
		return new ArrayList<Consulta> (consultas);
	}
	/**
     * Define nome da rua
     * @param rua
     */
	public void setRua(String rua) {
		this.rua = rua;
	}

	/**
	 * Define o estado
	 * @param estado
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}

	/**
     * Define preço mínimo
     * @param precoMinimo
     */
	public void setPrecoMinimo(double precoMinimo) {
		this.precoMinimo = precoMinimo;
	}

	/**
     * Define preço pedido
     * @param precoPedido
     */
	public void setPrecoPedido(double precoPedido) {
		this.precoPedido = precoPedido;
	}
	
	/**
     * Define consultas 
     * @param consultas
     */
	public void setConsultas(List<Consulta> consultas) {
		this.consultas = new ArrayList<Consulta> (consultas);
	}
	
	/**
	 * Verifica se um objeto dado é igual a este.
	 * @param o Objeto
	 */
	public boolean equals(Object o) {
		if (this == o) return true;
		if ((o == null) || (this.getClass() != o.getClass())) return false;
		else {
			Imovel i = (Imovel) o;
			return ( this.precoMinimo == i.precoMinimo &&
					 this.precoPedido == i.precoPedido && 
				     this.rua.equals(i.rua)); 
		}
	}

	/**
	 * HashCode da classe Imovel
	 * @return hashCode
	 */
	public int hashCode() {
		int hash = 7;
		long aux;

		hash = 31*hash + this.rua.hashCode();
		aux = Double.doubleToLongBits(this.precoMinimo);
		hash = 31*hash + (int)(aux^(aux >>> 32));
		aux = Double.doubleToLongBits(this.precoPedido);
		hash = 31*hash + (int)(aux^(aux >>> 32));

		return hash;
	}

	/**
 	 * Cria uma cópia do imóvel
 	 * @return Imóvel
 	 */
	public abstract Imovel clone();

	/**
	 * Adiciona uma consulta ao imóvel
	 * @param consulta
	 */
	public void addConsulta(Consulta c) {
		consultas.add(c);
	}
}

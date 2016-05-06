/**
 * Write a description of class Terreno here.
 */
public class Terreno extends Imovel
{
	private String tipo;
	private double area;
	private double diametroCanalizacao;
	private double potenciaSuportada;
	private boolean acessoEsgotos;

	/**
     * Construtor por parâmatros
     * @param rua
     * @param estado
     * @param precoMinimo
     * @param precoPedido
     * @param tipo
     * @param area
     * @param diametroCanalizacao
     * @param potenciaSuportada
     * @param acessoEsgotos
     */
	public Terreno(String rua, String estado, double precoMinimo, double precoPedido, 
                   String tipo, double area, double diametroCanalizacao, 
                   double potenciaSuportada, boolean acessoEsgotos) {
		super(rua, estado, precoMinimo, precoPedido);
		this.tipo = tipo;
		this.area = area;
		this.diametroCanalizacao = diametroCanalizacao;
		this.potenciaSuportada = potenciaSuportada;
		this.acessoEsgotos = acessoEsgotos;
	}

	/**
     * Construtor padrão
     */	
	public Terreno() {
		this("n/a", "n/a", 0, 0, "n/a", 0.0, 0.0, 0.0, false);
	}
	
	/**
     * Construtor por cópia
     */
	public Terreno(Terreno t) {
		super(t);
		this.diametroCanalizacao = t.getDiametroCanalizacao();
		this.potenciaSuportada = t.getPotenciaSuportada();
		this.acessoEsgotos = t.getAcessoEsgotos();
	}

	/**
     * Obter tipo de terreno
     * @return
     */
	public String getTipo() {
		return this.tipo;
	}

	/**
     * Obter área do terreno
     * @return
     */
	public double getArea() {
		return this.area;
	}

	/**
     * Obter diâmetro da canalização
     * @return
     */ 
	public double getDiametroCanalizacao() {
		return this.diametroCanalizacao;
	}

	/**
     * Obter potência suportada
     * @return
     */
	public double getPotenciaSuportada() {
		return this.potenciaSuportada;
	}

	/**
     * Determina se o terreno tem acesso aos esgotos
     * @return
     */
	public boolean getAcessoEsgotos() {
		return this.acessoEsgotos;
	}

	/**
     * Define tipo de terreno
     * @param tipo
     */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
     * Define a área do terreno
     * @param area
     */
	public void setArea(double area) {
		this.area = area;
	}

	/**
     * Define diâmetro da canalização
     * @param diametroCanalizacao
     */
	public void setDiametroCanalizacao(double diametroCanalizacao) {
		this.diametroCanalizacao = diametroCanalizacao;
	}
	
	/**
 	 * Define potência suportada
 	 * @param potenciaSuportada
 	 */
	public void setPotenciaSuportada(double potenciaSuportada) {
		this.potenciaSuportada = potenciaSuportada;
	}

	/**
 	 * Define se o terreno tem, ou não, acesso aos esgotos
 	 * @param acesso
 	 */
	public void setAcessoEsgotos(boolean acesso) {
		this.acessoEsgotos = acesso;
	}

	/**
	 * Verifica se um dado Objeto é igual a este Terreno.
	 * @param o Objeto
	 */
	public boolean equals(Object o) {
		if (this == o) return true;
		if ( (o == null) || (this.getClass() != o.getClass()) ) return false;
		else {
			Terreno t = (Terreno) o;
			return (super.equals(t) && 
					this.tipo.equals(t.getTipo()) &&
					this.area == t.getArea() && 
				  	this.diametroCanalizacao == t.getDiametroCanalizacao() &&
					this.potenciaSuportada == t.getPotenciaSuportada() &&
				  	this.acessoEsgotos == t.getAcessoEsgotos() );
		}
	}

	/**
	 * HashCode da classe Terreno
	 */
	public int hashCode() {
		int hash = 7;
		long aux;

		hash = 31*hash + super.hashCode();
		hash = 31*hash + this.tipo.hashCode();
		aux  = Double.doubleToLongBits(this.area);
		hash = 31*hash + (int)(aux^(aux >>> 32));
		aux  = Double.doubleToLongBits(this.diametroCanalizacao);
		hash = 31*hash + (int)(aux^(aux >>> 32));
		aux  = Double.doubleToLongBits(this.potenciaSuportada);
		hash = 31*hash + (int)(aux^(aux >>> 32));
		hash = 31*hash + (this.acessoEsgotos ? 0 : 1);

		return hash;
	}

	/**
 	 * Converte Terreno numa String
 	 * @return String
 	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("Tipo: ").append(tipo).append("\n");
		sb.append("Área: ").append(area).append("\n");
		sb.append("Diâmetro da canalização: ").append(diametroCanalizacao).append("\n");
		sb.append("Potência suportada: ").append(potenciaSuportada).append("\n");
		sb.append("Acesso aos esgotos: ").append(acessoEsgotos).append("\n");

		return sb.toString();
	}

	/**
 	 * Cria uma cópia do terreno
 	 * @return Terreno
 	 */
	public Terreno clone() {
		return new Terreno(this);
	}
}

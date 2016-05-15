/**
 * Write a description of class Terreno here.
 */

import java.util.ArrayList;

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
                   ArrayList<Consulta> consultas, String tipo, double area, 
                   double diametroCanalizacao, double potenciaSuportada, 
				   boolean acessoEsgotos) {

		super(rua, estado, precoMinimo, precoPedido, consultas);
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
		super();
		tipo = "n/a";
		area = 0.0;
		diametroCanalizacao = 0.0;
		potenciaSuportada = 0.0;
		acessoEsgotos = false;
	}
	
	/**
     * Construtor por cópia
     */
	public Terreno(Terreno t) {
		super(t);
		tipo = t.getTipo();
		area = t.getArea();
		diametroCanalizacao = t.getDiametroCanalizacao();
		potenciaSuportada = t.getPotenciaSuportada();
		acessoEsgotos = t.getAcessoEsgotos();
	}

	/**
     * Obter tipo de terreno
     * @return
     */
	public String getTipo() {
		return tipo;
	}

	/**
     * Obter área do terreno
     * @return
     */
	public double getArea() {
		return area;
	}

	/**
     * Obter diâmetro da canalização
     * @return
     */ 
	public double getDiametroCanalizacao() {
		return diametroCanalizacao;
	}

	/**
     * Obter potência suportada
     * @return
     */
	public double getPotenciaSuportada() {
		return potenciaSuportada;
	}

	/**
     * Determina se o terreno tem acesso aos esgotos
     * @return
     */
	public boolean getAcessoEsgotos() {
		return acessoEsgotos;
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
		if (this == o)
			 return true;

		if ( (o == null) || (this.getClass() != o.getClass()) ) 
			return false;

		Terreno t = (Terreno) o;
		return (super.equals(t) && 
				tipo.equals(t.getTipo()) &&
				area == t.getArea() && 
				diametroCanalizacao == t.getDiametroCanalizacao() &&
				potenciaSuportada == t.getPotenciaSuportada() &&
				acessoEsgotos == t.getAcessoEsgotos());
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

		sb.append(super.toString());
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

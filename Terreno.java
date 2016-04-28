
/**
 * Write a description of class Terreno here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Terreno extends Imovel
{
	private String tipo;
	private double area;
	private double diametroCanalizacao;
	private double potenciaSuportada;
	private boolean acessoEsgotos;

	/**
     * Construtor padrão
     */	
	public Terreno() {
		super();
		this.tipo = "n/a";
		this.area = 0.0;
		this.diametroCanalizacao = 0.0;
		this.potenciaSuportada = 0.0;
		this.acessoEsgotos = false;
	}
	
	/**
     * Construtor por parâmatros
     * @param rua
     * @param precoMinimo
     * @param precoPedido
     * @param tipo
     * @param area
     * @param diametroCanalizacao
     * @param potenciaSuportada
     * @param acessoEsgotos
     */
	public Terreno(String rua, double precoMinimo, double precoPedido, String tipo, double area, double diametroCanalizacao, double potenciaSuportada, boolean acessoEsgotos) {
		super(rua, precoMinimo, precoPedido);
		this.tipo = tipo;
		this.area = area;
		this.diametroCanalizacao = diametroCanalizacao;
		this.potenciaSuportada = potenciaSuportada;
		this.acessoEsgotos = acessoEsgotos;
	}

	/**
     * Construtor por cópia
     */
	public Terreno(Terreno t) {
		super.setRua(t.getRua());
		super.setPrecoMinimo(t.getPrecoMinimo());
		super.setPrecoPedido(t.getPrecoPedido());
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
}

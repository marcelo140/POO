
/**
 * Write a description of class Moradia here.
 */
public class Moradia extends Imovel
{
	private String tipo;
	private double areaImplantacao;
	private double areaCoberta;
	private double areaTerreno;
	private int quartos;
	private int wc;
	private int porta;

	/**
 	 * Construtor por parâmetro
 	 */
	public Moradia(String rua, double precoMinimo, double precoPedido,
                   String tipo, double areaImplantacao, double areaCoberta,
                   double areaTerreno, int quartos, int wc, int porta) {
		super(rua, precoMinimo, precoPedido);
		this.tipo = tipo;
		this.areaImplantacao = areaImplantacao;
		this.areaCoberta = areaCoberta;
		this.areaTerreno = areaTerreno;
		this.quartos = quartos;
		this.wc = wc;
		this.porta = porta;
	}

	/**
 	 * Construtor padrão
 	 */
	public Moradia() {
		this("n/a", 0.0, 0.0, "n/a", 0.0, 0.0, 0.0, 0, 0, 0);
	}

	/**
 	 * Construtor por cópia
 	 */
	public Moradia(Moradia m) {
		super(m);
		this.tipo = m.getTipo();
		this.areaImplantacao = m.getAreaImplantacao();
		this.areaCoberta = m.getAreaCoberta();
		this.areaTerreno = m.getAreaTerreno();
		this.quartos = m.getQuartos();
		this.wc = m.getWC();
		this.porta = m.getPorta();
	}

	/**
 	 * Obter tipo de moradia
 	 * @return
 	 */
	public String getTipo() {
		return this.tipo;
	}

	/**
 	 * Obter area de implantação
 	 * @result
 	 */
	public double getAreaImplantacao() {
		return this.areaImplantacao;
	}

	/**
 	 * Obter area coberta
 	 * @result
 	 */
	public double getAreaCoberta() {
		return this.areaCoberta;
	}

	/**
 	 * Obter area total do terreno
 	 * @result
 	 */
	public double getAreaTerreno() {
		return this.areaTerreno;
	}

	/**
 	 * Obter número de quartos da moradia
 	 * @result
 	 */
	public int getQuartos() {
		return this.quartos;
	}

	/**
 	 * Obter número de quartos da moradia
 	 * @result
 	 */
	public int getWC() {
		return this.wc;
	}

	/**
 	 * Obter número da porta da moradia
 	 * @result
 	 */
	public int getPorta() {
		return this.porta;
	}

	/**
 	 * Define o tipo de moradia
 	 * @param tipo
 	 */
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
  	 * Define a área de implantação da moradia
  	 * @param areaImplantacao
  	 */
	public void setAreaImplantacao(double areaImplantacao) {
		this.areaImplantacao = areaImplantacao;
	}

	/**
 	 * Define área coberta pela moradia
 	 * @param areaCoberta
 	 */
	public void setAreaCoberta(double areaCoberta) {
		this.areaCoberta = areaCoberta;
	}

	/**
  	 * Define a área total do terreno da moradia
  	 * @param areaTerreno
  	 */
	public void setAreaTerreno(double areaTerreno) {
		this.areaTerreno = areaTerreno;
	}

	/**
 	 * Define o número de quartos da moradia
 	 * @param quartos
 	 */
	public void setNumQuartos(int quartos) {
		this.quartos = quartos;
	}

	/**
 	 * Define o número de casas de banho da moradia
 	 * @param wc
 	 */
	public void setNumWC(int wc) {
		this.wc = wc;
	}

	/**
 	 * Define o número da porta da moradia
 	 * @param numeroPorta
 	 */
	public void setNumeroPorta(int numeroPorta) {
		this.porta = numeroPorta;
	}

	/**
	 * Verifica se um dado objeto é igual a esta Moradia.
	 * @param o Objeto
	 */
	public boolean equals(Object o) {
		if (this == o) return true;
		if ((o == null) || (this.getClass() != o.getClass())) return false;
		else {
			Moradia m = (Moradia) o;
			return (super.equals(m) &&
					this.tipo.equals(m.tipo) &&
                    this.areaImplantacao == m.areaImplantacao &&
					 this.areaCoberta == m.areaCoberta &&
				     this.areaTerreno == m.areaTerreno && 
				  	 this.quartos == m.quartos && 
				     this.wc == m.wc && 
					 this.porta == m.porta);
		}
	}

	/**
 	 * Cria uma cópia da Moradia
 	 * @return Moradia
 	 */
	public Moradia clone() {
		return new Moradia(this);
	}
}

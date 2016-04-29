
/**
 * Write a description of class Moradia here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Moradia extends Imovel
{
	private String tipo;
	private double areaImplantacao;
	private double areaCoberta;
	private double areaTerreno;
	private int numQuartos;
	private int numWC;
	private int numPorta;

	/**
 	 * Construtor por parâmetro
 	 */
	public Moradia(String rua, double precoMinimo, double precoPedido, String tipo, double areaImplantacao, double areaCoberta, double areaTerreno, int numQuartos, int numWC, int numPorta) {
		super(rua, precoMinimo, precoPedido);
		this.tipo = tipo;
		this.areaImplantacao = areaImplantacao;
		this.areaCoberta = areaCoberta;
		this.areaTerreno = areaTerreno;
		this.numQuartos = numQuartos;
		this.numWC = numWC;
		this.numPorta = numPorta;
	}

	/**
 	 * Construtor padrão
 	 */
	public Moradia() {
		super();
		this("n/a", 0.0, 0.0, 0.0, 0.0, 0, 0, 0);
	}

	/**
 	 * Construtor por cópia
 	 */
	public Moradia(Moradia m) {
		super(m.getRua(), m.getPrecoMinimo(), m.getPrecoPedido());
		this.tipo = m.getTipo();
		this.areaImplantacao = m.getAreaImplantacao();
		this.areaCoberta = m.getAreaCoberta();
		this.areaTerreno = m.getAreaTerreno();
		this.numQuartos = m.getNumQuartos();
		this.numWC = m.getNumWC();
		this.numPorta = m.getNumeroPorta();
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
	public int getNumQuartos() {
		return this.numQuartos;
	}

	/**
 	 * Obter número de quartos da moradia
 	 * @result
 	 */
	public int getNumWC() {
		return this.numWC;
	}

	/**
 	 * Obter número da porta da moradia
 	 * @result
 	 */
	public int getNumeroPorta() {
		return this.numPorta;
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
 	 * @param numQuartos
 	 */
	public void setNumQuartos(int numQuartos) {
		this.numQuartos = numQuartos;
	}

	/**
 	 * Define o número de casas de banho da moradia
 	 * @param numWC
 	 */
	public void setNumWC(int numWC) {
		this.numWC = numWC;
	}

	/**
 	 * Define o número da porta da moradia
 	 * @param numeroPorta
 	 */
	public void setNumeroPorta(int numeroPorta) {
		this.numPorta = numeroPorta;
	}
}


/**
 * Write a description of class Moradia here.
 */

import java.util.ArrayList;

public class Moradia extends Imovel implements Habitavel
{
	private String tipo;
	private double areaImplantacao, areaCoberta, areaTerreno;
	private int quartos, wc, porta;

	/**
 	 * Construtor por parâmetro
 	 * @param id
 	 * @param rua
 	 * @param estado
 	 * @param precoMinimo
 	 * @param precoPedido
 	 * @param tipo
 	 * @param areaImplantacao
 	 * @param areaCoberta
 	 * @param areaTerreno
 	 * @param quartos
 	 * @param wc
 	 * @param porta
 	 */
	public Moradia(String id, String rua, String estado, int precoMinimo, 
                   int precoPedido, ArrayList<Consulta> consultas, String tipo, 
                   double areaImplantacao, double areaCoberta,
                   double areaTerreno, int quartos, int wc, int porta) {

		super(id, rua, estado, precoMinimo, precoPedido, consultas);
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
		super();
		tipo = "n/a";
		areaImplantacao = 0.0;
		areaCoberta = 0.0;
		areaTerreno = 0.0;
		quartos = 0;
		wc = 0;
		porta = 0;	
	}

	/**
 	 * Construtor por cópia
 	 */
	public Moradia(Moradia m) {
		super(m);
		tipo = m.getTipo();
		areaImplantacao = m.getAreaImplantacao();
		areaCoberta = m.getAreaCoberta();
		areaTerreno = m.getAreaTerreno();
		quartos = m.getQuartos();
		wc = m.getWC();
		porta = m.getPorta();
	}

	/**
 	 * Obter tipo de moradia
 	 * @return
 	 */
	public String getTipo() {
		return tipo;
	}

	/**
 	 * Obter area de implantação
 	 * @result
 	 */
	public double getAreaImplantacao() {
		return areaImplantacao;
	}

	/**
 	 * Obter area coberta
 	 * @result
 	 */
	public double getAreaCoberta() {
		return areaCoberta;
	}

	/**
 	 * Obter area total do terreno
 	 * @result
 	 */
	public double getAreaTerreno() {
		return areaTerreno;
	}

	/**
 	 * Obter número de quartos da moradia
 	 * @result
 	 */
	public int getQuartos() {
		return quartos;
	}

	/**
 	 * Obter número de quartos da moradia
 	 * @result
 	 */
	public int getWC() {
		return wc;
	}

	/**
 	 * Obter número da porta da moradia
 	 * @result
 	 */
	public int getPorta() {
		return porta;
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
	public void setQuartos(int quartos) {
		this.quartos = quartos;
	}

	/**
 	 * Define o número de casas de banho da moradia
 	 * @param wc
 	 */
	public void setWC(int wc) {
		this.wc = wc;
	}

	/**
 	 * Define o número da porta da moradia
 	 * @param numeroPorta
 	 */
	public void setPorta(int numeroPorta) {
		this.porta = numeroPorta;
	}

	/**
	 * Verifica se um dado objeto é igual a esta Moradia.
	 * @param o Objeto
	 */
	public boolean equals(Object o) {
		if (this == o) 
			return true;

		if ((o == null) || (this.getClass() != o.getClass()))
			 return false;

		Moradia m = (Moradia) o;
		return (super.equals(m) &&
				this.tipo.equals(m.getTipo()) &&
				this.areaImplantacao == m.getAreaImplantacao() &&
				this.areaCoberta == m.getAreaCoberta() &&
			    this.areaTerreno == m.getAreaTerreno() && 
			  	this.quartos == m.getQuartos() && 
			    this.wc == m.getWC() && 
				this.porta == m.getPorta());
	}

	/**
 	 * Converte uma moradia numa String
 	 * @return String
 	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append(super.toString());
		sb.append("Tipo: ").append(tipo).append("\n");
		sb.append("Área de implantação: ").append(areaImplantacao).append("\n");
		sb.append("Área coberta: ").append(areaCoberta).append("\n");
		sb.append("Área do terreno: ").append(areaTerreno).append("\n");
		sb.append("Quartos: ").append(quartos).append("\n");
		sb.append("WC: ").append(wc).append("\n");
		sb.append("Porta: ").append(porta).append("\n");

		return sb.toString();
	}
	
	/**
	 * HashCode da classe Moradia
	 */
	public int hashCode() {
		int hash = 7;
		long aux;

		hash = 31*hash + super.hashCode();
		hash = 31*hash + tipo.hashCode();
		aux  = Double.doubleToLongBits(areaImplantacao);
		hash = 31*hash + (int)(aux^(aux >>> 32));
		aux  = Double.doubleToLongBits(areaCoberta);
		hash = 31*hash + (int)(aux^(aux >>> 32));
		aux  = Double.doubleToLongBits(areaTerreno);
		hash = 31*hash + (int)(aux^(aux >>> 32));
		hash = 31*hash + quartos;
		hash = 31*hash + wc;
		hash = 31*hash + porta;

		return hash;
	}

	/**
 	 * Cria uma cópia da Moradia
 	 * @return Moradia
 	 */
	public Moradia clone() {
		return new Moradia(this);
	}
}

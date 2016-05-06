
/**
 * Write a description of class Loja here.
 */

import java.util.ArrayList;

public class Loja extends Imovel
{
    private Apartamento parteHabitacional;
    private String tipoNegocio;
    private double area;
    private int porta;
    private boolean wc;

    /**
     * Construtor padrão
     */ 
    public Loja(){
       super();
       this.parteHabitacional = null;
       this.tipoNegocio = "n/a";
       this.area = 0;
       this.porta = 0;
       this.wc = false;
    }

    /**
     * Construtor por parâmatros
     * @param rua
     * @param estado
     * @param precoMinimo
     * @param precoPedido
     * @param parteHab
     * @param tipo
     * @param area
     * @param porta
     * @param wc
     */
    public Loja(String rua, String estado, double precoMinimo, double precoPedido,
                ArrayList<Consulta> consultas, Apartamento parteHab, String tipo, 
                double area, int porta, boolean wc) {
		super(rua, estado, precoMinimo, precoPedido, consultas);
		this.parteHabitacional = parteHab.clone();
		this.tipoNegocio = tipo;
		this.area = area;
		this.porta = porta;
		this.wc = wc;
	}

	/**
	 * Construtor por cópia
	 */
	public Loja(Loja t){
		super(t);
		this.parteHabitacional = t.getParteHabitacional();
		this.tipoNegocio = t.getTipoNegocio();
		this.area = t.getArea();
		this.porta = t.getPorta();
		this.wc = t.getWC();
	}

	/**
 	 * Obter parte habitacional da loja
 	 * @return Apartamento
 	 */
	private Apartamento getParteHabitacional() {
		return this.parteHabitacional.clone();
	}

    /**
     * Obter tipo de negócio da loja
     * @return
     */
    public String getTipoNegocio() {
     return this.tipoNegocio;
        }
    /**
     * Obter área total
     * @return
     */
    public double getArea(){
    return this.area;
    }
    /**
     * Obter número da porta
     * @return
     */
    public int getPorta(){
    return this.porta;
    }
    /**
     * Determina se o apartamento tem wc
     * @return
     */
    public boolean getWC(){
    return this.wc;
    }
    /**
     * Define tipo de negócio 
     * @param tipo
     */

	private void setParteHabitacional(Apartamento parteHab) {
		this.parteHabitacional = parteHab.clone();
	}

    public void setTipo(String tipo) {
        this.tipoNegocio = tipoNegocio;
    }
    /**
     * Define área da loja
     * @param area
     */
    public void setArea(double area) {
        this.area= area;
    }
    /**
     * Define número da porta
     * @param porta
     */
    public void setPorta(int porta) {
        this.porta = porta;
    }
    /**
     * Define se o apartamento tem, ou não, garagem
     * @param garagem
     */
    public void setwc(boolean wc) {
        this.wc = wc;
    }

	/**
	 * Verifica se o Objeto dado é igual a esta Loja
	 * @param o Objeto
	 */
	public boolean equals(Object o) {
		if (this == o) return true;
		if ((o == null) || (o.getClass() != this.getClass())) return false;
		else {
			Loja l = (Loja) o;
			return  super.equals(l) && 
					this.parteHabitacional.equals(l.parteHabitacional) &&
					this.tipoNegocio.equals(l.tipoNegocio) && 
					this.area == l.area &&
					this.wc == l.wc;
		}
	}

	/**
	 * HashCode da classe Loja
	 */
	public int hash() {
		int hash = 7;
		long aux;
	
		hash = 31*hash + super.hashCode();	
		hash = 31*hash + this.parteHabitacional.hashCode();
		hash = 31*hash + this.tipoNegocio.hashCode();
		aux = Double.doubleToLongBits(this.area);
		hash = 31*hash + (int)(aux^(aux >>> 32));
		hash = 31*hash + this.porta;
		hash = 31*hash + (this.wc ? 0 : 1);
		
		return hash;	
	}
	
	/**
 	 * Converte a Loja numa String
 	 * @return String
 	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append(super.toString());
		sb.append(parteHabitacional.toString());
		sb.append("Tipo de Negócio: ").append(tipoNegocio).append("\n");
		sb.append("Área: ").append(area).append("\n");
		sb.append("WC: ").append(wc).append("\n");

		return sb.toString();
	}

	/**
 	 * Cria uma cópia da loja
 	 * @return Loja
 	 */
	public Loja clone() {
		return new Loja(this);
	}
}


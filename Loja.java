
/**
 * Write a description of class Loja here.
 */

import java.util.ArrayList;

public class Loja extends Imovel
{
    private String tipoNegocio;
    private double area;
    private int porta;
    private boolean wc;

    /**
     * Construtor por parâmatros
     * @param id
     * @param rua
     * @param estado
     * @param precoMinimo
     * @param precoPedido
     * @param tipo
     * @param area
     * @param porta
     * @param wc
     */
    public Loja(String id, String rua, String estado, double precoMinimo, 
                double precoPedido, ArrayList<Consulta> consultas, String tipo, double area,
 				int porta, boolean wc) {

		super(id, rua, estado, precoMinimo, precoPedido, consultas);
		this.tipoNegocio = tipo;
		this.area = area;
		this.porta = porta;
		this.wc = wc;
	}
    
	/**
     * Construtor padrão
     */ 
    public Loja(){
       super();
       tipoNegocio = "n/a";
       area = 0;
       porta = 0;
       wc = false;
    }

	/**
	 * Construtor por cópia
	 */
	public Loja(Loja t){
		super(t);
		tipoNegocio = t.getTipoNegocio();
		area = t.getArea();
		porta = t.getPorta();
		wc = t.getWC();
	}

    /**
     * Obter tipo de negócio da loja
     * @return
     */
    public String getTipoNegocio() {
    	 return tipoNegocio;
    }

    /**
     * Obter área total
     * @return
     */
    public double getArea(){
	    return area;
    }

    /**
     * Obter número da porta
     * @return
     */
    public int getPorta(){
	    return porta;
    }

    /**
     * Determina se o apartamento tem wc
     * @return
     */
    public boolean getWC(){
	    return wc;
    }
    /**
     * Define tipo de negócio 
     * @param tipo
     */

    public void setTipo(String tipo) {
        this.tipoNegocio = tipoNegocio;
    }

    /**
     * Define área da loja
     * @param area
     */
    public void setArea(double area) {
        this.area = area;
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
		if (this == o)
			 return true;

		if ((o == null) || (o.getClass() != this.getClass())) 
			return false;

		Loja l = (Loja) o;
		return  super.equals(l) && 
				tipoNegocio.equals(l.getTipoNegocio()) && 
				area == l.getArea() &&
				wc == l.getWC();
	}

	/**
	 * HashCode da classe Loja
	 */
	public int hash() {
		int hash = 7;
		long aux;
	
		hash = 31*hash + super.hashCode();	
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

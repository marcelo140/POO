
/**
 * Write a description of class Loja here.
 */
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
     * @param precoMinimo
     * @param precoPedido
     * @param parteHab
     * @param tipo
     * @param area
     * @param porta
     * @param wc
     */
    public Loja(String rua, double precoMinimo, double precoPedido, Apartamento parteHab,
                String tipo, double area, int porta, boolean wc){
		super(rua, precoMinimo, precoPedido);
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
 	 * Cria uma cópia da loja
 	 * @return Loja
 	 */
	public Loja clone() {
		return new Loja(this);
	}
}


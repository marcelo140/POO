
/**
 * Write a description of class Apartamento here.
 */

public class Apartamento extends Imovel
{
    private String tipo;
    private double area;
    private int quartos;
    private int wc;
    private int andar;
    private int porta;
    private boolean garagem;
    
    /**
     * Construtor por parâmatros
     * @param rua
     * @param precoMinimo
     * @param precoPedido
     * @param tipo
     * @param area
     * @param quartos
     * @param wc
     * @param andar
     * @param porta
     * @param garagem
     */
    public Apartamento(String rua, double precoMinimo, double precoPedido,
                       String tipo, double area, int quartos,int wc, 
                       int andar, int porta, boolean garagem){
       super(rua, precoMinimo, precoPedido);
       this.tipo = tipo;
       this.area = area;
       this.quartos = quartos;
       this.wc = wc;
       this.andar = andar;
       this.porta = porta;
       this.garagem = garagem;
       }
    
	/**
     * Construtor padrão
     */	
    public Apartamento(){
       super();
       this.tipo = "n/a";
       this.area = 0;
       this.quartos = 0;
       this.wc = 0;
       this.andar = 0;
       this.porta = 0;
       this.garagem = false;
       }

    /**
     * Construtor por cópia
     */
	public Apartamento(Apartamento t){
		super(t);		
		this.tipo = t.getTipo();
		this.area = t.getArea();
		this.quartos = t.getNQuartos();
		this.wc = t.getWC();
		this.andar = t.getAndar();
		this.porta = t.getPorta();
		this.garagem = t.getGaragem();
	}

	/**
     * Obter tipo de apartamento
     * @return
     */
    public String getTipo() {
	 return this.tipo;
    }

    /**
     * Obter área total
     * @return
     */
    public double getArea(){
	    return this.area;
    }

    /**
     * Obter número de quartos
     * @return
     */
    public int getNQuartos(){
	    return this.quartos;
    }

    /**
     * Obter números de WCs
     * @return
     */
    public int getWC(){
	    return this.wc;
    }

    /**
     * Obter andar
     * @return
     */
    public int getAndar(){
	    return this.andar;
    }

    /**
     * Obter número da porta
     * @return
     */
    public int getPorta(){
	    return this.porta;
    }

    /**
     * Determina se o apartamento tem garagem
     * @return
     */
    public boolean getGaragem(){
	    return this.garagem;
    }

    /**
     * Define tipo de apartamento
     * @param tipo
     */
    public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	/**
     * Define área do apartamento
     * @param area
     */
	public void setArea(double area) {
		this.area= area;
	}

	/**
     * Define número de quartos
     * @param NQuartos
     */
	public void setQuartos(int quartos) {
		this.quartos = quartos;
	}

	/**
     * Define número de WCs
     * @param wc
     */
	public void setWC(int wc) {
		this.wc = wc;
	}

	/**
     * Define andar
     * @param andar
     */
	public void setAndar(int andar) {
		this.andar = andar;
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
	public void setGaragem(boolean garagem) {
		this.garagem = garagem;
	}

	/**
	 * Verifica se um dado Objeto é igual a este Apartamento
	 * @param o Objeto
	 */
	public boolean equals(Object o) {
		if (this == o) return true;
		if ((o == null) || (this.getClass() != o.getClass())) return false;
		else {
			Apartamento a = (Apartamento) o;
			return  super.equals(a) &&
					this.tipo.equals(a.tipo) && 
					this.area == a.area &&
					this.quartos == a.quartos &&
					this.wc == a.wc &&
					this.andar == a.andar &&
					this.porta == a.porta &&
					this.garagem == a.garagem;
		}
	}

	/**
	 * HashCode da classe Apartamento
	 */
	public int hashCode() {
		int hash = 7;
		long aux;
		
		hash = 31*hash + super.hashCode();
		hash = 31*hash + this.tipo.hashCode();
		aux  = Double.doubleToLongBits(this.area);
		hash = 31*hash + (int) (aux^(aux >>> 32));
		hash = 31*hash + this.quartos;
		hash = 31*hash + this.wc;
		hash = 31*hash + this.andar;
		hash = 31*hash + this.porta;
		hash = 31*hash + (this.garagem ? 0 : 1);

		return hash;
	}

	/**
 	 * Cria uma cópia do Apartamento
 	 */
	public Apartamento clone() {
		return new Apartamento(this);
	}
}


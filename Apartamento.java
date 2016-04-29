
/**
 * Write a description of class Apartamento here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Apartamento extends Imovel
{
    private String tipo;
    private double area;
    private int nQuartos;
    private int nWC;
    private int andar;
    private int porta;
    private boolean garagem;
    
    /**
     * Construtor padrão
     */	
    public Apartamento(){
       super();
       this.tipo = "indisponível";
       this.area = 0;
       this.nQuartos = 0;
       this.nWC = 0;
       this.andar = 0;
       this.porta = 0;
       this.garagem = false;
       }
    /**
     * Construtor por parâmatros
     * @param rua
     * @param precoMinimo
     * @param precoPedido
     * @param tipo
     * @param area
     * @param nQuartos
     * @param nWC
     * @param andar
     * @param porta
     * @param garagem
     */
    public Apartamento(String rua, double precoMinimo, double precoPedido, String tipo, double area, int nQuartos,int nWC, int andar, int porta, boolean garagem){
       super(rua, precoMinimo, precoPedido);
       this.tipo = tipo;
       this.area = area;
       this.nQuartos = nQuartos;
       this.nWC = nWC;
       this.andar = andar;
       this.porta = porta;
       this.garagem = garagem;
       }
    /**
     * Construtor por cópia
     */
       public Apartamento(Apartamento t){
	   super.setRua(t.getRua());
	   super.setPrecoMinimo(t.getPrecoMinimo());
	   super.setPrecoPedido(t.getPrecoPedido());
	   this.tipo = t.getTipo();
       this.area = t.getArea();
       this.nQuartos = t.getNQuartos();
       this.nWC = t.getNWC();
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
    return this.nQuartos;
    }
    /**
     * Obter números de WCs
     * @return
     */
    public int getNWC(){
    return this.nWC;
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
	public void setNQuartos(int nQuartos) {
		this.nQuartos = nQuartos;
	}
	/**
     * Define número de WCs
     * @param nWC
     */
	public void setNWC(int nWC) {
		this.nWC = nWC;
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
	 * @param o Obejto
	 */
	public boolean equals(Object o) {
		if (this == o) return true;
		if ((o == null) || (this.getClass() != o.getClass())) return false;
		else {
			Apartamento a = (Apartamento) o;
			return  super.equals(a) &&
					this.tipo.equals(a.tipo) && 
					this.area == a.area &&
					this.nQuartos == a.nQuartos &&
					this.nWC == a.nWC &&
					this.andar == a.andar &&
					this.porta == a.porta &&
					this.garagem == a.garagem;
		}
	}

}


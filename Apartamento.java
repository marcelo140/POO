/**
 * Write a description of class Apartamento here.
 */

import java.util.ArrayList;

public class Apartamento extends Imovel implements Habitavel {
	private String tipo;
	private double area;
	private int quartos, wc, andar, porta;
	private boolean garagem;
    
    /**
     * Construtor por parâmatros
     * @param id
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
	public Apartamento(String id, String rua, String estado, double precoMinimo, 
                       double precoPedido, ArrayList<Consulta> consultas, String tipo, 
                       double area, int quartos, int wc, int andar, int porta, 
                       boolean garagem){

		super(id, rua, estado, precoMinimo, precoPedido, consultas);
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
		this.quartos = t.getQuartos();
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
		return tipo;
    }

    /**
     * Obter área total
     * @return
     */
    public double getArea(){
	    return area;
    }

    /**
     * Obter número de quartos
     * @return
     */
    public int getQuartos(){
	    return quartos;
    }

    /**
     * Obter números de WCs
     * @return
     */
    public int getWC(){
	    return wc;
    }

    /**
     * Obter andar
     * @return
     */
    public int getAndar(){
	    return andar;
    }

    /**
     * Obter número da porta
     * @return
     */
    public int getPorta(){
	    return porta;
    }

    /**
     * Determina se o apartamento tem garagem
     * @return
     */
    public boolean getGaragem(){
	    return garagem;
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
		this.area = area;
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
		if (this == o) 
			return true;

		if ((o == null) || (this.getClass() != o.getClass())) 
			return false;

		Apartamento a = (Apartamento) o;
		return  super.equals(a) &&
				this.tipo.equals(a.getTipo()) && 
				this.area == a.getArea() &&
				this.quartos == a.getQuartos() &&
				this.wc == a.getWC() &&
				this.andar == a.getAndar() &&
				this.porta == a.getPorta() &&
				this.garagem == a.getGaragem();
	}

	/**
 	 * Converte um Apartamento numa String
 	 * @return String
 	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append(super.toString());
		sb.append("Tipo: ").append(tipo).append("\n");
		sb.append("Área: ").append(area).append("\n");
		sb.append("Quartos: ").append(quartos).append("\n");
		sb.append("WC: ").append(wc).append("\n");
		sb.append("Andar: ").append(andar).append("\n");
		sb.append("Porta: ").append(porta).append("\n");
		sb.append("Garagem: ").append(garagem).append("\n");
		
		return sb.toString();
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


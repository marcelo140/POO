
/**
 * Write a description of class LojaHabitavel here.
 */

import java.util.ArrayList;

public class LojaHabitavel extends Loja implements Habitavel {
	private String tipoApartamento;
	private double areaApartamento;
	private int quartos, wcApartamento, andar;
	private boolean garagem;

    /**
     * Construtor padrão
     */ 
    public LojaHabitavel(){
		super();
		tipoApartamento = "n/a";
		areaApartamento = 0.0;
		quartos = wcApartamento = andar = 0;
		garagem = false;
    }

    /**
     * Construtor por parâmatros
     * @param id
     * @param rua
     * @param estado
     * @param precoMinimo
     * @param precoPedido
     * @param consultas
     * @param tipo
     * @param area
     * @param porta
     * @param wc
     * @param tipoApartamento
     * @param areaApartamento
     * @param quartos
     * @param wcApartamento
     * @param andar
     */
    public LojaHabitavel(String id, String rua, String estado, int precoMinimo, 
                int precoPedido, ArrayList<Consulta> consultas, String tipo, double area, 
                boolean wc, int porta, String tipoApartamento, double areaApartamento, 
                int quartos, int wcApartamento, int andar) {

		super(id, rua, estado, precoMinimo, precoPedido, consultas, tipo, area, porta, wc);
		this.tipoApartamento = tipoApartamento;
		this.areaApartamento = areaApartamento;
		this.quartos = quartos;
		this.wcApartamento = wcApartamento;
		this.andar = andar;
	}

	/**
	 * Construtor por cópia
	 */
	public LojaHabitavel(LojaHabitavel t){
		super(t);
		tipoApartamento = t.getTipoApartamento();
		areaApartamento = t.getAreaApartamento();
		quartos = t.getQuartos();
		wcApartamento = t.getWcApartamento();
		andar = t.getAndar();
	}

	/**
 	 * Obter tipo de apartamento
 	 * @return Tipo
 	 */
	public String getTipoApartamento() {
		return tipoApartamento;
	}

	/**
 	 * Obter área do apartamento
 	 * @return área
 	 */
	public double getAreaApartamento() {
		return areaApartamento;
	}

	/**
 	 * Obter número de quartos
 	 * @return quartos
 	 */
	public int getQuartos() {
		return quartos;
	}

	/**
 	 * Obter número de wc no apartamento
 	 * @return número wc
 	 */
	public int getWcApartamento() {
		return wcApartamento;
	}

	/**
  	 * Obter andar da parte habitável
  	 * @return andar
  	 */
	public int getAndar() {
		return andar;
	}

	/**
 	 * Define tipo de apartamento
 	 * @param tipo
 	 */
	public void setTipoApartamento(String tipo) {
		this.tipoApartamento = tipo;
	}

	/**
 	 * Define área da parte habitacional
 	 * @param area
 	 */
	public void setAreaApartamento(double area) {
		this.areaApartamento = area;
	}

	/**
 	 * Define número de quartos da parte habitacional
 	 * @param quartos
 	 */
	public void setQuartos(int quartos) {
		this.quartos = quartos;
	}

	/**
 	 * Define número de wc na parte habitacional
 	 * @param wc
 	 */
	public void setWcApartamento(int wcApartamento) {
		this.wcApartamento = wcApartamento;
	}

	/**
 	 * Define andar da parte habitável
 	 * @param andar
 	 */
	public void setAndar(int andar) {
		this.andar = andar;
	}

	public boolean equals(Object o) {
		if (this == o)
			 return true;

		if ((o == null) || (o.getClass() != this.getClass())) 
			return false;

		LojaHabitavel l = (LojaHabitavel) o;
		return super.equals(l) &&
			   tipoApartamento.equals(l.getTipoApartamento()) &&  
			   areaApartamento == l.getAreaApartamento() &&
			   quartos == l.getQuartos() &&
			   wcApartamento == l.getWcApartamento() &&
			   andar == l.getAndar();
	}

	/**
	 * HashCode da classe LojaHabitavel
	 */
	public int hash() {
		int hash = 7;
		long aux;
	
		hash = 31*hash + super.hashCode();	
		hash = 31*hash + tipoApartamento.hashCode();
		aux = Double.doubleToLongBits(areaApartamento);
		hash = 31*hash + (int)(aux^(aux >>> 32));
		hash = 31*hash + quartos;
		hash = 31*hash + wcApartamento;
		hash = 31*hash + andar;
		
		return hash;	
	}
	
	/**
 	 * Converte a LojaHabitavel numa String
 	 * @return String
 	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append(super.toString());
		sb.append("Tipo apartamento: ").append(tipoApartamento).append("\n");
		sb.append("Área do apartamento: ").append(areaApartamento).append(" m²\n");
		sb.append("Número de quartos: ").append(quartos).append("\n");
		sb.append("Número de wc no apartamento: ").append(wcApartamento).append("\n");
		sb.append("Andar: ").append(andar).append("\n");
	
		return sb.toString();
	}

	/**
 	 * Cria uma cópia da loja
 	 * @return LojaHabitavel
 	 */
	public LojaHabitavel clone() {
		return new LojaHabitavel(this);
	}

}


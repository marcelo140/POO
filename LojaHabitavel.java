
/**
 * Write a description of class LojaHabitavel here.
 */

import java.util.ArrayList;

public class LojaHabitavel extends Loja implements Habitavel {
    private Apartamento parteHabitacional;

    /**
     * Construtor padrão
     */ 
    public LojaHabitavel(){
       super();
       this.parteHabitacional = new Apartamento();
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
    public LojaHabitavel(String rua, String estado, double precoMinimo, double precoPedido,
                ArrayList<Consulta> consultas, Apartamento parteHab, String tipo, 
                double area, int porta, boolean wc) {

		super(rua, estado, precoMinimo, precoPedido, consultas, tipo, area, porta, wc);
		setParteHabitacional(parteHab);
	}

	/**
	 * Construtor por cópia
	 */
	public LojaHabitavel(LojaHabitavel t){
		super(t);
		parteHabitacional = t.getParteHabitacional();
	}

	/**
 	 * Obter parte habitacional da loja
 	 * @return Apartamento
 	 */
	private Apartamento getParteHabitacional() {
		return parteHabitacional.clone();
	}

	private void setParteHabitacional(Apartamento parteHab) {
		parteHabitacional = parteHab.clone();
	}

	public boolean equals(Object o) {
		if (this == o)
			 return true;

		if ((o == null) || (o.getClass() != this.getClass())) 
			return false;

		LojaHabitavel l = (LojaHabitavel) o;
		return super.equals(l) && 
			   parteHabitacional.equals(l.getParteHabitacional());
	}

	/**
	 * HashCode da classe LojaHabitavel
	 */
	public int hash() {
		int hash = 7;
		long aux;
	
		hash = 31*hash + super.hashCode();	
		hash = 31*hash + this.parteHabitacional.hashCode();
		
		return hash;	
	}
	
	/**
 	 * Converte a LojaHabitavel numa String
 	 * @return String
 	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append(super.toString());
		sb.append(parteHabitacional.toString());
		
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


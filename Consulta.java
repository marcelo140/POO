import java.util.GregorianCalendar;
import java.util.Calendar;
/**
 * Classe que guarda a informação de quem consulta um anúncio. 
 */
public class Consulta {

	private GregorianCalendar data; // Data da consulta
	private String email; // Email do visitante

	/**
	 * Construtor por parametros.
	 * @param data data da consulta
	 * @param email email do visitante
	 */	
	public Consulta(GregorianCalendar data, String email) {
		this.data = (GregorianCalendar) data.clone(); 
		this.email = email;
	}

    /**
     * Construtor padrão 
     */
    public Consulta() {
		this.data = new GregorianCalendar();
		this.email = "n/a";
    }

	/**
	 * Construtor por cópia
	 * @param consulta 
	 */
	public Consulta(Consulta consulta) {
		this.data = (GregorianCalendar) consulta.data.clone();
		this.email = consulta.email;
	}

	/**
	 * Obtem data da consulta.
	 */ 
	public Calendar getData() {
		return (GregorianCalendar) this.data.clone();
	}

	/**
	 * Obtem email do visitante
	 */ 
	public String getEmail() {
		return this.email;
	}

	/**
	 * Define a data da consulta
	 * @param data
	 */
	private void setData(Calendar data) {
		this.data = (GregorianCalendar) data.clone();
	}

	/**
	 * Define o email do visitante
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Verifica se um dado objeto é igual a esta consulta
	 * @param o Objeto
	 */
	public boolean equals(Object o) {
		if (this == o) return true;
		if ( (o == null) || (this.getClass() != o.getClass()) ) return false;
		else {
			Consulta c = (Consulta) o;
			return  this.data.equals(c.data) && 
					this.email.equals(c.email) ;
		}
	}

	/**
	 * HashCode da Consulta
	 */
	public int hashCode() {
		int hash = 7;

		hash = 31*hash + data.hashCode();
		hash = 31*hash + email.hashCode();

		return hash;
	}

	/**
	 * Clone da Consulta
	 */
	public Consulta clone() {
		return new Consulta (this);
	}
}

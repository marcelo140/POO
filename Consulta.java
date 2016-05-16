import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * Classe que guarda a informação de quem consulta um anúncio. 
 */
public class Consulta implements Serializable {

	private LocalDateTime data; // Data da consulta
	private String email; // Email do visitante

	/**
	 * Construtor por parametros.
	 * @param data data da consulta
	 * @param email email do visitante
	 */	
	public Consulta(LocalDateTime data, String email) {
		this.data = data;
		this.email = email;
	}

    /**
     * Construtor padrão 
     */
    public Consulta() {
		this.data = LocalDateTime.now();
		this.email = "n/a";
    }

	/**
	 * Construtor por cópia
	 * @param consulta 
	 */
	public Consulta(Consulta consulta) {
		data = consulta.getData();
		email = consulta.getEmail();
	}

	/**
	 * Obtem data da consulta.
	 */ 
	public LocalDateTime getData() {
		return data;
	}

	/**
	 * Obtem email do visitante
	 */ 
	public String getEmail() {
		return email;
	}

	/**
	 * Define a data da consulta
	 * @param data
	 */
	private void setData(LocalDateTime data) {
		this.data = data;
	}

	/**
	 * Define o email do visitante
	 * @param email
	 */
	private void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Verifica se um dado objeto é igual a esta consulta
	 * @param o Objeto
	 */
	public boolean equals(Object o) {
		if (this == o) 
			return true;

		if ((o == null) || (this.getClass() != o.getClass())) 
			return false;

		Consulta c = (Consulta) o;
		return data.equals(c.getData()) && 
			   email.equals(c.getEmail());
	}

	/**
 	 * Converte o localtime numa String
 	 * @return String
 	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("Email: ").append(email).append("\n");
		sb.append("Data: ").append(data).append("\n");

		return sb.toString();
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
		return new Consulta(this);
	}
}

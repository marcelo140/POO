import java.time.LocalDate;
import java.io.Serializable;

/**
 * Abstract class Utilizador - Gerir dados do utilizador
 */

public abstract class Utilizador implements Serializable
{
	private String email, nome, password, morada;
	private LocalDate dataNascimento;

	/**
     * Construtor por parâmetros
     * @param email
     * @param nome
     * @param password
     * @param morada
     * @param dataNascimento
     */
	public Utilizador(String email, String nome, String password, String morada, 
                      LocalDate dataNascimento) {
		this.email = email;
		this.nome = nome;
		this.password = password;
		this.morada = morada;
		this.dataNascimento = dataNascimento;
	}

	/**
     * Construtor padrão
     */
	public Utilizador() {
		email = "n/a";
		nome = "n/a";
		password = "n/a";
		morada = "n/a";
		dataNascimento = LocalDate.now();
	}

	/**
     * Construtor por cópia
     */
	public Utilizador(Utilizador u) {
		email = u.getEmail();
		nome = u.getNome();
		password = u.getPassword();
		morada = u.getMorada();
		dataNascimento = u.getDataNascimento();
	}

	/**
     * Obter o email do utilizador
     */
	public String getEmail() {
		return email;
	}

	/**
     * Obter o nome do utilizador
     */
	public String getNome() {
		return nome;
	}

	/**
     * Obter a password do utilizador
     */
	public String getPassword() {
		return password;
	}

	/**
     * Obter morada do utilizador
     */
	public String getMorada() {
		return morada;
	}

    /**
     * Obter a data de nascimento do utilizador
     */
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	/**
     * Define o email do utilizador
     * @param email
     */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
     * Define o nome do utilizador
     * @param nome
     */
	public void setNome(String nome) {
		this.nome = nome;
	}

	/**
     * Define a password do utilizador
     * @param password
     */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
     * Define a morada do utilizador
     * @param morada
     */
	public void setMorada(String morada) {
		this.morada = morada;
	}

	/**
     * Define a data de nascimento do utilizador
     * @param dataNascimento
     */
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	/**
	 * Verifica se um dado Objeto é igual a este Utilizador.
	 * @param o Objeto
	 */
	public boolean equals(Object o) {
		if (this == o) 
			return true;

		if ((o == null) || (this.getClass() != o.getClass())) 
			return false;

		Utilizador u = (Utilizador) o;
		return (email.equals(u.getEmail()) &&
				nome.equals(u.getNome()) &&
				password.equals(u.getPassword()) &&
				morada.equals(u.getMorada()) &&
				dataNascimento.equals(u.getDataNascimento()));
	}

	/**
	 * HashCode da classe Utilizador
	 */
	public int hashCode() {
		int hash = 7;
		
		hash = 31*hash + email.hashCode();
		hash = 31*hash + nome.hashCode();
		hash = 31*hash + password.hashCode();
		hash = 31*hash + morada.hashCode();
		hash = 31*hash + dataNascimento.hashCode();

		return hash;
	}
	
	/**
 	 * Converte um utilizador numa String
 	 * @return String
 	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append("Email: ").append(email).append("\n");		
		sb.append("Nome: ").append(nome).append("\n");		
		sb.append("Morada: ").append(morada).append("\n");		
		sb.append("Data de Nascimento: ").append(dataNascimento.toString()).append("\n");	

		return sb.toString();	
	}

	/**
 	 * Cria uma cópia de um utilizador
 	 * @return Utilizador
 	 */
	public abstract Utilizador clone();
}

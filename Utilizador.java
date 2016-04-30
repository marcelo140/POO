import java.util.GregorianCalendar;

/**
 * Abstract class Utilizador - Gerir dados do utilizador
 */

public abstract class Utilizador
{
	private String email;
	private String nome;
	private String password;
	private String morada;
	private GregorianCalendar dataNascimento;

	/**
     * Construtor por parâmetros
     * @param email
     * @param nome
     * @param password
     * @param morada
     * @param dataNascimento
     */
	public Utilizador(String email, String nome, String password, String morada, GregorianCalendar dataNascimento) {
		this.email = email;
		this.nome = nome;
		this.password = password;
		this.morada = morada;
		this.dataNascimento = (GregorianCalendar) dataNascimento.clone();
	}

	/**
     * Construtor padrão
     */
	public Utilizador() {
		this("n/a", "n/a", "n/a", "n/a", null);
	}

	/**
     * Construtor por cópia
     */
	public Utilizador(Utilizador u) {
		this.email = u.getEmail();
		this.nome = u.getNome();
		this.password = u.getPassword();
		this.morada = u.getMorada();
		this.dataNascimento = u.getDataNascimento();
	}

	/**
     * Obter o email do utilizador
     */
	public String getEmail() {
		return this.email;
	}

	/**
     * Obter o nome do utilizador
     */
	public String getNome() {
		return this.nome;
	}

	/**
     * Obter a password do utilizador
     */
	public String getPassword() {
		return this.password;
	}

	/**
     * Obter morada do utilizador
     */
	public String getMorada() {
		return this.morada;
	}

    /**
     * Obter a data de nascimento do utilizador
     */
	public GregorianCalendar getDataNascimento() {
		return (GregorianCalendar) this.dataNascimento.clone();
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
	public void setDataNascimento(GregorianCalendar dataNascimento) {
		this.dataNascimento = (GregorianCalendar) dataNascimento.clone();
	}

	/**
	 * Verifica se um dado Objeto é igual a este Utilizador.
	 * @param o Objeto
	 */
	public boolean equals(Object o) {
		if (this == o) return true;
		if ((o == null) || (this.getClass() != o.getClass())) return false;
		else {
			Utilizador u = (Utilizador) o;
			return (this.email.equals(u.email) &&
					this.nome.equals(u.nome) &&
					this.password.equals(u.password) &&
					this.morada.equals(u.morada) &&
					this.dataNascimento.equals(u.dataNascimento));
		}
	}

	/**
	 * HashCode da classe Utilizador
	 */
	public int hashCode() {
		int hash = 7;
		
		hash = 31*hash + this.email.hashCode();
		hash = 31*hash + this.nome.hashCode();
		hash = 31*hash + this.password.hashCode();
		hash = 31*hash + this.morada.hashCode();
		hash = 31*hash + this.dataNascimento.hashCode();

		return hash;
	}

	/**
 	 * Cria uma cópia de um utilizador
 	 * @return Utilizador
 	 */
	public abstract Utilizador clone();
}

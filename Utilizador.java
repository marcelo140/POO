
/**
 * Abstract class Utilizador - write a description of the class here
 * 
 * @author (your name here)
 * @version (version number or date here)
 */
public abstract class Utilizador
{
	private String email;
	private String nome;
	private String password;
	private String morada;
	private String dataNascimento;

	/**
     * Construtor por parâmetros
     * @param email
     * @param nome
     * @param password
     * @param morada
     * @param dataNascimento
     */
	public Utilizador(String email, String nome, String password, String morada, String dataNascimento) {
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
		this("n/a", "n/a", "n/a", "n/a", "n/a");
	}

	/**
     * Construtor por cópia
     */
	public Utilizador(Utilizador util) {
		this.email = util.getEmail();
		this.nome = util.getNome();
		this.password = util.getPassword();
		this.morada = util.getMorada();
		this.dataNascimento = util.getDataNascimento();
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
	public String getDataNascimento() {
		return this.dataNascimento;
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
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
}

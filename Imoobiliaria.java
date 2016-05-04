import java.util.TreeMap;
import java.util.Map;

/**
 * Classe que definie a imoobiliaria 
 */
public class Imoobiliaria 
{
	String utilizador;
	private Map<String, Utilizador> utilizadores;
	private Map<Imovel, Vendedor> anuncios;

	/**
	 * Construtor por parametros
	 * @param utilizadores
	 * @param anuncios
	 */
	public Imoobiliaria(String sessao, Map<String, Utilizador> utilizadores, 
				Map<Imovel, Vendedor> anuncios) {
		this.utilizador = new String(utilizador);
		this.utilizadores = new TreeMap<String, Utilizador>(utilizadores);
		this.anuncios = new TreeMap<Imovel, Vendedor>(anuncios);
	}

	/**
	 * Construtor padrão
	 */
	public Imoobiliaria() {
		utilizador = null;
		this.utilizadores = new TreeMap<String, Utilizador>();
		this.anuncios = new TreeMap<Imovel, Vendedor>();
	}

	/**
	 * Construtor por cópia
	 * @param i imoobiliaria	
	 */
	public Imoobiliaria(Imoobiliaria i) {
		this(i.utilizador, i.utilizadores, i.anuncios);
	}

	/**
	 * Obtem utilizadores da imobiliaria
	 */
	private Map<String, Utilizador> getUtilizadores() {
		return new TreeMap<String, Utilizador>(this.utilizadores);
	}

	/**
	 * Obtem anúncios da imobiliaria
	 */
	private Map<Imovel, Vendedor> getAnuncios() {
		return new TreeMap<Imovel, Vendedor>(this.anuncios);
	}

	/**
	 * Define os utilizadores
	 * @param utilizadores
	 */
	private void setUtilizadores(Map<String, Utilizador> utilizadores) {
		this.utilizadores = new TreeMap<String, Utilizador> (utilizadores);
	}

	/**
	 * Define os Anúncios
	 * @param anuncios
	 */
	private void setAnuncios(Map<Imovel, Vendedor> anuncios) {
		this.anuncios = new TreeMap<Imovel, Vendedor> (anuncios);
	}
	
	/**
	 * Verifica se um dado Objeto é igual a esta Imoobiliaria
	 * @param o Objeto
	 */
	public boolean equals (Object o) {
		if ( this == o ) return true;
		if ( o == null || this.getClass() != o.getClass() ) return false;
		else {
			Imoobiliaria i = (Imoobiliaria) o;
			return  this.utilizadores.equals(i.utilizadores) &&
					this.anuncios.equals(i.anuncios);	
		} 	
	}

	/**
	 * HashCode da Imoobiliaria
	 */
	public int hashCode() {
		int hash = 7;

		hash = 31*hash + this.utilizadores.hashCode();
		hash = 31*hash + this.anuncios.hashCode();

		return hash;
	}

	/**
	 * Clone da Imoobiliaria
	 */
	public Imoobiliaria clone() {
		return new Imoobiliaria(this);
	}

	public void registarUtilizador(Utilizador utilizador) throws UtilizadorExistenteException {
		String id = utilizador.getEmail();

		if (this.utilizadores.containsKey(id))
			throw new UtilizadorExistenteException("Utilizador "+id+" já existe");

		this.utilizadores.put(utilizador.getEmail(), utilizador);
	}

	public void iniciaSessao(String email, String password) throws SemAutorizacaoException {
		Utilizador u = this.utilizadores.get(email);

		if (u == null)
			throw new SemAutorizacaoException("Utilizador "+email+" não existe");

		if (u.getPassword().equals(password) == false)
			throw new SemAutorizacaoException("Password não corresponde");

		this.utilizador = email;
	}

	public void fechaSessao() {
		this.utilizador = null;
	}

}

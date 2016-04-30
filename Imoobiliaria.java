import java.util.TreeMap;
import java.util.Map;

/**
 * Classe que definie a imoobiliaria 
 */
public class Imoobiliaria {

	private TreeMap<String, Utilizador> utilizadores;
	private TreeMap<Imovel, Vendedor> anuncios;

	/**
	 * Construtor por parametros
	 * @param utilizadores
	 * @param anuncios
	 */
	public Imoobiliaria(Map<String, Utilizador> utilizadores, 
				Map<Imovel, Vendedor> anuncios) {
		this.utilizadores = new TreeMap<String, Utilizador>(utilizadores);
		this.anuncios = new TreeMap<Imovel, Vendedor>(anuncios);
	}

	/**
	 * Construtor padrão
	 */
	public Imoobiliaria() {
		this.utilizadores = new TreeMap<String, Utilizador>();
		this.anuncios = new TreeMap<Imovel, Vendedor>();
	}

	/**
	 * Construtor por cópia
	 * @param i imoobiliaria	
	 */
	public Imoobiliaria(Imoobiliaria i) {
		this(i.utilizadores, i.anuncios);
	}

	/**
	 * Obtem utilizadores da imoobiliaria
	 */
	private Map<String, Utilizador> getUtilizadores() {
		return new TreeMap<String, Utilizador>(this.utilizadores);
	}

	/**
	 * Obtem anúncios da imoobiliaria
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
}

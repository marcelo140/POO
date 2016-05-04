import java.util.TreeMap;
import java.util.Map;

/**
 * Classe que definie a imoobiliaria 
 */
public class Imoobiliaria 
{
	Utilizador utilizador;
	private Map<String, Utilizador> utilizadores;
	private Map<Imovel, Vendedor> anuncios;
	private Map<String, Imovel> imoveis; //IdImovel -> Imovel

	/**
	 * Construtor por parametros
	 * @param utilizador
	 * @param utilizadores
	 * @param anuncios
	 * @param imoveis
	 */
	public Imoobiliaria(Vendedor utilizador, Map<String, Utilizador> utilizadores, 
				Map<Imovel, Vendedor> anuncios, Map<String, Imovel> imoveis) {
		this.utilizador = new Vendedor(utilizador);
		this.utilizadores = new TreeMap<String, Utilizador>(utilizadores);
		this.anuncios = new TreeMap<Imovel, Vendedor>(anuncios);
		this.imoveis = new TreeMap<String, Imovel>(imoveis);
	}

	/**
	 * Construtor por parametros
	 * @param utilizador
	 * @param utilizadores
	 * @param anuncios
	 * @param imoveis
	 */
	public Imoobiliaria(Comprador utilizador, Map<String, Utilizador> utilizadores, 
				Map<Imovel, Vendedor> anuncios, Map<String, Imovel> imoveis) {
		this.utilizador = new Comprador(utilizador);
		this.utilizadores = new TreeMap<String, Utilizador>(utilizadores);
		this.anuncios = new TreeMap<Imovel, Vendedor>(anuncios);
		this.imoveis = new TreeMap<String, Imovel>(imoveis);
	}

	/**
	 * Construtor padrão
	 */
	public Imoobiliaria() {
		utilizador = null;
		this.utilizadores = new TreeMap<String, Utilizador>();
		this.anuncios = new TreeMap<Imovel, Vendedor>();
		this.imoveis = new TreeMap<String, Imovel>();
	}

	/**
	 * Construtor por cópia
	 * @param i imoobiliaria	
	 */
	public Imoobiliaria(Imoobiliaria i) {
		if(i.utilizador.getClass().getSimpleName().equals("Vendedor"))
			this.utilizador = new Vendedor((Vendedor) i.utilizador);
		
		
		this.utilizadores = new TreeMap<String, Utilizador>(i.utilizadores);
		this.anuncios = new TreeMap<Imovel, Vendedor>(i.anuncios);
		this.imoveis = new TreeMap<String, Imovel>(i.imoveis);
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
	 * Obtem todos os imóveis da imobiliaria
	 */
	private Map<String, Imovel> getImoveis() {
		return new TreeMap<String, Imovel>(this.imoveis);
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
	 * Define os Imóveis
	 * @param imoveis
	 */
	private void setImoveis(Map<String, Imovel> imoveis) {
		this.imoveis = new TreeMap<String, Imovel> (imoveis);
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

		this.utilizador = this.utilizadores.get(email);
	}

	public void fechaSessao() {
		this.utilizador = null;
	}

	/**
	 * Regista um imóvel na imoobiliaria
	 * @param im Imóvel
	 * @throws ImovelExisteException Caso o imóvel a adicionar já existe
	 * @throws SemAutorizacaoException Caso o utilizador não tenha autorização
	 */
	public void registaImovel(Imovel im) throws ImovelExisteException, SemAutorizacaoException {
		
		if (this.utilizador.getClass().getSimpleName().equals("Cliente"))
			throw new SemAutorizacaoException("Utilizador " + this.utilizador.getNome() + " não está inscrito como Vendedor");

		if (this.anuncios.containsKey(im))
			throw new ImovelExisteException("Imóvel já existe.");

		this.imoveis.put(im.hashCode() + "", im);
	}
}

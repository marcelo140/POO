import java.util.*;

/**
 * Classe que definie a imobiliaria 
 */
public class Imoobiliaria 
{
	// Utilizador logado
	private Utilizador utilizador;
	// Lista de utilizadores registados na aplicação
	private Map<String, Utilizador> utilizadores; //Email -> Utilizador
	private Map<Imovel, Vendedor> anuncios;
	private Map<String, Imovel> imoveis; //IdImovel -> Imovel

	/**
	 * Construtor por parametros
	 * @param utilizador
	 * @param utilizadores
	 * @param anuncios
	 * @param imoveis
	 */
	public Imoobiliaria(Utilizador utilizador, Map<String, Utilizador> utilizadores, 
						Map<Imovel, Vendedor> anuncios, Map<String, Imovel> imoveis) {

		setUtilizador(utilizador);
		setUtilizadores(utilizadores);
		setAnuncios(anuncios);
		setImoveis(imoveis);
	}

	/**
	 * Construtor padrão
	 */
	public Imoobiliaria() {
		utilizador = null;
		utilizadores = new TreeMap<String, Utilizador>();
		anuncios = new TreeMap<Imovel, Vendedor>();
		imoveis = new TreeMap<String, Imovel>();
	}

	/**
	 * Construtor por cópia
	 * @param i imoobiliaria	
	 */
	public Imoobiliaria(Imoobiliaria i) {
		utilizador = i.getUtilizador();	
		utilizadores = i.getUtilizadores();
		anuncios = i.getAnuncios();
		imoveis = i.getImoveis();
	}

	/**
 	 * Obtem utilizador logado
 	 * @return Utilizador
 	 */
	private Utilizador getUtilizador() {
		Vendedor v;
		Comprador c;

		if (utilizador instanceof Vendedor) {
			v = (Vendedor) utilizador;
			return v.clone();
		}

		if (utilizador instanceof Comprador) {
			c = (Comprador) utilizador;
			return c.clone();
		}

		return null;
	}

	/**
	 * Obtem utilizadores da imobiliaria
	 */
	private Map<String, Utilizador> getUtilizadores() {
		return new TreeMap<String, Utilizador>(utilizadores);
	}

	/**
	 * Obtem anúncios da imobiliaria
	 */
	private Map<Imovel, Vendedor> getAnuncios() {
		return new TreeMap<Imovel, Vendedor>(anuncios);
	}

	/**
	 * Obtem todos os imóveis da imobiliaria
	 */
	private Map<String, Imovel> getImoveis() {
		return new TreeMap<String, Imovel>(imoveis);
	}

	/**
 	 * Define o utilizador logado
 	 * @param Utilizador
 	 */
	private void setUtilizador(Utilizador u) {
		if (u instanceof Vendedor)
			utilizador = new Vendedor((Vendedor) u);
		else if (u instanceof Comprador)
			utilizador = new Comprador((Comprador) u);
		else
			utilizador = null;
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

		if (!u.getPassword().equals(password))
			throw new SemAutorizacaoException("Password não corresponde");

		this.utilizador = this.utilizadores.get(email);
	}

	public void fechaSessao() {
		this.utilizador = null;
	}

/************************** Vendedores ******************************/

	/**
	 * Regista um imóvel na imoobiliaria
	 * @param im Imóvel
	 * @throws ImovelExisteException Caso o imóvel a adicionar já existe
	 * @throws SemAutorizacaoException Caso o utilizador não tenha autorização
	 */
	public void registaImovel(Imovel im) throws ImovelExisteException, SemAutorizacaoException {
		
		if (!(this.utilizador instanceof Vendedor))
			throw new SemAutorizacaoException("Utilizador não está inscrito como Vendedor");

		if (this.anuncios.containsKey(im))
			throw new ImovelExisteException("Imóvel já existe.");

		this.imoveis.put(im.hashCode() + "", im);
		this.anuncios.put(im, (Vendedor) utilizador);
	}

	/**
	 * Devolve lista com as datas (e emails, caso exista essa informação) das
	 * 10 últimas consultas aos imóveis que tem para venda.
	 * @throws SemAutorizacaoException Caso o utilizador não esteja ligado como Vendedor
	 * @return Lista com as 10 últimas consultas
	 */
	public List<Consulta> getConsultas() throws SemAutorizacaoException {
		ArrayList<Consulta> consultas = new ArrayList<>();
		Vendedor v;
		ArrayList<Imovel> imoveis; 

		if (!(utilizador instanceof Vendedor))
			throw new SemAutorizacaoException("O utilizador não está ligado como Vendedor");

		v = new Vendedor((Vendedor) utilizador);
		imoveis = (ArrayList<Imovel>) v.getImoveisEmVenda();
 
		for (Imovel i : imoveis ) {
			consultas.addAll(i.getConsultas());	
		}

		consultas.sort((c1, c2) -> c1.getData().compareTo(c2.getData()) );

		return consultas.subList(0, 10);
	}

	/**
	 * Altera o estado de um imóvel
	 * @param idImovel
	 * @param estado
	 * @throws ImovelInexistenteException Caso o imóvel não exista
	 * @throws SemAutorizacaoException Caso o utilizador não esteja ligado como Vendedor
	 * @throws EstadoInvalidoException Caso o estado dado não seja válido
	 */  
	public void setEstado(String idImovel, String estado) 
							throws ImovelInexistenteException ,
							       SemAutorizacaoException ,
		   						   EstadoInvalidoException {
		
		if (!(utilizador instanceof Vendedor))
			throw new SemAutorizacaoException("Utilizador não está ligado como Vendedor");
		if (!imoveis.containsKey(idImovel))
			throw new ImovelInexistenteException("Imóvel inexistente");
		if (!(estado.equals("venda") || estado.equals("reservado") || 
				estado.equals("vendido")))
			throw new EstadoInvalidoException("Estado deve ser 'venda', 'reservado' ou 'vendido'");

		 imoveis.get(idImovel).setEstado(estado);
	}

	/**
	 * Obter os códigos dos n imóveis mais consultados.
	 * @param n
	 * @return Conjunto com os n imóveis
	 */
	public Set<String> getTopImoveis(int n) {
		List<String> topImoveis = new ArrayList<String>();

		for(String s: imoveis.keySet()) {
			topImoveis.add(s);
		}
	
		topImoveis.sort((s1, s2) -> imoveis.get(s2).getConsultas().size() 
				- imoveis.get(s1).getConsultas().size());

		return new TreeSet<String>(topImoveis.subList(0,n));
	}

	
/************************** Todos os Utilizadores ******************************/

	/**
	 * Devolve uma lista de imóveis da classe dada com preco inferior ao preco dado
	 * @param classe
	 * @param preco
	 * @return Lista de Imóveis
	 */
	public List<Imovel> getImovel(String classe, int preco) {
		List<Imovel> l = new ArrayList<Imovel>();

		for (Imovel i : this.imoveis.values()) {
			if (i.getClass().getSimpleName().equals(classe) && i.getPrecoPedido() <= preco)
				l.add(i);
		}

		return l;
	}

	/**
	 * Obter lista de imóveis habitáveis até um dado preço
	 * @param preco
	 * @return lista de imóveis habitáveis
	 */
	public List<Habitavel> getHabitaveis(int preco) {
		ArrayList<Habitavel> imoveisHabitaveis = new ArrayList<>();

		for (Imovel i : this.imoveis.values()) {
			if (i instanceof LojaHabitavel ||
				   	i instanceof Moradia || i instanceof Apartamento) {
				Habitavel h = (Habitavel) i;
				imoveisHabitaveis.add(h);
			}
		}

		return imoveisHabitaveis;
	}

	/**
	 * Obter mapeamento para cada imóvel, respetivo vendedor
	 * @return Mapeamento imovel, vendedor
	 */
	public Map<Imovel, Vendedor> getMapeamentoImoveis() {
		return new TreeMap<Imovel, Vendedor> (anuncios);
	}

/************************** Compradores ******************************/
	
	/**
	 * Marcar um imóvel como favorito
	 * @param idImovel
	 * @throws ImovelInexistenteException Caso o imóvel não exista
	 * @throws SemAutorizacaoException Caso o utilizador não esteja ligado como Comprador
	 */
	public void setFavorito(String idImovel) throws ImovelInexistenteException, 
		   											SemAutorizacaoException{

		if (!(utilizador instanceof Comprador))
			throw new SemAutorizacaoException("Utilizador não está ligado como Comprador");
		if (!(imoveis.containsKey(idImovel)))
			throw new ImovelInexistenteException("Imovel não existe.");

		Comprador c = (Comprador) utilizador;
		Imovel i = imoveis.get(idImovel);
		c.addFavoritos(i);		
	}

	/**
	 * Obter imóveis favoritos de um utilizador ordenados por preço.
	 * @throws SemAutorizacaoException Caso o utilizador não esteja ligado como Comprador.
	 * @return Conjunto de imóveis ordenados por preço.
	 */
	public TreeSet<Imovel> getFavoritos() throws SemAutorizacaoException {
		
		if (!(utilizador instanceof Comprador))
			throw new SemAutorizacaoException("Utilizador não está ligado como Comprador");

		Comprador c = (Comprador) utilizador;
	
		ArrayList<Imovel> favs = new ArrayList<Imovel>(c.getFavoritos());
		favs.sort((i1, i2) -> Double.compare(i1.getPrecoPedido(), i2.getPrecoPedido()));

		return new TreeSet<Imovel> (favs);
	}

}

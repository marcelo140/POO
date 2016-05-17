import java.util.*;
import java.io.*;
import java.util.stream.Collectors;
import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * Classe que definie a imobiliaria 
 */
public class Imoobiliaria implements Serializable
{
	private static int numImoveis = 0;
	private static int getNumImoveis() { return numImoveis; }
	private static void incNumImoveis() { numImoveis++; }

	private Utilizador utilizador;
	private Map<String, Utilizador> utilizadores; //Email -> Utilizador
	private Map<String, Imovel> anuncios; //IdImovel -> Imovel

	/**
	 * Construtor por parametros
	 * @param utilizador
	 * @param utilizadores
	 * @param anuncios
	 */
	public Imoobiliaria(Utilizador utilizador, Map<String, Utilizador> utilizadores, 
						Map<String, Imovel> anuncios) {

		setUtilizador(utilizador);
		setUtilizadores(utilizadores);
		setAnuncios(anuncios);
	}

	/**
	 * Construtor padrão
	 */
	public Imoobiliaria() {
		utilizador = null;
		utilizadores = new TreeMap<String, Utilizador>();
		anuncios = new TreeMap<String, Imovel>();
	}

	/**
	 * Construtor por cópia
	 * @param i imoobiliaria	
	 */
	public Imoobiliaria(Imoobiliaria i) {
		utilizador = i.getUtilizador();	
		utilizadores = i.getUtilizadores();
		anuncios = i.getAnuncios();
	}
	
	/**
 	 * Obtem o tipo de utilizador:
 	 * 0 - não existe
 	 * 1 - comprador
 	 * 2 - vendedor
 	 */
	public int getTipoUtilizador() {
		if (utilizador instanceof Comprador)
			return 1;

		if (utilizador instanceof Vendedor)
			return 2;

		return 0;
	}	

	private String getUserEmail() {
		if (utilizador != null)
			return utilizador.getEmail();		

		return "n/a";
	}

	/**
 	 * Obtem utilizador logado
 	 * @return Utilizador
 	 */
	private Utilizador getUtilizador() {
		switch (getTipoUtilizador()) {
			case 1: Comprador c = (Comprador) utilizador;
                    return c.clone();
			case 2: Vendedor v = (Vendedor) utilizador;
					return v.clone();			
		}

		return null;
	}

	/**
	 * Obtem utilizadores da imobiliaria
	 */
	private Map<String, Utilizador> getUtilizadores() {
		utilizadores = new TreeMap<String, Utilizador>();

		for(Map.Entry<String, Utilizador> entry: this.utilizadores.entrySet())
			utilizadores.put(entry.getKey(), entry.getValue().clone());

		return utilizadores;
	}

	/**
	 * Obtem anúncios da imobiliaria
	 */
	private Map<String, Imovel> getAnuncios() {
		anuncios = new TreeMap<String, Imovel>();

		for(Map.Entry<String, Imovel> entry: this.anuncios.entrySet())
			anuncios.put(entry.getKey(), entry.getValue().clone());

		return anuncios;
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
		this.utilizadores = new TreeMap<String, Utilizador>();

		for(Map.Entry<String, Utilizador> entry: utilizadores.entrySet())
			this.utilizadores.put(entry.getKey(), entry.getValue().clone());
	}

	/**
	 * Define os Anúncios
	 * @param anuncios
	 */
	private void setAnuncios(Map<String, Imovel> anuncios) {
		this.anuncios = new TreeMap<String, Imovel>();

		for(Map.Entry<String, Imovel> entry: anuncios.entrySet())
			this.anuncios.put(entry.getKey(), entry.getValue().clone());
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

		utilizador = utilizadores.get(email);
	}

	public void fechaSessao() {
		utilizador = null;
	}

/************************** Vendedores ******************************/

	/**
	 * Regista um imóvel na imoobiliaria
	 * @param im Imóvel
	 * @throws ImovelExisteException Caso o imóvel a adicionar já existe
	 * @throws SemAutorizacaoException Caso o utilizador não tenha autorização
	 */
	public void registaImovel(Imovel im) throws ImovelExisteException, SemAutorizacaoException {
		Vendedor v;

		if (!(utilizador instanceof Vendedor))
			throw new SemAutorizacaoException("Utilizador não está inscrito como Vendedor");

		if (anuncios.containsValue(im))
			throw new ImovelExisteException("Imóvel já existe.");

		v = (Vendedor) utilizador;
		
		v.addImovelEmVenda(im);	
		anuncios.put(Integer.toString(getNumImoveis()), im);

		incNumImoveis();
	}

	/**
	 * Devolve lista com as datas (e emails, caso exista essa informação) das
	 * 10 últimas consultas aos imóveis que tem para venda.
	 * @throws SemAutorizacaoException Caso o utilizador não esteja ligado como Vendedor
	 * @return Lista com as 10 últimas consultas
	 */
	public List<Consulta> getConsultas() throws SemAutorizacaoException {
		ArrayList<Consulta> consultas = new ArrayList<>();
		ArrayList<Imovel> imoveis; 
		Vendedor v;

		if (!(utilizador instanceof Vendedor))
			throw new SemAutorizacaoException("O utilizador não está ligado como Vendedor");

		v = (Vendedor) utilizador;
		imoveis = (ArrayList<Imovel>) v.getImoveisEmVenda();
 
		for (Imovel i: imoveis){
			consultas.addAll(i.getConsultas());	
		}

		consultas.sort((c1, c2) -> c1.getData().compareTo(c2.getData()));

		return consultas.subList(0, 9);
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

		if (!anuncios.containsKey(idImovel))
			throw new ImovelInexistenteException("Imóvel inexistente");

		if (!(estado.equals("em venda") || estado.equals("reservado") || estado.equals("vendido")))
			throw new EstadoInvalidoException("Estado deve ser 'em venda', 'reservado' ou 'vendido'");

		
		 anuncios.get(idImovel).setEstado(estado);
	}

	/**
	 * Obter os códigos dos n imóveis mais consultados.
	 * @param n
	 * @return Conjunto com os n imóveis
	 */

	public Set<String> getTopImoveis(int n) throws SemAutorizacaoException {
		ArrayList<Imovel> topImoveis;
		Vendedor v;

		if (!(utilizador instanceof Vendedor))
			throw new SemAutorizacaoException("Utilizador não está ligado como vendedor");	

		v = (Vendedor) utilizador;
		topImoveis = (ArrayList<Imovel>) v.getImoveisEmVenda();
	
		topImoveis.sort((s1, s2) -> s2.getConsultas().size() - s1.getConsultas().size());

		return new TreeSet<String>(topImoveis.subList(0,n-1).stream().map(Imovel::getID).collect(Collectors.toSet()));
	}

	
/************************** Todos os Utilizadores ******************************/

	/**
	 * Devolve uma lista de imóveis da classe dada com preco inferior ao preco dado
	 * @param classe
	 * @param preco
	 * @return Lista de Imóveis
	 */
	public List<Imovel> getImovel(String classe, double preco) {
		List<Imovel> lista = new ArrayList<Imovel>();

		for (Imovel im: anuncios.values()) {
			if (im.getClass().getSimpleName().equals(classe) && im.getPrecoPedido() <= preco) {
				lista.add(im);
				im.addConsulta(new Consulta(LocalDateTime.now(), getUserEmail()));
			}
		}

			

		return lista;
	}

	/**
	 * Obter lista de imóveis habitáveis até um dado preço
	 * @param preco
	 * @return lista de imóveis habitáveis
	 */
	public List<Habitavel> getHabitaveis(double preco) {
		ArrayList<Habitavel> imoveisHabitaveis = new ArrayList<>();

		for (Imovel im: anuncios.values()) {
			if (im instanceof Habitavel) {
				im.addConsulta(new Consulta(LocalDateTime.now(), getUserEmail()));
				Habitavel h = (Habitavel) im;
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
		TreeMap<Imovel, Vendedor> map = new TreeMap<>();

		for(Utilizador u: utilizadores.values()) {
			if (u instanceof Vendedor) {
				Vendedor v = (Vendedor) u;

				for(Imovel im: v.getImoveisEmVenda()){
					im.addConsulta(new Consulta(LocalDateTime.now(), getUserEmail()));
					map.put(im, v);
				}
			}
		}

		return map;
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

		if (!(anuncios.containsKey(idImovel)))
			throw new ImovelInexistenteException("Imovel não existe.");

		Comprador c = (Comprador) utilizador;
		Imovel i = anuncios.get(idImovel);

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
	
		return (TreeSet<Imovel>) c.getFavoritos();
	}

	/**
 	 * Gravar estado da aplicação
 	 * @param ficheiro
 	 */
	public void gravar() throws IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("imoobiliaria.data"));
		oos.writeObject(this);

		oos.flush();
		oos.close();
	}

	/**
 	 * Iniciar aplicação com os dados guardados
 	 * @return Imoobiliaria
 	 */
	public static Imoobiliaria initApp() throws IOException, ClassNotFoundException {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("imoobiliaria.data"));
		Imoobiliaria im = (Imoobiliaria) ois.readObject();

		ois.close();
		return im;
	}
}

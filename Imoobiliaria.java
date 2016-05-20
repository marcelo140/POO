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
	private int numImoveis;
	private int getNumImoveis() { return numImoveis; }
	private void incNumImoveis() { numImoveis++; }

	private Utilizador utilizador;
	private Map<String, Utilizador> utilizadores; //Email -> Utilizador
	private Map<String, Imovel> anuncios;

	/**
	 * Construtor por parametros
	 * @param utilizador
	 * @param utilizadores
	 * @param anuncios
	 */
	public Imoobiliaria(Utilizador utilizador, Map<String, Utilizador> utilizadores, 
						Map<String, Imovel> anuncios, int numImoveis) {

		setUtilizador(utilizador);
		setUtilizadores(utilizadores);
		setAnuncios(anuncios);
		this.numImoveis = numImoveis;
	}

	/**
	 * Construtor padrão
	 */
	public Imoobiliaria() {
		utilizador = null;
		utilizadores = new TreeMap<String, Utilizador>();
		anuncios = new TreeMap<String, Imovel>();
		numImoveis = 0;
	}

	/**
	 * Construtor por cópia
	 * @param i imoobiliaria	
	 */
	public Imoobiliaria(Imoobiliaria i) {
		utilizador = i.getUtilizador();	
		utilizadores = i.getUtilizadores();
		anuncios = i.getAnuncios();
		numImoveis = i.getNumImoveis();
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
		if (this == o) 
			return true;

		if (o == null || this.getClass() != o.getClass()) 
			return false;

		Imoobiliaria i = (Imoobiliaria) o;
		return utilizadores.equals(i.utilizadores) &&
               anuncios.equals(i.anuncios);
	}

	/**
	 * HashCode da Imoobiliaria
	 */
	public int hashCode() {
		int hash = 7;

		hash = 31*hash + utilizadores.hashCode();
		hash = 31*hash + anuncios.hashCode();

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
 	 * Inicia um novo leilão
 	 * @param Imovel
 	 * @param horas
 	 */
	public void iniciaLeilao(Imovel im, int horas) throws SemAutorizacaoException {

		if (!(utilizador instanceof Vendedor))
			throw new SemAutorizacaoException("Utilizador não está inscrito como vendedor");

		Vendedor v = (Vendedor) utilizador;
		v.iniciaLeilao(im, horas);	
	}

	/**
 	 * Adiciona um licitador ao leilão a decorrer
 	 * @param idComprador
 	 * @param limite
 	 * @param incrementos
 	 * @param minutos
 	 */
	public void adicionaComprador(String idComprador, double limite, double incrementos,
                                  double minutos) throws LeilaoTerminadoException {

		Vendedor v = (Vendedor) utilizador;

		if (v.getLeilao().getComecou())
			throw new LeilaoTerminadoException("O leilão já terminou!");

		v.adicionaComprador(idComprador, limite, incrementos, minutos);
	}

	/**
 	 * Encerra o leilão que está a decorrer
 	 * @return Comprador
 	 */
	public Comprador encerraLeilao() {
		Vendedor v = (Vendedor) utilizador;
		Comprador vencedor = v.encerrarLeilao();

		try {
			if (vencedor != null)
				setEstado(v.getLeilao().getImovel().getID(), "reservado");
		} catch(ImovelInexistenteException | SemAutorizacaoException | EstadoInvalidoException e) {
			System.out.println(e.getMessage());
		}

		return null;
	}

	/**
	 * Regista um imóvel na imoobiliaria
	 * @param im Imóvel
	 * @throws ImovelExisteException Caso o imóvel a adicionar já existe
	 * @throws SemAutorizacaoException Caso o utilizador não tenha autorização
	 */
	public void registaImovel(Imovel im) throws ImovelExisteException, SemAutorizacaoException {

		if (!(utilizador instanceof Vendedor))
			throw new SemAutorizacaoException("Utilizador não está inscrito como vendedor");

		if (anuncios.containsValue(im))
			throw new ImovelExisteException("Imóvel já existe.");

		Vendedor v = (Vendedor) utilizador;
		String id = Integer.toString(getNumImoveis());
		im.setID(id);	
	
		v.addImovelEmVenda(im);	
		anuncios.put(id, im);

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
		Vendedor v;
		int size = 9;

		if (!(utilizador instanceof Vendedor))
			throw new SemAutorizacaoException("O utilizador não está ligado como Vendedor");

		v = (Vendedor) utilizador;
		for (Imovel im: v.getImoveisEmVenda().values())
			consultas.addAll(im.getConsultas());	

		consultas.sort((c1, c2) -> c1.getData().compareTo(c2.getData()));

		if (consultas.size() < size)
			size = consultas.size();

		return consultas.subList(0, size);
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

		Vendedor v = (Vendedor) utilizador;	
		v.setEstado(idImovel, estado);

		if (estado.equals("em venda")) {
			Imovel im = v.getImoveisEmVenda().get(idImovel);
			anuncios.put(idImovel, im);
		}

		if (estado.equals("reservado") || estado.equals("vendido"))
			anuncios.remove(idImovel);
	}

	/**
	 * Obter os códigos dos n imóveis mais consultados.
	 * @param n
	 * @return Conjunto com os n imóveis
	 */

	public Set<String> getTopImoveis(int n) throws SemAutorizacaoException {

		if (!(utilizador instanceof Vendedor))
			throw new SemAutorizacaoException("Utilizador não está ligado como vendedor");	

		Vendedor v = (Vendedor) utilizador;
		TreeSet<String> topImoveis = new TreeSet<>();

		for(Imovel im: anuncios.values())
			if (im.getConsultas().size() > n)
				topImoveis.add(im.getID());

		return topImoveis;
	}

	
/************************** Todos os Utilizadores ******************************/

	/**
	 * Devolve uma lista de imóveis da classe dada com preco inferior ao preco dado
	 * @param classe
	 * @param preco
	 * @return Lista de Imóveis
	 */
	public List<Imovel> getImovel(String classe, int preco) {
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
	public List<Habitavel> getHabitaveis(int preco) {
		ArrayList<Habitavel> imoveisHabitaveis = new ArrayList<>();

		for (Imovel im: anuncios.values()) {
			if (im instanceof Habitavel && im.getPrecoPedido() < preco) {

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

				for(Imovel im: v.getImoveisEmVenda().values()){
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

public class Leilao {
	private Imovel im;
	private int horas;
	private boolean terminado;
	List<Licitador> licitadores;
	
	/**
 	 * Construtor por parâmetros
 	 * @param im
 	 * @param horas
 	 * @param licitacoes
 	 */
	public Leilao(Imovel im, int horas, boolean terminado, List<Licitador> licitares) {
		this.im = im;
		this.horas = horas;
		this.terminado = terminado;
		setLicitadores(licitadores);
	}

	/**
 	 * Construtor padrão
 	 */
	public Leilao() {
		im = null;
		horas = 0;
		terminado = false;
		licitadores= new ArrayList<Licitador>();
	}

	/**
 	 * Construtor por cópia
 	 * @param l
 	 */
	public Leilao(Leilao l) {
		im = l.getImovel();
		horas = l.getHoras();
		terminado = l.getTerminado();
		licitadores= l.getLicitadores();
	}

	/**
 	 * Obter o imóvel a ser leiloada
 	 * @return Imovel
 	 */
	public Imovel getImovel() {
		return im;
	}

	/**
 	 * Obter duracao do leilão
 	 * @return duracao
 	 */
	public int getDuracao() {
		return horas;
	}

	/**
 	 * Obter estado do leilão
 	 * @return estado
 	 */
	public boolean get() {
		return terminado;
	}

	/**
 	 * Obter lista de licitadores que participam no leilão
 	 * @return licitadores
 	 */
	private List<Licitador> getLicitadores() {
		ArrayList<Licitador> licitacoes = new ArrayList();

		for(Licitador l: this.licitacoes)
			licitacoes.add(l.clone());

		return licitacoes;
	}

	/**
 	 * Define imovel a ser leiloada
 	 * @param Imovel
 	 */
	public setImovel(Imovel im) {
		this.im = im;
	}

	/**
 	 * Define duração do leilão
 	 * @param horas
 	 */
	public setDuracao(int horas) {
		this.horas = horas;
	}

	/**
 	 * Define estado do leilão
 	 * @param estado
 	 */
	public setTerminado(boolean estado) {
		this.terminado = estado;
	}

	/**
 	 * Define lista de licitadores
 	 * @param Licitadores
 	 */
	private void setLicitadores(List<Licitador> licitadores) {
		this.licitadores = new ArrayList<>();

		for(Licitador l: licitadores)
			this.licitadores(l.clone());
	}

	/**
 	 * Adiciona um licitador ao leilão
 	 * @param idComprador
 	 * @param limite
 	 * @param incrementos
 	 * @param minutos
 	 */
	public addLicitador(String idComprador, double limite, double incrementos,
                        double minutos) {

		licitacoes.add(new Licitador(idComprador, limite, incrementos, minutos);
	}

	/**
 	 * Encerra o leilão e decide o vencedor
 	 * @return idComprador
 	 */
	public String encerrar() {
		boolean fim = false;

		while(!fim) {
			for(i = 0; i < licitadores.size(); i++)
		}
	}
}

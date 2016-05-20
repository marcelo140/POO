import java.util.TreeMap;
import java.util.Map;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * O vendedor é a entidade responsável pela gestão dos anúncios de imóveis para
 * venda. 
 */

public class Vendedor extends Utilizador 
{
	private Map<String, Imovel> imoveisEmVenda;
	private Map<String, Imovel> imoveisVendidos;
	private Leilao leilao;

	/**
	 * Construtor por parametros
	 * @param email
	 * @param nome
	 * @param password
	 * @param morada
	 * @param dataNascimento
	 * @param imoveisEmVenda
	 * @param imoveisVendidos
	 */
	public Vendedor(String email, String nome, String password, String morada, 
                    LocalDate dataNascimento, Map<String, Imovel> imoveisEmVenda,
                    Map<String, Imovel> imoveisVendidos, Leilao leilao) {

		super(email, nome, password, morada, dataNascimento);
		setImoveisEmVenda(imoveisEmVenda);
		setImoveisVendidos(imoveisVendidos);
		setLeilao(leilao);
	}

	/**
	 * Construtor padrão
	 */
	public Vendedor() {
		super();
		imoveisEmVenda = new TreeMap<String, Imovel>();
		imoveisVendidos = new TreeMap<String, Imovel>();
		leilao = null;
	}
		
	public Vendedor(Vendedor v) {
		super(v);
        imoveisEmVenda = v.getImoveisEmVenda();
		imoveisVendidos = v.getImoveisVendidos();
		leilao = v.getLeilao();
	}

	/**
	 * Obtem imóveis em venda do Vendedor
	 */
	public Map<String, Imovel> getImoveisEmVenda() {
		TreeMap<String, Imovel> imoveisEmVenda = new TreeMap<>();

		for(Map.Entry<String, Imovel> map: this.imoveisEmVenda.entrySet())
			imoveisEmVenda.put(map.getKey(), map.getValue().clone());

		return imoveisEmVenda;
	}

	/**
	 * Obtem imóveis vendidos pelo Vendedor
	 */
	public Map<String, Imovel> getImoveisVendidos() {
		TreeMap<String, Imovel> imoveisVendidos = new TreeMap<>();

		for(Map.Entry<String, Imovel> map: this.imoveisVendidos.entrySet())
			imoveisVendidos.put(map.getKey(), map.getValue().clone());

		return imoveisVendidos;
	}

	/**
 	 * Obtem o leilão a decorrer
 	 * @return Leilão
 	 */
	public Leilao getLeilao() {
		return leilao.clone();
	}

	/**
 	 * Define a lista de imóveis em venda
 	 * @param imoveisEmVenda
 	 */
	private void setImoveisEmVenda(Map<String, Imovel> imoveisEmVenda) {
		this.imoveisEmVenda = new TreeMap<String, Imovel>();

		for(Map.Entry<String, Imovel> map: imoveisEmVenda.entrySet())
			this.imoveisEmVenda.put(map.getKey(), map.getValue().clone());
	}

	/**
 	 * Define a lista de imóveis vendidos
 	 * @param imoveisVendidos
 	 */
	private void setImoveisVendidos(Map<String, Imovel> imoveisVendidos) {
		this.imoveisVendidos = new TreeMap<String, Imovel>();

		for(Map.Entry<String, Imovel> map: imoveisVendidos.entrySet())
			this.imoveisVendidos.put(map.getKey(), map.getValue().clone());
	}

	/**
 	 * Define o leilão a decorrer
 	 * @param Leilao
 	 */
	private void setLeilao(Leilao leilao) {
		this.leilao = leilao.clone();
	}

	/**
 	 * Adiciona o imóvel à lista de imoveis em venda
 	 * @param Imovel
 	 */
	public void addImovelEmVenda(Imovel im) {
		imoveisEmVenda.put(im.getID(), im);	
	}	

	/**
	 * Verifica se dado Objeto é igual a este Vendedor.
	 * @param o Objeto
	 */
	public boolean equals(Object o) {
		if (this == o)
			 return true;

		if ((o == null) || (this.getClass() != o.getClass())) 
			return false;

		Vendedor v = (Vendedor) o;
		return super.equals(v) &&
			   imoveisEmVenda.equals(v.getImoveisEmVenda()) &&
			   imoveisVendidos.equals(v.getImoveisVendidos()) &&
               leilao.equals(v.leilao);
	}

	/**
	 * HashCode do Vendedor
	 */
	public int hashCode() {
		int hash = 7;

		hash = 31*hash + super.hashCode();
		hash = 31*hash + imoveisEmVenda.hashCode();
		hash = 31*hash + imoveisVendidos.hashCode();
		hash = 31*hash + leilao.hashCode();

		return hash;
	}

	/**
  	 * Muda estado do imóvel
  	 * @param idImovel
  	 * @param estado
  	 */
	public void setEstado(String idImovel, String estado) {
		Imovel im;
		
		if (!estado.equals("em venda")) {
			im = imoveisEmVenda.remove(idImovel);
			if (im != null) {
				im.setEstado(estado);
				imoveisVendidos.put(im.getID(), im);		
			}
		}

		if (estado.equals("em venda")) {
			im = imoveisVendidos.remove(idImovel);
			if (im != null) {
				im.setEstado(estado);
				imoveisEmVenda.put(im.getID(), im);
			}
		}

	}

	/**
 	 * Inicia um novo leilão
 	 * @param Imovel
 	 * @param horas
 	 */
	public void iniciaLeilao(Imovel im, int horas) {
		this.leilao = new Leilao(im, horas, false, new ArrayList<Licitador>());
	}

	/**
 	 * Adiciona um licitador ao leilão
 	 * @param idComprador
 	 * @param limite
 	 * @param incrementos
 	 * @param minutos
 	 */
	public void adicionaComprador(String idComprador, double limite, double incrementos,
								  double minutos) {

		leilao.addLicitador(idComprador, limite, incrementos, minutos);
	}

	/**
 	 * Encerra o leilão atual
 	 * @return Comprador
 	 */
	public Comprador encerrarLeilao() {
		String str = leilao.encerrar();

		if (str.equals("n/a"))
			return null;

		Comprador c = new Comprador();
		c.setEmail(str);

		return c;
	}

	/**
 	 * Converte Vendedor em String
 	 * @return String
 	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append(super.toString());
		sb.append("Imoveis em venda: ").append(imoveisEmVenda.toString()).append("\n");
		sb.append("Imoveis vendidos: ").append(imoveisVendidos.toString()).append("\n");
		sb.append("Leilão: ").append(leilao.toString()).append("\n");

		return sb.toString();
	}

	/**
 	 * Cria uma cópia de um vendedor
 	 * @return Vendedor
 	 */
	public Vendedor clone() {
		return new Vendedor(this);
	}
}

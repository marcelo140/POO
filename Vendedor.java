import java.util.TreeMap;
import java.util.Map;
import java.time.LocalDate;

/**
 * O vendedor é a entidade responsável pela gestão dos anúncios de imóveis para
 * venda. 
 */

public class Vendedor extends Utilizador 
{
	private Map<String, Imovel> imoveisEmVenda;
	private Map<String, Imovel> imoveisVendidos;

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
                    Map<String, Imovel> imoveisVendidos) {

		super(email, nome, password, morada, dataNascimento);
		setImoveisEmVenda(imoveisEmVenda);
		setImoveisVendidos(imoveisVendidos);
	}

	/**
	 * Construtor padrão
	 */
	public Vendedor() {
		super();
		this.imoveisEmVenda = new TreeMap<String, Imovel>();
		this.imoveisVendidos = new TreeMap<String, Imovel>();	
	}
		
	public Vendedor(Vendedor v) {
		super(v);
        imoveisEmVenda = v.getImoveisEmVenda();
		imoveisVendidos = v.getImoveisVendidos();
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
		return (super.equals(v) &&
				imoveisEmVenda.equals(v.getImoveisEmVenda()) &&
				imoveisVendidos.equals(v.getImoveisVendidos()));
	}

	

	/**
	 * HashCode do Vendedor
	 */
	public int hashCode() {
		int hash = 7;

		hash = 31*hash + super.hashCode();
		hash = 31*hash + imoveisEmVenda.hashCode();
		hash = 31*hash + imoveisVendidos.hashCode();

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
 	 * Converte Vendedor em String
 	 * @return String
 	 */
	public String toString() {
		StringBuilder sb = new StringBuilder();

		sb.append(super.toString());
		sb.append("Imoveis em venda: ").append(imoveisEmVenda.toString()).append("\n");
		sb.append("Imoveis vendidos: ").append(imoveisVendidos.toString()).append("\n");

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

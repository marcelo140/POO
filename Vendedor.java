import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

/**
 * O vendedor é a entidade responsável pela gestão dos anúncios de imóveis para
 * venda. 
 */

public class Vendedor extends Utilizador 
{
	private List<Imovel> imoveisEmVenda;
	private List<Imovel> imoveisVendidos;

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
                    LocalDate dataNascimento, List<Imovel> imoveisEmVenda, 
                    List<Imovel> imoveisVendidos) {

		super(email, nome, password, morada, dataNascimento);
		setImoveisEmVenda(imoveisEmVenda);
		setImoveisVendidos(imoveisVendidos);
	}

	/**
	 * Construtor padrão
	 */
	public Vendedor() {
		super();
		this.imoveisEmVenda = new ArrayList<Imovel>();
		this.imoveisVendidos = new ArrayList<Imovel>();	
	}
		
	public Vendedor(Vendedor v) {
		super(v);
        imoveisEmVenda = v.getImoveisEmVenda();
		imoveisVendidos = v.getImoveisVendidos();
	}

	/**
	 * Obtem imóveis em venda do Vendedor
	 */
	public List<Imovel> getImoveisEmVenda() {
		ArrayList<Imovel> imoveisEmVenda = new ArrayList<>();

		for(Imovel im: this.imoveisEmVenda)
			imoveisEmVenda.add(im.clone());

		return imoveisEmVenda;
	}

	/**
	 * Obtem imóveis vendidos pelo Vendedor
	 */
	public List<Imovel> getImoveisVendidos() {
		ArrayList<Imovel> imoveisVendidos = new ArrayList<>();

		for(Imovel im: this.imoveisVendidos)
			imoveisVendidos.add(im.clone());

		return imoveisVendidos;
	}

	/**
 	 * Define a lista de imóveis em venda
 	 * @param imoveisEmVenda
 	 */
	private void setImoveisEmVenda(List<Imovel> imoveisEmVenda) {
		this.imoveisEmVenda = new ArrayList<Imovel>(imoveisEmVenda);

		for(Imovel im: imoveisEmVenda)
			this.imoveisEmVenda.add(im.clone());
	}

	/**
 	 * Define a lista de imóveis vendidos
 	 * @param imoveisVendidos
 	 */
	private void setImoveisVendidos(List<Imovel> imoveisVendidos) {
		this.imoveisVendidos = new ArrayList<Imovel>();

		for(Imovel im: imoveisVendidos)
			this.imoveisVendidos.add(im.clone());
	}

	/**
 	 * Adiciona o imóvel à lista de imoveis em venda
 	 * @param Imovel
 	 */
	public void addImovelEmVenda(Imovel im) {
		imoveisEmVenda.add(im);	
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

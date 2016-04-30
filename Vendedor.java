import java.util.ArrayList;
import java.util.List;
import java.util.GregorianCalendar;

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
	public Vendedor(String email, String nome, String password, String morada, GregorianCalendar dataNascimento, List<Imovel> imoveisEmVenda, List<Imovel> imoveisVendidos) {
		super(email, nome, password, morada, dataNascimento);

		this.imoveisEmVenda = new ArrayList<Imovel>();
		for (Imovel im : imoveisEmVenda)
			this.imoveisEmVenda.add(im);
	
		this.imoveisVendidos = new ArrayList<Imovel>();	
		for (Imovel im : imoveisVendidos)
			this.imoveisVendidos.add(im);
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
		this(v.getEmail(), v.getNome(), v.getPassword(), v.getMorada(), v.getDataNascimento(), v.getImoveisEmVenda(), v.getImoveisVendidos());
	}

	/**
	 * Obtem imóveis em venda do Vendedor
	 */
	private List<Imovel> getImoveisEmVenda() {
		return new ArrayList<Imovel> (this.imoveisEmVenda);
	}

	/**
	 * Obtem imóveis vendidos pelo Vendedor
	 */
	private List<Imovel> getImoveisVendidos() {
		return new ArrayList<Imovel> (this.imoveisVendidos);
	}

	/**
 	 * Define a lista de imóveis em venda
 	 * @param imoveisEmVenda
 	 */
	private void setImoveisEmVenda(List<Imovel> imoveisEmVenda) {
		for(Imovel i: imoveisEmVenda)
			this.imoveisEmVenda.add(i.clone());
	}

	/**
 	 * Define a lista de imóveis vendidos
 	 * @param imoveisVendidos
 	 */
	private void setImoveisVendidos(List<Imovel> imoveisVendidos) {
		for(Imovel i: imoveisEmVenda)
			this.imoveisEmVenda.add(i.clone());
	}

	/**
	 * Verifica se dado Objeto é igual a este Vendedor.
	 * @param o Objeto
	 */
	public boolean equals(Object o) {
		if (this == o) return true;
		if ((o == null) || (this.getClass() != o.getClass())) return false;
		else {
			Vendedor v = (Vendedor) o;
			return (super.equals(v) &&
					this.imoveisEmVenda.equals(v.imoveisEmVenda) &&
					this.imoveisVendidos.equals(v.imoveisVendidos));
		}
	}

	/**
	 * HashCode do Vendedor
	 */
	public int hashCode() {
		int hash = 7;

		hash = 31*hash + super.hashCode();
		hash = 31*hash + this.imoveisEmVenda.hashCode();
		hash = 31*hash + this.imoveisVendidos.hashCode();

		return hash;
	}

	/**
 	 * Cria uma cópia de um vendedor
 	 * @return Vendedor
 	 */
	public Vendedor clone() {
		return new Vendedor(this);
	}
}

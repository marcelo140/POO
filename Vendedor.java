import java.util.ArrayList;
import java.util.List;

/**
 * O vendedor é a entidade responsável pela gestão dos anúncios de imóveis para
 * venda. 
 * @author Bruno Cancelinha 
 * @version 0.1
 */
public class Vendedor extends Utilizador {

	List<Imovel> imoveisEmVenda  = new ArrayList<Imovel>();
	List<Imovel> imoveisVendidos = new ArrayList<Imovel>();

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
	public Vendedor(String email, String nome, String password, String morada, String dataNascimento, List<Imovel> imoveisEmVenda, List<Imovel> imoveisVendidos) {
		super(email, nome, password, morada, dataNascimento);
		
		for (Imovel im : imoveisEmVenda)
			this.imoveisEmVenda.add(im);
		
		for (Imovel im : imoveisVendidos)
			this.imoveisVendidos.add(im);
	}

	/**
	 * Construtor padrão
	 */
	public Vendedor() {
		super();
	}
		
	public Vendedor(Vendedor vend) {
		this(vend.getEmail(), vend.getNome(), vend.getPassword(), vend.getMorada(), vend.getDataNascimento(), vend.getImoveisEmVenda(), vend.getImoveisVendidos() );
		
	}

	/**
	 * Obtem imóveis em venda do Vendedor
	 */
	public List<Imovel> getImoveisEmVenda() {
		return new ArrayList<Imovel> (this.imoveisEmVenda);
	}

	/**
	 * Obtem imóveis vendidos pelo Vendedor
	 */
	public List<Imovel> getImoveisVendidos() {
		return new ArrayList<Imovel> (this.imoveisVendidos);
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
}

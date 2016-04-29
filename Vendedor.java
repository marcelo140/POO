import java.util.ArrayList;

/**
 * O vendedor é a entidade responsável pela gestão dos anúncios de imóveis para
 * venda. 
 * @author Bruno Cancelinha 
 * @version 0.1
 */
public class Vendedor extends Utilizador {

	ArrayList<Imovel> imoveisEmVenda  = new ArrayList<Imovel>();
	ArrayList<Imovel> imoveisVendidos = new ArrayList<Imovel>();

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
	public Vendedor(String email, String nome, String password, String morada, String dataNascimento, ArrayList<Imovel> imoveisEmVenda, ArrayList<Imovel> imoveisVendidos) {
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
	public ArrayList<Imovel> getImoveisEmVenda() {
		return this.imoveisEmVenda;
	}

	/**
	 * Obtem imóveis vendidos pelo Vendedor
	 */
	public ArrayList<Imovel> getImoveisVendidos() {
		return this.imoveisVendidos;
	}
}

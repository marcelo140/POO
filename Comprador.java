import java.util.TreeSet;

/**
 * Write a description of class Comprador here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Comprador extends Utilizador
{
    TreeSet<Imovel> favoritos = new TreeSet<Imovel>();

	/**
 	 * Construtor padrão
 	 */
    public Comprador() {
        super();
    }

	/**
 	 * Construtor por parâmetros
 	 */
    public Comprador(String email, String nome, String password, String morada, String dataNascimento, TreeSet<Imovel> favoritos) {
        super(email,nome,password,morada,dataNascimento);
        
        for(Imovel im: favoritos)
            this.favoritos.add(im);
    }

	/**
 	 * Construtor por cópia
 	 */
    public Comprador(Comprador c) {
        super(c.getEmail(), c.getNome(), c.getPassword(), c.getMorada(), c.getDataNascimento());
    
        for(Imovel im: favoritos)
            this.favoritos.add(im);
    }

	/**
 	 * Obtem imóveis favoritos do utilizador
 	 * @return
 	 */
	public TreeSet<Imovel> getFavoritos() {
		return this.favoritos;
	}
}

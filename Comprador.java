import java.util.Set;
import java.util.TreeSet;
import java.util.GregorianCalendar;

/**
 * Write a description of class Comprador here.
 */

public class Comprador extends Utilizador
{
    private Set<Imovel> favoritos;

	/**
 	 * Construtor por parâmetros
 	 */
    public Comprador(String email, String nome, String password, String morada, 
					 GregorianCalendar dataNascimento, Set<Imovel> favoritos) {

        super(email, nome, password, morada, dataNascimento);
        setFavoritos(favoritos);
    }

	/**
 	 * Construtor padrão
 	 */
    public Comprador() {
        super();
		favoritos = new TreeSet<Imovel>(new ComparatorImovelByPreco());
    }

	/**
 	 * Construtor por cópia
 	 */
    public Comprador(Comprador c) {
        super(c);
		this.favoritos = c.getFavoritos(); 
    }

	/**
 	 * Obter cópia dos favoritos
 	 * @return Set
 	 */
	public Set<Imovel> getFavoritos() {
		TreeSet<Imovel> favoritos = new TreeSet<>(new ComparatorImovelByPreco());

		for(Imovel im: this.favoritos)
			favoritos.add(im.clone());
		
		return favoritos;
	}

	/**
 	 * Definir favoritos
 	 * @param favoritos
 	 */
	private void setFavoritos(Set<Imovel> favoritos) {
		this.favoritos = new TreeSet<Imovel>(new ComparatorImovelByPreco());

		for(Imovel f: favoritos)
			this.favoritos.add(f);
	}

	/**
	 * Adiciona um imóvel aos favoritos do comprador
	 * @param Imovel
	 */
	public void addFavoritos(Imovel im) {
		this.favoritos.add(im);
	}

	/**
	 * Verifica se o objeto dado é igual a este.
	 * @param o Objeto
	 */
	public boolean equals(Object o) {
		if (o == this)
			 return true;

		if ((o == null) || (this.getClass() != o.getClass())) 
			return false;

		Comprador c = (Comprador) o;
		return super.equals(c) &&
			   this.favoritos.equals(c.getFavoritos());
	}

	/**
	 * HashCode da classe Comprador
	 */
	public int hashCode() {
		int hash = 7;

		hash = 31*hash + super.hashCode();
		hash = 31*hash + favoritos.hashCode();

		return hash;
	}

	/**
 	 * Converte Comprador em String
 	 * @return String
 	 */
	public String toString(){
		StringBuilder sb = new StringBuilder();

		sb.append(super.toString());
		sb.append(favoritos.toString()).append("\n");
	
		return sb.toString();
	}

	/**
 	 * Cria uma cópia de um comprador
 	 * @return Comprador
 	 */
	public Comprador clone() {
		return new Comprador(this);
	}
}

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
        super(email,nome,password,morada,dataNascimento);
       	this.favoritos = new TreeSet<Imovel>();
        setFavoritos(favoritos);
    }

	/**
 	 * Construtor padrão
 	 */
    public Comprador() {
        super();
		this.favoritos = new TreeSet<Imovel>();
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
	private Set<Imovel> getFavoritos() {
		return new TreeSet<Imovel>(this.favoritos);
	}

	/**
 	 * Definir favoritos
 	 * @param favoritos
 	 */
	private void setFavoritos(Set<Imovel> favoritos) {
		for(Imovel f: favoritos)
			this.favoritos.add(f);
	}

	/**
	 * Verifica se o objeto dado é igual a este.
	 * @param o Objeto
	 */
	public boolean equals(Object o) {
		if (o == this) return true;
		if ( (o == null) || (this.getClass() != o.getClass())) return false;
		else {
			Comprador c = (Comprador) o;
			return super.equals(c) &&
				this.favoritos.equals(c.getFavoritos() );
		}

	}

	/**
	 * HashCode da classe Comprador
	 */
	public int hashCode() {
		int hash = 7;

		hash = 31*hash + super.hashCode();
		hash = 31*hash + this.favoritos.hashCode();

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

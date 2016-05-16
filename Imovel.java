/**
 * Abstract class Imovel - write a description of the class here
 */

import java.util.List;
import java.util.ArrayList;
import java.io.Serializable;

public abstract class Imovel implements Serializable {
    private String id, rua, estado;
    private double precoMinimo, precoPedido;
    private List<Consulta> consultas;

    /**
     * Construtor por parâmetros
     * @param id
     * @param rua
     * @param estado
     * @param precoMinimo
     * @param precoPedido
     * @param consultas
     */ 
    public Imovel(String id, String rua, String estado, double precoMinimo,
                  double precoPedido, List<Consulta> consultas) {
		this.id = id;
        this.rua = rua;
        this.estado = estado;
        this.precoMinimo = precoMinimo;
        this.precoPedido = precoPedido;
		setConsultas(consultas);
    }

    /**
     * Construtor padrão
     */ 
    public Imovel() {
		id = "n/a";
		rua = "n/a";
		estado = "em venda";
		precoMinimo = 0.0;
		precoPedido = 0.0;
		consultas = new ArrayList<Consulta>();
    }

    /**
     * Construtor por cópia
     */
    public Imovel(Imovel i) {
		id = i.getID();
        rua = i.getRua();
        estado = i.getEstado();
        precoMinimo = i.getPrecoMinimo();
        precoPedido = i.getPrecoPedido();
        consultas = i.getConsultas();
    }

	/**
 	 * Obter id do imóvel
 	 * @return
 	 */
	public String getID() {
		return id;
	}

    /**
     * Obter nome da rua
     * @return
     */
    public String getRua() {
        return rua;
    }

    /**
     * Obter preço mínimo
     * @return
     */
    public double getPrecoMinimo() {
        return precoMinimo;
    }

    /**
     * Obter preço pedido
     * @return
     */
    public double getPrecoPedido() {
        return precoPedido;
    }

    /**
     * Obter o estado do imóvel
     * @return estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * Obter consultas do imóvel
     * @return consultas
     */
    public List<Consulta> getConsultas() {
		ArrayList<Consulta> consultas = new ArrayList<>();

		for(Consulta c: this.consultas)
			consultas.add(c.clone());

		return consultas;
    }

	/**
 	 * Define id do imóvel
 	 * @param id
 	 */
	public void setID(String id) {
		this.id = id;
	}

    /**
     * Define nome da rua
     * @param rua
     */
    public void setRua(String rua) {
        this.rua = rua;
    }

    /**
     * Define o estado
     * @param estado
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * Define preço mínimo
     * @param precoMinimo
     */
    public void setPrecoMinimo(double precoMinimo) {
        this.precoMinimo = precoMinimo;
    }

    /**
     * Define preço pedido
     * @param precoPedido
     */
    public void setPrecoPedido(double precoPedido) {
        this.precoPedido = precoPedido;
    }
    
    /**
     * Define consultas 
     * @param consultas
     */
    public void setConsultas(List<Consulta> consultas) {
        this.consultas = new ArrayList<Consulta>();

		for(Consulta c: consultas)
			this.consultas.add(c.clone());
    }
    
    /**
     * Adiciona uma consulta ao imóvel
     * @param consulta
     */
    public void addConsulta(Consulta c) {
        consultas.add(c);
    }

    /**
     * Verifica se um objeto dado é igual a este.
     * @param o Objeto
     */
    public boolean equals(Object o) {
        if (this == o) 
			return true;

        if ((o == null) || (this.getClass() != o.getClass()))
			 return false;

		Imovel i = (Imovel) o;
		return (precoMinimo == i.getPrecoMinimo() &&
				precoPedido == i.getPrecoPedido() &&
				id.equals(i.getID()) &&
				rua.equals(i.getRua()) &&
				estado.equals(i.getEstado()) &&
				consultas.equals(i.getConsultas()));
    }

    /**
     * HashCode da classe Imovel
     * @return hashCode
     */
    public int hashCode() {
        int hash = 7;
        long aux;

        hash = 31*hash + id.hashCode();
        hash = 31*hash + rua.hashCode();
        hash = 31*hash + estado.hashCode();
        aux = Double.doubleToLongBits(precoMinimo);
        hash = 31*hash + (int)(aux^(aux >>> 32));
        aux = Double.doubleToLongBits(precoPedido);
        hash = 31*hash + (int)(aux^(aux >>> 32));
        hash = 31*hash + consultas.hashCode();

        return hash;
    }

    /**
     * Transforma o imóvel numa String
     * @return String
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();

		sb.append("ID: ").append(id).append("\n");
        sb.append("Rua: ").append(rua).append("\n");
        sb.append("Estado: ").append(estado).append("\n");
        sb.append("Preço mínimo: ").append(precoMinimo).append("\n");
        sb.append("Preço pedido: ").append(precoPedido).append("\n");
        sb.append("Consultas: ").append(consultas.toString()).append("\n");
        
        return sb.toString();
    }

    /**
     * Cria uma cópia do imóvel
     * @return Imóvel
     */
    public abstract Imovel clone();
}

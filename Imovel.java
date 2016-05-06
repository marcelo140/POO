/**
 * Abstract class Imovel - write a description of the class here
 */

import java.util.*;

public abstract class Imovel {
    private String rua, estado;
    private double precoMinimo, precoPedido;
    private List<Consulta> consultas;

    /**
     * Construtor por parâmetros
     * @param rua
     * @param estado
     * @param precoMinimo
     * @param precoPedido
     * @param consultas
     */ 
    public Imovel(String rua, String estado, double precoMinimo, double precoPedido, 
                  List<Consulta> consultas) {
        this.rua = rua;
        this.estado = estado;
        this.precoMinimo = precoMinimo;
        this.precoPedido = precoPedido;
        this.consultas = new ArrayList<Consulta>(consultas);
    }

    /**
     * Construtor padrão
     */ 
    public Imovel() {
        this("n/a", "n/a", 0.0, 0.0, null);
    }

    /**
     * Construtor por cópia
     */
    public Imovel(Imovel i) {
        rua = i.getRua();
        estado = i.getEstado();
        precoMinimo = i.getPrecoMinimo();
        precoPedido = i.getPrecoPedido();
        consultas = new ArrayList<Consulta> (i.getConsultas());
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
        return new ArrayList<Consulta>(consultas);
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
        this.consultas = new ArrayList<Consulta> (consultas);
    }
    
    /**
     * Verifica se um objeto dado é igual a este.
     * @param o Objeto
     */
    public boolean equals(Object o) {
        if (this == o) return true;
        if ((o == null) || (this.getClass() != o.getClass())) return false;
        else {
            Imovel i = (Imovel) o;
            return ( this.precoMinimo == i.getPrecoMinimo() &&
                     this.precoPedido == i.getPrecoPedido() &&
                     this.rua.equals(i.getRua()) &&
                     this.estado.equals(i.getEstado()) &&
                     this.consultas.equals(i.getConsultas()));
        }
    }

    /**
     * HashCode da classe Imovel
     * @return hashCode
     */
    public int hashCode() {
        int hash = 7;
        long aux;

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

    /**
     * Adiciona uma consulta ao imóvel
     * @param consulta
     */
    public void addConsulta(Consulta c) {
        consultas.add(c);
    }
}

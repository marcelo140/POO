
/**
 * Write a description of class Loja here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Loja extends Imovel
{
    private Apartamento parteHabitacional;
    private String tipoNegocio;
    private double area;
    private int porta;
    private boolean WC;
    /**
     * Construtor padrão
     */ 
    public Loja(){
       super();
       this.parteHabitacional = new Apartamento();
       this.tipoNegocio = "n/a";
       this.area = 0;
       this.porta = 0;
       this.WC = false;
       }
    /**
     * Construtor por parâmatros
     * @param rua
     * @param precoMinimo
     * @param precoPedido
     * @param parteHab
     * @param tipo
     * @param area
     * @param porta
     * @param WC
     */
    public Loja(String rua, double precoMinimo, double precoPedido, String tipo, double area, int porta, boolean WC){
       super(rua, precoMinimo, precoPedido);
       this.tipoNegocio = tipo;
       this.area = area;
       this.porta = porta;
       this.WC = WC;
       }
    /**
     * Construtor por cópia
     */
       public Loja(Loja t){
       super.setRua(t.getRua());
       super.setPrecoMinimo(t.getPrecoMinimo());
       super.setPrecoPedido(t.getPrecoPedido());
       this.tipoNegocio = t.getTipoNegocio();
       this.area = t.getArea();
       this.porta = t.getPorta();
       this.WC = t.getWC();
    }
    /**
     * Obter tipo de negócio da loja
     * @return
     */
    public String getTipoNegocio() {
     return this.tipoNegocio;
        }
    /**
     * Obter área total
     * @return
     */
    public double getArea(){
    return this.area;
    }
    /**
     * Obter número da porta
     * @return
     */
    public int getPorta(){
    return this.porta;
    }
    /**
     * Determina se o apartamento tem WC
     * @return
     */
    public boolean getWC(){
    return this.WC;
    }
    /**
     * Define tipo de negócio 
     * @param tipo
     */
    public void setTipo(String tipo) {
        this.tipoNegocio = tipoNegocio;
    }
    /**
     * Define área da loja
     * @param area
     */
    public void setArea(double area) {
        this.area= area;
    }
    /**
     * Define número da porta
     * @param porta
     */
    public void setPorta(int porta) {
        this.porta = porta;
    }
    /**
     * Define se o apartamento tem, ou não, garagem
     * @param garagem
     */
    public void setWC(boolean WC) {
        this.WC = WC;
    }
}



/**
 * Write a description of class Apartamento here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Apartamento extends Imovel
{
    private String tipo;
    private double area;
    private int nQuartos;
    private int nWC;
    private int andar;
    private int porta;
    private boolean garagem;
    
    public Apartamento(){
       super();
       this.tipo = "indisponível";
       this.area = 0;
       this.nQuartos = 0;
       this.nWC = 0;
       this.andar = 0;
       this.porta = 0;
       this.garagem = false;
       }
    public Apartamento(String rua, double precoMinimo, double precoPedido, String tipo, double area, private int nQuartos,int nWC, int andar, int porta, boolean garagem){
       super(rua, precoMinimo, precoPedido);
       this.tipo = tipo;
       this.area = area;
       this.nQuartos = nQuartos;
       this.nWC = nWC;
       this.andar = andar;
       this.porta = porta;
       this.garagem = garagem;
       }
       public Apartamento(Apartamento t){
		super.setRua(t.getRua());
		super.setPrecoMinimo(t.getPrecoMinimo());
		super.setPrecoPedido(t.getPrecoPedido());
		this.tipo = tipo;
       this.area = area;
       this.nQuartos = nQuartos;
       this.nWC = nWC;
       this.andar = andar;
       this.porta = porta;
       this.garagem = garagem;
	}
        }


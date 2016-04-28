
/**
 * Write a description of class Terreno here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Terreno extends Imovel
{
	private String tipo;
	private double area;
	private double diametroCanalizacao;
	private double potenciaSuportada;
	private boolean acessoEsgotos;
	
	public Terreno() {
		super();
		this.tipo = "n/a";
		this.area = 0.0;
		this.diametroCanalizacao = 0.0;
		this.potenciaSuportada = 0.0;
		this.acessoEsgotos = false;
	}
	
	public Terreno(String rua, double precoMinimo, double precoPedido, String tipo, double area, double diametroCanalizacao, double potenciaSuportada, boolean acessoEsgotos) {
		super(rua, precoMinimo, precoPedido);
		this.tipo = tipo;
		this.area = area;
		this.diametroCanalizacao = diametroCanalizacao;
		this.potenciaSuportada = potenciaSuportada;
		this.acessoEsgotos = acessoEsgotos;
	}

	public Terreno(Terreno t) {
		super.setRua(t.getRua());
		super.setPrecoMinimo(t.getPrecoMinimo());
		super.setPrecoPedido(t.getPrecoPedido());
		this.diametroCanalizacao = t.getDiametroCanalizacao();
		this.potenciaSuportada = t.getPotenciaSuportada();
		this.acessoEsgotos = t.getAcessoEsgotos();
	}

	public String getTipo() {
		return this.tipo;
	}

	public double getArea() {
		return this.area;
	}

	public double getDiametroCanalizacao() {
		return this.diametroCanalizacao;
	}

	public double getPotenciaSuportada() {
		return this.potenciaSuportada;
	}

	public boolean getAcessoEsgotos() {
		return this.acessoEsgotos;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public void setArea(double area) {
		this.area = area;
	}

	public void setDiametroCanalizacao(double diametroCanalizacao) {
		this.diametroCanalizacao = diametroCanalizacao;
	}

	public void setPotenciaSuportada(double potenciaSuportada) {
		this.potenciaSuportada = potenciaSuportada;
	}

	public void setAcessoEsgotos(boolean acesso) {
		this.acessoEsgotos = acesso;
	}
}

import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.io.Serializable;

public class Leilao implements Serializable {
    private Imovel im;
    private int horas;
    private boolean comecou;
    List<Licitador> licitadores;
    
    /**
     * Construtor por parâmetros
     * @param im
     * @param horas
     * @param licitacoes
     */
    public Leilao(Imovel im, int horas, boolean comecou, List<Licitador> licitadores) {
        this.im = im;
        this.horas = horas;
        this.comecou = comecou;
        setLicitadores(licitadores);
    }

    /**
     * Construtor padrão
     */
    public Leilao() {
        im = null;
        horas = 0;
        comecou = false;
        licitadores= new ArrayList<Licitador>();
    }

    /**
     * Construtor por cópia
     * @param l
     */
    public Leilao(Leilao l) {
        im = l.getImovel();
        horas = l.getDuracao();
        comecou = l.getComecou();
        licitadores= l.getLicitadores();
    }

    /**
     * Obter o imóvel a ser leiloada
     * @return Imovel
     */
    public Imovel getImovel() {
        return im;
    }

    /**
     * Obter duracao do leilão
     * @return duracao
     */
    public int getDuracao() {
        return horas;
    }

    /**
     * Obter estado do leilão
     * @return estado
     */
    public boolean getComecou() {
        return comecou;
    }

    /**
     * Obter lista de licitadores que participam no leilão
     * @return licitadores
     */
    private List<Licitador> getLicitadores() {
        ArrayList<Licitador> licitacoes = new ArrayList<>();

        for(Licitador l: this.licitadores)
            licitacoes.add(l.clone());

        return licitacoes;
    }

    /**
     * Define imovel a ser leiloada
     * @param Imovel
     */
    public void setImovel(Imovel im) {
        this.im = im;
    }

    /**
     * Define duração do leilão
     * @param horas
     */
    public void setDuracao(int horas) {
        this.horas = horas;
    }

    /**
     * Define estado do leilão
     * @param estado
     */
    public void setComecou(boolean estado) {
        this.comecou = estado;
    }

    /**
     * Define lista de licitadores
     * @param Licitadores
     */
    private void setLicitadores(List<Licitador> licitadores) {
        this.licitadores = new ArrayList<>();

        for(Licitador l: licitadores)
            this.licitadores.add(l.clone());
    }

    /**
     * Adiciona um licitador ao leilão
     * @param idComprador
     * @param limite
     * @param incrementos
     * @param minutos
     */
    public void addLicitador(String idComprador, double limite, double incrementos,
                        double minutos) {

        licitadores.add(new Licitador(idComprador, limite, incrementos, minutos));
    }

    /**
     * Encerra o leilão e decide o vencedor
     * @return idComprador
     */
    public String encerrar() {
        long start = System.currentTimeMillis();
        String topId="n/a";
        double montante, topValor = 0;
        setComecou(true);

        long time = System.currentTimeMillis();
        while ((time-start)/1000 < horas) {
            for(Licitador lic: licitadores) {
                if (lic.getMinutos() > (time-lic.getUltimaLicitacao())/1000)
					continue;

                if (lic.getMontante() > lic.getLimite() || lic.getComprador().equals(topId))
					continue;

				lic.setUltimaLicitacao(time);
				montante = lic.getMontante() + lic.getIncrementos();
				lic.setMontante(montante);
	
                System.out.println("Licitador "+lic.getComprador()+" licitou "+montante);
                    
                if (montante> topValor) {
                	topValor = montante;
                    topId = lic.getComprador();
                }
        	}
            time = System.currentTimeMillis();
       }	

       return topId;
    }
    
    public Leilao clone() {
        return new Leilao(this);
    }
}

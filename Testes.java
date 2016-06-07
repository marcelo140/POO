

import static org.junit.Assert.*;
import java.util.TreeMap;
import java.time.LocalDate;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.*;
import java.util.ArrayList;

/**
 * The test class Testes.
 *
 * É necessário completar os teste, colocando os parâmetros nos construtores.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class Testes
{
    private Imoobiliaria imo;
    private Vendedor v;
    private Terreno t;

    /**
     * Teste principal
     */
    @Test
    public void mainTest() {
        imo = new Imoobiliaria();
        try {
            imo.iniciaSessao("",null);
            fail();
        } catch(SemAutorizacaoException e) {
            
        } catch(Exception e) {
            fail();
        }
        
        try {
            v = new Vendedor("joao@vendedor.com", "João Almeida", "password", "Rua da Rainha nº 2", 
                    LocalDate.now(), new TreeMap<String, Imovel>(),
                    new TreeMap<String, Imovel>(), new Leilao());  // Preencher parâmetros do construtor
            imo.registarUtilizador(v);
        } catch(Exception e) {
            fail();
        }
        
        String email = v.getEmail();
        String password = v.getPassword();
        
        try {
            imo.iniciaSessao(email, password);
        } catch(Exception e) {
            fail();
        }
        
        t = new Terreno("t1923", "Rua Dom Afonso", "em venda", 10, 
                   30, new ArrayList<Consulta>(), "contrucao", 
                   50, 23,520,true);  // Preencher parâmetros do construtor
        try {
            imo.registaImovel(t);
        } catch (Exception e) {
            fail();
        }
            
        int s = imo.getImovel("Terreno", Integer.MAX_VALUE).size();
        assertTrue(s>0);
        Set<String> ids = null;
        
        try {
            ids = imo.getTopImoveis(0); 
        } catch(Exception e) { 
            fail();
        }
        assertTrue(ids.contains(t.getID()));
        assertTrue(imo.getMapeamentoImoveis().keySet().contains(t));
        try {
            assertTrue(imo.getConsultas().size()>0);
        } catch(Exception e) {
            fail();
        }
        
        imo.fechaSessao();
        Comprador c = new Comprador("miguel@comprador.com", "Miguel Pessoa", "123qwerty", "Rua dos cogumelos nº 9", 
					 LocalDate.now(), new TreeSet<Imovel>());  // Preencher parâmetros do construtor
        try {
            imo.registarUtilizador(c);
        } catch(Exception e) {
            fail();
        }
        email = c.getEmail();
        password = c.getPassword();
        try {
            imo.iniciaSessao(email, password);
            imo.setFavorito(t.getID());
            assertTrue(imo.getFavoritos().contains(t));
        } catch(Exception e) {
            e.printStackTrace();
            fail();
        }
    }
    
}

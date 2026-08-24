

import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import automacao_sigaa.paginas.metodos;
import automacao_sigaa.paginas.Navegador;
import automacao_sigaa.paginas.Ensino;
import automacao_sigaa.paginas.Pesquisa;
import automacao_sigaa.paginas.Ensino; 


public class LoginTest {

    @Before
    public void iniciar() {
        Navegador.abrirNavegador("https://sigaa-hom.uffs.edu.br"); 
    }

    @Test
    public void testLoginSigaa() {
        metodos a = new metodos();
        Ensino e = new Ensino();
        Pesquisa p = new Pesquisa();
        a.logarSigaa("aleksander.lopes", "Aleks15872704");
        a.navegarMenuDiscente("pesquisa", "projeto de pesquisa");
        // e.trancamentoDeMatriculaCCR("03854413041", "Aleks15872704", "03112005", "trancar");
        // e.matriculaExtraordinaria("Chapecó", "03854413041", "123", "03112005");
        // e.suspensaoDoPrograma("03854413041", "", "03112005");
        e.consultasGerais("Consultar Turma");
        p.projetoDePesquisa("consultar projetos"); 
    }   

    @After
    public void finalizar() {
        Navegador.fecharNavegador();
    }
}



import org.junit.Before;
import org.junit.Test;
import org.junit.After;
import automacao_sigaa.paginas.metodos;
import automacao_sigaa.paginas.Navegador;


public class LoginTest {

    @Before
    public void iniciar() {
        Navegador.abrirNavegador("https://sigaa-hom.uffs.edu.br"); 
    }

    @Test
    public void testLoginSigaa() {
        metodos a = new metodos();
        a.logarSigaa("aleksander.lopes", "Aleks15872704");
        a.navegarMenuDiscente("Ensino", "Consultas Gerais");
        // a.trancamentoDeMatriculaCCR("03854413041", "Aleks15872704", "03112005", "trancar");
        // a.matriculaExtraordinaria("Chapecó", "03854413041", "123", "03112005");
        // a.suspensaoDoPrograma("03854413041", "", "03112005");
        a.consultasGerais("Consultar Turma");
    }

    @After
    public void finalizar() {
        Navegador.fecharNavegador();
    }
}

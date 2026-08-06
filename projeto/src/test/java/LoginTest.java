

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
        a.logarSigaa("", "");
        a.navegarMenuDiscente("Ensino", "Emitir Histórico");
    }

    @After
    public void finalizar() {
        Navegador.fecharNavegador();
    }
}

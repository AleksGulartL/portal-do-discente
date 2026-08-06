

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
        a.navegarMenuDiscente("Estágio", "Mural de Vagas");

    }

    @After
    public void finalizar() {
        Navegador.fecharNavegador();
    }
}

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import automacao_sigaa.paginas.Navegador;
import automacao_sigaa.paginas.PortalDiscente;
import automacao_sigaa.paginas.verificaçao;

public class EnsinoNavegacaoTest {

    private static final String TITULO_PORTAL = "SIGAA-TREINAMENTO - Sistema Integrado de Gestão de Atividades Acadêmicas";
    private static final String TITULO_RELATORIO = "Sistema Integrado de Gestão de Atividades Acadêmicas";
    private static final String URL_PORTAL = "/sigaa/portais/discente/discente.jsf";

    private PortalDiscente portal;
    private verificaçao validador;

    private String usuario = "aleksander.lopes";
    private String senha = "Mudar123";

    @Before
    public void iniciar() {
        Navegador.abrirNavegador("https://sigaatre-tst.uffs.edu.br/sigaa");
        portal = new PortalDiscente();
        validador = new verificaçao();

        portal.login.logarSigaaTreinamentos(usuario, senha);
        validador.aguardarCarregamentoDaPagina();
    }

    
    @Test
    public void portalDoDiscenteCarregaAposLogin() {
        validarTela("Portal do Discente", URL_PORTAL, TITULO_PORTAL, null);
    }

    
    @Test
    public void consultarMinhasNotas() {
        portal.login.navegarMenuDiscente("ensino", "consultar minhas notas");
        validarTela("Consultar Minhas Notas", URL_PORTAL, TITULO_RELATORIO, "Relatório de Notas");
    }

    @Test
    public void consultarIndicesAcademicos() {
        portal.login.navegarMenuDiscente("ensino", "consultar índices acadêmicos");
        validarTela("Consultar Índices Acadêmicos", "/graduacao/discente/relatorio_indices_discente.jsf",
                TITULO_RELATORIO, "Descrição dos Índices Acadêmicos");
    }

    @Test
    public void emitirAtestadoDeMatriculaAbreRelatorio() {
        portal.login.navegarMenuDiscente("ensino", "emitir atestado de matrícula");
        validarTela("Emitir Atestado de Matrícula", URL_PORTAL, TITULO_RELATORIO, "Atestado de Matrícula");
    }

    @Test
    public void calendarioAcademico() {
        portal.login.navegarMenuDiscente("ensino", "calendário acadêmico");
        validarTela("Calendário Acadêmico", URL_PORTAL, TITULO_PORTAL, "Lista de Calendários");
    }

    
    @Test
    public void consultarTurma() {
        portal.ensino.consultasGerais("Consultar Turma");
        validarTela("Consultar Turma", URL_PORTAL, TITULO_PORTAL, null);
    }

    @Test
    public void consultarEstruturaCurricular() {
        portal.ensino.consultasGerais("Consultar Estrutura Curricular");
        validarTela("Consultar Estrutura Curricular", URL_PORTAL, TITULO_PORTAL, null);
    }

    @Test
    public void consultarUnidadesAcademicas() {
        portal.ensino.consultasGerais("Consultar Unidades Acadêmicas");
        validarTela("Consultar Unidades Acadêmicas", URL_PORTAL, TITULO_PORTAL, null);
    }

    
    @Test
    public void EmitirAtestadoDeMatriculaVoltaAoPortal() {
        portal.ensino.emitirAtestadoDeMatricula();
        validarTela("Portal após emitir atestado", URL_PORTAL, TITULO_PORTAL, null);
    }

    
    @Test
    public void metodosDeVerificacaoRetornamFalsoQuandoNaoBatem() {
        Assert.assertFalse("validarUrlAtual deveria falhar para uma rota inexistente",
                validador.validarUrlAtual("/rota/que/nao/existe.jsf"));
        Assert.assertFalse("validarTituloDaPagina deveria falhar para um título errado",
                validador.validarTituloDaPagina("Título que não existe"));
        Assert.assertFalse("validarMensagemNaTela deveria falhar para um texto ausente",
                validador.validarMensagemNaTela("Texto que certamente não está na página"));
    }

    @After
    public void finalizar() {
        Navegador.fecharNavegador();
    }


    /** Aplica todas as verificações da classe verificaçao na tela atual. textoNaTela == null pula essa checagem. */
    private void validarTela(String nome, String fragmentoUrl, String titulo, String textoNaTela) {
        validador.aguardarCarregamentoDaPagina();
        WebDriver driver = Navegador.driver;

        Assert.assertFalse("[" + nome + "] Erro sistêmico (500/404/exception) na página",
                validador.existeErroSistemicoNaPagina());

        Assert.assertTrue("[" + nome + "] URL inesperada: " + driver.getCurrentUrl(),
                validador.validarUrlAtual(fragmentoUrl));

        Assert.assertTrue("[" + nome + "] Título inesperado: '" + driver.getTitle() + "'",
                validador.validarTituloDaPagina(titulo));

        if (textoNaTela != null) {
            Assert.assertTrue("[" + nome + "] Texto '" + textoNaTela + "' não apareceu (a navegação chegou na tela certa?)"
                    + " | Cabeçalhos na tela: " + cabecalhosVisiveis(),
                    validador.validarMensagemNaTela(textoNaTela));
        }
    }

    private String cabecalhosVisiveis() {
        StringBuilder sb = new StringBuilder();
        for (WebElement e : Navegador.driver.findElements(By.cssSelector("h2, h3, legend, caption"))) {
            if (e.isDisplayed() && !e.getText().isBlank()) {
                sb.append("[").append(e.getText().trim().replace("\n", " ")).append("] ");
            }
        }
        return sb.toString();
    }
}

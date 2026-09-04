package automacao_sigaa.paginas;

import java.time.Duration;

public class Estagio extends metodos {
    public void navegarNoMenu() {
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(3));
        voltarAoMenuPrincipal();
        navegarMenuDiscente("estágio", "gerenciar estágios");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(3));
        voltarAoMenuPrincipal();
        navegarMenuDiscente("estágio", "pré-cadastro de estágio");
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(3));
        clicarBuscar();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(3));
        voltarAoMenuPrincipal();

    }
}

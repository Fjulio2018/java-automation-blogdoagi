# Projeto QA UI Automation

Este é um projeto de automação de testes para QA UI usando Java, selenuim e TestNG.

## Pré-requisitos

Certifique-se de ter as seguintes ferramentas instaladas em seu sistema:

- Java 11
- Maven 3.9.6


## Configuração do Projeto

1. Clone este repositório em sua máquina local:

   ```bash
   git clone https://github.com/Fjulio2018/API-Rest-Assured-Testing
   ```

2. Navegue até o diretório do projeto:

   ```bash
   cd java-automation-blogdoagi
   



3. Build do Projeto com Maven:

   ```bash
   mvn clean install
   ```

## Executando os Testes

Para executar os testes, utilize o seguinte comando Maven:

```bash
mvn clean test 
```

Isso iniciará a execução dos testes usando TestNG.xml.

## Estrutura do Projeto

- **src/test/java/br/com/blogdoagi/pages**: Contém os Page Objects
- **src/test/java/br/com/blogdoagi/tests**: Contém os arquivos Java para implementação dos testes.
- **src/test/java/br/com/blogdoagi/utils**: Contém os arquivos de recursos para os testes
## Dependências Principais

    TestNG:
        Nome: TestNG
        Versão: 7.10.2



    Selenium :
        Nome: selenium-java
        Versão: 4.21.0

    Webdrivermanager:
        Nome: webdrivermanager
        Versão: 5.8.0

    reportng:
        Nome: reportng
        Versão: 1.1.4



    

## Relatórios

Os relatórios de execução podem ser encontrados no diretório `test-output/All Test Suite` após a execução dos testes.

## Notas Adicionais



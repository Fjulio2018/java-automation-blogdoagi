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
## Cenários de Teste BDD

```gherkin

# language: pt
# Build by Francis Nascis

Funcionalidade: Validação do Blog Agi

  Contexto:
    Dado que acesse uma página do Blog

  Cenário: Acesso a HomePage
    Quando acessar a HomePage
    Então valido que o título da página contém "Blog do Agi"

  Cenário: Validação da quantidade de links para páginas na HomePage
    Quando pesquisar a quantidade de links para paginas nas "Últimas do Blog do Agi"
    Então valido que são 6 links na página

  Cenário: Validação da quantidade de links ler texto na HomePage
    Quando pesquisar a quantidade de links para textos nas "Últimas do Blog do Agi"
    Então valido que são 6 links na página

  Cenário: Validação do Menu Agi
    Quando validar o Menu
    Então certifico a presença do logo e do menu

  Cenário: Validar quantidade de post em uma busca
    Quando realizar uma busca
    Então valido que a máxima de 9 posts é exibida

  Cenário: Valida fluxo de busca de vagas
    Quando realizar uma busca por vagas no Search do menu
    E acessar a busca desejada
    Então o sistema retorna a página com o link para o Gupy

  Cenário: Valida acesso para página Carreira pelo menu
    Quando acessar o menu
    E acessar o link Carreira
    Então o sistema retorna a página Carreira para validação



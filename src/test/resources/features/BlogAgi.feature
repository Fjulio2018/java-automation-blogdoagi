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
    Então valido que são 22 links na página

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

# language: pt

Funcionalidade: Validação do Blog Agi


  Cenário: Acesso a HomePage


    Dado que acesse a URL "https://blogdoagi.com.br/"
    Quando acessar HomePage
    Então valido que o título da página tenha "Blog do Agi"

  Cenário: Validação da quantidade de links de Suas Finanças na HomePage

     Dado que acesse a URL "https://blogdoagi.com.br/"
     Quando pesquisar a quantidade de links de "Suas finanças"
     Então valido que são 4 links na pagina


  Cenário: Validação do Menu Agi

    Dado que acesse uma pagina do Blog
    Quando validar o Menu
    Então certifico a presença do logo e menu

  Cenário: Validar quantidade de post em uma busca

    Dado que acesse a HomePage
    Quando performar uma busca
    Então valido que a máxima de 9  posts

  Cenário: Valida fluxo de busca de vagas

    Dado que acesse a HomePage
    Quando performar uma busca vagas no Search do menu
    E acessar a busca desejada
    Então sistema retorna a página com o link para o gupy

  Cenário: Valida acesso para página Carreira pelo menu

    Dado que acesse a HomePage
    Quando acessar o menu
    E acessar o link Carreira
    Então sistema retorna a página carreira para Validação

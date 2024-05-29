# language: pt

Funcionalidade: Validação do Blog Agi


Cenario: Acesso a HomePage


Dado que acesse a URL "https://blogdoagi.com.br/"
Quando acessar Home page
Então valido que o titulo da pagina tenha "Blog do Agi"


Cenario: Validação do Menu Agi
Dado que acesse uma pagina do Blog
Quando validar o Menu
Então certifico a presença do logo
E certifico a presença do primeiro item do menu

Cenario: Validar quantidade de post em uma busca
Dado que acesse a HomePage
Quando performar uma busca
Então valido que a maxima de 9  posts

Cenario: Valida fluxo de busca de vagas
Dado que acesse a HomePage
Quando performar uma busca vagas no search do menu
E acessar a busca desejada
Então sistema retorna a pagina com o link para o gupy

Cenario: Valida acesso para pagina Carreira pelo menu
Dado que acesse a HomePage
Quando acessar o menu
E acessar acessar i link Carreira
Então sistema retorna a pagina carreira para Validação
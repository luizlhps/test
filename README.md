<h1 align="left">Bem-vindo ao meu teste 👋</h1>

<p align="left">O projeto foi desenvolvido com base na arquitetura limpa, seguindo os princípios do DDD. Foi utilizado o Swagger para facilitar a documentação da API.</p>
<h2 align="left">Sobre as tomadas de decisão</h2>

<p align="left">Decidiu-se separar o produto (`product`) e a medida (`measurement`) como entidades distintas. O `measurement`, por representar unidades de peso como "kg" ou "mb", poderia futuramente ser armazenado em uma tabela enum, separando ainda mais as possíveis medidas utilizadas no sistema.<br><br>A implementação do método `getAll` foi aprimorada com filtros personalizados, permitindo, por exemplo, listar produtos em promoção dentro de uma faixa de preço específica, realizar ordenação (`order by`) por preço e incluir paginação.<br><br>Adicionaram-se rotas auxiliares para atender alguns requisitos do teste, como a rota `/products/average`, que retorna o valor médio de todos os produtos, e a rota `/products/most-expensive`, que retorna o produto mais caro. Esses valores são calculados diretamente no repositório, evitando, por exemplo, a necessidade de calcular a média no código.<br><br>Validações foram adicionadas para rotas como `getAll`, `update`, `create` e `delete`.</p>

<h2 align="left">Tecnologias</h2>

<div align="left"> <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/docker/docker-original.svg" height="40" alt="docker logo" /> <img width="12" /> <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/spring/spring-original.svg" height="40" alt="spring logo" /> <img width="12" /> <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/postgresql/postgresql-original.svg" height="40" alt="postgresql logo" /> </div>

<h2 align="left">Como iniciar o projeto</h2>

<p align="left">Para iniciar o projeto facilmente, é necessário ter o Docker instalado. Caso contrário, será necessário ter o PostgreSQL instalado na máquina.</p>

<h4 align="left">- Iniciando o projeto com Docker</h4>

<p align="left">Primeiro, navegue até a raiz do projeto e utilize o comando `docker compose up -d`.<br>Após a aplicação ser iniciada, acesse a rota <a href="http://localhost:8080/swagger-ui/index.html#/">http://localhost:8080/swagger-ui/index.html#/</a>. Nessa interface, será possível visualizar todos os endpoints.</p>

<h4 align="left">- Iniciando o projeto sem Docker</h4>

<p align="left">Para iniciar sem Docker, é necessário instalar o PostgreSQL. Após a instalação e configuração, você deverá editar o arquivo `application.properties`, localizado na raiz do projeto, preenchendo as variáveis:<br><br> - `DB_URL`<br> - `DB_USER`<br> - `DB_PASSWORD`<br><br> Depois disso, utilize o Maven para adicionar as dependências e iniciar o projeto. Após iniciar a aplicação, acesse <a href="http://localhost:8080/swagger-ui/index.html#/">http://localhost:8080/swagger-ui/index.html#/</a> para visualizar todos os endpoints.</p>

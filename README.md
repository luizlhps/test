# Bem-vindo ao meu teste 👋

O projeto foi desenvolvido com base na arquitetura limpa, seguindo os princípios do DDD. Foi utilizado o Swagger para facilitar a documentação da API.

## Sobre as tomadas de decisão

Decidiu-se separar o produto (`product`) e a medida (`measurement`) como entidades distintas. O `measurement`, por representar unidades de peso como "kg" ou "mb", poderia futuramente ser armazenado em uma tabela enum, separando ainda mais as possíveis medidas utilizadas no sistema.

A implementação do método `getAll` foi aprimorada com filtros personalizados, permitindo, por exemplo, listar produtos em promoção dentro de uma faixa de preço específica, realizar ordenação (`order by`) por preço e incluir paginação.

Adicionaram-se rotas auxiliares para atender alguns requisitos do teste, como a rota `/products/average`, que retorna o valor médio de todos os produtos, e a rota `/products/most-expensive`, que retorna o produto mais caro. Esses valores são calculados diretamente no repositório, evitando, por exemplo, a necessidade de calcular a média no código.

Validações foram adicionadas para rotas como `getAll`, `update`, `create` e `delete`.

## Tecnologias

<div align="left">
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/docker/docker-original.svg" height="40" alt="docker logo"  />
  <img width="12" />
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/spring/spring-original.svg" height="40" alt="spring logo"  />
  <img width="12" />
  <img src="https://cdn.jsdelivr.net/gh/devicons/devicon/icons/postgresql/postgresql-original.svg" height="40" alt="postgresql logo"  />
</div>

## Como iniciar o projeto

Para iniciar o projeto facilmente, é necessário ter o Docker instalado. Caso contrário, será necessário ter o PostgreSQL instalado na máquina.

### Iniciando o projeto com o Docker

1. Navegue até a raiz do projeto.
2. Execute o comando:

   ```bash
   docker compose up -d
   ```

3. Após a aplicação ser iniciada, acesse http://localhost:8080/swagger-ui/index.html#/. Nessa interface do swagger, será possível visualizar todos os endpoints.

### Iniciando o projeto sem o Docker

1. Instale o PostgreSQL.
2. Edite o arquivo application.properties localizado na raiz do projeto, preenchendo as variáveis:
DB_URL
DB_USER
DB_PASSWORD

3. Use o Maven para adicionar as dependências e iniciar o projeto.
4. Após iniciar a aplicação, acesse http://localhost:8080/swagger-ui/index.html#/ para visualizar todos os endpoints

# Aplicação Triângulo em Java para console utilizando Docker Compose

## Contextualização

Este projeto implementa uma aplicação Java para calcular a área de um triângulo por meio de um menu interativo no console.

O usuário pode informar a base e a altura do triângulo, calcular sua área e encerrar a aplicação.

O projeto foi desenvolvido para utilização na IDE NetBeans e utiliza o Apache Maven para compilar e empacotar a aplicação no formato JAR. O Docker é utilizado para construir a imagem e executar a aplicação em um container, enquanto o Docker Compose facilita o gerenciamento da execução.

### Funcionalidades

- Leitura da base e da altura do triângulo.
- Cálculo da área do triângulo.
- Exibição do resultado no console.
- Menu interativo para selecionar as operações.

## Tecnologias utilizadas

- **Java 8:** linguagem e ambiente de execução da aplicação.
- **Apache Maven:** ferramenta para gerenciamento do projeto, compilação e empacotamento.
- **IDE NetBeans:** ambiente de desenvolvimento.
- **Docker:** ferramenta utilizada para construir imagens e executar containers.
- **Docker Compose:** ferramenta utilizada para configurar e executar a aplicação em container.

## Pré-requisitos

Para desenvolver e construir a aplicação, é necessário ter:

- Java 8 instalado, caso a compilação seja realizada localmente.
- Apache Maven instalado, caso a compilação seja realizada localmente.
- Docker instalado e em execução.
- Docker Compose disponível por meio do comando `docker compose`.

Os comandos a seguir devem ser executados no terminal do sistema operacional, como o PowerShell do Windows.

## Estrutura e arquivos do projeto

- `pom.xml` — arquivo de configuração do Maven, com as informações do projeto e suas dependências.
- `src/main/java/Principal.java` — classe principal da aplicação, responsável pela interação com o usuário, conforme a estrutura atual do projeto.
- `Dockerfile` — define a imagem base, copia o arquivo JAR e especifica o comando de inicialização da aplicação.
- `compose.yml` — define o serviço Docker responsável pela execução da aplicação.
- `target/triangulo_java_docker-0.0.1.jar` — arquivo JAR esperado pelo Dockerfile após a construção do projeto.

O nome e o caminho da classe principal devem ser conferidos caso a estrutura real do projeto seja diferente da descrita acima.

## Construção da aplicação

Na pasta do projeto, execute:

```bash
mvn clean package
```

Esse comando limpa os arquivos de construção anteriores, compila o código e empacota a aplicação conforme a configuração do Maven.

Antes de construir a imagem Docker, confirme que o arquivo JAR esperado pelo `Dockerfile` foi gerado em `target/`.

## Execução com Docker Compose

### Construir a imagem e executar a aplicação interativamente

Execute:

```bash
docker compose run --build --rm app
```

Esse comando constrói a imagem quando necessário e inicia a aplicação em uma sessão interativa, permitindo digitar as opções do menu no console. A opção `--rm` remove o container temporário ao final da execução.

### Remover os containers e as imagens do projeto

```bash
docker compose down --rmi all
```

Esse comando remove os containers e as imagens associadas aos serviços definidos no arquivo Compose.

## Dockerfile

O Dockerfile utiliza a imagem `eclipse-temurin:8-jre-alpine`, que fornece o ambiente de execução Java 8.

Durante a construção da imagem, o arquivo JAR gerado pelo Maven é copiado para o diretório `/app`. Quando o container é iniciado, o comando `java -jar` executa a aplicação.

## Docker Compose

O arquivo `compose.yml` define o serviço `app`, responsável por executar a aplicação Java.

O serviço utiliza o Dockerfile localizado no diretório do projeto e define o nome da imagem e do container.

Como a aplicação atual realiza apenas cálculos matemáticos, não é necessário configurar um banco de dados ou um serviço de administração de banco de dados.

## Observações

- O arquivo JAR gerado pelo Maven deve ter o mesmo nome e caminho definidos na instrução `COPY` do Dockerfile.
- O `pom.xml` precisa estar configurado para gerar um JAR executável compatível com o comando `java -jar`.
- Para utilizar o menu interativo, prefira `docker compose run --build --rm app`.
- O projeto utiliza Java 8; a versão do compilador Maven deve ser compatível com essa configuração.

# Define a imagem base que será utilizada para criar a imagem da aplicação.
# A imagem eclipse-temurin:8-jre-alpine contém o Java Runtime Environment (JRE) 8
# e utiliza o Alpine Linux como sistema operacional base.
FROM eclipse-temurin:8-jre-alpine

# Define o diretório de trabalho dentro do container.
# A partir deste diretório serão executados os comandos da aplicação.
# Caso o diretório não exista, ele será criado automaticamente.
WORKDIR /app

# Copia o arquivo JAR da aplicação, gerado previamente pelo Maven,
# do computador para o diretório /app dentro da imagem.
#
# Arquivo de origem:
# ./target/triangulo_console_java_docker-0.0.1.jar
#
# Arquivo de destino dentro da imagem
# /app/cadastromensagem_mongodb_docker
COPY ./target/triangulo_console_java_docker-0.0.1.jar .

# Define o comando executado automaticamente quando o container for iniciado.
#
# O parâmetro "-jar" informa à JVM que será executado um arquivo JAR.
# Como o WORKDIR foi definido como /app, o arquivo JAR será localizado
# dentro desse diretório.
CMD ["java", "-jar", "./triangulo_console_java_docker-0.0.1.jar"]
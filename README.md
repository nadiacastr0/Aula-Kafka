# Apache Kafka

Criando projeto Kafka usando a linguagem de programação Java na versão 17 e instalando o Kafka pelo Docker:

1. Certifique-se de ter o Docker instalado em sua máquina.
2. Crie um novo diretório para o seu projeto Kafka e acesse-o pelo terminal.
3. Dentro do diretório do projeto, crie um arquivo chamado `docker-compose.yml` e adicione o seguinte conteúdo:

```yaml
version: '3'
services:
  zookeeper:
    image: confluentinc/cp-zookeeper
    ports:
      - "2181:2181"
    environment:
      ZOOKEEPER_CLIENT_PORT: 2181
    networks:
      - kafka-network

  kafka:
    image: confluentinc/cp-kafka
    ports:
      - "9092:9092"
    environment:
      KAFKA_ADVERTISED_LISTENERS: PLAINTEXT://kafka:9092
      KAFKA_ZOOKEEPER_CONNECT: zookeeper:2181
    depends_on:
      - zookeeper
    networks:
      - kafka-network

networks:
  kafka-network:
    driver: bridge

```

1. No terminal, execute o comando `docker-compose up`  para iniciar/baixar os containers no docker.
2. Aguarde até que os containers sejam iniciados e estejam em execução.
3. Abra sua IDE de preferência e crie um novo projeto Java.
4. Adicione as dependências necessárias para o desenvolvimento do projeto Kafka usando o Maven.
5. baixe o repositório `` na sua máquina.
6. Execute o projeto Java e verifique se as mensagens estão sendo produzidas e consumidas corretamente no Kafdrop.
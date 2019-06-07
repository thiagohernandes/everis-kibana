# everis-kibana
Exemplo de log com Spring Boot + ELK

## Instruções
- git clone https://github.com/thiagohernandes/everis-kibana.git
- realizar o download e descompactar em um diretório de preferência as ferramentas abaixo:
- https://www.elastic.co/pt/downloads/elasticsearch; https://www.elastic.co/pt/downloads/kibana; https://www.elastic.co/pt/downloads/logstash;

## Configurações
- o arquivo de log configurado para acesso pelo Logstash está configurado na aplicação em "c:\Dev\temp\log-kibana.log";
- na basta "config" do Kibana, descomentar as diretivas: "server.host: "localhost"" e "elasticsearch.hosts: ["http://localhost:9200"]";
- na pasta "config" do Logstash, copiar o arquivo "logstash.conf" para o diretório "bin" do próprio Logstash e colocar a configuração abaixo:
```
input {
  file {
    type => "java"
     path => "C:/Dev/temp/log-kibana.log"
    codec => multiline {
      pattern => "^%{YEAR}-%{MONTHNUM}-%{MONTHDAY} %{TIME}.*"
      negate => "true"
      what => "previous"
    }
  }
}
 
filter {
  #If log line contains tab character followed by 'at' then we will tag that entry as stacktrace
  if [message] =~ "\tat" {
    grok {
      match => ["message", "^(\tat)"]
      add_tag => ["stacktrace"]
    }
  }
 
}
 
output {
   
  stdout {
    codec => rubydebug
  }
 
  # Sending properly parsed log events to elasticsearch
  elasticsearch {
    hosts => ["localhost:9200"]
  }
}
```
## Running
- abrir 3 prompt de comando e executar: 
- primeiro prompt: dentro do diretório "bin" do elasticsearch -> elasticsearch.bat
- segundo prompt: dentro do diretório "bin" do kibana -> kibana.bat
- terceiro prompt: dentro do diretório "bin" do logstash -> logstash.bat -f logstash.conf

## Acesso Kibana dashboard
- http://localhost:5601

## Configuração Kibana de acesso aos logs
- ir no ícone de Managment e configurar um "Index patern";
- clicar em "Index patern" e colocar o nome de "logstash-*";
- habilitar a opção: "Include System Indices" - clicar em next;
- em "Timer Filter field name" definir "I don´t want to use the Timer Filter";
- depois* ir em "Discovery" e digitar em filter primeiro o termo "exception" e depois "getAllTimes", que são os logs emitidos ao chamar os serviços: http://localhost:8080/api/times/todos-erro e http://localhost:8080/api/times/todos;
* realizar algumas chamadas dos serviços da api times


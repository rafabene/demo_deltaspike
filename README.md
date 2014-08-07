demo_deltaspike
================

Projeto de demonstração sobre CDI Portable Extensions e DeltaSpike

Para executar:

Inicie o JBoss WildFly
----------------------

1. Abra a linha de comando e navegue  até o diretório raiz do servidor.
2. Às linhas a seguir mostram os comandos para executar o Wildfly:

        No Linux:   JBOSS_HOME/bin/standalone.sh
        No Windows: JBOSS_HOME\bin\standalone.bat


Build e Deploy da Demo
----------------------


1. Tenha a certeza que de o servidor está iniciado como descrito acima.
2. Abra a linha de comando e navegue até o diretório raizo desta demo.
3. Digite o seguinte comando para fazer o build e deploy da demo:

        mvn clean package wildfly:deploy

4. Isto irá implantar o arquivo `/target/demo_deltaspike.war` no instância do servidor em execução.
 
Acesse a aplicação
-------------------

A aplicação estará sendo executada na seguinte URL: <http://localhost:8080/demo_deltaspike/>.
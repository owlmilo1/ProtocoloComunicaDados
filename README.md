# Protocolo de Comunicação
> Definição e implementação de um protocolo simples em Java, usando sockets e serialização.

## Definição
Dentro do pacote haverá o identificador do pacote atual, a quantidade total de caracteres, e o identificador do próximo pacote. O reconhecimento do pacote, pelo cliente, será realizado com um pacote indicando o identificador do próximo pacote. Não recebendo este pacote de reconhecimento, o cliente envia o pacote outra vez.

## Classe de Pacote e seus Atributos
Os objetos da classe Mensagem representam os Pacotes que serão enviados.
Dentro da classe estão os atributos: 
- **mensagem**, que representa o conteúdo do pacote; 
- **tamMensagem**, que representa o tamanho da mensagem; 
- **posAtual**, o índice do pacote; 
- **posProxima**, o índice do próximo pacote.

## Fluxo
- O cliente envia um pacote. 
- O servidor recebe esse pacote e compara seu índice com o índice esperado, se corresponder, ele envia um pacote de confirmação indicando o índice do próximo pacote esperado, se não, ele envia um pacote indicando o índice do pacote que foi recebido. 
- O cliente recebe o pacote do servidor, se seu índice indicar o do próximo pacote a ser enviado, significa que o servidor recebeu o pacote que o cliente enviou e está esperando o próximo, se o pacote indicar o índice do que o cliente enviou, o servidor não recebeu o pacote, então o cliente envia novamente.

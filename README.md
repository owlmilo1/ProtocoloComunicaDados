# Protocolo de Comunicação
> Definição e implementação de um protocolo simples em Java, usando sockets e serialização.

## Definição
Dentro do pacote haverá o identificador do pacote atual, a quantidade total de caracteres, e o identificador do próximo pacote. O reconhecimento do pacote, pelo cliente, será realizado com um pacote indicando o identificador do próximo pacote. Não recebendo este pacote de reconhecimento, o cliente envia o pacote outra vez.

## Classe de Pacote e seus Atributos
Os objetos da classe [Mensagem](https://github.com/owlmilo1/ProtocoloComunicaDados/blob/main/src/implementaprotocolo/Mensagem.java) representam os Pacotes que serão enviados.
Dentro da classe estão os atributos: 
- **mensagem**, que representa o conteúdo do pacote; 
- **tamMensagem**, que representa o tamanho da mensagem; 
- **posAtual**, o índice do pacote; 
- **posProxima**, o índice do próximo pacote.

## Fluxo
- [O cliente envia um pacote](https://github.com/owlmilo1/ProtocoloComunicaDados/blob/main/src/implementaprotocolo/Cliente.java#L34). 
- O servidor recebe esse pacote e [compara seu índice com o índice esperado](https://github.com/owlmilo1/ProtocoloComunicaDados/blob/main/src/implementaprotocolo/Servidor.java#L26), [se corresponder, ele envia um pacote de confirmação indicando o índice do próximo pacote esperado](https://github.com/owlmilo1/ProtocoloComunicaDados/blob/main/src/implementaprotocolo/Servidor.java#L29), [se não, ele envia um pacote indicando o índice do pacote que foi recebido.](https://github.com/owlmilo1/ProtocoloComunicaDados/blob/main/src/implementaprotocolo/Servidor.java#L34) 
- O cliente recebe o pacote do servidor, [se seu índice indicar o do próximo pacote a ser enviado](https://github.com/owlmilo1/ProtocoloComunicaDados/blob/main/src/implementaprotocolo/Cliente.java#L41), significa que o servidor recebeu o pacote que o cliente enviou e está esperando o próximo, [se o pacote indicar o índice do que o cliente enviou](https://github.com/owlmilo1/ProtocoloComunicaDados/blob/main/src/implementaprotocolo/Cliente.java#L44), o servidor não recebeu o pacote, então o cliente envia novamente.

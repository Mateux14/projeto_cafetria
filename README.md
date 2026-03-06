# Projeto Cafeteria em Java

Projeto simples em Java para gerenciamento de uma cafeteria, com foco em:

- cadastro de clientes
- cadastro de produtos
- criação de pedidos
- adição de itens ao pedido
- cálculo do total do pedido

## Estrutura

```bash
projeto_cafeteria_github/
├── src/
│   ├── Cliente.java
│   ├── Produto.java
│   ├── Pedido.java
│   ├── ItemPedido.java
│   └── Main.java
└── README.md
```

## Como executar

No terminal, dentro da pasta `src`, rode:

```bash
javac *.java
java Main
```

## Funcionalidades implementadas

### Cliente
- cadastrar cliente
- listar clientes
- buscar cliente por ID
- remover cliente por ID

### Produto
- cadastrar produto
- listar produtos
- buscar produto por ID
- atualizar preço
- remover produto

### Pedido
- criar pedido
- listar pedidos
- buscar pedido por ID
- cancelar pedido

### ItemPedido
- adicionar item ao pedido
- listar itens do pedido
- calcular total do pedido

## Observação

O projeto utiliza `ArrayList` para armazenamento em memória, conforme o modelo acadêmico mais comum para esse tipo de atividade inicial em Java.

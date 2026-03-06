public class Main {

    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE CAFETERIA ===\n");

        Cliente.cadastrarCliente(1, "Mateus", "(61) 99999-9999");
        Cliente.cadastrarCliente(2, "Ana", "(61) 98888-8888");

        System.out.println("\n--- CLIENTES ---");
        Cliente.listarClientes();

        Produto.cadastrarProduto(1, "Café Expresso", 8.00);
        Produto.cadastrarProduto(2, "Pão de Queijo", 6.50);
        Produto.cadastrarProduto(3, "Cappuccino", 12.00);

        System.out.println("\n--- PRODUTOS ---");
        Produto.listarProdutos();

        Pedido.criarPedido(1, 1);

        System.out.println("\n--- ITENS DO PEDIDO 1 ---");
        ItemPedido.adicionarItemPedido(1, 1, 2);
        ItemPedido.adicionarItemPedido(1, 2, 3);
        ItemPedido.adicionarItemPedido(1, 3, 1);
        ItemPedido.listarItensPedido(1);

        double total = ItemPedido.calcularTotalPedido(1);
        System.out.println("\nTotal do pedido 1: R$ " + String.format("%.2f", total));

        System.out.println("\n--- PEDIDOS ---");
        Pedido.listarPedidos();
    }
}

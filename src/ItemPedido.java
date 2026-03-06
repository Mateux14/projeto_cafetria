import java.util.ArrayList;

public class ItemPedido {

    private int idPedido;
    private int idProduto;
    private int quantidade;

    private static final ArrayList<ItemPedido> itens = new ArrayList<>();

    public ItemPedido(int idPedido, int idProduto, int quantidade) {
        this.idPedido = idPedido;
        this.idProduto = idProduto;
        this.quantidade = quantidade;
    }

    public static void adicionarItemPedido(int idPedido, int idProduto, int quantidade) {
        if (quantidade <= 0) {
            System.out.println("Quantidade inválida.");
            return;
        }

        Pedido pedido = Pedido.buscarPedido(idPedido);
        if (pedido == null) {
            System.out.println("Pedido não encontrado.");
            return;
        }

        Produto produto = Produto.buscarProduto(idProduto);
        if (produto == null) {
            System.out.println("Produto não encontrado.");
            return;
        }

        itens.add(new ItemPedido(idPedido, idProduto, quantidade));
        System.out.println("Item adicionado ao pedido.");
    }

    public static double calcularTotalPedido(int idPedido) {
        double total = 0;

        for (ItemPedido item : itens) {
            if (item.idPedido == idPedido) {
                Produto produto = Produto.buscarProduto(item.idProduto);
                if (produto != null) {
                    total += produto.getPreco() * item.quantidade;
                }
            }
        }

        return total;
    }

    public static void listarItensPedido(int idPedido) {
        boolean encontrou = false;

        for (ItemPedido item : itens) {
            if (item.idPedido == idPedido) {
                Produto produto = Produto.buscarProduto(item.idProduto);
                String nomeProduto = (produto != null) ? produto.getNome() : "Produto removido";
                System.out.println(
                    "Produto: " + nomeProduto +
                    " | Quantidade: " + item.quantidade
                );
                encontrou = true;
            }
        }

        if (!encontrou) {
            System.out.println("Nenhum item encontrado para esse pedido.");
        }
    }
}

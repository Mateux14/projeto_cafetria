import java.util.ArrayList;

public class Produto {

    private int id;
    private String nome;
    private double preco;

    private static final ArrayList<Produto> produtos = new ArrayList<>();

    public Produto(int id, String nome, double preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public static void cadastrarProduto(int id, String nome, double preco) {
        if (nome == null || nome.trim().isEmpty()) {
            System.out.println("Nome do produto inválido.");
            return;
        }

        if (preco <= 0) {
            System.out.println("Preço do produto inválido.");
            return;
        }

        if (buscarProduto(id) != null) {
            System.out.println("Já existe um produto com esse ID.");
            return;
        }

        produtos.add(new Produto(id, nome, preco));
        System.out.println("Produto cadastrado com sucesso.");
    }

    public static void listarProdutos() {
        if (produtos.isEmpty()) {
            System.out.println("Nenhum produto cadastrado.");
            return;
        }

        for (Produto p : produtos) {
            System.out.println(p.id + " - " + p.nome + " - R$ " + String.format("%.2f", p.preco));
        }
    }

    public static Produto buscarProduto(int id) {
        for (Produto p : produtos) {
            if (p.id == id) {
                return p;
            }
        }
        return null;
    }

    public static void atualizarPreco(int id, double novoPreco) {
        Produto produto = buscarProduto(id);

        if (produto == null) {
            System.out.println("Produto não encontrado.");
            return;
        }

        if (novoPreco <= 0) {
            System.out.println("Novo preço inválido.");
            return;
        }

        produto.setPreco(novoPreco);
        System.out.println("Preço atualizado com sucesso.");
    }

    public static void removerProduto(int id) {
        Produto produto = buscarProduto(id);

        if (produto == null) {
            System.out.println("Produto não encontrado.");
            return;
        }

        produtos.remove(produto);
        System.out.println("Produto removido com sucesso.");
    }
}

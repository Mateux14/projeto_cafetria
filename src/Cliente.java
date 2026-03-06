import java.util.ArrayList;

public class Cliente {

    private int id;
    private String nome;
    private String telefone;

    private static final ArrayList<Cliente> clientes = new ArrayList<>();

    public Cliente(int id, String nome, String telefone) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public static void cadastrarCliente(int id, String nome, String telefone) {
        if (nome == null || nome.trim().isEmpty()) {
            System.out.println("Nome não pode ser vazio.");
            return;
        }

        if (buscarClientePorId(id) != null) {
            System.out.println("Já existe um cliente com esse ID.");
            return;
        }

        clientes.add(new Cliente(id, nome, telefone));
        System.out.println("Cliente cadastrado com sucesso.");
    }

    public static void listarClientes() {
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
            return;
        }

        for (Cliente c : clientes) {
            System.out.println(c.id + " - " + c.nome + " - " + c.telefone);
        }
    }

    public static Cliente buscarClientePorId(int id) {
        for (Cliente c : clientes) {
            if (c.id == id) {
                return c;
            }
        }
        return null;
    }

    public static void removerClientePorId(int id) {
        Cliente cliente = buscarClientePorId(id);

        if (cliente == null) {
            System.out.println("Cliente não encontrado.");
            return;
        }

        clientes.remove(cliente);
        System.out.println("Cliente removido com sucesso.");
    }
}

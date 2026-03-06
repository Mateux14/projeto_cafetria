import java.time.LocalDate;
import java.util.ArrayList;

public class Pedido {

    private int id;
    private int idCliente;
    private String data;

    private static final ArrayList<Pedido> pedidos = new ArrayList<>();

    public Pedido(int id, int idCliente) {
        this.id = id;
        this.idCliente = idCliente;
        this.data = LocalDate.now().toString();
    }

    public int getId() {
        return id;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public String getData() {
        return data;
    }

    public static void criarPedido(int id, int idCliente) {
        if (buscarPedido(id) != null) {
            System.out.println("Já existe um pedido com esse ID.");
            return;
        }

        Cliente cliente = Cliente.buscarClientePorId(idCliente);
        if (cliente == null) {
            System.out.println("Cliente não encontrado.");
            return;
        }

        pedidos.add(new Pedido(id, idCliente));
        System.out.println("Pedido criado com sucesso.");
    }

    public static void listarPedidos() {
        if (pedidos.isEmpty()) {
            System.out.println("Nenhum pedido cadastrado.");
            return;
        }

        for (Pedido p : pedidos) {
            System.out.println("Pedido: " + p.id + " | Cliente: " + p.idCliente + " | Data: " + p.data);
        }
    }

    public static Pedido buscarPedido(int id) {
        for (Pedido p : pedidos) {
            if (p.id == id) {
                return p;
            }
        }
        return null;
    }

    public static void cancelarPedido(int id) {
        Pedido pedido = buscarPedido(id);

        if (pedido == null) {
            System.out.println("Pedido não encontrado.");
            return;
        }

        pedidos.remove(pedido);
        System.out.println("Pedido cancelado com sucesso.");
    }
}

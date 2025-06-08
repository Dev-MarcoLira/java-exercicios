import java.util.ArrayList;
import java.util.List;

public class MyApp {
    public static void main(String[] args) {

        ArrayList<Produto> produtos = new ArrayList<>();
        Produto produto = new Produto("detergente", 14.0f, 0.23f);
        produtos.add(produto);

     
        Mesa mesa = new Mesa("1", "Salão");
        Cliente cliente = new Cliente("MARCAO", "88656181756", mesa);
        Funcionario funcionario = new Funcionario("moises", "00055566677");
        Endereco endereco = new Endereco("Estrada do portella", "10507020", "tijuca", "SC", 2);
        Restaurante restaurante = new Restaurante("TEMPERO DE MAE", "237123309", endereco, "tdm");
        Menu menu = new Menu(produtos, restaurante.getNome(), restaurante.getNomeFantasia(), restaurante.getCnpj(), restaurante.getEndereco());

        Pedido pedido = new Pedido();
        Item item = new Item(produto, 1, produto.getValProduto()); 
        pedido.addItem(item);
        pedido.setTipoPagamento(TipoPagamento.CARTAO);
 
        pedido.pagar();

        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("CPF: " + cliente.getCpf());
        System.out.println(mesa);
    }
}

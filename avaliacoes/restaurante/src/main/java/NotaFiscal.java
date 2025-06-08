import java.util.ArrayList;
import java.util.UUID;

public class NotaFiscal implements INFCGenerator {

    private UUID id;
    private String cnpjEmitente;
    private ArrayList<Produto> produtos;
    private float total;

    public NotaFiscal() {
        this.produtos = new ArrayList<>();
    }

    @Override
    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return this.id;
    }

    public String getCnpjEmitente() {
        return cnpjEmitente;
    }

    public ArrayList<Produto> getProdutos() {
        return this.produtos;
    }

    public float getTotal() {
        return this.total;
    }

    @Override
    public void setEmitente(String cnpj) {
        this.cnpjEmitente = cnpj;
    }

    @Override
    public void addProd(ArrayList<Produto> produtos) {
        this.produtos.addAll(produtos);
    }

    @Override
    public void setTotal(float total) {
        this.total = total;
    }

   
public void gerar() {
    System.out.println("\n=========== NOTA FISCAL ===========");
    System.out.println("ID: " + getId());
    System.out.println("Emitente (CNPJ): " + getCnpjEmitente());
    System.out.println("Produtos:");

    for (Produto p : getProdutos()) {
        System.out.println("- " + p.getNome() + " - R$" + String.format("%.2f", p.getValProduto()) +
                           " (com IVA: R$" + String.format("%.2f", p.getPrecoComIva()) + ")");
    }

    System.out.println("-----------------------------------");
    System.out.printf("Total com IVA (23%%): R$%.2f\n", total);
    System.out.println("===================================\n");
}

    
}

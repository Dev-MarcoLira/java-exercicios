import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Pedido{
    private float numPedido;
    private float valorTotal;
    private List<Item> itens;
    private NotaFiscal notaFiscal;
    private TipoPagamento tipoPagamento;

    public Pedido(){
        this.numPedido = numPedido;
        this.valorTotal = valorTotal;
        this.itens = new ArrayList<>();
    }
    
    public TipoPagamento getTipoPagamento() {
        return this.tipoPagamento;
    }

    public void setTipoPagamento(TipoPagamento tipoPagamento) {
        this.tipoPagamento = tipoPagamento;
    }
    
    public List<Item> getItens() {
        return this.itens;
    }
    
    public void setItens(List<Item> itens) {
        this.itens = itens;
    }

    public void addItem(Item item){
        this.itens.add(item);
    }
    public NotaFiscal getNotaFiscal() {
        return this.notaFiscal;
    }

    public void setNotaFiscal(NotaFiscal notaFiscal) {
        this.notaFiscal = notaFiscal;
    }
    public float getNumPedido() {
        return numPedido;
    }
    public void setNumPedido(float numPedido) {
        this.numPedido = numPedido;
    }
    public float getValorTotal() {
        return valorTotal;
    }
    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

   public void pagar() {
      
        if (tipoPagamento == TipoPagamento.PIX) {
            new Pix().pagar();
        } else if (tipoPagamento == TipoPagamento.CARTAO) {
            new Cartao().pagar();
        } else if (tipoPagamento == TipoPagamento.ESPECIE) {
            new Especie().pagar();
        }
        NotaFiscal nota = new NotaFiscal();
        nota.setId(UUID.randomUUID());
        nota.setEmitente("237123309"); 

        List<Produto> produtos = new ArrayList<>();
        float total = 0;
        for (Item item : itens) {
            produtos.add(item.getProduto());
            total += item.getTotal(); 
        }

        nota.addProd(produtos);
        float totalComIva = total * 1.23f;
        nota.setTotal(totalComIva);
        this.valorTotal = totalComIva;

        setNotaFiscal(nota);
        nota.gerar();
    
   }
}

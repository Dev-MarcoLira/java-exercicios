import java.util.List;
import java.util.UUID;

public interface INFCGenerator {
    
    public void setId(UUID id);
    public void setEmitente(String cnpj);
    public void setTotal(float total);
    public void addProd(List<Produto> produtos);

}

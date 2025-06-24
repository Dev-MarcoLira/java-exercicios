package models;

import DAO.ItemDAO;

public class Item {
    
    private Produto produto;
    private int quantidade;
    private float valVenda;
    private ItemDAO itemDAO;

    
    
    public Item(Produto produto, int quantidade, float val, ItemDAO itemDAO) {
        setProduto(produto);
        setQuantidade(quantidade);
        setValVenda(val);
        setItemDAO(itemDAO);
    }
    
    public void create(){
        getItemDAO().create(this);
    }
    
    public void read(){
        getItemDAO().read();
    }
    
    public void delete(int id){
        getItemDAO().delete(id);
    }
    
    
    public ItemDAO getItemDAO() {
        return this.itemDAO;
    }

    public void setItemDAO(ItemDAO itemDAO) {
        this.itemDAO = itemDAO;
    }
    
    public Produto getProduto() {
        return this.produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return this.quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public float getValVenda() {
        return this.valVenda;
    }

    public void setValVenda(float valVenda) {
        this.valVenda = valVenda;
    }

    public float getTotal() {
        return this.valVenda * this.quantidade;
    }
}
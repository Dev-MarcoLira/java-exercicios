package views;

import java.util.Scanner;

import DAO.ItemDAO;
import models.Item;
import models.Produto;

public class ItemScan {
 
    private Produto produto;

    public Produto getProduto() {
        return this.produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }


    public ItemScan(
        Produto produto
    ){
        setProduto(produto);
        
    }

    public Item read(){
        
        Scanner scan = new Scanner(System.in);
        ItemDAO itemDAO = new ItemDAO();

        System.out.print("Quantidade: ");
        int quantidade = scan.nextInt();
        
        System.out.print("Valor: ");
        float valor = scan.nextFloat();


        Item item = new Item(getProduto(), quantidade, valor, itemDAO);
        
        return item;
    }


}

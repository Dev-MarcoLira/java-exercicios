package DAO;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;

import models.Item;


public class ItemDAO {
    
    
    public String path = "../db/item.db";
    public ArrayList<Item> items = new ArrayList<Item>();
    public int num = 1;
    
    public void create(Item item){
        
        
        try{
            
            FileWriter db = new FileWriter(path);

            for(Item itemX : items){

                db.write("Pedido #" + num + ":\n");
                db.write("Produto: " + itemX.getProduto().getNome() + "\n");
                db.write("Quantidade: " + itemX.getQuantidade() + "\n");
                db.write("Valor: R$" + itemX.getValVenda() + "\n");
                db.write("Total: R$" + itemX.getTotal() + "\n");
                db.write("\n");
            }

            db.close();
            num++;

        }catch(Exception e){

            System.err.println(e.getMessage());
        }
    }
    
    public void read(){
        
        
        try {
            File source = new File(path);
            
            Scanner reader = new Scanner(source);

            while(reader.hasNextLine()){

                String data = reader.nextLine();
                System.out.println(data);
            }

        } catch (Exception e){
            System.err.println(e.getMessage());
        }

    }
    
    public void delete(int id){
    
        try {
            File source = new File(path);
            
            Scanner reader = new Scanner(source);

            while(reader.hasNextLine()){

                String line = reader.nextLine();
                
                if(line.contains("#")){

                    String idNum = line.split("#")[1];

                    if(idNum.contains(String.valueOf(id))){
                        items.remove(id);
                    }else{

                        System.out.println("Item não encontrado!");
                    }

                }

            }

        } catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
    

}

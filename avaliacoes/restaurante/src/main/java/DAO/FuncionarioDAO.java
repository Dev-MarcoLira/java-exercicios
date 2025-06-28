package DAO;

import java.util.ArrayList;

import models.Funcionario;
import models.Item;

public class FuncionarioDAO {
 
    public String path = "c:\\Users\\Marco\\Documents\\programming\\java\\cefet\\java-exercicios\\avaliacoes\\restaurante\\src\\main\\java\\db\\item.txt";
    
    public void add (Funcionario funcionario){
        
        int id = this.getNextId();
    }

    private int getNextId() {

        int maxId = 0;
        ArrayList<Item> items = getAll();

        for (Item i : items ) {
            if (i.getId() > maxId) {
                maxId = i.getId();
            }
        }

        return maxId + 1;
    }

}
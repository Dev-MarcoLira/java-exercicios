package DAO;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;

import models.Funcionario;
import models.Item;

public class FuncionarioDAO {
 
    public String path = "c:\\Users\\Marco\\Documents\\programming\\java\\cefet\\java-exercicios\\avaliacoes\\restaurante\\src\\main\\java\\db\\item.txt";
    
    public void add (Funcionario funcionario){
        
        int id = this.getNextId();
        
        ArrayList<Funcionario> funcionarios = getAll();

        
        try (BufferedWriter db = new BufferedWriter(new FileWriter(path, false))) {
            
            funcionario.setId(getNextId());
            funcionarios.add(funcionario);

            for(Funcionario func : funcionarios){
                db.write(func.getId() + "," + func.getNome() + "," + func.getCpf() + "," + func.getCargo() + "," + func.getCtps());
                db.newLine();
            }

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

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
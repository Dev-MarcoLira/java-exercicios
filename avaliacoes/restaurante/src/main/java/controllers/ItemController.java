package controllers;

import java.util.Scanner;

import DAO.ItemDAO;
import models.Item;

public class ItemController {
    
    public static void main(String args[]) {

        Scanner scan = new Scanner(System.in);
        ItemDAO itemDAO = new ItemDAO();

        System.out.println("Escolha a opção: ");
        System.out.println("1: Criar");
        System.out.println("2: Ler");
        System.out.println("3: Deletar ");
        
        int opcao = Integer.parseInt(scan.nextLine());
        
        switch(opcao){
            
            case 1:
            
                System.out.print("Quantidade: ");
                int quantidade = scan.nextInt();
                
                System.out.print("Valor: ");
                float valor = scan.nextFloat();
                
                
                Item item = new Item(null, quantidade, valor, itemDAO);
                
                item.create();
                
                break;
            
            case 2:
            
                itemDAO.read();
                break;
                    
            case 3:
                
                System.out.print("ID: ");
                int id = scan.nextInt();
                
                itemDAO.delete(id);
                break;
        }

            scan.close();
    }        
}
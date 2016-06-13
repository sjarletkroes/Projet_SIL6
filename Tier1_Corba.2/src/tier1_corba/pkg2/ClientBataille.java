/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tier1_corba.pkg2;

import Corba.JoueurAction;
import Corba.JoueurActionHelper;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Goldwing
 */
public class ClientBataille {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        try {
            // TODO code application logic here
            InitialContext ctxt = new InitialContext();
            Object Stub = ctxt.lookup("CorbaServer");
            JoueurAction jActStub = JoueurActionHelper.narrow((org.omg.CORBA.Object) Stub);
            
            boolean jeu = true;
            System.out.println("Bonjour et binvennue jeune padawan !");
            System.out.println("Que souhaites-tu faire ?");
            System.out.println(" 1 - Créer un compte ");
            System.out.println(" 2 - Te connecter ");
            System.out.println(" 3 - Te déconnecter ");
            System.out.println("Laisses toi guider seulement par ton intuition ... ");
            System.out.println("... et surtout n'oubli pas, un Jedi doit sentir la Force filtrer à travers son esprit (- Obi-Wan à Luke-)");
            
            System.out.println("Entre ton choix : ");
            int nbAction = 0;
            
            while(jeu){
                
                if(nbAction > 0){
                    System.out.println("======================================");
                    System.out.println("Et maintenant que souhaites-tu faire ?");
                    System.out.println(" 1 - Créer un compte ");
                    System.out.println(" 2 - Te connecter ");
                    System.out.println(" 3 - Te déconnecter ");
                    System.out.println("Entre ton choix : ");
                    System.out.println("\n");
                }else{nbAction = 1;}
                
                Scanner sc = new Scanner(System.in);
                int str = sc.nextInt();
                
                System.out.println("Alors que la Force soit avec toi ! ");
                System.out.println("\n");
                
                switch (str)
                {
                    case 1://ctréation de compte
                       
                      System.out.println("Entre ton nom d'utilisateur : ");
                      String name = sc.next();
                      
                      //on verifie que le login n'exist pas déjà
                      String l = "nul";
                      String rep = jActStub.creerCompte(name, "null");
                      while(rep.equals("Le login est déjà utilisé")){
                          System.out.println("Le login est déjà utilisé ");
                          System.out.println("Entre un autre nom d'utilisateur : ");
                          name = sc.next();
                          rep = jActStub.creerCompte(name, "null");
                      }
                      
                      //while
                      System.out.println("Entre ton mot de passe : ");
                      String mdp = sc.next();
                      System.out.println("Confirme ton mot de passe : ");
                      String mdpConfirm = sc.next();
                      
                       boolean valInterdite = false;
                       if(mdp.equals("null"))
                           valInterdite = true;
                       
                       while(!mdp.equals(mdpConfirm) || valInterdite){
                            System.out.println("\n");
                            if(valInterdite)
                                System.out.println(" Votre mot de passe ne peut pas être égal à NULL");
                           else
                                System.out.println("Il y à une erreur : le mot de passe et sa confirmation ne corespondent pas");
                           
                            
                            System.out.println("Entre ton mot de passe : ");
                            mdp = sc.next();
                            System.out.println("Confirme ton mot de passe : ");
                            mdpConfirm = sc.next();
                            
                            // pour gerer l'existance de l'utilisateur en base
                            if(mdp.equals("null"))
                                valInterdite = true;
                            else
                                valInterdite = false;
                          }
                       
                      if(mdp.toString().equals(mdpConfirm.toString())){
                          String repS = jActStub.creerCompte(name, mdp);
                          System.out.println("\n");
                          System.out.println("Loading ...");
                          System.out.println("--------- "+ repS +" ---------");
                          System.out.println("Ils recrutent des nains, maintenant dans les commandos ?");
                          System.out.println("\n");
                      }
                      break;    
                    case 2:
                        System.out.println("SPICE DE FFOOOOOOUUUUUUUUU !!!!!!!!!");
                        break;
                    case 3:
                        jeu = false;
                        System.out.println("Bye bye !");
                        break;
                  default:
                    /*Action*/;             
                }
             }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}

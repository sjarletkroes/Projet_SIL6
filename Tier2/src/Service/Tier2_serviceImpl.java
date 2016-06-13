/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import java.util.ArrayList;
import java.util.Hashtable;
import tier2_Corba.Joueur;
import tier2_Corba.JoueurActionPOA;

/**
 *
 * @author Goldwing
 */
public class Tier2_serviceImpl extends JoueurActionPOA {
    private ArrayList<Joueur> lesJoueurs;
    private ArrayList<Joueur> lesJoueursConnecte;
    private Hashtable joueurs = new Hashtable();
    private ArrayList<String> joueursConnectes = new ArrayList<>();
    
    @Override
    public String createJoueur(String login, String pass) {
        String msg = "";
        //Joueur J1 = new Joueur(login, pass,0);
        
        //on verifie que le joueur existe
        if(!joueurs.containsKey(login)){
            if(!pass.equals("null")){
                joueurs.put(login,pass);
                System.out.println("le joueur "+ login +" est crée.");
                msg = "Votre compte "+ login +" à bien été créé.";
            }
        }else{
            msg = "Le login est déjà utilisé";
        }
        return msg;
    }

    @Override
    public String connectJoueur(String login, String pass) {
        String msg = "";
        //Joueur J1 = new Joueur(login, pass,0);
        
        //on verifie que le joueur existe
        if(joueurs.contains(login)){
            
            //on verifie qu'il ne soit pas déjà connecté
            if(!this.lesJoueursConnecte.contains(login)){
                joueursConnectes.add(login);
                System.out.println("le joueur est "+ login +" connecté");
                msg = "Vous êtes bien connecté.";
            }else{
                msg = "Vous êtes déjà connecté.";
            }
            
        }else{
            msg = "Vous n'êtes pas inscrit, veuillez créer un compte.";
        }
        return msg;
    }

    @Override
    public String disconectJoueur(String login) {
        String msg = "";
        //Joueur J1 = new Joueur(login, pass,0);
        
        //on verifie que le joueur existe
        if(joueurs.contains(login)){
            
            //on verifie qu'il soit connecté
            if(this.lesJoueursConnecte.contains(login)){
                joueursConnectes.remove(login);
                System.out.println("le joueur est "+ login +" déconnecté");
                msg = "Vous êtes bien déconnecté.";
            }else{
                msg = "Vous êtes déjà déconnecté.";
            }
        }else{
            msg = "Vous n'êtes pas inscrit, veuillez créer un compte.";
        }
        return msg;
    }

    @Override
    public int getScoreJoueur(String login) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Joueur[] getJoueursConnect() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Joueur[] getJoueursOrder() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

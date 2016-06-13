/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Corba.Joueur;
import Corba.JoueurActionPOA;
import java.util.ArrayList;
import java.util.Hashtable;

/**
 *
 * @author Goldwing
 */
public class ServiceJoueurImpl extends JoueurActionPOA{
    
    private ArrayList<Joueur> lesJoueurs;
    private ArrayList<Joueur> lesJoueursConnecte;
    private Hashtable joueurs = new Hashtable();
    private ArrayList<String> joueursConnectes = new ArrayList<>();
    
    @Override
    public String creerCompte(String identifiant, String motDePasse) {
        String msg = "";
        //Joueur J1 = new Joueur(login, pass,0);
        
        //on verifie que le joueur existe
        if(!joueurs.containsKey(identifiant)){
            if(!motDePasse.equals("null")){
                joueurs.put(identifiant,motDePasse);
                System.out.println("le joueur "+ identifiant +" est crée.");
                msg = "Votre compte "+ identifiant +" à bien été créé.";
            }
        }else{
            msg = "Le login est déjà utilisé";
        }
        return msg;
    }

    @Override
    public String authentifier(String identifiant, String motDePasse) {
        String msg = "";
        //Joueur J1 = new Joueur(login, pass,0);
        
        //on verifie que le joueur existe
        if(joueurs.contains(identifiant)){
            
            //on verifie qu'il ne soit pas déjà connecté
            if(!this.lesJoueursConnecte.contains(identifiant)){
                joueursConnectes.add(identifiant);
                System.out.println("le joueur est "+ identifiant +" connecté");
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
    public String deconnecter(String identifiant) {
        String msg = "";
        //Joueur J1 = new Joueur(login, pass,0);
        
        //on verifie que le joueur existe
        if(joueurs.contains(identifiant)){
            
            //on verifie qu'il soit connecté
            if(this.lesJoueursConnecte.contains(identifiant)){
                joueursConnectes.remove(identifiant);
                System.out.println("le joueur est "+ identifiant +" déconnecté");
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
    public int donnerScore(String identifiant) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Joueur[] donnerListeConnectes(String identifiant) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Joueur[] donnerClassement(String identifiant) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

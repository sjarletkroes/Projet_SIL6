package Corba;


/**
* Corba/PartieActionOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Corba.idl
* lundi 13 juin 2016 22 h 14 CEST
*/

public interface PartieActionOperations 
{
  int createPartie (Corba.Joueur J, Corba.PartieHolder p);
  String connectToPartie (Corba.Joueur J, Corba.Partie p);
  String disconnectToPartie (Corba.Joueur J, Corba.Partie P);
  int getScoreJoueur (Corba.Joueur J);
  Corba.Partie[] getPartiesEnAttente ();
  Corba.Partie[] getPartiesEnCours ();
} // interface PartieActionOperations

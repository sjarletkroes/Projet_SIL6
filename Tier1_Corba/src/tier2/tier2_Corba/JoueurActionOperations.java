package tier2_Corba;


/**
* tier2_Corba/JoueurActionOperations.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Tier2.idl
* dimanche 12 juin 2016 00 h 02 CEST
*/

public interface JoueurActionOperations 
{
  String createJoueur (String login, String pass);
  String connectJoueur (String login, String pass);
  String disconectJoueur (String login);
  int getScoreJoueur (String login);
  tier2_Corba.Joueur[] getJoueursConnect ();
  tier2_Corba.Joueur[] getJoueursOrder ();
} // interface JoueurActionOperations
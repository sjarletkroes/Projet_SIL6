package Corba;


/**
* Corba/Partie.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Corba.idl
* lundi 13 juin 2016 22 h 14 CEST
*/

public final class Partie implements org.omg.CORBA.portable.IDLEntity
{
  public int idPartie = (int)0;
  public String nomPartie = null;
  public int nbrMaxJoueurPartie = (int)0;

  public Partie ()
  {
  } // ctor

  public Partie (int _idPartie, String _nomPartie, int _nbrMaxJoueurPartie)
  {
    idPartie = _idPartie;
    nomPartie = _nomPartie;
    nbrMaxJoueurPartie = _nbrMaxJoueurPartie;
  } // ctor

} // class Partie

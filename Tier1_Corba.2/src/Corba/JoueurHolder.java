package Corba;

/**
* Corba/JoueurHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Corba.idl
* lundi 13 juin 2016 22 h 35 CEST
*/

public final class JoueurHolder implements org.omg.CORBA.portable.Streamable
{
  public Corba.Joueur value = null;

  public JoueurHolder ()
  {
  }

  public JoueurHolder (Corba.Joueur initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = Corba.JoueurHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    Corba.JoueurHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return Corba.JoueurHelper.type ();
  }

}
package Corba;


/**
* Corba/JoueursHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Corba.idl
* lundi 13 juin 2016 22 h 35 CEST
*/

public final class JoueursHolder implements org.omg.CORBA.portable.Streamable
{
  public Corba.Joueur value[] = null;

  public JoueursHolder ()
  {
  }

  public JoueursHolder (Corba.Joueur[] initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = Corba.JoueursHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    Corba.JoueursHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return Corba.JoueursHelper.type ();
  }

}

package tier2_Corba;

/**
* tier2_Corba/PartieHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Tier2.idl
* dimanche 12 juin 2016 00 h 02 CEST
*/

public final class PartieHolder implements org.omg.CORBA.portable.Streamable
{
  public tier2_Corba.Partie value = null;

  public PartieHolder ()
  {
  }

  public PartieHolder (tier2_Corba.Partie initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = tier2_Corba.PartieHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    tier2_Corba.PartieHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return tier2_Corba.PartieHelper.type ();
  }

}

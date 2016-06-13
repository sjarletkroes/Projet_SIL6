package tier2_Corba;


/**
* tier2_Corba/JoueurListHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Tier2.idl
* dimanche 12 juin 2016 00 h 02 CEST
*/

abstract public class JoueurListHelper
{
  private static String  _id = "IDL:tier2_Corba/JoueurList:1.0";

  public static void insert (org.omg.CORBA.Any a, tier2_Corba.Joueur[] that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static tier2_Corba.Joueur[] extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = tier2_Corba.JoueurHelper.type ();
      __typeCode = org.omg.CORBA.ORB.init ().create_sequence_tc (0, __typeCode);
      __typeCode = org.omg.CORBA.ORB.init ().create_alias_tc (tier2_Corba.JoueurListHelper.id (), "JoueurList", __typeCode);
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static tier2_Corba.Joueur[] read (org.omg.CORBA.portable.InputStream istream)
  {
    tier2_Corba.Joueur value[] = null;
    int _len0 = istream.read_long ();
    value = new tier2_Corba.Joueur[_len0];
    for (int _o1 = 0;_o1 < value.length; ++_o1)
      value[_o1] = tier2_Corba.JoueurHelper.read (istream);
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, tier2_Corba.Joueur[] value)
  {
    ostream.write_long (value.length);
    for (int _i0 = 0;_i0 < value.length; ++_i0)
      tier2_Corba.JoueurHelper.write (ostream, value[_i0]);
  }

}

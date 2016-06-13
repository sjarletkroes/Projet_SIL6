package tier2_Corba;


/**
* tier2_Corba/JoueurActionHelper.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from Tier2.idl
* dimanche 12 juin 2016 00 h 02 CEST
*/

abstract public class JoueurActionHelper
{
  private static String  _id = "IDL:tier2_Corba/JoueurAction:1.0";

  public static void insert (org.omg.CORBA.Any a, tier2_Corba.JoueurAction that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static tier2_Corba.JoueurAction extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      __typeCode = org.omg.CORBA.ORB.init ().create_interface_tc (tier2_Corba.JoueurActionHelper.id (), "JoueurAction");
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static tier2_Corba.JoueurAction read (org.omg.CORBA.portable.InputStream istream)
  {
    return narrow (istream.read_Object (_JoueurActionStub.class));
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, tier2_Corba.JoueurAction value)
  {
    ostream.write_Object ((org.omg.CORBA.Object) value);
  }

  public static tier2_Corba.JoueurAction narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof tier2_Corba.JoueurAction)
      return (tier2_Corba.JoueurAction)obj;
    else if (!obj._is_a (id ()))
      throw new org.omg.CORBA.BAD_PARAM ();
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      tier2_Corba._JoueurActionStub stub = new tier2_Corba._JoueurActionStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

  public static tier2_Corba.JoueurAction unchecked_narrow (org.omg.CORBA.Object obj)
  {
    if (obj == null)
      return null;
    else if (obj instanceof tier2_Corba.JoueurAction)
      return (tier2_Corba.JoueurAction)obj;
    else
    {
      org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl)obj)._get_delegate ();
      tier2_Corba._JoueurActionStub stub = new tier2_Corba._JoueurActionStub ();
      stub._set_delegate(delegate);
      return stub;
    }
  }

}
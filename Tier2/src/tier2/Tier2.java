/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Service.Tier2_serviceImpl;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.omg.CORBA.Context;
import org.omg.CORBA.ORB;
import org.omg.CORBA.ORBPackage.InvalidName;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;
import org.omg.PortableServer.POAManagerPackage.AdapterInactive;
import org.omg.PortableServer.POAPackage.ServantNotActive;
import org.omg.PortableServer.POAPackage.WrongPolicy;
/**
 *
 * @author Goldwing
 */
public class Tier2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {
            ORB orb = ORB.init(args,null);
            org.omg.CORBA.Object poaRef = orb.resolve_initial_references("RootPOA");
            POA rootpoa = POAHelper.narrow(poaRef);
            rootpoa.the_POAManager().activate();
            
            Tier2_serviceImpl service = new Tier2_serviceImpl();
            
            InitialContext ctxt = new InitialContext();
            ctxt.rebind("CorbaServer",  rootpoa.servant_to_reference(service));
            
            orb.run();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tier2.pkg2;

import Service.ServiceJoueurImpl;
import javax.naming.InitialContext;
import org.omg.CORBA.ORB;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

/**
 *
 * @author Goldwing
 */
public class Tier22 {

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
            
            ServiceJoueurImpl service = new ServiceJoueurImpl();
            
            InitialContext ctxt = new InitialContext();
            ctxt.rebind("CorbaServer",  rootpoa.servant_to_reference(service));
            
            orb.run();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
}

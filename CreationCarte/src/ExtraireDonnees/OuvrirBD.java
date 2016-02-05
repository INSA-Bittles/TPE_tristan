//@author trist

package ExtraireDonnees;

import java.sql.* ;
import java.io.* ;

//import com.mysql.jdbc.driver.* ;

public class OuvrirBD 
{
    public Connection ConnectionBD;
    
    public OuvrirBD()
    {
        System.out.println("Debut de lecture BD");
        
        try 
        {
            // chargement de la classe par son nom
            Class c = Class.forName("com.mysql.jdbc.Driver") ;
            Driver pilote = (Driver)c.newInstance() ;
        
            // enregistrement du pilote auprès du DriverManager
            DriverManager.registerDriver(pilote);
        
            // Protocole de connexion
            String protocole =  "jdbc:mysql:" ;
        
            // Informations sur le BD
            String ip =  "localhost" ; 
            String port =  "3306" ;
            String nomBase =  "aventix" ;
        
            // Chaîne de connexion
            String conString = protocole +  "//" + ip +  ":" + port +  "/" + nomBase ;
        
            // Identifiants de connexion et mot de passe
            String nomConnexion =  "root" ;
            String motDePasse =  "Password" ;
        
            // Connexion
            Connection con = DriverManager.getConnection(
            conString, nomConnexion, motDePasse) ;
            ConnectionBD = con;          
        }
        
        catch (Exception e) 
        {
            // gestion des exceptions
            System.out.println("erreur");
        }
        
        System.out.println("Fin de lecture BD");
    } 
    
    public void LireBD()
    {
        try
        {
            // Envoi d’une requête générique
            String sql =  "select * from beneficiaire" ;
            Statement smt = ConnectionBD.createStatement() ;
            ResultSet rs = smt.executeQuery(sql) ;
            while (rs.next())
            {
               System.out.println(rs.getString("PrenomBeneficiaire")+"\t"+rs.getString("NomBeneficiaire")+"\t"+rs.getString("NumeroCarte")) ;
            }
        }   
        catch (Exception e) 
        {
            // gestion des exceptions
            System.out.println("erreur");
        }
    }
}
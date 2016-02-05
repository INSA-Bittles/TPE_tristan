//@author trist
 
package ExtraireDonnees;

import java.io.File;
import java.io.FileWriter;
import java.sql.ResultSet;
import java.sql.Statement;
import Cryptage.CryptageRSA;

public class CreeCarte 
{
    public CreeCarte(OuvrirBD ouvrir)
    {
        try
        {
            // Envoi d’une requête générique
            String sql =  "select * from carteapuce" ;
            Statement smt = ouvrir.ConnectionBD.createStatement() ;
            ResultSet rs = smt.executeQuery(sql) ;
            
            //Creation des fichiers cartes
            while (rs.next())
            {
                //Cree un fichier vide .donnees avec comme nom le numero de la carte et le remplis
                String nomFichier = 
                        "./Cartes/"
                        +rs.getString("NumeroCarte")
                        +".donnees";
                creeFichier(nomFichier);
                String donnees = 
                        "################################\n"
                        +"################################\n"
                        +"<NumeroCarte>"+rs.getString("NumeroCarte")+"<NumeroCarte>"
                        +"\n################################"
                        +"\n################################";
                remplirFichier(nomFichier,donnees);
                
                //Crypte le fichier de donnees en RSA
                
                
                //Cree un fichier contenant le code d'identification de la carte
                String nomFichier2 = 
                        "./Cartes/"
                        +rs.getString("NumeroCarte")
                        +".codecarte";
                creeFichier(nomFichier2);
                String donnees2 = 
                        "##########################\n"
                        +"##########################\n"
                        +"<CodeCarte>"+rs.getString("CodeCarte")+"<CodeCarte>"
                        +"\n##########################"
                        +"\n##########################";
                remplirFichier(nomFichier2,donnees2);
                
                //Crypte le fichier code en blowfish
                
            }
        }   
        catch (Exception e) 
        {
            // gestion des exceptions
            System.out.println("erreur");
        }
    }
    
    //Méthode pour la création des fichiers
    public static void creeFichier(String lenomFichier)
    {
        try
        {
            File f = new File (lenomFichier);
            if(f.createNewFile())
            {
                System.out.println("Le fichier a été créé");
            }
            else if (f.exists())
            {
                System.out.println ("Le fichier existe déjà");
            }
            else
            {
                System.out.println("Erreur, Impossible de créer ce fichier");
            }
        }
        catch (Exception e) 
        {
            // gestion des exceptions
            System.out.println("erreur");
        }
    }
    
    //Méthode pour l'écriture de données dans les fichiers
    public static void remplirFichier(String leNomFichier, String lesDonnees)
    {
        try 
        {
            FileWriter fw = new FileWriter(leNomFichier);
            fw.write(lesDonnees);
            System.out.println("Le fichier a été modifié");
            fw.close();
        }
        catch (Exception e) 
        {
            // gestion des exceptions
            System.out.println("erreur");
        }
    }
}

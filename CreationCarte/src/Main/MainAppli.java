//@author trist

package Main;

import Cryptage.*;
import ExtraireDonnees.*;
import java.math.BigInteger;

public class MainAppli 
{
    public static void main (String[] args)
    {
        System.out.println("Debut du programme");

//        Ouverture de la base de donnée
        OuvrirBD ouvrir = new OuvrirBD();
//        Lecture et affichage dans le terminal
//        ouvrir.LireBD();
//        Création des carte à partir des données de la BD
        CreeCarte cree = new CreeCarte(ouvrir);
        
//        String plaintext = "toto";
//        System.out.println("plaintext = " + plaintext);
//        CryptageRSA rsa = new CryptageRSA();
//        rsa.generateKeyPair();
//        byte[] publicKey = rsa.getPublicKeyInBytes();
//        byte[] privateKey = rsa.getPrivateKeyInBytes();
//        byte[] ciphertext = rsa.crypt(plaintext); 
//        rsa.getPrivateKey();
//        System.out.println("ciphertext = " + new BigInteger(ciphertext));
//        rsa.setPublicKey(publicKey);
//        rsa.setPrivateKey(privateKey);    
//        String plaintext2 = rsa.decryptInString(ciphertext);
//        System.out.println("plaintext2 = " + plaintext2);
//        rsa.getPublicKey();
//        if (!plaintext2.equals(plaintext)) System.out.println("Error: plaintext2 != plaintext");

//        String plaintext = "toto";
//        System.out.println("plaintext = " + plaintext);
//        CryptageBlowfish bf = new CryptageBlowfish();
//        bf.generateKey();
//        byte[] secretKey = bf.getSecretKeyInBytes();
//        byte[] ciphertext = bf.crypt(plaintext);   
//        System.out.println("ciphertext = " + new BigInteger(ciphertext));
//
//        bf.setSecretKey(secretKey);
//        String plaintext2 = bf.decryptInString(ciphertext);
//        System.out.println("plaintext2 = " + plaintext2);
//        if (!plaintext2.equals(plaintext)) System.out.println("Error: plaintext2 != plaintext");

        System.out.println("Fin du programme");
    }
}

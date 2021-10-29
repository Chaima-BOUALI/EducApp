package com.esprit.tests;

import com.esprit.services.impl.ServiceAdministrateurImpl;
import com.esprit.services.impl.ServiceFormateurImpl;
import com.esprit.services.impl.ServicePublicityImpl;
import com.esprit.services.impl.ServiceUtilisateurImpl;
import com.esprit.services.impl.ServiceValidateImpl;
import com.esprit.models.Administrateur;
import com.esprit.models.Formateur;
import com.esprit.models.Publicity;
import com.esprit.models.Utilisateur;
import com.esprit.models.Validate;
import static jdk.nashorn.internal.runtime.regexp.RegExpFactory.validate;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author stef info
 */
public class MainProg {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
////////////////////////////TEST UTILISTAUERS SERVICE///////////////////////////////////////  
    
            ServiceUtilisateurImpl su=new ServiceUtilisateurImpl();
            //Test Recherche By Username
        //su.findByUsername("chay123").forEach(System.out::println);
        //su.findByUsername("chayma123").forEach(System.out::println);

       
         //Test Method Ajouter
        //su.ajouter(new Utilisateur(2,"chay123","khgt","chayma","boualy","chayma.boualy@esprit.tn","femme","12345678999","21387606","utilisateur"));
        //su.ajouter(new Utilisateur(2,"chay123","khgt","chayma","boualy","chayma.boualy@esprit.tn","femme","12345678999","21387606","utilisateur"));
        //su.ajouter(new Utilisateur(3,"CC","123597","cyrine","nasri","c.n@esprit.tn","femme","1258778999","21387606","utilisateur")); 
        //su.ajouter(new Utilisateur(4,"CC","1237","khaled","saidi","k.s@esprit.tn","homme","1258778999","21387606","utilisateur")); 
        //Test Supprimer
        //su.supprimer(new Utilisateur (2,"chay123","khgt","chayma","boualy","chayma.boualy@esprit.tn","femme","12345678999","21387606","utilisateur"));

        //Test Recherche By Id
        //su.findById(2).forEach(System.out::println);
        //su.findById(3).forEach(System.out::println);
        
        //TEST AFFICHAGE 
        //su.afficher().forEach(System.out::println);

        
        ////////////////////////////TEST FORMATEUR SERVICE///////////////////////////////////////  
        
                ServiceFormateurImpl sf=new ServiceFormateurImpl();

        //Test Recherche By UTLISIATEUR
       // sf.findByUtilisateur (1).forEach(System.out::println);
       
       //Test Method Ajouter
       // sf.ajouter(new Formateur("2 ans ","cv123", 1,"chay123","00000","chayma","boualy","chayma.boualy@esprit.tn","femme","12345999","21387606","formateur"));
       // sf.ajouter(new Formateur("2 ans ","cv.txt", 1,"chay123","123","chayma","boualy","chayma.boualy@esprit.tn","femme","12345999","21387606","formateur"));
       // sf.ajouter(new Formateur("4 ans ","cv.rar", 6,"c123","0000","cyrine","nasri","c.c@esprit.tn","femme","12345999","21387606","formateur"));

        //Test Method Supprimer
        //sf.supprimer(new Formateur ("2 ans ","cv123", 1,"chay123", "111","chayma","boualy","chayma.boualy@esprit.tn","femme","12345999","21387606","formateur"));
        
         //Test Afficher 
         //sf.afficher().forEach(System.out::println);
        
        
                ////////////////////////////TEST ADMINISTRATEUR SERVICE///////////////////////////////////////  

                                ServiceAdministrateurImpl sa=new ServiceAdministrateurImpl();

         //Test Method Ajouter
       //sa.ajouter(new Administrateur ("secretaire",7,"chay123","00000","chayma","boualy","chayma.boualy@esprit.tn","femme","459","123","Administrateur"));
       
       //sa.ajouter(new Administrateur( "responsable", 8,"cha1222","123","chayma","boualy","chayma.boualy@esprit.tn","femme","12345999","21387606","formateur"));

        //Test Method Supprimer
       // sa.supprimer(new Administrateur ("secretaire",7,"chay123","00000","chayma","boualy","chayma.boualy@esprit.tn","femme","459","123","Administrateur"));
        
         //Test Methode Afficher 
        //sa.afficher().forEach(System.out::println);
        
        
        //Test Recherche By Utilisateur
       //sa.findByUtilisateur(1).forEach(System.out::println);
        
       
       
       
   ////////////////////////////TEST VALIDITE DE PAIEMENT  SERVICE///////////////////////////////////////  

                                   ServiceValidateImpl sv=new ServiceValidateImpl();

   
    //Test Recherche By idUtilisateur
      //sv.findById(1).forEach(System.out::println);
       
     //Test Method Ajouter validate
       sv.ajouter(new Validate ( "chayma" ,"paiement non validé"));
       sv.ajouter(new Validate ("ahmed","paiement validé"));

        
         //Test Methode Afficher 
       sv.afficher().forEach(System.out::println);
       
       
         
   ////////////////////////////TEST PUBLICITY///////////////////////////////////////  

                                   ServicePublicityImpl sp=new ServicePublicityImpl();
    //Test Recherche By idPublicity
     //sp.findByIdPub(1).forEach(System.out::println);
     
     //Test Method Ajouter Publicity
      // sp.ajouter (new Publicity(1, "desc1", "title01", "pic01", "position01", "link01", "date1", "date2"));
      //sp.ajouter (new Publicity(2, "desc2", "title02", "pic02", "position02", "link02", "date11", "date22"));
          // sp.ajouter (new Publicity(3, "desc3", "title03", "pic03", "position04", "link04", "date11", "date22"));

      
         //Test Methode Afficher 
       //sp.afficher().forEach(System.out::println);
       
       //Test Method Supprimer
       //sp.supprimer(new Publicity (2, "desc2", "title02", "pic02", "position02", "link02", "date11", "date22"));
    }
    
    
}

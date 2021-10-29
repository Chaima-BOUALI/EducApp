package com.esprit.tests;

import com.esprit.models.Promotion;
import com.esprit.models.Ressource;
import com.esprit.models.Seance;
import com.esprit.services.impl.ServicePromotionImpl;
import com.esprit.services.impl.ServiceRessourceImpl;
import com.esprit.services.impl.ServiceSeanceImpl;
import java.sql.Date;
import static sun.misc.MessageUtils.where;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 21650
 */
public class MainProg {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //////////////// TEST RESSOURCE/////////////
        
        ServiceRessourceImpl sr=new ServiceRessourceImpl();
        //TEST METHODE AJOUTER
        
        //sr.ajouter(new Ressource ("java",13, "tp", "www.fichiercours.com",5));
        //sr.ajouter(new Ressource (2, "tp", "www.fichiertp.com"));   
        //sr.ajouter(new Ressource (5, "video", "www.esprit1.com"));

          
        
        //TEST SUPPRIMER
        //sr.supprimer(new Ressource ("java",10, "tp", "www.fichiercours.com",1));
        
        // TEST Modifier
        //sr.modifier(new Ressource ("java",8, "tp", "www.fichiercours.com",1));
        
        //TEST AFFICHER
        //sr.afficher().forEach(System.out::println);
       
       //TEST FINDBYIName
       //sr.findByName("java").forEach(System.out::println);
       
       //TEST FINDBYTYPE_RESSOURCE
      //sr.findByTypeRessource("tp").forEach(System.out::println);
       
    
      
      
      
      
      ///////////////////TEST SEANCE////////////
      ServiceSeanceImpl ss= new ServiceSeanceImpl();
      //// test finByIdSeance
      //ss.findByidSeance(15).forEach(System.out::println);
      
      //// test Ajouter
      
     // ss.ajouter(new Seance("seance 2 java",5,new Date(12)));
     //  ss.ajouter(new Seance("UMl",1,new Date(33)));
      
      //Test Supprimer
     // ss.supprimer(new Seance("UMl",1,new Date(33)));
       
      
      // TSET Modifier
     // ss.modifier(new Seance("java",1,new Date(12)));;
      
     
     // testAfficher
     //ss.afficher().forEach(System.out::println);
     
     
     ////////////////// TEST PROMOTION////////////
     ServicePromotionImpl sp =new ServicePromotionImpl();
             
      //Test Ajouter
       
       //sp.ajouter (new Promotion(2 , new Date(30), new Date(33), 15, "20"));
        //sp.ajouter (new Promotion(1 , "date1", "date2", 25, "15"));
     // test supprimer
     //sp.supprimer(new Promotion(2, new Date(30),new Date(33), 15, "30"));
     
     
     
    
    
}}

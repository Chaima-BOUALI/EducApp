/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.tests;

import java.sql.Date;

import com.esprit.models.Abonnement;
import com.esprit.models.Category;
import com.esprit.models.Session;
import com.esprit.services.impl.ServiceAbonnementImpl;
import com.esprit.services.impl.ServiceCategoryImpl;
import com.esprit.services.impl.ServiceSessionImpl;


/**
 *
 * @author aissa
 */
public class MainProg {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ////////////////////////////TEST CATEGORY SERVICE///////////////////////////////////////

    	
        ServiceCategoryImpl sc=new ServiceCategoryImpl();
        
        //Test Method Ajouter
        //sc.ajouter(new Category("Industrie","Some description"));
        
        //Test Modifier
        //sc.modifier(new Category(1,"Industrie","Some description"));
        
        //Test Supprimer
        //sc.supprimer(new Category(1,"Industrie","Some description"));
        
        //Test Afficher 
        //sc.afficher().forEach(System.out::println);
        
        //Test Recherche By Name
        //sc.findByName("Ind").forEach(System.out::println);
        
        
        
        ////////////////////////////TEST SESSION SERVICE///////////////////////////////////////
        
        ServiceSessionImpl ss=new ServiceSessionImpl();
        
        //Test Method Ajouter
        //ss.ajouter(new Session(new Date(12),new Date(33),"UML",20,"Description","url",1));
        
        //Test Modifier
        //ss.modifier(new Session(4,new Date(12),new Date(33),"UML",20,"Description","url_image",1));
        
        //Test Supprimer
        //ss.supprimer(new Session(4,new Date(12),new Date(33),"UML",20,"Description","url_image",1));
        
        //Test Afficher 
        ss.afficher().forEach(System.out::println);
        
        //Test Recherche By Name
        //ss.findByName("JA").forEach(System.out::println);
        
        //Test Recherche By Category
        //ss.findByCategory(1).forEach(System.out::println);
        
        
        ////////////////////////////TEST Abonnement SERVICE///////////////////////////////////////
     
        ServiceAbonnementImpl sa=new ServiceAbonnementImpl();
        
        //Test Method Ajouter
        //sa.ajouter(new Abonnement("Blue Pass",1,1));
        
        //Test Modifier
        //sa.modifier(new Abonnement(1,"Blue Pass",1,3));
        
        //Test Supprimer
        //sa.supprimer(new Abonnement(1,"Blue Pass",1,3));
        
        //Test Afficher 
        //sa.afficher().forEach(System.out::println);
        
        //Test Recherche By User
        //sa.findByUser(1).forEach(System.out::println);
        
        //Test Recherche By Session
        sa.findBySession(1).forEach(System.out::println);
    }
    
}

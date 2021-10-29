/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.services;

import com.esprit.models.Seance;
import java.util.List;

/**
 *
 * @author 21650
 */
public interface IServiceSeance extends IServices<Seance>{
    List<Seance>findByName(String nom);
    
}

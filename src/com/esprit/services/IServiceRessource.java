/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.services;

import com.esprit.models.Ressource;
import java.util.List;

/**
 *
 * @author 21650
 */
public interface IServiceRessource extends IServices<Ressource> {
    List<Ressource> findByName(String nom);
    List<Ressource> findByTypeRessource(String typeRessource);
}

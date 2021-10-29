/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.services;

import com.esprit.models.Promotion;
import java.util.List;

/**
 *
 * @author 21650
 */
public interface IServicePromotion extends IServices <Promotion>{
    List<Promotion>findByIdPromotion(int idPromotion);

    
}

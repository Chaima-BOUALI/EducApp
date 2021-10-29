/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.services;

import com.esprit.models.Publicity;
import java.util.List;

/**
 *
 * @author stef info
 */
public interface IServicePublicity extends IService<Publicity> {
        List<Publicity> findByIdPub (int idPub);

    
}

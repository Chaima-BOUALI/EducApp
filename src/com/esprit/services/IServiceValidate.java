/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.esprit.services;

import com.esprit.models.Validate;
import java.util.List;

/**
 *
 * @author stef info
 */
public interface IServiceValidate extends IService<Validate> {
        List<Validate> findByUsername (String username);

    
}

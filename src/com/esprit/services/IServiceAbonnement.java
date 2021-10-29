package com.esprit.services;

import java.util.List;

import com.esprit.models.Abonnement;

public interface IServiceAbonnement extends IService<Abonnement> {

	public List<Abonnement> findByUser(int id);
	public List<Abonnement> findBySession(int id);
        public List<Abonnement> findBySessionAndUser(int id_user,int id_session);

}

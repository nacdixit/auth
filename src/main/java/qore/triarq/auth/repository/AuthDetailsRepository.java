package qore.triarq.auth.repository;

import java.util.List;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import qore.triarq.auth.model.Authdetails;


@Repository
public interface AuthDetailsRepository extends CrudRepository<Authdetails, String>{

	public List<Authdetails> findByusername(String username);
	

}

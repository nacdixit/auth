package qore.triarq.auth.repository;
import java.util.List;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import qore.triarq.auth.model.UserView;


@Repository
public interface UserViewRepository extends CrudRepository<UserView, String>{
	
	public List<UserView> findByusername(String username);
	

}

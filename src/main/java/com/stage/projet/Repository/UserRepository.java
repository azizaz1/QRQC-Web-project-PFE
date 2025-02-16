package com.stage.projet.Repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.stage.projet.Model.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	Optional<User> findByUsername(String name);
    Optional<User> findByUsernameAndPassword(String username, String password);

	//User findByEmail(String email);

	//User findByToken(String token);
	
	
	


}


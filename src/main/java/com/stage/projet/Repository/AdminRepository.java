package com.stage.projet.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.stage.projet.Model.Admin;
@Repository
public interface AdminRepository extends JpaRepository<Admin, Long>{

}

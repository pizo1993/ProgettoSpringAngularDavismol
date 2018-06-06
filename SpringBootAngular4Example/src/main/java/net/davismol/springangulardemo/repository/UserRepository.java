package net.davismol.springangulardemo.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.davismol.springangulardemo.viewmodels.UserViewModel;

@Repository
public interface UserRepository extends JpaRepository<UserViewModel, Long> {

}



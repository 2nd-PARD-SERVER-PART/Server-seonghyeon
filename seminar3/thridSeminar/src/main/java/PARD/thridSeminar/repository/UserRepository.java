package PARD.thridSeminar.repository;

import PARD.thridSeminar.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    boolean existsByUserEmail(String userEmail);

    boolean existsByUserEmailAndUserPassword(String userEmail, String userPassword);

//    List<UserEntity> findByUserSignUpTimeOrderByUserSignUpTime
}

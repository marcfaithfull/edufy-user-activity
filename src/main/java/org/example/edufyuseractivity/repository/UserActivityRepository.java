package org.example.edufyuseractivity.repository;

import org.example.edufyuseractivity.model.entity.UserActivity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserActivityRepository extends JpaRepository<UserActivity,Long> {

}

package org.example.edufyuseractivity.repository;

import org.example.edufyuseractivity.enumeration.MediaType;
import org.example.edufyuseractivity.model.entity.UserActivity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserActivityRepository extends JpaRepository<UserActivity,Long> {

    List<UserActivity> findByUserId(String userId);

    List<UserActivity> findByMediaIdAndMediaType(String mediaId, MediaType mediaType);

}

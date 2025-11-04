package org.example.edufyuseractivity.repository;

import org.example.edufyuseractivity.enumeration.MediaType;
import org.example.edufyuseractivity.model.entity.UserActivity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserActivityRepository extends JpaRepository<UserActivity,Long> {

    List<UserActivity> findByUserId(Long userId);

    List<UserActivity> findByMediaIdAndMediaType(Long mediaId, MediaType mediaType);

    Optional<UserActivity> findByMediaIdAndMediaTypeAndUserId(Long mediaId, MediaType mediaType, Long userId);
}

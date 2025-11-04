package org.example.edufyuseractivity.service;

import org.example.edufyuseractivity.enumeration.MediaType;
import org.example.edufyuseractivity.enumeration.Reaction;
import org.example.edufyuseractivity.model.dto.UserActivityDto;
import org.example.edufyuseractivity.model.entity.UserActivity;

import java.util.List;

public interface UserActivityService {

    UserActivity likeMedia(UserActivityDto userActivity);

    UserActivity dislikeMedia(UserActivityDto userActivity);

    UserActivity reaction(UserActivityDto dto, Reaction reaction);

    UserActivity savePlayedActivity(UserActivityDto userActivity);

    List<UserActivity> getUserActivity(Long userId);

    List<UserActivity> getMediaActivity(Long mediaId, MediaType mediaType);


}

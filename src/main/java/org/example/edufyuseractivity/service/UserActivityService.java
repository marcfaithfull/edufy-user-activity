package org.example.edufyuseractivity.service;

import org.example.edufyuseractivity.enumeration.MediaType;
import org.example.edufyuseractivity.model.dto.UserActivityDto;
import org.example.edufyuseractivity.model.entity.UserActivity;

import java.util.List;

public interface UserActivityService {

    UserActivity saveActivity(UserActivityDto userActivity);

    List<UserActivity> getUserActivity(String userId);

    List<UserActivity> getMediaActivity(String mediaId, MediaType mediaType);


}

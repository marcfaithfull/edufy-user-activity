package org.example.edufyuseractivity.service;

import org.example.edufyuseractivity.model.dto.UserActivityDto;
import org.example.edufyuseractivity.model.entity.UserActivity;

public interface UserActivityService {

    UserActivity saveActivity(UserActivityDto userActivity);


}

package org.example.edufyuseractivity.mapper;

import org.example.edufyuseractivity.model.dto.UserActivityDto;
import org.example.edufyuseractivity.model.entity.UserActivity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class UserActivityMapper {

    public UserActivity dtoToEntity(UserActivityDto userActivityDTO) {
        UserActivity userActivity = new UserActivity();
        userActivity.setUserId(userActivityDTO.getUserId());
        userActivity.setMediaId(userActivityDTO.getMediaId());
        userActivity.setMediaType(userActivityDTO.getMediaType());
        userActivity.setReaction(userActivityDTO.getReaction());
        userActivity.setDateTime(LocalDateTime.now());
        return userActivity;
    }
}

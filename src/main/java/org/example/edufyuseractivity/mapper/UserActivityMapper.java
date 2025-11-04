package org.example.edufyuseractivity.mapper;

import org.example.edufyuseractivity.model.dto.UserActivityDto;
import org.example.edufyuseractivity.model.entity.UserActivity;
import org.springframework.stereotype.Service;

@Service
public class UserActivityMapper {

    public UserActivity entityFromDto(UserActivityDto userActivityDTO) {
        UserActivity userActivity = new UserActivity();
        userActivity.setUserId(userActivityDTO.getUserId());
        userActivity.setMediaId(userActivityDTO.getMediaId());
        userActivity.setMediaType(userActivityDTO.getMediaType());
        /*if (userActivityDTO.getReaction() != null) {
            userActivity.setReaction(userActivityDTO.getReaction());
        }
        userActivity.setUserClickedPlay(userActivityDTO.hasUserClickedPlay());
        userActivity.setReactionDate(LocalDateTime.now());*/
        return userActivity;
    }
}

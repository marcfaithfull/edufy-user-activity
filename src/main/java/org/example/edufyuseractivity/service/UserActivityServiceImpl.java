package org.example.edufyuseractivity.service;

import org.example.edufyuseractivity.enumeration.MediaType;
import org.example.edufyuseractivity.enumeration.Reaction;
import org.example.edufyuseractivity.model.dto.UserActivityDto;
import org.example.edufyuseractivity.model.entity.UserActivity;
import org.example.edufyuseractivity.mapper.UserActivityMapper;
import org.example.edufyuseractivity.repository.UserActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserActivityServiceImpl implements UserActivityService {
    private final UserActivityRepository userActivityRepository;
    private final UserActivityMapper userActivityMapper;

    @Autowired
    public UserActivityServiceImpl(UserActivityRepository userActivityRepository, UserActivityMapper userActivityMapper) {
        this.userActivityRepository = userActivityRepository;
        this.userActivityMapper = userActivityMapper;
    }

    @Override
    public UserActivity likeMedia(UserActivityDto dto) {
        return reaction(dto, Reaction.LIKE);
    }

    @Override
    public UserActivity dislikeMedia(UserActivityDto dto) {
        return reaction(dto, Reaction.DISLIKE);
    }

    @Override
    public UserActivity reaction(UserActivityDto dto, Reaction reaction) {
        Optional<UserActivity> existing = userActivityRepository.findByMediaIdAndMediaTypeAndUserId(
                dto.getMediaId(), dto.getMediaType(), dto.getUserId());

        UserActivity userActivity = existing.orElseGet(() -> userActivityMapper.entityFromDto(dto));
        userActivity.setReaction(reaction);
        userActivity.setReactionDate(LocalDateTime.now());

        return userActivityRepository.save(userActivity);
    }

    @Override
    public UserActivity savePlayedActivity(UserActivityDto dto) {
        Optional<UserActivity> existing = userActivityRepository.findByMediaIdAndMediaTypeAndUserId(
                dto.getMediaId(), dto.getMediaType(), dto.getUserId());

        UserActivity userActivity = existing.orElseGet(() -> userActivityMapper.entityFromDto(dto));
        userActivity.setUserClickedPlay(true);
        userActivity.setLastPlayed(LocalDateTime.now());

        return userActivityRepository.save(userActivity);
    }

    @Override
    public List<UserActivity> getUserActivity(Long userId) {
        return userActivityRepository.findByUserId(userId);
    }

    @Override
    public List<UserActivity> getMediaActivity(Long mediaId, MediaType mediaType) {
        return userActivityRepository.findByMediaIdAndMediaType(mediaId, mediaType);
    }
}

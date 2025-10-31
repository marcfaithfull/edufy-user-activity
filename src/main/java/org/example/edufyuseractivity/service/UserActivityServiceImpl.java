package org.example.edufyuseractivity.service;

import org.example.edufyuseractivity.model.dto.UserActivityDto;
import org.example.edufyuseractivity.model.entity.UserActivity;
import org.example.edufyuseractivity.mapper.UserActivityMapper;
import org.example.edufyuseractivity.repository.UserActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserActivityServiceImpl implements UserActivityService {
    private final UserActivityRepository userActivityRepository;
    UserActivityMapper userActivityMapper;

    @Autowired
    public UserActivityServiceImpl(UserActivityRepository userActivityRepository, UserActivityMapper userActivityMapper) {
        this.userActivityRepository = userActivityRepository;
        this.userActivityMapper = userActivityMapper;
    }

    @Override
    public UserActivity saveActivity(UserActivityDto userActivityDto) {
        UserActivity userActivity = userActivityMapper.dtoToEntity(userActivityDto);
        userActivityRepository.save(userActivity);
        return userActivity;
    }
}

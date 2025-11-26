package org.example.edufyuseractivity.service;

import org.example.edufyuseractivity.enumeration.MediaType;
import org.example.edufyuseractivity.enumeration.Reaction;
import org.example.edufyuseractivity.mapper.UserActivityMapper;
import org.example.edufyuseractivity.model.dto.UserActivityDto;
import org.example.edufyuseractivity.model.entity.UserActivity;
import org.example.edufyuseractivity.repository.UserActivityRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UserActivityServiceImplTest {
    @Mock
    private UserActivityRepository userActivityRepository;
    @Mock
    private UserActivityMapper userActivityMapper;
    @InjectMocks
    private UserActivityServiceImpl userActivityServiceImpl;

    private UserActivity existing;
    private UserActivityDto userActivityDto;

    @BeforeEach
    void setUp() {
        userActivityDto = new UserActivityDto();

        existing = new UserActivity();
        existing.setId(1L);
        existing.setMediaId(1L);
        existing.setMediaType(MediaType.VIDEO);
        existing.setUserId(1L);
    }

    @Test
    void likeMedia_Success() {
        UserActivityService service = spy(userActivityServiceImpl);

        doReturn(existing).when(service).reaction(userActivityDto, Reaction.LIKE);

        UserActivity result = service.likeMedia(userActivityDto);

        assertEquals(existing, result);
        verify(service).reaction(userActivityDto, Reaction.LIKE);
    }

    @Test
    void dislikeMedia_Success() {
        UserActivityService service = spy(userActivityServiceImpl);

        doReturn(existing).when(service).reaction(userActivityDto, Reaction.DISLIKE);

        UserActivity result = service.dislikeMedia(userActivityDto);

        assertEquals(existing, result);
        verify(service).reaction(userActivityDto, Reaction.DISLIKE);
    }

    @Test
    void reaction_withExistingEntity() {
        when(userActivityRepository.findByMediaIdAndMediaTypeAndUserId(
                userActivityDto.getMediaId(), userActivityDto.getMediaType(), userActivityDto.getUserId()))
                .thenReturn(Optional.of(existing));

        when(userActivityRepository.save(any(UserActivity.class))).thenAnswer(
                i -> i.getArgument(0)
        );

        UserActivity result = userActivityServiceImpl.reaction(userActivityDto, Reaction.LIKE);

        assertEquals(Reaction.LIKE, result.getReaction());
        assertNotNull(result.getReactionDate());
        verify(userActivityMapper, never()).entityFromDto(any());
        verify(userActivityRepository).save(existing);
    }

    @Test
    void reaction_withNewEntity() {
        UserActivity newEntity = new UserActivity();
        newEntity.setId(2L);

        when(userActivityRepository.findByMediaIdAndMediaTypeAndUserId(
                userActivityDto.getMediaId(), userActivityDto.getMediaType(), userActivityDto.getUserId()))
                .thenReturn(Optional.empty());

        when(userActivityMapper.entityFromDto(userActivityDto)).thenReturn(newEntity);
        when(userActivityRepository.save(any(UserActivity.class))).thenAnswer(
                i -> i.getArgument(0)
        );

        UserActivity result = userActivityServiceImpl.reaction(userActivityDto, Reaction.LIKE);

        assertEquals(Reaction.LIKE, result.getReaction());
        assertNotNull(result.getReactionDate());
        verify(userActivityMapper).entityFromDto(any());
        verify(userActivityRepository).save(newEntity);
    }

    @Test
    void savePlayedActivity() {
        when(userActivityRepository.findByMediaIdAndMediaTypeAndUserId(
                userActivityDto.getMediaId(), userActivityDto.getMediaType(), userActivityDto.getUserId()))
                .thenReturn(Optional.of(existing));

        when(userActivityRepository.save(any(UserActivity.class))).thenAnswer(
                i -> i.getArgument(0)
        );

        UserActivity result = userActivityServiceImpl.savePlayedActivity(userActivityDto);

        assertThat(result.getUserClickedPlay()).isTrue();
        assertThat(result.getLastPlayed()).isNotNull();
        verify(userActivityMapper, never()).entityFromDto(any());
        verify(userActivityRepository).save(existing);
    }

    @Test
    void getUserActivity() {
        when(userActivityRepository.findByUserId(1L)).thenReturn(List.of(existing));

        userActivityServiceImpl.getUserActivity(1L);

        verify(userActivityRepository).findByUserId(1L);
    }

    @Test
    void getMediaActivity() {
        when(userActivityRepository.findByMediaIdAndMediaType(1L, MediaType.VIDEO)).thenReturn(List.of(existing));

        userActivityServiceImpl.getMediaActivity(1L, MediaType.VIDEO);

        verify(userActivityRepository).findByMediaIdAndMediaType(1L, MediaType.VIDEO);
    }
}
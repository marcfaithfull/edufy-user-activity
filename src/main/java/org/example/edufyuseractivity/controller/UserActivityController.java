package org.example.edufyuseractivity.controller;

import org.example.edufyuseractivity.enumeration.MediaType;
import org.example.edufyuseractivity.model.dto.UserActivityDto;
import org.example.edufyuseractivity.model.entity.UserActivity;
import org.example.edufyuseractivity.service.UserActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserActivityController {
    private final UserActivityService userActivityService;

    @Autowired
    public UserActivityController(UserActivityService userActivityService) {
        this.userActivityService = userActivityService;
    }

    @PostMapping("/react")
    public ResponseEntity<UserActivity> saveUserReaction(@RequestBody UserActivityDto activity) {
        UserActivity savedActivity = userActivityService.saveReaction(activity);
        return ResponseEntity.status(HttpStatus.OK).body(savedActivity);
    }

    @PostMapping("/played")
    public ResponseEntity<UserActivity> savePlayActivity(@RequestBody UserActivityDto activity) {
        UserActivity playActivity = userActivityService.savePlayedActivity(activity);
        return ResponseEntity.status(HttpStatus.OK).body(playActivity);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<List<UserActivity>> getUserActivity(@PathVariable Long id) {
        return ResponseEntity.ok(userActivityService.getUserActivity(id));
    }

    @GetMapping("/media")
    public ResponseEntity<List<UserActivity>> getMediaActivity(@RequestParam Long mediaId, @RequestParam MediaType mediaType) {
        return ResponseEntity.ok(userActivityService.getMediaActivity(mediaId, mediaType));
    }
}

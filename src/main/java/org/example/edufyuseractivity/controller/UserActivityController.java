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

    @PostMapping("/post/activity")
    public ResponseEntity<UserActivity> saveUserActivity(@RequestBody UserActivityDto activity) {
        UserActivity savedActivity = userActivityService.saveActivity(activity);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedActivity);
    }

    @GetMapping("/user")
    public ResponseEntity<List<UserActivity>> getUserActivity(@RequestParam String userId) {
        return ResponseEntity.ok(userActivityService.getUserActivity(userId));
    }

    @GetMapping("/media")
    public ResponseEntity<List<UserActivity>> getMediaActivity(@RequestParam String mediaId, @RequestParam MediaType mediaType) {
        return ResponseEntity.ok(userActivityService.getMediaActivity(mediaId, mediaType));
    }
}

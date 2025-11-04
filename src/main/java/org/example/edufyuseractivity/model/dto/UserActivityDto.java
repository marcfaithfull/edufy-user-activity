package org.example.edufyuseractivity.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.example.edufyuseractivity.enumeration.MediaType;
import org.example.edufyuseractivity.enumeration.Reaction;

public class UserActivityDto {
    @NotBlank
    private Long userId;

    @NotBlank
    private Long mediaId;

    @NotNull
    private MediaType mediaType;

    @NotNull
    private Reaction reaction;

    private boolean userClickedPlay;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getMediaId() {
        return mediaId;
    }

    public void setMediaId(Long mediaId) {
        this.mediaId = mediaId;
    }

    public MediaType getMediaType() {
        return mediaType;
    }

    public void setMediaType(MediaType mediaType) {
        this.mediaType = mediaType;
    }

    public Reaction getReaction() {
        return reaction;
    }

    public void setReaction(Reaction reaction) {
        this.reaction = reaction;
    }

    public boolean isUserClickedPlay() {
        return userClickedPlay;
    }

    public void setUserClickedPlay(boolean userClickedPlay) {
        this.userClickedPlay = userClickedPlay;
    }
}

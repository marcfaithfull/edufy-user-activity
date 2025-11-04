package org.example.edufyuseractivity.model.entity;

import jakarta.persistence.*;
import org.example.edufyuseractivity.enumeration.MediaType;
import org.example.edufyuseractivity.enumeration.Reaction;

import java.time.LocalDateTime;

@Entity
@Table(name = "user_activity")
public class UserActivity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "activity_id")
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "media_id")
    private Long mediaId;

    @Column(name = "media_type")
    @Enumerated(EnumType.STRING)
    private MediaType mediaType;

    @Column(name = "user_reaction")
    @Enumerated(EnumType.STRING)
    private Reaction reaction = Reaction.NEUTRAL;

    @Column(name = "user_clicked_play")
    private Boolean userClickedPlay = false;

    @Column(name = "reaction_date")
    private LocalDateTime reactionDate = null;

    @Column(name = "last_played")
    private LocalDateTime lastPlayed = null;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Boolean getUserClickedPlay() {
        return userClickedPlay;
    }

    public void setUserClickedPlay(Boolean userClickedPlay) {
        this.userClickedPlay = userClickedPlay;
    }

    public LocalDateTime getReactionDate() {
        return reactionDate;
    }

    public void setReactionDate(LocalDateTime dateTime) {
        this.reactionDate = dateTime;
    }

    public LocalDateTime getLastPlayed() {
        return lastPlayed;
    }

    public void setLastPlayed(LocalDateTime lastPlayed) {
        this.lastPlayed = lastPlayed;
    }
}

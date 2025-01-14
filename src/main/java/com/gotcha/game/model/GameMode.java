package com.gotcha.game.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.URL;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "gamemodes")
public class GameMode extends Auditable {
    @NotBlank
    @Getter
    @Setter
    @Column(unique = true)
    private String name;

    @Getter
    @Setter
    private String picture;

    @Getter
    @Setter
    private String description;

    public GameMode(@NotBlank String name, @URL String picture, String description) {
        this.name = name;
        this.picture = picture;
        this.description = description;
    }

    public GameMode() {

    }
}

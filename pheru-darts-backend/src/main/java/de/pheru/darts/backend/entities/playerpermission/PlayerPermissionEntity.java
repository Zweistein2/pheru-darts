package de.pheru.darts.backend.entities.playerpermission;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "Player_Permissions")
public class PlayerPermissionEntity {

    @Id
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;
    private String userId;
    private String permittedUserId;

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(final String userId) {
        this.userId = userId;
    }

    public String getPermittedUserId() {
        return permittedUserId;
    }

    public void setPermittedUserId(final String permittedUserId) {
        this.permittedUserId = permittedUserId;
    }
}

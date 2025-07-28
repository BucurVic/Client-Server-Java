package Inot.Network.dto;

import java.io.Serializable;

public class PersoanaOficiuDTO implements Serializable {
    private String username;
    private String password;
    private String location;

    public PersoanaOficiuDTO(String username, String password, String location) {
        this.username = username;
        this.password = password;
        this.location = location;
    }


    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return "PersoanaOficiuDTO [username=" + username + ", password=" + password + ", location=" + location + "]";
    }
}

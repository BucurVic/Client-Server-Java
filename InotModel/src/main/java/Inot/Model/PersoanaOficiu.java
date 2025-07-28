package Inot.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Table;

@jakarta.persistence.Entity
@Table(name = "PersoaneOficiu")
public class PersoanaOficiu extends Entity<Long>{
    private String username;
    private String password;
    private String location;

    public PersoanaOficiu(String username, String password, String location) {
        this.username = username;
        this.password = password;
        this.location = location;
    }

    public PersoanaOficiu() {}

    @Column (name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column (name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column (name = "location")
    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "PersoanaOficiu{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}

package PARD.thridSeminar.entity;

import PARD.thridSeminar.dto.SignUpDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int UserNum;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String userEmail; //camelcase snakecase user_email
    @Column(length = 20)
    private String userPassword; // user_password (deafult : VARCHAR(255))

    @CreationTimestamp
    private Timestamp userSignUpTime;

    public UserEntity(SignUpDto dto) {
        this.userEmail = dto.getUserEmail();
        this.userPassword = dto.getUserPassword();
    }
}

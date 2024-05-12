package kg.alatoo.midterm.DTO.authorization;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthLoginDTO {
    private String username;
    private String password;
}

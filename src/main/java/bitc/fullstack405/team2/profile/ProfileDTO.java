package bitc.fullstack405.team2.profile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class ProfileDTO {
  private String userId;
  private String userPw;
  private String userName;
  private String userEmail;
  private String gender;
  private int age;
  private String userPhone;
  private String nickname;
  private int point;
}

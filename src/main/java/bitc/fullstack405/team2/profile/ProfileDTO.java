package bitc.fullstack405.team2.profile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class ProfileDTO {
  private String userId;
  private String userPw;
  private String userName;
  private String email;
  private String gender;
  private int age;
  private String mobileNumber;
  private String nickname;
  private int point;
}

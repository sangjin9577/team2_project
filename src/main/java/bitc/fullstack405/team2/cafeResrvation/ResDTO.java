package bitc.fullstack405.team2.cafeResrvation;

import lombok.Data;

@Data
public class ResDTO {
  private int resId;
  private int resTime;
  private String resDate;
  private String state;
  private int cafeId;
  private int userId;
  private int themeId;
}

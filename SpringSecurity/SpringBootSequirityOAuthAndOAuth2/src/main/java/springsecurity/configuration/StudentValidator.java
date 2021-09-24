package springsecurity.configuration;

import java.util.List;

import org.springframework.security.oauth2.core.OAuth2Error;
import org.springframework.security.oauth2.core.OAuth2ErrorCodes;
import org.springframework.security.oauth2.core.OAuth2TokenValidator;
import org.springframework.security.oauth2.core.OAuth2TokenValidatorResult;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.util.Assert;

 public class StudentValidator implements OAuth2TokenValidator<Jwt> {
  private final String student;

  StudentValidator(String student) {
    Assert.hasText(student, "audience is null or empty");
    this.student = student;
  }

  public OAuth2TokenValidatorResult validate(Jwt jwt) {
    List<String> audiences = jwt.getAudience();
    if (audiences.contains(this.student)) {
      return OAuth2TokenValidatorResult.success();
    }
    OAuth2Error err = new OAuth2Error(OAuth2ErrorCodes.INVALID_TOKEN);
    return OAuth2TokenValidatorResult.failure(err);
  }
}

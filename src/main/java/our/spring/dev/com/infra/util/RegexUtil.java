package our.spring.dev.com.infra.util;

public class RegexUtil {
    public static final String LOGIN_PATTERN = "^[a-zA-Z0-9_-]{3,15}$";
    public static final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,15}$";
    public static final String PHONE_PATTERN = "^38(039|050|063|066|067|068|073|091|092|093|094|095|096|097|098|099)[0-9]{7}$";
}
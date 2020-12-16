package libararymanagementsystemnew1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IdentyCardValidator {
    private Pattern pattern;
    private Matcher matcher;
    
    private static final String IDENTY_PATTERN = "\\d{9}v";
    
    public IdentyCardValidator (){
        pattern = Pattern.compile(IDENTY_PATTERN);
    }
    
    /*
    Validate hex with regular
    @param hex
        hx for validation
    @return true valdi hex, false invalid hex
    */
    
    public boolean validate(final String hex){
        matcher = pattern.matcher(hex);
        return matcher.matches();
    }
}

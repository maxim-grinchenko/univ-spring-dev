package our.spring.dev.com.infra.validation;

import net.sf.oval.Validator;
import net.sf.oval.localization.locale.ThreadLocalLocaleProvider;

import java.util.Locale;

public class ValidationFactory {
    public static Validator getValidator() {
        return new LocaleValidator();
    }

    static class LocaleValidator extends Validator {
        LocaleValidator() {
            ThreadLocalLocaleProvider localeProvider = new ThreadLocalLocaleProvider();
            localeProvider.setLocale(Locale.ENGLISH);
            setLocaleProvider(localeProvider);
        }
    }
}
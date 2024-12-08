package tobbyspring.hellospring;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class UserAuditorAware implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        System.out.println("Used EnableJpaAuditing Annotation");
        return Optional.empty();
    }
}

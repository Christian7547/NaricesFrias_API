package NaricesFrias_API.NaricesFrias_API.infrastructure.conf;

import NaricesFrias_API.NaricesFrias_API.application.services.implementation.AuthService;
import NaricesFrias_API.NaricesFrias_API.application.services.interfaces.IAuthService;
import NaricesFrias_API.NaricesFrias_API.domain.ports.IAuthDomainRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AuthConf {

    @Bean
    IAuthService authBeanService(IAuthDomainRepository authDomainRepository){
        return new AuthService(authDomainRepository);
    }
}

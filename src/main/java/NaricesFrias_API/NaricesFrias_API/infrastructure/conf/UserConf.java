package NaricesFrias_API.NaricesFrias_API.infrastructure.conf;

import NaricesFrias_API.NaricesFrias_API.application.services.implementation.UserService;
import NaricesFrias_API.NaricesFrias_API.application.services.interfaces.IUserService;
import NaricesFrias_API.NaricesFrias_API.domain.ports.IUserDomainRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConf {

    @Bean
    IUserService userBeanService(IUserDomainRepository userDomainRepository){
        return new UserService(userDomainRepository);
    }
}

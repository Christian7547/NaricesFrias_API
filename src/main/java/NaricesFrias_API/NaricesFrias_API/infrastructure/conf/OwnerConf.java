package NaricesFrias_API.NaricesFrias_API.infrastructure.conf;

import NaricesFrias_API.NaricesFrias_API.application.services.implementation.OwnerService;
import NaricesFrias_API.NaricesFrias_API.application.services.interfaces.IOwnerService;
import NaricesFrias_API.NaricesFrias_API.domain.ports.IOwnerDomainRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OwnerConf {

    @Bean
    IOwnerService ownerBeanService(IOwnerDomainRepository ownerDomainRepository){
        return new OwnerService(ownerDomainRepository);
    }
}

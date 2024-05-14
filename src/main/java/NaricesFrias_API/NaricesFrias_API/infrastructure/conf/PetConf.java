package NaricesFrias_API.NaricesFrias_API.infrastructure.conf;

import NaricesFrias_API.NaricesFrias_API.application.services.implementation.PetService;
import NaricesFrias_API.NaricesFrias_API.application.services.interfaces.IPetService;
import NaricesFrias_API.NaricesFrias_API.domain.ports.IPetDomainRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PetConf {

    @Bean
    IPetService ownerBeanService(IPetDomainRepository petDomainRepository){
        return new PetService(petDomainRepository);
    }
}

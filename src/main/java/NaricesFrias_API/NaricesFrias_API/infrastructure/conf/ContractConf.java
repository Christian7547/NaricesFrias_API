package NaricesFrias_API.NaricesFrias_API.infrastructure.conf;

import NaricesFrias_API.NaricesFrias_API.application.services.implementation.ContractService;
import NaricesFrias_API.NaricesFrias_API.application.services.interfaces.IContractService;
import NaricesFrias_API.NaricesFrias_API.domain.ports.IContractDomainRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ContractConf {
    @Bean
    IContractService contractBeanService(IContractDomainRepository contractDomainRepository){
        return new ContractService(contractDomainRepository);
    }
}

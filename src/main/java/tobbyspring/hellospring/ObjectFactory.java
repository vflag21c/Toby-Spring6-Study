package tobbyspring.hellospring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tobbyspring.hellospring.exrate.CachedExRateProvider;
import tobbyspring.hellospring.payment.ExRateProvider;
import tobbyspring.hellospring.exrate.WebApiExRateProvider;
import tobbyspring.hellospring.payment.PaymentService;

@Configuration
public class ObjectFactory {

    @Bean
    public PaymentService paymentService() {
        return new PaymentService(cachedExRateProvider());
    }

    @Bean
    public ExRateProvider cachedExRateProvider() {
        return new CachedExRateProvider(exRateProvider());
    }

    @Bean
    public ExRateProvider exRateProvider() {
        return new WebApiExRateProvider();
    }

}

package springdemo.aop;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration 
@EnableAspectJAutoProxy
@ComponentScan("springdemo.aop")
public class DemoConfig {

}

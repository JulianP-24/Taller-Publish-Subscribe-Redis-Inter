package co.edu.escuelaing.arsw.connection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;

@Configuration
@PropertySource("application.properties")
public class PSRedisConnectionConfiguration {
    @Value("${redis.broker.hostname}")
    private String redisHostName;
    @Value("${redis.broker.port}")
    private int redisPort;
    @Value("${redis.broker.pswd}")
    private String redisPswd;

    @Bean
    public LettuceConnectionFactory redisConnectionFactory() {
        RedisStandaloneConfiguration redisconf = new RedisStandaloneConfiguration(redisHostName,redisPort);
        redisconf.setPassword(redisPswd);
        LettuceConnectionFactory connectionFactory = new LettuceConnectionFactory(redisconf);
        return connectionFactory;
    }
}

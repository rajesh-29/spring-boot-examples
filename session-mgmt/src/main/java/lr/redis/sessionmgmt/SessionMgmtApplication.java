package lr.redis.sessionmgmt;

import java.io.Serializable;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@EnableEurekaClient
@SpringBootApplication
public class SessionMgmtApplication {

	public static void main(String[] args) {
		SpringApplication.run(SessionMgmtApplication.class, args);
	}

}


@Configuration
class RedisSessionHandler {
	
	@Bean
	JedisConnectionFactory jedisConnectionFactory() {
	    return new JedisConnectionFactory();
	}
	 
	@Bean
	public RedisTemplate<String, Object> redisTemplate() {
	    RedisTemplate<String, Object> template = new RedisTemplate<>();
	    template.setConnectionFactory(jedisConnectionFactory());
	    return template;
	}
}


@RedisHash("Session")
class Session implements Serializable {
	
	private static final long serialVersionUID = 4472229046079733833L;
	
	private String sessionKeyId;
	private String sessionValue;
	
	public String getSessionKeyId() {
		return sessionKeyId;
	}
	public void setSessionKeyId(String sessionKeyId) {
		this.sessionKeyId = sessionKeyId;
	}
	public String getSessionValue() {
		return sessionValue;
	}
	public void setSessionValue(String sessionValue) {
		this.sessionValue = sessionValue;
	}
	@Override
	public String toString() {
		return "Session [sessionKeyId=" + sessionKeyId + ", sessionValue=" + sessionValue + "]";
	}
	
}


@RepositoryRestResource 
interface SessionRepository extends CrudRepository<Session, String> {}
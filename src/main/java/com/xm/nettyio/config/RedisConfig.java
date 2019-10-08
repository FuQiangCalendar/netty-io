package com.xm.nettyio.config;

import com.xm.nettyio.utils.CacheManager;
import com.xm.nettyio.utils.TemplateCacheManager;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;

/**
 * @ClassName RedisConfig
 * @Description
 * @Author Wangjunkai
 * @Date 2019/8/26 13:57
 **/

@Configuration
//@EnableTransactionManagement
public class RedisConfig {


    @Bean
    @ConditionalOnMissingBean(RedisTemplate.class)
    public RedisTemplate<String, Object> getRedisClient(RedisConnectionFactory factory){
        RedisTemplate<String, Object> redisClient = new RedisTemplate<>();
        redisClient.setKeySerializer(new JdkSerializationRedisSerializer(RedisConfig.class.getClassLoader()));
        redisClient.setDefaultSerializer(new JdkSerializationRedisSerializer(RedisConfig.class.getClassLoader()));
        redisClient.setConnectionFactory(factory);
      //  redisClient.setEnableTransactionSupport(true);
        return redisClient;
    }

    @Bean
    @ConditionalOnMissingBean(CacheManager.class)
    public CacheManager getCacheManager(RedisTemplate<String, Object> template){
        return new TemplateCacheManager(template);
    }

/*    @Bean
    public PlatformTransactionManager transactionManager(HikariDataSource dataSource) throws SQLException {
        return new DataSourceTransactionManager(dataSource);
    }*/


}
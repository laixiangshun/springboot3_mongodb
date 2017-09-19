package com.lai.mongoConfig;

import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import static com.lai.mongoConfig.PrimaryMongoConfig.MONGO_TEMPLATE;

/**
 * Created by lailai on 2017/9/18.
 * 读取对应的配置文件信息构造对应的mongoTemplate
 */
@Configuration
public class MultipleMongoConfig {
    @Autowired
    private MultipleMongoProperties mongoProperties;

    @Primary
    @Bean(name = MONGO_TEMPLATE)
    public MongoTemplate primaryMongoTemplate() throws Exception{
        return  new MongoTemplate(primaryFactory(mongoProperties.getPrimary()));
    }
    @Bean
    @Qualifier(SecondaryMongoConfig.MONGO_TEMPLATE)
    public MongoTemplate secondaryMongoTemplate() throws  Exception{
        return new MongoTemplate(secondaryFactory(mongoProperties.getSecondary()));
    }
    @Bean
    @Primary
    public MongoDbFactory primaryFactory(MongoProperties mongo) throws Exception{
        return new SimpleMongoDbFactory(new MongoClient(mongo.getHost(),mongo.getPort()),mongo.getDatabase());
    }
    @Bean
    public MongoDbFactory secondaryFactory(MongoProperties mongo) throws Exception{
        return new SimpleMongoDbFactory(new MongoClient(mongo.getHost(),mongo.getPort()),mongo.getDatabase());
    }
}

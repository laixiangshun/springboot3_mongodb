package com.lai.mongoConfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Created by lailai on 2017/9/18.
 * 配置不同包使用不同的数据源
 */
@Configuration
@EnableMongoRepositories(basePackages = "com.lai.repository.secondary",mongoTemplateRef = SecondaryMongoConfig.MONGO_TEMPLATE)
public class SecondaryMongoConfig {
    protected static final String MONGO_TEMPLATE="secondaryMongoTemplate";
}

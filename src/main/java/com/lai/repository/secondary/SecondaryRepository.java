package com.lai.repository.secondary;

import com.lai.model.secondary.SecondaryMongoObject;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by lailai on 2017/9/19.
 */
public interface SecondaryRepository extends MongoRepository<SecondaryMongoObject,String>{
}

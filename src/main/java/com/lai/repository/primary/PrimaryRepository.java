package com.lai.repository.primary;

import com.lai.model.primary.PrimaryMongoObject;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by lailai on 2017/9/19.
 */
public interface PrimaryRepository extends MongoRepository<PrimaryMongoObject,String>{
}

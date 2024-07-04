package com.jayoswal.internet_speed.repository;

import com.jayoswal.internet_speed.document.Speed;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpeedRepository extends MongoRepository<Speed, Long> {
}

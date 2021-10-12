package com.youssefi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.youssefi.entities.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long>{

}

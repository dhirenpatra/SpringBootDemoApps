/*
 * Copyright (c) 2020. Self learning and applying project advanced concepts through out.
 */

package com.spring.patterns.repository;

import org.springframework.data.repository.CrudRepository;

public interface PresidentRepository extends CrudRepository<PresidentEntity, Long> {
    PresidentEntity findByEmail(String email);
}

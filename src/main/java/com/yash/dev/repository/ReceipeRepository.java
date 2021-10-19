package com.yash.dev.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yash.dev.utils.Receipe;

/**
 * Created by Yashwanth Anand S
 **/

public interface ReceipeRepository extends JpaRepository<Receipe, Long> {
	Receipe findReceipeImageById(Long id);
}

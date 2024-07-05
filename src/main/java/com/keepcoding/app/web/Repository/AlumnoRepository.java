package com.keepcoding.app.web.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.keepcoding.app.web.entity.Alumno;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno,Long> {

}

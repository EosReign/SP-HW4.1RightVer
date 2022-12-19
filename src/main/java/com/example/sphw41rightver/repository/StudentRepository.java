package com.example.sphw41rightver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.sphw41rightver.entity.Student;

import java.util.Collection;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {
    Collection<Student> findByAgeBetween(int min, int max);

    Collection<Student> findStudentByFaculty_Id(long id);

    @Query(value = "select count(*) from student", nativeQuery = true)
    Integer getAmountOfStudents();

    @Query(value = "select avg(age) from student", nativeQuery = true)
    Double getAverageAgeOfStudents();

    @Query(value = "select * from student order by id  offset 4", nativeQuery = true)
    List<Student> getLastOfStudentsById();
}

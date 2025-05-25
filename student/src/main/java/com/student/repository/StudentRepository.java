package com.student.repository;
import com.student.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {

    //@Query(value = "select * from student where name =:name",nativeQuery = true)
    @Query(value = "select * from student where name=:name",nativeQuery = true)
    public List<Student> getUserDataByName(@Param("name") String name12);

    @Query(value = "select * from student where contact_number=:mobile",nativeQuery = true)
     public List<Student> getStudentByPhone(@Param("mobile") String contactNumber);

    @Query(value = "SELECT * FROM student  WHERE contactNumber = :contactNumber",nativeQuery = true)
    public List<Student> getUserData(@Param("contactNumber") String contactNumber);

    @Query(value = "select * from student where name like %:student_name%",nativeQuery = true)
    public List<Student> searchUserByName(@Param("student_name") String userName);
     //bellow query use for search name;
     //select * from student where name like '%?%';
     //select * from student where name like '%rahul%';

}

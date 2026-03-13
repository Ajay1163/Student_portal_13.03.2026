package mits.Student_portal_Backend;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Student_repo extends JpaRepository<Student, Long> {

	Student findByEmail(String email);
}

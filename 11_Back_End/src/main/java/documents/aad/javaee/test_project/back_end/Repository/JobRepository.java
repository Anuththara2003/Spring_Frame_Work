package documents.aad.javaee.test_project.back_end.Repository;

import documents.aad.javaee.test_project.back_end.Entity.Job;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<Job, Integer> {

    //JPA METHODS
    //Prefix + FieldName + Operator + Conjunction

    // Prefix:
    //findBy - readBy - getBy - countBy - existBy - deleteBy

    //FieldName:

    //entity attribute name

    //Operator:

    //Equals - IsNull - IsNotNull - LessThan - LessThanEqual - GreaterThan - GreaterThanEqual -
    // Between - In - NotIn - Like - NotLike - StartingWith - NotStartingWith - EndingWith - NotEndingWith - Contains - NotContains -IgnoreCase

    //Conjunction:
    //And - Or

    @Transactional
    @Modifying
    @Query(value = "UPDATE Job SET status = 'Deactivated' WHERE id =?1", nativeQuery = true)
    void changeStatus(String id);


    List<Job> findJobByJobTitleContainingIgnoreCase(String keyword);
}

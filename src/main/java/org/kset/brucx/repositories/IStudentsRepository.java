package org.kset.brucx.repositories;

import org.kset.brucx.models.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by marin on 17.12.2016..
 */
@Repository
public interface IStudentsRepository {

    /**
     * Fetches student by its jmbag
     * @param jmbag uniuque student identifier
     * @return single {@link Student} or null if it doesn't exists
     */
    Student getByJmbag(String jmbag);

    /**
     * Fetches student by its contactless card identifier
     * @param nfcId uniuque student contactless card identifier
     * @return single {@link Student} or null if it doesn't exists
     */
    Student getByNfcId(String nfcId);

    /**
     * Fetches all stored students
     * @return list of {@link Student}s
     */
    List<Student> getStudents();

    /**
     * Persist student.
     * @param student {@link Student}
     */
    void storeStudent(Student student);

}

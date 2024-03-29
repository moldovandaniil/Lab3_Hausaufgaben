package com.company.memory;

import com.company.model.Teacher;
import com.company.model.Course;
import com.company.model.Student;
import com.company.model.RegistrationSystem;


/**
 * Repository to control the Professor class
 */
public class TeacherRepository extends InMemoryRepository<Teacher>{
    RegistrationSystem regSys = new RegistrationSystem();

    public TeacherRepository()
    {
        super();
    }

    /**
     * Overriding the update function
     * @param obj object
     * @return the modified object
     */
    @Override
    public Teacher update(Teacher obj) {
        /* Find the course by ID*/
        Teacher teacherToUpdate = this.repoList.stream()
                .filter(course -> course.getFirstName() == obj.getFirstName())
                .findFirst()
                .orElseThrow();

        /*Update the new values*/

        if(obj.getCourses().size() == 0){
            regSys.removeStudents(teacherToUpdate.getCourses().get(0));
        }
        teacherToUpdate.setCourses(obj.getCourses());

        return teacherToUpdate;
    }
}
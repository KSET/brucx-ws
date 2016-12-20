package org.kset.brucx.controllers;

import org.kset.brucx.models.Student;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by marin on 19.12.2016..
 */
@RestController
@RequestMapping("api/v1/students")
public class StudentsController extends BaseController {

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Student getStudentById(@PathVariable String id) {
        return null;
    }

}

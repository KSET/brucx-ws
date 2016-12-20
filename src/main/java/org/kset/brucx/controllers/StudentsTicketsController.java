package org.kset.brucx.controllers;

import org.kset.brucx.models.StatusMessage;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by marin on 19.12.2016..
 */
@RestController
@RequestMapping("/api/v1/students/{id}/tickets")
public class StudentsTicketsController extends BaseController {

    @RequestMapping(path = "", method = RequestMethod.POST)
    public StatusMessage buyTicket() {
        return null;
    }
}

package com.company.enroller.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.company.enroller.model.Meeting;
import com.company.enroller.persistence.MeetingService;


@RestController
@RequestMapping("/meetings")
public class MeetingRestController {

    @Autowired
    MeetingService meetingService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<?> getMeetings() {
        Collection<Meeting> meetings = meetingService.getAll();
        return new ResponseEntity<Collection<Meeting>>(meetings, HttpStatus.OK);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getMeeting(@PathVariable("id") long id) {
        Meeting meeting = meetingService.findById(id);
        if (meeting == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Meeting>(meeting, HttpStatus.OK);
    }

//    // POST http://localhost:8080/participants
//    @RequestMapping(value = "", method = RequestMethod.POST)
//    public ResponseEntity<?> registerParticipant(@RequestBody Participant participant) {
//        if (participantService.findByLogin(participant.getLogin()) != null) {
//            return new ResponseEntity<String>(
//                    "Unable to create particpant with login '" + participant.getLogin() + " 'already exists",
//                    HttpStatus.CONFLICT);
//        }
//        participantService.add(participant);
//        return new ResponseEntity<Participant>(participant, HttpStatus.CREATED);
//    }
//
// // DELETE http://localhost:8080/participants
//    @RequestMapping(value ="/{id}", method = RequestMethod.DELETE)
//    public ResponseEntity<?> deleteParticipant(@PathVariable("id") String login) {
//        Participant participant = participantService.findByLogin(login);
//        if (participant == null) {
//            return new ResponseEntity<String>(
//                    "Unable to remove participant with login '" + participant.getLogin() + " 'not exist yet",
//                    HttpStatus.NOT_FOUND);
//        }
//        participantService.remove(participant);
//        return new ResponseEntity<Participant>(participant, HttpStatus.OK);
//    }
//
    
}

package org.versioning.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.versioning.handlers.MergeRequestEventHandler;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
public class GitlabEventsController {

    private static Logger logger = LoggerFactory.getLogger(GitlabEventsController.class);

    @Autowired private MergeRequestEventHandler mergeRequestEventHandler;

    @RequestMapping(path = "/merge-requests", method = POST)
    public ResponseEntity handleMergeRequestUpdate(@RequestBody String mergeRequestNotification) {
        logger.info(Thread.currentThread().getName() + ": Received merge request notification");
        mergeRequestEventHandler.doHandle(mergeRequestNotification);
        logger.info(Thread.currentThread().getName() + ": Handling async. Returning...");
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}

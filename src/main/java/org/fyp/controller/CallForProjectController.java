package org.fyp.controller;

import org.apache.commons.lang3.StringUtils;
import org.camunda.bpm.engine.RuntimeService;
import org.fyp.util.Constants;
import org.fyp.util.WorkflowLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/callforprojects")
public class CallForProjectController extends BaseController {

    @Autowired
    private RuntimeService runtimeService;

    @GetMapping("/sendprojectproposal/{process-instance-id}")
    public ResponseEntity<String> callForProject(
            @PathVariable(name = "process-instance-id") String processInstanceId
    ) {
        WorkflowLogger.info(LOGGER, "Project Proposal Received", "Project proposal received for process instance id: " + processInstanceId);

        try {
            if (StringUtils.isEmpty(processInstanceId)) {
                WorkflowLogger.error(LOGGER, "Project Proposal Received", "Process Instance Id cannot be null or empty");
                return ResponseEntity.badRequest().body("Process Instance Id cannot be null or empty");
            }

            runtimeService
                    .createMessageCorrelation(Constants.MESSAGE_PROJECTPROPOSALRECEIVED)
                    .processInstanceId(processInstanceId)
                    .correlate();

            return ResponseEntity.ok().body(processInstanceId + " is ready to be reviewed.");
        } catch (Exception e) {
            WorkflowLogger.error(LOGGER, "Project Proposal Received", "Unknown Exception", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unknown Exception. Message: " + e.getMessage());
        }
    }
}


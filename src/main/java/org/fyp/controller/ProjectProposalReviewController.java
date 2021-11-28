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
@RequestMapping("/api/projectproposalreview")
public class ProjectProposalReviewController extends BaseController {

    @Autowired
    private RuntimeService runtimeService;

    @PostMapping("/comments/{process-instance-id}")
    public ResponseEntity<String> projectAllocatedStudent(
            @PathVariable(name = "process-instance-id") String processInstanceId, @RequestBody String comments
    ) {
        final String METHOD = "Proposal Has Comments";
        WorkflowLogger.info(LOGGER, METHOD, "Comments are: \n" + comments);

        try {
            if (StringUtils.isEmpty(processInstanceId)) {
                WorkflowLogger.error(LOGGER, METHOD, "Process Instance Id cannot be null or empty");
                return ResponseEntity.badRequest().body("Process Instance Id cannot be null or empty");
            }



            runtimeService
                    .createMessageCorrelation(Constants.MESSAGE_PROPOSALHASCOMMENTS)
                    .processInstanceId(processInstanceId)
                    .correlate();

            return ResponseEntity.ok().body(processInstanceId + " is ready to be reviewed.");
        } catch (Exception e) {
            WorkflowLogger.error(LOGGER, METHOD, "Unknown Exception", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unknown Exception. Message: " + e.getMessage());
        }
    }
}


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
@RequestMapping("/api/projectallocation")
public class ProjectAllocationController extends BaseController {

    @Autowired
    private RuntimeService runtimeService;

    @GetMapping("/allocate/student/{process-instance-id}")
    public ResponseEntity<String> projectAllocatedStudent(
            @PathVariable(name = "process-instance-id") String processInstanceId
    ) {
        final String METHOD = "Project Allocated Student";
        WorkflowLogger.info(LOGGER, METHOD, "Project Allocated for process id: " + processInstanceId);

        try {
            if (StringUtils.isEmpty(processInstanceId)) {
                WorkflowLogger.error(LOGGER, METHOD, "Process Instance Id cannot be null or empty");
                return ResponseEntity.badRequest().body("Process Instance Id cannot be null or empty");
            }

            runtimeService
                    .createMessageCorrelation(Constants.MESSAGE_STUDENTPROJECTASSIGNED)
                    .processInstanceId(processInstanceId)
                    .correlate();

            return ResponseEntity.ok().body(processInstanceId + " is ready to be reviewed.");
        } catch (Exception e) {
            WorkflowLogger.error(LOGGER, METHOD, "Unknown Exception", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unknown Exception. Message: " + e.getMessage());
        }
    }

    @GetMapping("/allocate/advisor/{process-instance-id}")
    public ResponseEntity<String> projectAllocatedAdvisor(
            @PathVariable(name = "process-instance-id") String processInstanceId
    ) {
        final String METHOD = "Project Allocated Advisor";
        WorkflowLogger.info(LOGGER, METHOD, "Project Allocated for process id: " + processInstanceId);

        try {
            if (StringUtils.isEmpty(processInstanceId)) {
                WorkflowLogger.error(LOGGER, METHOD, "Process Instance Id cannot be null or empty");
                return ResponseEntity.badRequest().body("Process Instance Id cannot be null or empty");
            }

            runtimeService
                    .createMessageCorrelation(Constants.MESSAGE_ADVISORPROJECTASSIGNED)
                    .processInstanceId(processInstanceId)
                    .correlate();

            return ResponseEntity.ok().body(processInstanceId + " is ready to be reviewed.");
        } catch (Exception e) {
            WorkflowLogger.error(LOGGER, METHOD, "Unknown Exception", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Unknown Exception. Message: " + e.getMessage());
        }
    }
}


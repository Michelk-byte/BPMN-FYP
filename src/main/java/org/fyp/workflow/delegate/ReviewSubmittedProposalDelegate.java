package org.fyp.workflow.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.fyp.util.Constants;
import org.fyp.util.WorkflowLogger;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service("ReviewSubmittedProposal")
public class ReviewSubmittedProposalDelegate extends BaseDelegate implements JavaDelegate {
    private static final String METHOD = "Review Submitted Proposal";
    @Override
    public void execute(DelegateExecution execution) throws Exception {

        WorkflowLogger.info(LOGGER, METHOD, "Review the submitted FYP proposal");

        boolean hasProjectTitle = hasFormField(execution, Constants.FORMFIELD_PROJECTTITLE);
        boolean hasProjectDescription = hasFormField(execution, Constants.FORMFIELD_PROJECTDESCRIPTION);
        boolean hasProjectObjectives = hasFormField(execution, Constants.FORMFIELD_PROJECTOBJECTIVES);
        boolean hasProjectDeliverables = hasFormField(execution, Constants.FORMFIELD_PROJECTDELIVERABLES);
        boolean hasProjectSupervisor = hasFormField(execution, Constants.FORMFIELD_SUPERVISOR);
        boolean hasProjectCoSupervisor = hasFormField(execution, Constants.FORMFIELD_COSUPERVISORS);
        boolean hasProjectPrerequisites = hasFormField(execution, Constants.FORMFIELD_PREREQUISITES);
        boolean hasProjectOutcome = hasFormField(execution, Constants.FORMFIELD_PROJECTOUTCOME);

        boolean proposalMeetsRequirements = new Random().nextBoolean();
        boolean formCompleted = false;

        if (hasProjectTitle &&
                hasProjectCoSupervisor &&
                hasProjectDeliverables &&
                hasProjectDescription &&
                hasProjectOutcome &&
                hasProjectObjectives &&
                hasProjectPrerequisites &&
                hasProjectSupervisor) {
            String projectTitle = (String) getFormField(execution, Constants.FORMFIELD_PROJECTTITLE);

            WorkflowLogger.info(LOGGER, METHOD, String.format("Project %s meets the fyp proposal requirements", projectTitle));
            formCompleted = true;
        } else {
            WorkflowLogger.error(LOGGER, METHOD, "Project proposal incomplete");
            WorkflowLogger.error(LOGGER, METHOD, "Project returned");
        }

        execution.setVariable(Constants.VAR_PROPOSALMEETSREQUIREMENTS, formCompleted && proposalMeetsRequirements);

    }

    protected boolean hasFormField(DelegateExecution execution, String formField) {
        return execution.hasVariable(formField) && ((String) getFormField(execution,formField)).length()>0;
    }
}

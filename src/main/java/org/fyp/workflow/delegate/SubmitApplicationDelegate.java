package org.fyp.workflow.delegate;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.fyp.entity.ApplicantGroup;
import org.fyp.service.ApplicantGroupService;
import org.fyp.service.ProjectService;
import org.fyp.util.Constants;
import org.fyp.util.WorkflowLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("SubmitApplication")
public class SubmitApplicationDelegate extends BaseDelegate implements JavaDelegate {

    @Autowired
    ApplicantGroupService applicantGroupService;


    @Override
    public void execute(DelegateExecution execution) {
        long projectId1 = (long) getFormField(execution, Constants.FORMFIELD_PROJECTID1);
        long projectId2 = (long) getFormField(execution, Constants.FORMFIELD_PROJECTID2);
        String registrationIds = (String) getFormField(execution, Constants.FORMFIELD_REGISTRATIONIDS);
        
        ApplicantGroup group = new ApplicantGroup(registrationIds, projectId1,projectId2);
        applicantGroupService.saveOrUpdate(group);

        WorkflowLogger.info(LOGGER, "Submit Application", "Project application submitted by student.");
    }
}

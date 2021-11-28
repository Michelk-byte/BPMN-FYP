package org.fyp.entity;

import javax.persistence.*;

@Table(name = "applicant_group")
@Entity
public class ApplicantGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long groupId;
    private String registrationIds;
    private long projectId1;
    private long projectId2;

    public void setAssigned(boolean notAssigned) {
        this.assigned = notAssigned;
    }

    private boolean assigned = false;


    public ApplicantGroup(String registrationIds, long projectId1, long projectId2) {
        this.registrationIds = registrationIds;
        this.projectId1 = projectId1;
        this.projectId2 = projectId2;
    }

    public ApplicantGroup() {

    }

    public long getGroupId() {
        return groupId;
    }

    public String getRegistrationIds() {
        return registrationIds;
    }

    public void setRegistrationIds(String registrationIds) {
        this.registrationIds = registrationIds;
    }

    public long getProjectId1() {
        return projectId1;
    }

    public void setProjectId1(long projectId1) {
        this.projectId1 = projectId1;
    }

    public long getProjectId2() {
        return projectId2;
    }

    public void setProjectId2(long projectId2) {
        this.projectId2 = projectId2;
    }
}
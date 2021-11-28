package org.fyp.entity;

import org.fyp.util.Constants;
import org.fyp.util.ProjectStatusEnum;

import javax.persistence.*;

@Entity
@Table(name = "project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String projectTitle;
    private String projectDescription;
    private String projectObjectives;
    private String projectDeliverables;
    private String projectSupervisor;
    private String projectCoSupervisor;
    private String projectPrerequisites;
    private String projectOutcome;
    private long numberOfStudents;
    private long groupId;

    public void setAssigned(boolean assigned) {
        this.assigned = assigned;
    }

    private boolean assigned = false;

    public Project(String projectTitle, String projectDescription, String projectObjectives, String projectDeliverables, String projectSupervisor, String projectCoSupervisor, String projectPrerequisites, String projectOutcome, long numberOfStudents) {
        this.projectTitle = projectTitle;
        this.projectDescription = projectDescription;
        this.projectObjectives = projectObjectives;
        this.projectDeliverables = projectDeliverables;
        this.projectSupervisor = projectSupervisor;
        this.projectCoSupervisor = projectCoSupervisor;
        this.projectPrerequisites = projectPrerequisites;
        this.projectOutcome = projectOutcome;
        this.numberOfStudents = numberOfStudents;
    }

    public Project() {

    }

    public long getGroupId() {
        return groupId;
    }

    public void setGroupId(long groupId) {
        this.groupId = groupId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getProjectTitle() {
        return projectTitle;
    }

    public void setProjectTitle(String projectTitle) {
        this.projectTitle = projectTitle;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public String getProjectObjectives() {
        return projectObjectives;
    }

    public void setProjectObjectives(String projectObjectives) {
        this.projectObjectives = projectObjectives;
    }

    public String getProjectDeliverables() {
        return projectDeliverables;
    }

    public void setProjectDeliverables(String projectDeliverables) {
        this.projectDeliverables = projectDeliverables;
    }

    public String getProjectSupervisor() {
        return projectSupervisor;
    }

    public void setProjectSupervisor(String projectSupervisor) {
        this.projectSupervisor = projectSupervisor;
    }

    public String getProjectCoSupervisor() {
        return projectCoSupervisor;
    }

    public void setProjectCoSupervisor(String projectCoSupervisor) {
        this.projectCoSupervisor = projectCoSupervisor;
    }

    public String getProjectPrerequisites() {
        return projectPrerequisites;
    }

    public void setProjectPrerequisites(String projectPrerequisites) {
        this.projectPrerequisites = projectPrerequisites;
    }

    public String getProjectOutcome() {
        return projectOutcome;
    }

    public void setProjectOutcome(String projectOutcome) {
        this.projectOutcome = projectOutcome;
    }

    public long getNumberOfStudents() {
        return numberOfStudents;
    }

    public void setNumberOfStudents(long numberOfStudents) {
        this.numberOfStudents = numberOfStudents;
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectId='" + id + '\'' +
                "projectTitle='" + projectTitle + '\'' +
                ", projectDescription='" + projectDescription + '\'' +
                ", projectObjectives='" + projectObjectives + '\'' +
                ", projectDeliverables='" + projectDeliverables + '\'' +
                ", projectSupervisor='" + projectSupervisor + '\'' +
                ", projectCoSupervisor='" + projectCoSupervisor + '\'' +
                ", projectPrerequisites='" + projectPrerequisites + '\'' +
                ", projectOutcome='" + projectOutcome + '\'' +
                ", numberOfStudents=" + numberOfStudents +
                '}';
    }
}

/*
 * Copyright 2018 Alfresco, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.activiti.cloud.services.query.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;
import javax.persistence.ConstraintMode;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Task extends ActivitiEntityMetadata implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private String assignee;
    private String name;
    private String description;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date createTime;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date dueDate;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Date claimDate;
    private String priority;
    private String category;
    private String processDefinitionId;
    private String processInstanceId;
    private String status;
    private String owner;
    private String parentTaskId;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date lastModified;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date lastModifiedTo;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date lastModifiedFrom;

    @JsonIgnore
    @ManyToOne(optional = true)
    @JoinColumn(name = "processInstanceId", referencedColumnName = "id", insertable = false, updatable = false
            , foreignKey = @javax.persistence.ForeignKey(value = ConstraintMode.NO_CONSTRAINT, name = "none"))
    private ProcessInstance processInstance;

    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "taskId", referencedColumnName = "id", insertable = false, updatable = false
            , foreignKey = @javax.persistence.ForeignKey(value = ConstraintMode.NO_CONSTRAINT, name = "none"))
    private Set<TaskCandidateUser> taskCandidateUsers;

    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "taskId", referencedColumnName = "id", insertable = false, updatable = false
            , foreignKey = @javax.persistence.ForeignKey(value = ConstraintMode.NO_CONSTRAINT, name = "none"))
    private Set<TaskCandidateGroup> taskCandidateGroups;

    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "taskId", referencedColumnName = "id", insertable = false, updatable = false
            , foreignKey = @javax.persistence.ForeignKey(value = ConstraintMode.NO_CONSTRAINT, name = "none"))
    private Set<Variable> variables;

    public Task() {
    }

    @JsonCreator
    public Task(@JsonProperty("id") String id,
                @JsonProperty("assignee") String assignee,
                @JsonProperty("name") String name,
                @JsonProperty("description") String description,
                @JsonProperty("createTime") Date createTime,
                @JsonProperty("dueDate") Date dueDate,
                @JsonProperty("priority") String priority,
                @JsonProperty("category") String category,
                @JsonProperty("processDefinitionId") String processDefinitionId,
                @JsonProperty("processInstanceId") String processInstanceId,
                @JsonProperty("serviceName") String serviceName,
                @JsonProperty("serviceFullName") String serviceFullName,
                @JsonProperty("serviceVersion") String serviceVersion,
                @JsonProperty("appName") String appName,
                @JsonProperty("appVersion") String appVersion,
                @JsonProperty("status") String status,
                @JsonProperty("lastModified") Date lastModified,
                @JsonProperty("claimDate") Date claimDate,
                @JsonProperty("owner") String owner,
                @JsonProperty("parentTaskId") String parentTaskId) {
        super(serviceName,
              serviceFullName,
              serviceVersion,
              appName,
              appVersion);
        this.id = id;
        this.assignee = assignee;
        this.name = name;
        this.description = description;
        this.createTime = createTime;
        this.dueDate = dueDate;
        this.priority = priority;
        this.category = category;
        this.processDefinitionId = processDefinitionId;
        this.processInstanceId = processInstanceId;
        this.status = status;
        this.lastModified = lastModified;
        this.claimDate = claimDate;
        this.owner = owner;
        this.parentTaskId = parentTaskId;
    }

    public String getId() {
        return id;
    }

    public String getAssignee() {
        return assignee;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public String getPriority() {
        return priority;
    }

    public String getCategory() {
        return category;
    }

    public String getProcessDefinitionId() {
        return processDefinitionId;
    }

    public String getProcessInstanceId() {
        return processInstanceId;
    }

    public String getStatus() {
        return status;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setAssignee(String assignee) {
        this.assignee = assignee;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setProcessDefinitionId(String processDefinitionId) {
        this.processDefinitionId = processDefinitionId;
    }

    public void setProcessInstanceId(String processInstanceId) {
        this.processInstanceId = processInstanceId;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setLastModified(Date lastModified) {
        this.lastModified = lastModified;
    }

    @Transient
    public Date getLastModifiedTo() {
        return lastModifiedTo;
    }

    public void setLastModifiedTo(Date lastModifiedTo) {
        this.lastModifiedTo = lastModifiedTo;
    }

    @Transient
    public Date getLastModifiedFrom() {
        return lastModifiedFrom;
    }

    public Date getClaimDate() {
        return claimDate;
    }

    public void setClaimDate(Date claimDate) {
        this.claimDate = claimDate;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public void setLastModifiedFrom(Date lastModifiedFrom) {
        this.lastModifiedFrom = lastModifiedFrom;
    }

    /**
     * @return the processInstance
     */
    public ProcessInstance getProcessInstance() {
        return this.processInstance;
    }

    /**
     * @param processInstance the processInstance to set
     */
    public void setProcessInstance(ProcessInstance processInstance) {
        this.processInstance = processInstance;
    }

    /**
     * @return the variables
     */
    public Set<Variable> getVariables() {
        return this.variables;
    }

    /**
     * @param variables the variables to set
     */
    public void setVariables(Set<Variable> variables) {
        this.variables = variables;
    }

    /**
     * @return the taskCandidateUsers
     */
    public Set<TaskCandidateUser> getTaskCandidateUsers() {
        return this.taskCandidateUsers;
    }

    /**
     * @param taskCandidateUsers the taskCandidateUsers to set
     */
    public void setTaskCandidateUsers(Set<TaskCandidateUser> taskCandidateUsers) {
        this.taskCandidateUsers = taskCandidateUsers;
    }

    /**
     * @return the taskCandidateUsers
     */
    public Set<TaskCandidateGroup> getTaskCandidateGroups() {
        return this.taskCandidateGroups;
    }

    /**
     * @param taskCandidateGroups the taskCandidateGroups to set
     */
    public void setTaskCandidateGroups(Set<TaskCandidateGroup> taskCandidateGroups) {
        this.taskCandidateGroups = taskCandidateGroups;
    }

    public String getParentTaskId() {
        return parentTaskId;
    }

    public void setParentTaskId(String parentTaskId) {
        this.parentTaskId = parentTaskId;
    }
}

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

import java.util.Date;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.springframework.format.annotation.DateTimeFormat;


@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProcessInstance extends ActivitiEntityMetadata {

    @Id
    private String id;
    private String name;
    private String description;
    private String processDefinitionId;
    private String processDefinitionKey;
    private String initiator;
    private Date startDate;
    private String businessKey;
    private String status;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date lastModified;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date lastModifiedTo;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date lastModifiedFrom;

    @JsonIgnore
    @OneToMany(mappedBy = "processInstance")
    @org.hibernate.annotations.ForeignKey(name = "none")
    private Set<Task> tasks;

    @JsonIgnore
    @OneToMany(mappedBy = "processInstance")
    @org.hibernate.annotations.ForeignKey(name = "none")
    private Set<Variable> variables;

    public ProcessInstance() {
    }

    public ProcessInstance(String serviceName,
                           String serviceFullName,
                           String serviceVersion,
                           String appName,
                           String appVersion,
                           String processInstanceId,
                           String processDefinitionId,
                           String status,
                           Date lastModified) {
        super(serviceName,serviceFullName,serviceVersion,appName,appVersion);
        this.id = processInstanceId;
        this.processDefinitionId = processDefinitionId;
        this.status = status;
        this.lastModified = lastModified;
    }

    public String getProcessDefinitionId() {
        return processDefinitionId;
    }

    public String getStatus() {
        return status;
    }

    public Date getLastModified() {
        return lastModified;
    }

    public void setProcessDefinitionId(String processDefinitionId) {
        this.processDefinitionId = processDefinitionId;
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

    public void setLastModifiedFrom(Date lastModifiedFrom) {
        this.lastModifiedFrom = lastModifiedFrom;
    }

    public Set<Task> getTasks() {
        return this.tasks;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }

    public Set<Variable> getVariables() {
        return variables;
    }

    public void setVariables(Set<Variable> variables) {
        this.variables = variables;
    }

    public String getProcessDefinitionKey() {
        return processDefinitionKey;
    }

    public void setProcessDefinitionKey(String processDefinitionKey) {
        this.processDefinitionKey = processDefinitionKey;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInitiator() {
        return initiator;
    }

    public void setInitiator(String initiator) {
        this.initiator = initiator;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public String getBusinessKey() {
        return businessKey;
    }

    public void setBusinessKey(String businessKey) {
        this.businessKey = businessKey;
    }
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package workshop3a24.Entities;

/**
 *
 * @author azers
 */
public class Tache {
    private int id;
    private int projectId;
    private String nom;
    private String status;
    private String files;
    private String description;
    private String priority;
    private int estimatedTime;

    public Tache(int projectId,String nom, String status, String files, String description, String priority, int estimatedTime) {     
        this.projectId = projectId;
        this.nom= nom;
        this.status = status;
        this.files = files;
        this.description = description;
        this.priority = priority;
        this.estimatedTime = estimatedTime;
    }

    public Tache() {
       
    }

    // getters and setters for all fields

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFiles() {
        return files;
    }

    public void setFiles(String files) {
        this.files = files;
    }
    
      public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public int getEstimatedTime() {
        return estimatedTime;
    }

    public void setEstimatedTime(int estimatedTime) {
        this.estimatedTime = estimatedTime;
    }
    
    @Override
    public String toString() {
        return "Tache{" +
                "id=" + id +
                ", projectId=" + projectId +
                 ", Nom=" + nom +
                ", status='" + status + '\'' +
                ", files='" + files + '\'' +
                ", description='" + description + '\'' +
                ", priority='" + priority + '\'' +
                ", estimatedTime=" + estimatedTime +
                '}';
    }
}

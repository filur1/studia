package db;

import java.util.*;


public class Milestone extends DbObject {


    protected String name;
    protected String description;
    protected Date deadline;
    protected Date createdAt;
    protected Date updatedAt;
    protected Project project;
    protected List<Task> tasks;
    protected List<Comment<Milestone>> comments;
    protected List<Attachment<Milestone>> attachments;


    public Milestone(){
        super();
        this.tasks = new ArrayList<Task>();
        this.comments = new ArrayList<Comment<Milestone>>();
        this.attachments = new ArrayList<Attachment<Milestone>>();
    }

    public Milestone(int id){
        super();
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

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public void addTask(Task task){
        this.tasks.add(task);
    }

    public void removeTask(Task task){
        this.tasks.remove(task);
    }


    public List<Comment<Milestone>> getComments(){
        return this.comments;
    }

    public void addComment(Comment<Milestone> comment){
        this.comments.add(comment);
        comment.parent = this;
        this.save();
        comment.save();
    }


    public List<Attachment<Milestone>> getAttachments(){
        return this.attachments;
    }

    public void addAttachment(Attachment<Milestone> attachment){
        this.attachments.add(attachment);
        attachment.parent = this;
        this.save();
        attachment.save();
    }


    public static Collection<Milestone> all(){
        return Database.odb.getObjects(Milestone.class);
    }

}

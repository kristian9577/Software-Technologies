package issuetracker.entity;

import javax.persistence.*;

@Entity
@Table(name = "issues")
public class Issue {

    private Integer id;

    private String title;

    private String content;

    private Integer priority;

    public Issue() {
    }

    public Issue(String title, String content, Integer priority) {
        this.title = title;
        this.content = content;
        this.priority = priority;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(nullable = false)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(nullable = false)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Column(nullable = false)
    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }
}

package pl.coderslab.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "article")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 100)
    @NotBlank
    @Size(max=200)
    private String title;
    @OneToOne
    private Author author;
    @NotBlank
    @Size(min=5)
    private String content;
    @ManyToMany(fetch = FetchType.EAGER)
    @Size(min=1)
    private List<Category> categories = new ArrayList<>();

    @Column(name = "created_on")
    private LocalDateTime created;
    @Column(name = "updated_on")
    private LocalDateTime updated;

    @PrePersist
    public void prePersist() {
        created = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        updated = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author=" + author +
                ", content='" + content + '\'' +
                ", categories=" + categories +
                ", created=" + created +
                ", updated=" + updated +
                '}';
    }
}

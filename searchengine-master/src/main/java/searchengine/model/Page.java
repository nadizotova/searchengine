package searchengine.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import javax.persistence.Index;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "page", indexes = {@Index(name = "path_index", columnList = "path")})

public class Page {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @JoinColumn(name = "site_id", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Site siteId;

    @Column(name = "path", columnDefinition = "TEXT", nullable = false, length = 30)
    private String path;

    @Column(name = "code")
    private int code;

    @Column(name = "content", columnDefinition = "MEDIUMTEXT")
    private String content;

}



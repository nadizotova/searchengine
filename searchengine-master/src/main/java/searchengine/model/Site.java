package searchengine.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;


@NoArgsConstructor
@Getter
@Setter
@Table(name = "site")
@Entity
public class Site {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", columnDefinition = "ENUM('INDEXING', 'INDEXED')")
    private Status status;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "status_time")
    private Date statusTime;

    @Column(name = "last_error", columnDefinition = "TEXT")
    private String lastError;

    @Column(name = "url", columnDefinition = "VARCHAR(255)")
    private String url;

    @Column(name = "name", columnDefinition = "VARCHAR(255)")
    private String name;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Page> pages;




//    @OneToMany(mappedBy = "site")
//    private List<Page> pages = new ArrayList<>();
}
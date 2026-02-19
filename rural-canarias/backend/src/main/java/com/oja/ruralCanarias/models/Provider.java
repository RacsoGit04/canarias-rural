import java.lang.annotation.Inherited;

@Entity
@JoinTable(name = "providers")
public class Provider{
    @Id
    private Long userId; 

    @OneToOne
    @MapsId
    @JoinColumn(name  ="user_id")
    private User user; 

    @Column(name = "company_name")
    private String companyName; 

    @Column(name = "contac_info")
    private String contactInfo; 

}
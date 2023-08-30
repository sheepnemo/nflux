package story.domain;

import jakarta.persistence.*;

@Entity
@Table (name = "POST_INFO")
public class PostInfo {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;
	
	@Column (name = "P_NAME")
	private String postName;
	
	@Column (name = "P_HASH")
	private String postHashtag;
	
	@Column (name = "P_USER")
	private String postingUser;
	
	@Column (name = "P_DATE")
	private String postingDate;
	
	@Column (name = "P_TIME")
	private int postTimes;
	
	@Column (name = "P_AFFIRM")
	private int postAffirmNumber;
	
}

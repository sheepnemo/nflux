package story.domain;

import jakarta.persistence.*;

@Entity
@Table (name = "POST_CONTENT")
public class PostContent {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;
	
	@Column (name = "P_ID")
	private Long postId;
	
	@Column (name = "P_CONTENT")
	private String postContent;
}

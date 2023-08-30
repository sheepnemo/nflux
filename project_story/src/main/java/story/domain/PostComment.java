package story.domain;

import jakarta.persistence.*;

@Entity
@Table (name = "POST_COMMENT")
public class PostComment {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;
	
	@Column (name = "P_ID")
	private String postId;
	
	@Column (name = "P_COMMENT")
	private String postComment;
	
	@Column (name = "P_COMMENTUSER")
	private String commentUser;
}

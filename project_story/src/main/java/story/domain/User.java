package story.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "USER_INFO")
public class User {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;
	
	@Column (name = "U_NAME")
	private String userName;
	
	@Column (name = "U_ID")
	private String userId;
	
	@Column (name = "U_PW")
	private String userPw;
	
	@Column (name = "U_MAIL")
	private String userMail;
	
	@Column (name = "U_NICKNAME")
	private String userNickname;
	
	@Column (name = "U_PHONE")
	private String userPhone;
	
	@Column (name = "ADMINUSER")
	private boolean adminUser;
	
	@Column (name = "ADMINNUMBER")
	private String adminNumber;
}

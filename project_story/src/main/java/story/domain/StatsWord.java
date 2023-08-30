package story.domain;

import jakarta.persistence.*;

@Entity
@Table (name = "STATS_WORD")
public class StatsWord {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;
	
	@Column (name = "S_AFFIRM")
	private int wordAffirmnumber;
	
	@Column (name = "S_WORD")
	private String word;
}

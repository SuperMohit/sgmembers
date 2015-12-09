package com.sg.members.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.lucene.analysis.core.LowerCaseFilterFactory;
import org.apache.lucene.analysis.core.StopFilterFactory;
import org.apache.lucene.analysis.ngram.NGramFilterFactory;
import org.apache.lucene.analysis.standard.StandardFilterFactory;
import org.apache.lucene.analysis.standard.StandardTokenizerFactory;
import org.hibernate.search.annotations.Analyze;
import org.hibernate.search.annotations.Analyzer;
import org.hibernate.search.annotations.AnalyzerDef;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Parameter;
import org.hibernate.search.annotations.Store;
import org.hibernate.search.annotations.TokenFilterDef;
import org.hibernate.search.annotations.TokenizerDef;

import com.sg.members.DTO.MemberDTO;


@AnalyzerDef(name = "ngram",
tokenizer = @TokenizerDef(factory = StandardTokenizerFactory.class ),
filters = {
  @TokenFilterDef(factory = StandardFilterFactory.class),
  @TokenFilterDef(factory = LowerCaseFilterFactory.class),
  @TokenFilterDef(factory = StopFilterFactory.class),
  @TokenFilterDef(factory = NGramFilterFactory.class,
    params = { 
      @Parameter(name = "minGramSize", value = "2"),
      @Parameter(name = "maxGramSize", value = "20") } )
}
)
@Entity
@Table(name="member")
@Indexed
public class Member {

	private int id;
	private String status;
	private int raceId;
	private int weight;
	private int height;
	private boolean is_veg;

	public Member() {

	}

	public Member(int id, String status, int raceId, int weight, int height, boolean is_veg) {
		super();
		this.id = id;
		this.status = status;
		this.setRaceId(raceId);
		this.setWeight(weight);
		this.setHeight(height);
		this.is_veg = is_veg;
	}

	public static MemberDTO toMemberDTO(Member member) {

		if (member != null) {

			return new MemberDTO(member.getId(), member.getStatus(), member.getRaceId(), member.getWeight(),
					member.getHeight(), member.isIs_veg());

		}

		return null;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Field(index = Index.YES, analyze = Analyze.YES, store = Store.NO,analyzer = @Analyzer(definition="ngram"))
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	

	
	public boolean isIs_veg() {
		return is_veg;
	}

	public void setIs_veg(boolean is_veg) {
		this.is_veg = is_veg;
	}

	/**
	 * @return the raceId
	 */
	
	@Column(name="idrace")
	public int getRaceId() {
		return raceId;
	}

	/**
	 * @param raceId the raceId to set
	 */
	public void setRaceId(int raceId) {
		this.raceId = raceId;
	}

	/**
	 * @return the weight
	 */
	
	public int getWeight() {
		return weight;
	}

	/**
	 * @param weight the weight to set
	 */
	public void setWeight(int weight) {
		this.weight = weight;
	}

	/**
	 * @return the height
	 */
	
	public int getHeight() {
		return height;
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}

}

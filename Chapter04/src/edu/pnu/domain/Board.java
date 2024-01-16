package edu.pnu.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Board {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long seq;
//	@Column(length=25)
	private String title;
	private String writer;
	private String content;
	@Temporal(TemporalType.DATE)
	private Date createDate; // 이게 카맬로테이션으로 작성되어있지만 db로 들어갈땐 언더바로 creat_date이렇게 들어갔었음.
	
	public Long getSeq() {
		return seq;
	}
	public void setSeq(Long seq) {
		this.seq = seq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Long getCnt() {
		return cnt;
	}
	public void setCnt(Long cnt) {
		this.cnt = cnt;
	}
	private Long cnt;
	
	@Override
	public String toString() {
		return "Board [seq=" + seq + ", title=" + title + ", writer=" + writer + ", content=" + content
				+ ", createDate=" + createDate + ", cnt=" + cnt + ", getSeq()=" + getSeq() + ", getTitle()="
				+ getTitle() + ", getWriter()=" + getWriter() + ", getContent()=" + getContent() + ", getCreateDate()="
				+ getCreateDate() + ", getCnt()=" + getCnt() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}

}


package com.cg.entity;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Response {

	@Id

	@GeneratedValue(strategy = GenerationType.AUTO)
	private int respId;

	@Column(name = "answer")
	private String answer;

	@Column
	private LocalDate respDate;

	@Column
	private LocalTime respTime;

	@Column(name = "accuracy")
	private int accuracy;

	@ManyToOne(cascade = CascadeType.ALL)
	private Feed feeds;

	@OneToOne(cascade = CascadeType.ALL)
	private Developer dev;

	public Response() {}

	public Response(int respId, String answer, LocalDate respDate, LocalTime respTime, int accuracy, Feed feeds,
			Developer dev) {
		super();
		this.respId = respId;
		this.answer = answer;
		this.respDate = respDate;
		this.respTime = respTime;
		this.accuracy = accuracy;
		this.feeds = feeds;
		this.dev = dev;
	}

	public int getRespId() {
		return respId;
	}

	public void setRespId(int respId) {
		this.respId = respId;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public LocalDate getRespDate() {
		return respDate;
	}

	public void setRespDate(LocalDate respDate) {
		this.respDate = respDate;
	}

	public LocalTime getRespTime() {
		return respTime;
	}

	public void setRespTime(LocalTime respTime) {
		this.respTime = respTime;
	}

	public int getAccuracy() {
		return accuracy;
	}

	public void setAccuracy(int accuracy) {
		this.accuracy = accuracy;
	}

	public Feed getFeeds() {
		return feeds;
	}

	public void setFeeds(Feed feeds) {
		this.feeds = feeds;
	}

	public Developer getDev() {
		return dev;
	}

	public void setDev(Developer dev) {
		this.dev = dev;
	}

	@Override
	public String toString() {
		return "Response [respId=" + respId + ", answer=" + answer + ", respDate=" + respDate + ", respTime=" + respTime
				+ ", accuracy=" + accuracy + ", feeds=" + feeds + ", dev=" + dev + "]";
	}

	
	
}
	
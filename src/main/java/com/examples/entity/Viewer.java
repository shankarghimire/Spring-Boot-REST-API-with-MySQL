package com.examples.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity(name="Viewer")
@Table(name="viewer")
public class Viewer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="viewer_id")
	private Long id;
	
	@Column(name="nick_name")
	private String nickName;
	
	@ManyToMany
	@JoinTable(
			name="followed_streams",
			joinColumns = @JoinColumn(name="viewer_id"),
			inverseJoinColumns = @JoinColumn(name="stream_id")
			)
	private List<Stream> followedStreams = new ArrayList<>();


	public Viewer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Viewer(Long id, String nickName, List<Stream> followedStreams) {
		super();
		this.id = id;
		this.nickName = nickName;
		this.followedStreams = followedStreams;
	}

	public Viewer(String nickName) {
		super();
		this.nickName = nickName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public List<Stream> getFollowedStreams() {
		return followedStreams;
	}

	public void setFollowedStreams(List<Stream> followedStreams) {
		this.followedStreams = followedStreams;
	}
	
	public void followStream(Stream stream) {
		followedStreams.add(stream);
	}

	@Override
	public String toString() {
		return "Viewer [id=" + id + ", nickName=" + nickName + ", followedStreams=" + followedStreams + "]";
	}
	

}

package com.examples.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity(name="Stream")
@Table(name="stream")
public class Stream {
	
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO )
	private Long id;
	private String name;
	
	@ManyToMany(mappedBy = "followedStreams")
	private List<Viewer> followers = new ArrayList<>();
	
	public Stream() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Stream(Long id, String name, List<Viewer> folowers) {
		super();
		this.id = id;
		this.name = name;
		this.followers = folowers;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Viewer> getFolowers() {
		return followers;
	}
	public void setFolowers(List<Viewer> folowers) {
		this.followers = folowers;
	}
	public void addViewer(Viewer viewer) {
		followers.add(viewer);
	}

	@Override
	public String toString() {
		return "Stream [id=" + id + ", name=" + name + ", folowers=" + followers + "]";
	}
	

}

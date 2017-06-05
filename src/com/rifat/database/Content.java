package com.rifat.database;

public class Content {

	public String title;
	public String content;
	public String tag;
	public String other;
	public int id;
	public Content()
	{
		
	}
	public Content(String title,String content,String tag)
	{
		this.title=title;
		this.content=content;
		this.tag=tag;
		
	}
	public Content(String title,String content,String tag,int id)
	{
		this.title=title;
		this.content=content;
		this.tag=tag;
		this.id=id;
		
	}
	
	public Content(String title,String content,String tag,int id,String other)
	{
		this.title=title;
		this.content=content;
		this.tag=tag;
		this.id=id;
		this.other=other;
		
	}
	@Override
	public String toString() {
		return "Content [title=" + title + ", content=" + content + ", tag=" + tag + ", id=" + id + "]";
	}
	
}

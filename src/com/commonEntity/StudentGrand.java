package com.commonEntity;

import java.util.Date;

public class StudentGrand {
    private String id;

    private String name;

    private String subject;

    private int grang;

    private Date createTime;

    public int type;

    public StudentGrand(String id, String name, String subject, int grang, Date createTime, int type) {
        super();
        this.id = id;
        this.name = name;
        this.subject = subject;
        this.grang = grang;
        this.createTime = createTime;
        this.type = type;
    }

    public StudentGrand(String id, String name, String subject, int grang) {
        super();
        this.id = id;
        this.name = name;
        this.subject = subject;
        this.grang = grang;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public int getGrang() {
        return grang;
    }

    public void setGrang(int grang) {
        this.grang = grang;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}

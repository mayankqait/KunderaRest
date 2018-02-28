package com.infotech.entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;



@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class AuditableClass<U> {

	/**
	 * Default serial version UID
	 */
	private static final long serialVersionUID = 1L;

	@CreatedBy
    @Column(name = "created_by")
    protected U createdBy;

    @CreatedDate
	@Column(name = "created_at")
    @Temporal(TemporalType.TIMESTAMP)
    protected Date createdAt;;

    @LastModifiedBy
    @Column(name = "updated_by")
    protected U updatedBy;

    @LastModifiedDate
    @Column(name = "updated_at")
	@Temporal(TemporalType.TIMESTAMP)
    protected Date updatedAt;

    public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public U getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(U createdBy) {
		this.createdBy = createdBy;
	}

	public Date getUpdatedAt() throws InstantiationException, IllegalAccessException {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public U getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(U updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String toString() {
		return null;
	}

}


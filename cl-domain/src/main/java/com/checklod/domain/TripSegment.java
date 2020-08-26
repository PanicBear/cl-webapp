package com.checklod.domain;

import java.time.LocalDateTime;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "TripSegment")
public class TripSegment {
    
	@EmbeddedId
	@AttributeOverrides({
		  @AttributeOverride( name = "tripId", column = @Column(name = "tripId")),
		  @AttributeOverride( name = "seq", column = @Column(name = "seq"))
		})
    private TripSegmentId tripSegmentId;
    
    @Column(name="phoneNo")
    private String phoneNo;
    
    @Column(name="driverId")
    private long driverId;
    
    @Column(name="driverName")
    private String driverName;
    
    @Column(name="vehicleNo")
    private String vehicleNo;
    
    @Column(name="transMode")
    private String transMode;
    
    @NotNull(message = "checkin is mandatory")
    @CreationTimestamp
    private LocalDateTime checkin;
    
    @UpdateTimestamp
    private LocalDateTime checkout;
    
    @NotNull(message = "logger id is mandatory")
    @Column(name="loggerId")
    private String loggerId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "tripId", nullable = false, insertable=false, updatable=false)
    private Trip trip;
}
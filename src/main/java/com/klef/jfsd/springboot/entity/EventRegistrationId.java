package com.klef.jfsd.springboot.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class EventRegistrationId implements Serializable {

    @Column(name = "event_id")
    private int eventId;  // Change this to int

    @Column(name = "student_id")
    private String studentId;

    public EventRegistrationId() {}

    public EventRegistrationId(int eventId, String studentId) {
        this.eventId = eventId;
        this.studentId = studentId;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EventRegistrationId that = (EventRegistrationId) o;
        return eventId == that.eventId && studentId.equals(that.studentId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventId, studentId);
    }
}

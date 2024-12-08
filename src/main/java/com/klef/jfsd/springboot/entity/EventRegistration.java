package com.klef.jfsd.springboot.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "event_registration")
public class EventRegistration {

    @EmbeddedId
    private EventRegistrationId id;

    @ManyToOne
    @MapsId("eventId")
    @JoinColumn(name = "event_id")
    private Event event;

    @ManyToOne
    @MapsId("studentId")
    @JoinColumn(name = "student_id")
    private Student student;

    // Constructors, getters, and setters
    public EventRegistration() {}

    public EventRegistration(Event event, Student student) {
        this.event = event;
        this.student = student;
        this.id = new EventRegistrationId(event.getId(), student.getId());
    }

    public EventRegistrationId getId() { return id; }
    public void setId(EventRegistrationId id) { this.id = id; }

    public Event getEvent() { return event; }
    public void setEvent(Event event) { this.event = event; }

    public Student getStudent() { return student; }
    public void setStudent(Student student) { this.student = student; }
}

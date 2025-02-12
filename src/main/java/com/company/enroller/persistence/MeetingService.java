package com.company.enroller.persistence;

import java.util.Collection;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import com.company.enroller.model.Meeting;
import com.company.enroller.model.Participant;

@Component("meetingService")
public class MeetingService {

	DatabaseConnector connector;
	Session session;

	public MeetingService() {
		connector = DatabaseConnector.getInstance();
	}

	public Collection<Meeting> getAll() {
		String hql = "FROM Meeting";
		Query query = connector.getSession().createQuery(hql);
		return query.list();
	}
	
	public Meeting findById(long id) {
        Meeting meeting = (Meeting) connector.getSession().get(Meeting.class, id);
        return meeting;
    }

    public void add(Meeting meeting) {
        Transaction transaction = this.connector.getSession().beginTransaction();
        connector.getSession().save(meeting);
        transaction.commit();
    }

    public void remove(Meeting meeting) {
        Transaction transaction = this.connector.getSession().beginTransaction();
        connector.getSession().delete(meeting);
        transaction.commit();
    }

    public void addParticipant(Participant participant) {
        Transaction transaction = this.connector.getSession().beginTransaction();
        connector.getSession().save(participant);
        transaction.commit();
    }

    public void updateTitle(Meeting meeting, String title) {
        Transaction transaction = this.connector.getSession().beginTransaction();
        meeting.setTitle(title);
        session.save(meeting);
        transaction.commit();       
    }

    public void updateDescription(Meeting meeting, String description) {
        Transaction transaction = this.connector.getSession().beginTransaction();
        meeting.setDescription(description);
        session.save(meeting);
        transaction.commit();
    }

    public void updateDate(Meeting meeting, String date) {
        Transaction transaction = this.connector.getSession().beginTransaction();
        meeting.setDate(date);
        session.save(meeting);
        transaction.commit();        
    }
 }

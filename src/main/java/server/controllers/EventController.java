package server.controllers;

import server.exceptions.ResponseException;
import server.models.Event;
import server.models.Student;

import java.sql.SQLException;
import java.util.ArrayList;

import server.providers.EventTable;

/**
 * Created by STFU on 19/10/2017
 */


public class EventController {

    /**
     * EventController-klassen forbinder vores endpoints med vores providers,
     * som sender SQL statements til databasen
     */

    //Controller-klasse for event. Laver kald til databasen.
    //API forbindes med database.
    private EventTable eventTable = new EventTable();

    /**
     *
     * @param idEvent
     * @return Attending Students
     * @throws IllegalAccessException
     * @throws SQLException
     */
    public ArrayList getAttendingStudents(String idEvent) throws IllegalAccessException, SQLException {
        ArrayList attendingStudents = eventTable.getAttendingStudents(idEvent);
        eventTable.close();
        return attendingStudents;
    }

    /**
     *
     * @param eventData
     * @param student
     * @return Create Event
     * @throws SQLException
     */
    public boolean createEvent(Event eventData, Student student) throws SQLException {
        boolean createEvent = eventTable.createEvent(eventData, student);
        eventTable.close();
        return createEvent;
    }

    /**
     *
     * @return All Events
     */
    public ArrayList<Event> getAllEvents() {
        ArrayList getAllEvents = eventTable.getAllEvents();
        eventTable.close();
        return getAllEvents;
    }

    /**
     *
     * @param event
     * @param student
     * @return Delete event
     * @throws Exception
     */
    public boolean deleteEvent(Event event, Student student) throws Exception {
        boolean deleteEvent = eventTable.deleteEvent(event, student);
        eventTable.close();
        return deleteEvent;
    }

    /**
     *
     * @param eventId
     * @param studentId
     * @return Join Event
     * @throws ResponseException
     */
    public boolean joinEvent(int eventId, int studentId) throws ResponseException {
        boolean joinEvent = eventTable.joinEvent(eventId, studentId);
        eventTable.close();
        return joinEvent;
    }

    /**
     *
     * @param event
     * @param student
     * @return Update Event
     * @throws Exception
     */
    public boolean updateEvent(Event event, Student student) throws Exception {
        boolean updateEvent = eventTable.updateEvent(event, student);
        eventTable.close();
        return updateEvent;

    }

    /**
     * Følgende er lånt fra https://github.com/Pewtro/STFU-new/blob/d9ec9cf5d63c6cdc0ec81dc4d74d04c164b0fdf8/src/main/java/server/controllers/EventController.java
     *
     * @return myEvents
     */

    public ArrayList<Event> getMyEvents(Student student) {
        ArrayList getMyEvents = eventTable.getMyEvents(student);
        eventTable.close();
        return getMyEvents;
    }

}


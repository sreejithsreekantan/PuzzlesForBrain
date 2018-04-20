package com.sree;

/*
Give a set of meetings with time from a person's calendar. Figure out how much time that person spent in meetings.

Make sure you don't double count for overlapping meetings.

Input: CalendarEvent() with the start and end time of meetings
Output: Total time spent in proper formatting of hours,minutes and seconds
 */
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CalendarEvent implements Comparable {
    Date start, end;

    public CalendarEvent(Date start, Date end) {
        this.start = start;
        this.end = end;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getStart() {
        return start;
    }

    public  void setEnd(Date end) {
        this.end = end;
    }

    public Date getEnd() {
        return end;
    }

    public int compareTo(Object o) {
//        return ((CalendarEvent)o).getStart().compareTo(start);
        return start.compareTo(((CalendarEvent)o).getStart());
    }

    @Override
    public String toString() {
        return super.toString() + " " + start.toString() + " to " + end.toString();
    }

    public static Long calculateTotalTimeSpentInMeetings(List<CalendarEvent> events) {
        Collections.sort(events);

        // Print out the sorted list of events/meetings
//        for (CalendarEvent event:
//                events) {
//            System.out.println(event);
//        }

        Long totalTimeSpentInMeetings = new Long(0);
        Date prevEndDate = events.get(0).getStart();
        Date startDate, endDate;
        for (CalendarEvent event:
                events) {
            startDate = event.getStart();
            endDate = event.getEnd();
            if (startDate.before(prevEndDate)) {
                startDate = prevEndDate;
            }
            if (startDate.before(endDate)) {
                totalTimeSpentInMeetings += (endDate.getTime() - startDate.getTime());
                prevEndDate = endDate;
            }
        }
        return  totalTimeSpentInMeetings;
    }

    public static void main(String[] args) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("y-MM-dd-H-m");
        List<CalendarEvent> events = new ArrayList<>();
        events.add(new CalendarEvent(sdf.parse("2018-03-04-09-00"), sdf.parse("2018-03-04-10-00")));
        events.add(new CalendarEvent(sdf.parse("2018-02-03-09-00"), sdf.parse("2018-02-03-10-00")));
        events.add(new CalendarEvent(sdf.parse("2018-01-01-09-00"), sdf.parse("2018-01-01-10-00")));
        events.add(new CalendarEvent(sdf.parse("2018-01-01-09-30"), sdf.parse("2018-01-01-10-30")));
        events.add(new CalendarEvent(sdf.parse("2018-01-01-10-30"), sdf.parse("2018-01-01-11-30")));
        events.add(new CalendarEvent(sdf.parse("2018-01-01-16-00"), sdf.parse("2018-01-01-17-00")));
        events.add(new CalendarEvent(sdf.parse("2018-01-02-09-00"), sdf.parse("2018-01-02-10-00")));
        events.add(new CalendarEvent(sdf.parse("2018-01-02-15-30"), sdf.parse("2018-01-02-16-00")));

        Long totalTimeSpentInMilliseconds = calculateTotalTimeSpentInMeetings(events);
        Long hours = TimeUnit.MILLISECONDS.toHours(totalTimeSpentInMilliseconds);
        Long minutes = TimeUnit.MILLISECONDS.toMinutes(totalTimeSpentInMilliseconds) - TimeUnit.HOURS.toMinutes(hours);
        Long seconds = TimeUnit.MILLISECONDS.toSeconds(totalTimeSpentInMilliseconds) - TimeUnit.MINUTES.toSeconds(minutes) - TimeUnit.HOURS.toSeconds(hours);

        System.out.printf("Total time spent in meetings: %d hours %d min, %d sec (%d milliseconds)", hours, minutes, seconds, totalTimeSpentInMilliseconds);
    }
}

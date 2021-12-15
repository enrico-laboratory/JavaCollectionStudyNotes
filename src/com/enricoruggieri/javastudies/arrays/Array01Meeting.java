package com.enricoruggieri.javastudies.arrays;

import java.util.*;

/**
 * Interview cake
*
 */

public class Array01Meeting {

    private int startTime;
    private int endTime;

    public Array01Meeting(int startTime, int endTime) {
        // number of 30 min blocks past 9:00 am
        this.startTime = startTime;
        this.endTime   = endTime;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "Meeting{" +
                "startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }


    public static List<Array01Meeting> mergeTry(List<Array01Meeting> meetingList) {
        // sort the meeting traditional way
//        meetingList.sort(new Comparator<Meeting>() {
//            @Override
//            public int compare(Meeting meeting, Meeting t1) {
//                return meeting.getStartTime() - t1.getStartTime();
//            }
//        });

        // sort the meeting lambda
//        meetingList.sort((first, second) -> first.getStartTime() - second.getStartTime());

        // sorting using Comparator
        meetingList.sort(Comparator.comparingInt(Array01Meeting::getStartTime));

        Array01Meeting unmergedMeeting = meetingList.get(0);
        List<Array01Meeting> newMeetingList = new ArrayList<>(meetingList.size());

        // merge the meeting
        for (int i = 1; i < meetingList.size(); i++) {
            if (unmergedMeeting.getEndTime() >= meetingList.get(i).getStartTime()) {
                System.out.println("Merging meetings: " + unmergedMeeting + " with " +
                        meetingList.get(i));
                int meetingStaringTime = unmergedMeeting.getStartTime();
                int meetingEndingTime = Math.max(unmergedMeeting.getEndTime(), meetingList.get(i).getEndTime());
                unmergedMeeting = new Array01Meeting(
                        meetingStaringTime,
                        meetingEndingTime);

                System.out.println("result = " + unmergedMeeting);
            } else {
                System.out.println("Merged not needed. Adding " + unmergedMeeting );
                newMeetingList.add(unmergedMeeting);
                unmergedMeeting = meetingList.get(i);
                System.out.println("New unmerged meeting ie " + unmergedMeeting);
            }
        }
        newMeetingList.add(unmergedMeeting);
        return newMeetingList;
    }

    public static List<Array01Meeting> mergeSolution (List<Array01Meeting> meetingList) {
        // sorting list
        meetingList.sort(Comparator.comparingInt(Array01Meeting::getStartTime));


        // initialize mergedMeetings with the earliest meeting
        List<Array01Meeting> mergedMeetings = new ArrayList<>();
        mergedMeetings.add(meetingList.get(0));

        for (Array01Meeting currentMeeting : meetingList) {

            Array01Meeting lastMergedMeeting = mergedMeetings.get(mergedMeetings.size() - 1);
            System.out.println("Last merged meeting: " + lastMergedMeeting);

            // if the current meeting overlaps with the last merged meeting, use the
            // later end time of the two
            if (currentMeeting.getStartTime() <= lastMergedMeeting.getEndTime()) {
                System.out.println("Current meeting  " + currentMeeting + " startTime is less " +
                        "or equal then the last merged meeting " + lastMergedMeeting);
                System.out.println("Changing end time of the last merged meeting with the biggest between " +
                        "last Merged meeting end time (" + lastMergedMeeting.getEndTime() + ") and the current " +
                        "meeting end time (" + currentMeeting.getEndTime() + ")");
                lastMergedMeeting.setEndTime(Math.max(lastMergedMeeting.getEndTime(), currentMeeting.getEndTime()));

                // add the current meeting since it doesn't overlap
            } else {
                System.out.println("Adding " + currentMeeting + " because no overlapping found");
                mergedMeetings.add(currentMeeting);
            }
        }

        return mergedMeetings;

    }

    public static void main(String[] args) {
        Array01Meeting meeting1 = new Array01Meeting(0, 1);
        Array01Meeting meeting2 = new Array01Meeting(3, 5);
        Array01Meeting meeting3 = new Array01Meeting(4, 8);
        Array01Meeting meeting4 = new Array01Meeting(10, 12);
        Array01Meeting meeting5 = new Array01Meeting(9, 10);
        Array01Meeting meeting6 = new Array01Meeting(56, 90);
        Array01Meeting meeting7 = new Array01Meeting(67, 78);
        Array01Meeting meeting8 = new Array01Meeting(100, 103);
        Array01Meeting meeting9 = new Array01Meeting(16 , 25);
        Array01Meeting meeting10 = new Array01Meeting(3, 87);

//        Meeting meeting1 = new Meeting(1, 10);
//        Meeting meeting2 = new Meeting(2, 5);
//        Meeting meeting3 = new Meeting(4, 8);
//        Meeting meeting4 = new Meeting(5, 9);


        List<Array01Meeting> meetingList = new ArrayList<>();
        meetingList.add(meeting1);
        meetingList.add(meeting2);
        meetingList.add(meeting3);
        meetingList.add(meeting4);
        meetingList.add(meeting5);
        meetingList.add(meeting6);
        meetingList.add(meeting7);
        meetingList.add(meeting8);
        meetingList.add(meeting9);
        meetingList.add(meeting10);


        List<Array01Meeting> mergedMeetings = mergeSolution(meetingList);

        for (Array01Meeting meeting : mergedMeetings) {
            System.out.println(meeting);
        }

    }
}

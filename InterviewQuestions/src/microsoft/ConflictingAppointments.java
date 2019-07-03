package microsoft;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Given a list of appointments, tells which of them conflict with each other.
 */
public class ConflictingAppointments {

    public static void main(String[] args){
        List<Appointment> appointments = new ArrayList<>();

        appointments.add(new Appointment(1, 5));
        appointments.add(new Appointment(3, 7));
        appointments.add(new Appointment(2, 6));
        appointments.add(new Appointment(10, 15));
        appointments.add(new Appointment(5, 6));


        setConflicts(appointments);
        for (Appointment appointment: appointments){
            if (appointment.hasConflict){
                System.out.println("Start time:"
                        + appointment.startTime
                        + " and end time "
                        + appointment.endTime
                        + " has a conflict");
            }
        }

    }



    /**
     * Appointment class. SHould always be sorted by start time.
     */
    static class Appointment implements Comparable<Appointment>{
        int startTime;
        int endTime;
        boolean hasConflict;

        public Appointment(int start, int end){
            this.startTime = start;
            this.endTime = end;
            this.hasConflict = false;
        }

        @Override
        public int compareTo(Appointment anotherAppointment) {
            return this.startTime - anotherAppointment.startTime;
        }
    }

    /**
     * Checks each adjacent activity to check if they
     * have a conflict with each other.
     * @param appointments a list of appointments
     */
    public static void setConflicts(List<Appointment> appointments){
        Collections.sort(appointments);
        for (int i = 0; i < appointments.size() - 1; ++i){
            Appointment current = appointments.get(i);
            if (current.hasConflict) continue;
            Appointment next = appointments.get(i+1);
            if (next.startTime < current.endTime){
                current.hasConflict = true;
                next.hasConflict = true;
            }
        }
    }
}

package edu.duke.ece65.team2.AttendanceManager;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * The PersistenceManager class is responsible for writing the AttendanceRecord into CSV or JSON file.
 */
public class PersistenceManager {
    /**
     * The separator for the CSV file.
     */
    private final String separator = ",";
    /**
     * The new line for the CSV file.
     */
    private final String newLine = "\n";
    /**
     * The headers for the CSV file.
     */
    private final String headers = "Student ID,Student Name,Time,Status"; //more info

    /**
     * This function will write the AttendanceRecord into CSV
     * 
     * @param fileName is the file's name
     * @param session is the AttendanceSession that contain the records information
    */
    public void writeRecordsToCSV(String fileName, AttendanceSession session){
        List<AttendanceRecord> records = session.getRecords();
        try{
            FileWriter writer = new FileWriter(fileName+".csv"); //path ???
            writer.append(headers+newLine);
            for(AttendanceRecord r:records){
                writer.write(r.getStudentID()+separator);
                writer.write(r.getStudentName()+separator);
                writer.write(r.getAttendanceDate()+separator);
                writer.write(r.getStatus()+newLine);
            }
            System.out.println("Successfully create and write csv");
            writer.close();
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
        
    }

    /**
     * This function will write the AttendanceRecord into JSON
     * 
     * @param fileName is the file's name
     * @param courseName is the course's name
     * @param lectureID is the lecture's ID
     * @param session is the AttendanceSession that contain the records information
    */
    public void writeRecordsToJSON(String fileName, String courseName, String lectureID, AttendanceSession session){
        List<AttendanceRecord> records = session.getRecords();
        try{
            
            FileWriter writer = new FileWriter("export/"+fileName+".JSON"); //path ???
            writer.write("{"+newLine);
            writer.write("\"Course Name\": "+"\""+courseName+"\""+separator+newLine);
            writer.write("\"Lecture ID\": "+"\""+lectureID+"\""+separator+newLine);
            writer.write("\"Attendance\": "+"{"+newLine);
            for(AttendanceRecord r:records){
                writer.write("\""+r.getStudentID()+"\": "+"{"+newLine);
                writer.write("\"Student Name\": "+"\""+r.getStudentName()+"\""+separator+newLine);
                writer.write("\"Time\": "+"\""+r.getAttendanceDate()+"\""+separator+newLine);
                writer.write("\"Status\": "+"\""+r.getStatus()+"\""+newLine);
                if(r.equals(records.get(records.size()-1))){
                    writer.write("}"+newLine);
                }
                else{
                    writer.write("},"+newLine);
                }
            }
            writer.append("}"+newLine);
            writer.append("}");
            System.out.println("Succesfully create and write csv");

            writer.close();
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
        
    }
}

package edu.duke.ece65.team2.AttendanceManager;


import java.io.PrintStream;

/**
 * The TextUserView class is responsible for displaying information to the user in a text-based format.
 */
public class TextUserView {
    /**
     * The PrintStream used to write output to the user.
     */
  final PrintStream out;

    /**
     * Constructs a new TextUserView object with the specified PrintStream.
     * @param out The PrintStream used to write output to the user.
     */
  public TextUserView(PrintStream out){
    this.out = out;
  }

    /**
     * Prints the header for a section of text.
     * @param header The header to print.
     */
  void printHeader(String header){
    out.println("=".repeat(75));
    out.println(header);
    out.println("=".repeat(75));
  }

  /**
   * Prints the list of students in a course.
   * @param course The course to print the students for.
   */
  void printStudents(Course course){
    printHeader("Students in Course " + course.getName());
    for (int i = 0; i < course.numberOfStudents(); i++) {
      StringBuilder sb = new StringBuilder();
      sb.append(i + 1).append(". ");
      sb.append(course.getStudentName(i));
      out.println(sb.toString());
    }
  }

    /**
     * Prints the list of lectures in a course.
     * @param course The course to print the lectures for.
     */
  void printLectures(Course course) {
    printHeader("Lectures in " + course.getName());
    for (int i = 0; i < course.numberOfLectures(); i++) {
      StringBuilder sb = new StringBuilder();
      sb.append(i + 1).append(". ");
      sb.append(course.getLectureName(i));
      out.println(sb.toString());
    }
  }

    /**
     * Prints the list of courses for a professor.
     * @param professor The professor to print the courses for.
     */
  void printCourses(Professor professor) {
    printHeader("Courses Taught by " + professor.getName());
    for (int i = 0; i < professor.getCourses().size(); i++) {
            String sb = (i + 1) + ". " +
                    professor.getCourses().get(i).getCourseID() +
                    " - " +
                    professor.getCourses().get(i).getName();
            out.println(sb);
        }
    }

  /**
   * Prints the attendance status for a students in a lecture.
   * @param lecture The lecture to print the attendance status for.
   */
  void printStudentStatus(Lecture lecture) {
        printHeader("Student Statuses");
        AttendanceSession session = lecture.getAttendanceSession();
        for (AttendanceRecord record : session.getRecords()) {
            out.println(record.getStudentName() + " - " + record.getStatus());
    }
  }

  /**
   * Prints the attendance status for a list of students.
   * @param s the student to check
   */
  void studentAddCheck(Student s){
    if(s.legalName != "" && s.studentID != "" &&
       s.email != "" && s.displayName != ""){
      out.println("Student " + s.legalName +
                         "Successfully Added");
    }
    else{
      out.println("Failed to add all fields for the student");
    }
  }
}


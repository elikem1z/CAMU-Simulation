import java.util.ArrayList;

public class course{

    private String courseID;
    private String courseName;
    private double creditHours;
    // private int yearOffered;
    private boolean majorRequirement;
    private Faculty assignedFaculty;
    private String assignedFacultyIntern;
    private ArrayList<Student> enrolledStudents;




    //CONSTRUCTORS

    //-----no arg constructor
    public Course() {
        this.courseID = null; // Default value
        this.courseName = null; // Same as above
        this.creditHours = 1.0; // Default for a double field
        // this.yearOffered = 0;
        this.majorRequirement = false; // Default boolean value
        this.assignedFaculty = null; // Indicates no faculty assigned
        this.assignedFacultyIntern = null;
        this.enrolledStudents = new ArrayList<Student>();

    }


    //-----
    public Course(String courseID, String courseName, double creditHours, /*int yearOffered*/, boolean majorRequirement,
                Faculty assignedFaculty, String assignedFacultyIntern, ArrayList<Student> enrolledStudents){

        this.courseID = courseID;
        this.courseName = courseName;
        this.creditHours = creditHours;
        // this.yearOffered = yearOffered;
        this.majorRequirement = majorRequirement;
        this.assignedFaculty = assignedFaculty;
        this.assignedFacultyIntern = null;
        this.enrolledStudents = new ArrayList<Student>();
    }


    public Course(String courseID, String courseName, double creditHours, /*int yearOffered*/, boolean majorRequirement,
                    Faculty assignedFaculty, ArrayList<Student> enrolledStudents){

        this.courseID = courseID;
        this.courseName = courseName;
        this.creditHours = creditHours;
        //this.yearOffered = yearOffered;
        this.majorRequirement = majorRequirement;
        this.assignedFaculty = assignedFaculty;
        this.assignedFacultyIntern = null; //take this
        this.enrolledStudents = new ArrayList<Student>();
    }











    //Methods


    public void enrollStudent(Student student){ 
        this.enrolledStudents.add(student);
    }

    public void removeStudent(Student student){
        this.enrolledStudents.remove(Student);

        //TO DO: Check if student has actually been removed by iterating through the enrolledStudents list.

    }


    
/**
*This method handles assigning a faculty to a course, it also takes care of
*all the possible errors the user might encounter when they try to assign a faculty.
*
* @param faculty the faculty object that the user will like to assign to the course.
* @return a boolean indicating whether or not the assignment was sucessful.
*/

    public boolean assignFaculty(Faculty faculty){

        /*checking whether the Faculty object provided by is valid and not 'null'
        .This is to prevent potential 'NullPointerExceptions'*/

        // Check if the faculty object is valid
        if (faculty == null) {
            System.out.println("Error: Cannot assign an undefined faculty to " + this.courseName + ".");
            return false;
        }

        // we need to check if there's already a faculty assigned
        if (this.assignedFaculty != null){
            if (this.assignedFaculty.equals(faculty)) {
                System.out.println(faculty.name + " is already assigned to " + this.courseName + ".");
                return false; // No need to reassign if it's the same faculty
                }
            else {
                System.out.println("There is already a different faculty assigned to " + this.courseName + ".");
                return false;
            }
        }
        //assigns the faculty
        this.assignedFaculty = faculty;
        String chosenFacultyName = this.assignedFaculty.name;
        System.out.println(faculty.name + " has been successfully Assigned to " + this.courseName + ".");
        
        //This will indicate whether the assignment has been successful
        return true;
    }


/**
*.....
*This method handles removing a faculty from a course, it also takes care of
*all the possible errors the user might encounter when they try to remove a faculty.
*
* @param faculty the faculty object that the user will like to remove.
* @return a boolean indicating whether or not the removal was sucessful.
*
*
*
*/

    public boolean removeFaculty(Faculty faculty){

        //Error handling in removing a faculty in a course.
        if (this.assignedFaculty == null){
            System.out.println("Error. There is no faculty assigned to" + this.courseName + ".");
            return false; // This indicates that there was no faculty assigned to the course.
        }

        if (!this.assignedFaculty.equals(faculty)){
            System.out.println("Error: The faculty assigned to " + this.courseName + " is not the one you are trying to remove.");
            return false; // This indicates the wrong faculty was specified for removal
        }

        String chosenFacultyName = this.assignedFaculty.name; //Save the chosen faculty name in a variable to prevent a NullPointerException from occuring.
            System.out.println(chosenFacultyName + " is the faculty for " + this.courseName + ".\nRemoval in progress...");
            
            this.assignedFaculty = null; //sets the value to null ,hence removing the faculty.
            System.out.println(chosenFacultyName + " has been successfully removed from " + this.courseName + ".");

            return true; //indicates that the removal was successful
        }



}

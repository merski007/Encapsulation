package lab2;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * In this lab focus on METHOD encapsulation and fix/add code as necessary.
 * Pay special attention to the following issues:
 *    1. Not all methods need to be public
 *    2. When methods need to be called in a certain order you can do this
 *       by creating a parent method that calls the other, helper methods.
 *    3. There is some duplicate code used that violates the D.R.Y. principle.
 *       Eliminate that by encapsulating the duplicate code in a new method
 *       and then call that method in place of the duplicate code
 *    4. All method parameters should be validated.
 * 
 * Review the tips in the document "EncapCheckList.pdf" if needed.
 *
 * @author      Jim Lombardo, WCTC Instructor
 * @version     1.02
 */
public class Employee {
    private String firstName;
    private String lastName;
    private String ssn;
    private boolean metWithHr;
    private boolean metDeptStaff;
    private boolean reviewedDeptPolicies;
    private boolean movedIn;
    private String cubeId;
    private Date orientationDate;
    private Date startDate;
    
    DateUtilities date = new DateUtilities();

    public Employee(Date startDate, String firstName, String lastName, String ssn) {
        this.startDate = startDate;
        this.firstName = firstName;
        this.lastName = lastName;
        this.setSsn(ssn);
    }
    
    public void newHireMeetings(Date orientationDate, String cubeId){
        this.setOrientationDate(orientationDate);
        this.meetWithHrForBenefitAndSalryInfo();
        this.meetDepartmentStaff();
        this.reviewDeptPolicies();
        this.moveIntoCubicle(cubeId);
        
        this.outputMessages();
    }

    //1
    // Assume this must be performed first, and assume that an employee
    // would only do this once, upon being hired.
    private void meetWithHrForBenefitAndSalryInfo() {
        setMetWithHr(true);
    }
    
    //1
    // Assume this must be performed first, and assume that an employee
    // would only do this once, upon being hired.:
    private void meetDepartmentStaff() {
        setMetDeptStaff(true);
    }

    //3
    // Assume this must be performed third. And assume that because department
    // policies may change that this method may need to be called 
    // independently from other classes.
    public void reviewDeptPolicies() {
        setReviewedDeptPolicies(true);
        reviewDeptPoliciesOutputs();
    }
    
    //4
    // Assume this must be performed 4th. And assume that because employees
    // sometimes change office locations that this method may need to be called 
    // independently from other classes.
    public void moveIntoCubicle(String cubeId) {
        setCubeId(cubeId);
        setMovedIn(true);
        moveIntoCubicleOutput();
    }

    public String getFirstName() {
        return firstName;
    }

    // setter methods give the developer the power to control what data is
    // allowed through validation.
    private void setFirstName(String firstName) {
       this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    private void setLastName(String lastName) {
       this.lastName = lastName;
    }

    //should i make this private??
    public String getSsn() {
        return ssn;
    }

    private void setSsn(String ssn){
        if(ssn.length() != 9){
            throw new IllegalArgumentException("The value is not 9 digits");
        }
        else{
            this.ssn = ssn;
        }
    }

    public boolean isMetWithHr() {
        return metWithHr;
    }

    // boolean parameters need no validation
    private void setMetWithHr(boolean metWithHr) {
        this.metWithHr = metWithHr;
    }

    public boolean isMetDeptStaff() {
        return metDeptStaff;
    }

    private void setMetDeptStaff(boolean metDeptStaff) {
        this.metDeptStaff = metDeptStaff;
    }

    public boolean isReviewedDeptPolicies() {
        return reviewedDeptPolicies;
    }

    public void setReviewedDeptPolicies(boolean reviewedDeptPolicies) {
        this.reviewedDeptPolicies = reviewedDeptPolicies;
    }

    public boolean isMovedIn() {
        return movedIn;
    }

    public void setMovedIn(boolean movedIn) {
        this.movedIn = movedIn;
    }

    public String getCubeId() {
        return cubeId;
    }

    
    private void setCubeId(String cubeId) {
        if(cubeId == "A1" || cubeId == "A2" || cubeId == "A3"){
            this.cubeId = cubeId;
        }
        else{
            throw new IllegalArgumentException("The cube location does not exist");
        }
    }

    public Date getOrientationDate() {
        return orientationDate;
    }

    private void setOrientationDate(Date orientationDate) {
        if(orientationDate.before(orientationDate)){
            
        }
        this.orientationDate = orientationDate;
    }

    public Date getStartDate() {
        return startDate;
    }
    
    
    
    // NOTE: we are still violating SRP because we are using output statements
    // which is not a responsibility of this class. However, to keep things
    // simple we'll use these as placeholders for real code that would be
    // here if we spent more time on the simulation.
    
    private void meetWithHrForBenefitAndSalryInfoOutput() {    
        System.out.println(firstName + " " + lastName + " met with Hr on "
            + date.getFormattedDate(orientationDate));
    }
    
    private void meetDepartmentStaffOutput() {    
        System.out.println(firstName + " " + lastName + " met with Dept. Staff on "
            + date.getFormattedDate(orientationDate));
    }
    
    private void reviewDeptPoliciesOutputs() {       
        System.out.println(firstName + " " + lastName + " reviewed Dept policies on "
            + date.getFormattedDate(orientationDate));
    }
    
    private void moveIntoCubicleOutput() {       
        System.out.println(firstName + " " + lastName + " moved into cubicle "
                + cubeId + " on " + date.getFormattedDate(orientationDate));
    }
    
    private void outputMessages(){
        meetWithHrForBenefitAndSalryInfoOutput();
        meetDepartmentStaffOutput();
        reviewDeptPoliciesOutputs();
        moveIntoCubicleOutput();
    }
}

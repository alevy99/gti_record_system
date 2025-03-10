package ie.gti.recordsystem.model;

public class StudentAssignment {

    private Student student;

    private Assignment assignment;

    private Boolean isSubmitted;

    private Boolean isGraded;

    private Double mark;
    
    /**
     * @return the student
     */
    public Student getStudent() {
        return student;
    }

    /**
     * @param student the student to set
     */
    public void setStudent(Student student) {
        this.student = student;
    }

    /**
     * @return the assignment
     */
    public Assignment getAssignment() {
        return assignment;
    }

    /**
     * @param assignment the assignment to set
     */
    public void setAssignment(Assignment assignment) {
        this.assignment = assignment;
    }

    /**
     * @return the isSubmitted
     */
    public Boolean getIsSubmitted() {
        return isSubmitted;
    }

    /**
     * @param isSubmitted the isSubmitted to set
     */
    public void setIsSubmitted(Boolean isSubmitted) {
        this.isSubmitted = isSubmitted;
    }

    /**
     * @return the isGraded
     */
    public Boolean getIsGraded() {
        return isGraded;
    }

    /**
     * @param isGraded the isGraded to set
     */
    public void setIsGraded(Boolean isGraded) {
        this.isGraded = isGraded;
    }

    /**
     * @return the mark
     */
    public Double getMark() {
        return mark;
    }

    /**
     * @param mark the mark to set
     */
    public void setMark(Double mark) {
        this.mark = mark;
    }

}

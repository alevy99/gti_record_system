package ie.gti.recordsystem.model;

public class Course {
    
    private String name;
    
    private String code;
    
    private boolean isFullTime;

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return the isFullTime
     */
    public boolean isIsFullTime() {
        return isFullTime;
    }

    /**
     * @param isFullTime the isFullTime to set
     */
    public void setIsFullTime(boolean isFullTime) {
        this.isFullTime = isFullTime;
    }
    
}

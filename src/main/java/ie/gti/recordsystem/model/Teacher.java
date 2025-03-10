package ie.gti.recordsystem.model;

public class Teacher {
    
    private Person person;

    private String licenceCode;

    /**
     * @return the person
     */
    public Person getPerson() {
        return person;
    }

    /**
     * @param person the person to set
     */
    public void setPerson(Person person) {
        this.person = person;
    }

    /**
     * @return the licenceCode
     */
    public String getLicenceCode() {
        return licenceCode;
    }

    /**
     * @param licenceCode the licenceCode to set
     */
    public void setLicenceCode(String licenceCode) {
        this.licenceCode = licenceCode;
    }
}

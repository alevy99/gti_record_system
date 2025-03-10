package ie.gti.recordsystem.model;

import java.util.Date;

public class Assignment {

    private GroupSubject groupSubject;

    private Date openDate;

    private Date dueDate;

    /**
     * @return the groupSubject
     */
    public GroupSubject getGroupSubject() {
        return groupSubject;
    }

    /**
     * @param groupSubject the groupSubject to set
     */
    public void setGroupSubject(GroupSubject groupSubject) {
        this.groupSubject = groupSubject;
    }

    /**
     * @return the openDate
     */
    public Date getOpenDate() {
        return openDate;
    }

    /**
     * @param openDate the openDate to set
     */
    public void setOpenDate(Date openDate) {
        this.openDate = openDate;
    }

    /**
     * @return the dueDate
     */
    public Date getDueDate() {
        return dueDate;
    }

    /**
     * @param dueDate the dueDate to set
     */
    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }
}

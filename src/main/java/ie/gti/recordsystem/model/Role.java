package ie.gti.recordsystem.model;

public enum Role {

    ADMIN(1, "admin"),
    TEACHER(2, "teacher"),
    STUDENT(3, "student");

//    public enum RoleType {
//        ADMIN(1, "admin"),
//        TEACHER(2, "teacher"),
//        STUDENT(3, "student");
//
//        public final long id;
//        public final String name;
//
//        RoleType(long id, String name) {
//            this.id = id;
//            this.name = name;
//        }
//    }

    public Role(long id, String name) {
        this.id = id;
        this.name = name;
    }

    private long id;

    private String name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}

package DesingPattern.Creational;

/**
 *
 * when you want to seperate creation logic from it's representation.e.g.
 * Multiple db access. One process multiple representation
 *
 * Uniform Creation Via Interface
 * Loose Coupling
 *
 * StringBuilder
 *
 */

class Student {
    String name;
    String roll;
    String subject1;
    String subject2;
    String subject3;
    String subject4;
    String subject5;
    String subject6;

    private Student(StudentBuilder builder) {
        this.name = builder.name;
        this.roll = builder.roll;
        this.subject1 = builder.subject1;
        this.subject2 = builder.subject2;
        this.subject3 = builder.subject3;
        this.subject4 = builder.subject4;
        this.subject5 = builder.subject5;
        this.subject6 = builder.subject6;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", roll='" + roll + '\'' +
                ", subject1='" + subject1 + '\'' +
                ", subject2='" + subject2 + '\'' +
                ", subject3='" + subject3 + '\'' +
                ", subject4='" + subject4 + '\'' +
                ", subject5='" + subject5 + '\'' +
                ", subject6='" + subject6 + '\'' +
                '}';
    }

    public static class StudentBuilder {
        private String name;
        private String roll;
        private String subject1;
        private String subject2;
        private String subject3;
        private String subject4;
        private String subject5;
        private String subject6;

        public StudentBuilder(String name, String roll) {
            this.name = name;
            this.roll = roll;
        }

        public StudentBuilder setSubject1(String subject1) {
            this.subject1 = subject1;
            return this;
        }

        public StudentBuilder setSubject2(String subject2) {
            this.subject2 = subject2;
            return this;
        }

        public StudentBuilder setSubject3(String subject3) {
            this.subject3 = subject3;
            return this;
        }

        public StudentBuilder setSubject4(String subject4) {
            this.subject4 = subject4;
            return this;
        }

        public StudentBuilder setSubject5(String subject5) {
            this.subject5 = subject5;
            return this;
        }

        public StudentBuilder setSubject6(String subject6) {
            this.subject6 = subject6;
            return this;
        }

        public Student build() {
            return new Student(this);
        }
    }
}
//=================================================================================================

interface Query {
    public void execute();
}

class MongoDBQuery implements Query {
    String from;
    String where;

    @Override
    public void execute() {
        System.out.println("Mongo DB Query from " + from + " where " + where);
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public void setWhere(String where) {
        this.where = where;
    }
}

class SqlQuery implements Query {
    String from;
    String where;

    @Override
    public void execute() {
        System.out.println("Sql DB Query from " + from + " where " + where);
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public void setWhere(String where) {
        this.where = where;
    }
}

interface QueryBuilder {
    void from(String form);
    void where(String where);
    Query getQuery();
}

class MongoDBQueryBuilder implements QueryBuilder {
    MongoDBQuery query = new MongoDBQuery();

    @Override
    public void from(String form) {
        query.setFrom(form);
    }

    @Override
    public void where(String where) {
        query.setWhere(where);
    }

    @Override
    public Query getQuery() {
        return query;
    }
}

class SqlQueryBuilder implements QueryBuilder {
    SqlQuery query = new SqlQuery();

    @Override
    public void from(String form) {
        query.setFrom(form);
    }

    @Override
    public void where(String where) {
        query.setWhere(where);
    }

    @Override
    public Query getQuery() {
        return query;
    }
}

class QueryBuilderDirector {

    public Query buildQuery(String from, String where, QueryBuilder builder) {
        builder.from(from);
        builder.where(where);
        return builder.getQuery();
    }
}

public class BuilderPattern {
    public static void main(String[] args) {
        // One way of doing it
        Student student1 = new Student.StudentBuilder("Ashish", "23").
                setSubject1("Math").setSubject2("English").build();
        Student student2 = new Student.StudentBuilder("Ankita", "27").
                setSubject1("Biology").setSubject4("English").build();
        System.out.println(student1);
        System.out.println(student2);
        //Other way
        QueryBuilderDirector director = new QueryBuilderDirector();
        Query query1 = director.buildQuery("Mongo", "DB", new MongoDBQueryBuilder());
        Query query2 = director.buildQuery("SQL", "DB", new SqlQueryBuilder());
        query1.execute();
        query2.execute();
    }
}

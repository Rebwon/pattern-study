package com.rebwon;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class UnitOfWorkPatternTests {

    interface UnitOfWork<T> {

        String INSERT = "INSERT";
        String UPDATE = "UPDATE";
        String DELETE = "DELETE";

        void registerNew(T entity);

        void registerModified(T entity);

        void registerDeleted(T entity);

        void commit();
    }

    public static class StudentDB {

        public void insert(Student student) {

        }

        public void update(Student student) {

        }

        public void delete(Student student) {

        }
    }

    public static class StudentRepository implements UnitOfWork<Student> {

        private final Map<String, List<Student>> context;
        private final StudentDB studentDB;

        public StudentRepository(Map<String, List<Student>> context, StudentDB studentDB) {
            this.context = context;
            this.studentDB = studentDB;
        }

        @Override
        public void registerNew(Student entity) {
            register(entity, INSERT);
        }

        @Override
        public void registerModified(Student entity) {
            register(entity, UPDATE);
        }

        @Override
        public void registerDeleted(Student entity) {
            register(entity, DELETE);
        }

        @Override
        public void commit() {
            if (context == null || context.size() == 0) {
                return;
            }
            System.out.println("Commit start");
            if (context.containsKey(UnitOfWork.INSERT)) {
                commitInsert();
            }

            if (context.containsKey(UnitOfWork.DELETE)) {
                commitDelete();
            }

            if (context.containsKey(UnitOfWork.UPDATE)) {
                commitUpdate();
            }
            System.out.println("Commit finished");
        }

        private void commitUpdate() {
            var modifiedStudents = context.get(UnitOfWork.UPDATE);
            for (var student : modifiedStudents) {
                System.out.printf("Updating %s to database", student.getName());
                studentDB.update(student);
            }
        }

        private void commitDelete() {
            var deletedStudents = context.get(UnitOfWork.DELETE);
            for (var student : deletedStudents) {
                System.out.printf("Deleting %s to database", student.getName());
                studentDB.delete(student);
            }
        }

        private void commitInsert() {
            var studentsBeInserted = context.get(UnitOfWork.INSERT);
            for (var student : studentsBeInserted) {
                System.out.printf("Saving %s to database", student.getName());
                studentDB.insert(student);
            }
        }

        private void register(Student student, String operation) {
            var studentOperate = context.get(operation);
            if (studentOperate == null) {
                studentOperate = new ArrayList<>();
            }
            studentOperate.add(student);
            context.put(operation, studentOperate);
        }
    }

    public static class Student {
        private final Integer id;
        private final String name;
        private final String address;

        public Student(Integer id, String name, String address) {
            this.id = id;
            this.name = name;
            this.address = address;
        }

        public Integer getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getAddress() {
            return address;
        }
    }
}

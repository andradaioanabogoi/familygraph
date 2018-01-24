package com.neoworks.interviewtests.graph;

public class User {
        private String name;
        private String email;
        private int age;

        public User(String name, String email, int age) {
            this.name = name;
            this.email = email;
            this.age = age;
        }

        public String getName() {
            return name;
        }
        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }
        public void setEmail(String email) {
            this.email = email;
        }

        public int getAge() {
        return age;
    }
        public void setAge(int id) {
        this.age = age;
    }

        // creates a User Object from a data array
        protected static User createUser(String[] metadata) {
            String name = metadata[0];
            String email = metadata[1];
            int age = Integer.parseInt(metadata[2]);
            return new User(name, email, age);
        }

        @Override
        public String toString(){
            return "\nName="+getName()+"::Email"+getEmail()+"::Age="+getAge();
        }

}

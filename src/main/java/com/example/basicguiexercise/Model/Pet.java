    package com.example.basicguiexercise.Model;

    public class Pet {

        String animal;
        String name;
        String gender;
        String diet;
        String id;

        public Pet() {
        }

        public String getAnimal() {
            return animal;
        }

        public void setAnimal(String animal) {
            this.animal = animal;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getDiet() {
            return diet;
        }

        public void setDiet(String diet) {
            this.diet = diet;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Pet(String animal, String name, String gender, String diet, String id) {
            this.animal = animal;
            this.name = name;
            this.gender = gender;
            this.diet = diet;
            this.id = id;
        }
    }


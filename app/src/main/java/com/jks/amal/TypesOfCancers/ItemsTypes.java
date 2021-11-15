package com.jks.amal.TypesOfCancers;

public class ItemsTypes {

    String Name;
    String Description;
    String Causes;
    String Symptoms;
    String Therapy;
    String diagnosis;
    String details;

    public ItemsTypes(String name, String description, String causes, String symptoms, String therapy, String diagnosis, String details) {
        Name = name;
        Description = description;
        Causes = causes;
        Symptoms = symptoms;
        Therapy = therapy;
        this.diagnosis = diagnosis;
        this.details = details;
    }

    public String getName() {
        return Name;
    }


    public String getDescription() {
        return Description;
    }


    public String getCauses() {
        return Causes;
    }


    public String getSymptoms() {
        return Symptoms;
    }


    public String getTherapy() {
        return Therapy;
    }


    public String getDiagnosis() {
        return diagnosis;
    }

}
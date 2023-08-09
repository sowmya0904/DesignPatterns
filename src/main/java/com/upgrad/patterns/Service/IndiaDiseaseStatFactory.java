package com.upgrad.patterns.Service;

import com.upgrad.patterns.Interfaces.IndianDiseaseStat;
import com.upgrad.patterns.Constants.SourceType;
import com.upgrad.patterns.Strategies.DiseaseShStrategy;
import com.upgrad.patterns.Strategies.JohnHopkinsStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.upgrad.patterns.Constants.SourceType.DiseaseSh;

@Service
public class IndiaDiseaseStatFactory {
    private IndianDiseaseStat diseaseShStrategy;
    private IndianDiseaseStat johnHopkinsStrategy;
    private IndianDiseaseStat diseaseStat;

    @Autowired
    public IndiaDiseaseStatFactory(DiseaseShStrategy diseaseShStrategy, JohnHopkinsStrategy johnHopkinsStrategy) {
        this.diseaseShStrategy = diseaseShStrategy;
        this.johnHopkinsStrategy = johnHopkinsStrategy;
    }


    //create a method named GetInstance with return type as IndianDiseaseStat and parameter of type sourceType
    //create a conditional statement
    //if the sourceType is JohnHopkins
    //return johnHopkinsStrategy
    //if the sourceType is DiseaseSh
    // return diseaseShStrategy
    //create a message for invalid disease strategy/sourceType
    //throw the message as an Illegal argument exception

    public IndianDiseaseStat GetInstance(SourceType sourceType) {
        String source = sourceType.toString();
        try {
            if (source.equals("JohnHopkins")) {
                diseaseStat = johnHopkinsStrategy;
            } else if (source.equals("DiseaseSh")) {
                diseaseStat = diseaseShStrategy;
            }
        } catch (Exception e) {
            String message = String.format("Invalid source type specified. Available source type (%s, %s)", DiseaseSh, SourceType.JohnHopkins);
            throw new IllegalArgumentException(message);
        }

        return diseaseStat;
    }
}

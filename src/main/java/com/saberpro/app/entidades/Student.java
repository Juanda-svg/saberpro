package com.saberpro.app.entidades;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "students")
public class Student {
    @Id
    private String id;
    private String documentType;
    private String documentNumber;
    private String firstSurname;
    private String secondSurname;
    private String firstName;
    private String secondName;
    private String email;
    private String phoneNumber;
    private String registrationNumber;
    private Double overallScore;
    private String scoreLevel;
    private Double writtenCommunicationScore;
    private String writtenCommunicationLevel;
    private Double quantitativeReasoningScore;
    private String quantitativeReasoningLevel;
    private Double criticalReadingScore;
    private String criticalReadingLevel;
    private Double citizenshipCompetenciesScore;
    private String citizenshipCompetenciesLevel;
    private Double englishScore;
    private String englishLevel;
    private Double engineeringProjectFormulationScore;
    private String engineeringProjectFormulationLevel;
    private Double scientificThinkingMathStatsScore;
    private String scientificThinkingMathStatsLevel;
    private Double softwareDesignScore;
    private String softwareDesignLevel;
    private String englishLevelCategory;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDocumentType() {
		return documentType;
	}
	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}
	public String getDocumentNumber() {
		return documentNumber;
	}
	public void setDocumentNumber(String documentNumber) {
		this.documentNumber = documentNumber;
	}
	public String getFirstSurname() {
		return firstSurname;
	}
	public void setFirstSurname(String firstSurname) {
		this.firstSurname = firstSurname;
	}
	public String getSecondSurname() {
		return secondSurname;
	}
	public void setSecondSurname(String secondSurname) {
		this.secondSurname = secondSurname;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getSecondName() {
		return secondName;
	}
	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getRegistrationNumber() {
		return registrationNumber;
	}
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}
	public Double getOverallScore() {
		return overallScore;
	}
	public void setOverallScore(Double overallScore) {
		this.overallScore = overallScore;
	}
	public String getScoreLevel() {
		return scoreLevel;
	}
	public void setScoreLevel(String scoreLevel) {
		this.scoreLevel = scoreLevel;
	}
	public Double getWrittenCommunicationScore() {
		return writtenCommunicationScore;
	}
	public void setWrittenCommunicationScore(Double writtenCommunicationScore) {
		this.writtenCommunicationScore = writtenCommunicationScore;
	}
	public String getWrittenCommunicationLevel() {
		return writtenCommunicationLevel;
	}
	public void setWrittenCommunicationLevel(String writtenCommunicationLevel) {
		this.writtenCommunicationLevel = writtenCommunicationLevel;
	}
	public Double getQuantitativeReasoningScore() {
		return quantitativeReasoningScore;
	}
	public void setQuantitativeReasoningScore(Double quantitativeReasoningScore) {
		this.quantitativeReasoningScore = quantitativeReasoningScore;
	}
	public String getQuantitativeReasoningLevel() {
		return quantitativeReasoningLevel;
	}
	public void setQuantitativeReasoningLevel(String quantitativeReasoningLevel) {
		this.quantitativeReasoningLevel = quantitativeReasoningLevel;
	}
	public Double getCriticalReadingScore() {
		return criticalReadingScore;
	}
	public void setCriticalReadingScore(Double criticalReadingScore) {
		this.criticalReadingScore = criticalReadingScore;
	}
	public String getCriticalReadingLevel() {
		return criticalReadingLevel;
	}
	public void setCriticalReadingLevel(String criticalReadingLevel) {
		this.criticalReadingLevel = criticalReadingLevel;
	}
	public Double getCitizenshipCompetenciesScore() {
		return citizenshipCompetenciesScore;
	}
	public void setCitizenshipCompetenciesScore(Double citizenshipCompetenciesScore) {
		this.citizenshipCompetenciesScore = citizenshipCompetenciesScore;
	}
	public String getCitizenshipCompetenciesLevel() {
		return citizenshipCompetenciesLevel;
	}
	public void setCitizenshipCompetenciesLevel(String citizenshipCompetenciesLevel) {
		this.citizenshipCompetenciesLevel = citizenshipCompetenciesLevel;
	}
	public Double getEnglishScore() {
		return englishScore;
	}
	public void setEnglishScore(Double englishScore) {
		this.englishScore = englishScore;
	}
	public String getEnglishLevel() {
		return englishLevel;
	}
	public void setEnglishLevel(String englishLevel) {
		this.englishLevel = englishLevel;
	}
	public Double getEngineeringProjectFormulationScore() {
		return engineeringProjectFormulationScore;
	}
	public void setEngineeringProjectFormulationScore(Double engineeringProjectFormulationScore) {
		this.engineeringProjectFormulationScore = engineeringProjectFormulationScore;
	}
	public String getEngineeringProjectFormulationLevel() {
		return engineeringProjectFormulationLevel;
	}
	public void setEngineeringProjectFormulationLevel(String engineeringProjectFormulationLevel) {
		this.engineeringProjectFormulationLevel = engineeringProjectFormulationLevel;
	}
	public Double getScientificThinkingMathStatsScore() {
		return scientificThinkingMathStatsScore;
	}
	public void setScientificThinkingMathStatsScore(Double scientificThinkingMathStatsScore) {
		this.scientificThinkingMathStatsScore = scientificThinkingMathStatsScore;
	}
	public String getScientificThinkingMathStatsLevel() {
		return scientificThinkingMathStatsLevel;
	}
	public void setScientificThinkingMathStatsLevel(String scientificThinkingMathStatsLevel) {
		this.scientificThinkingMathStatsLevel = scientificThinkingMathStatsLevel;
	}
	public Double getSoftwareDesignScore() {
		return softwareDesignScore;
	}
	public void setSoftwareDesignScore(Double softwareDesignScore) {
		this.softwareDesignScore = softwareDesignScore;
	}
	public String getSoftwareDesignLevel() {
		return softwareDesignLevel;
	}
	public void setSoftwareDesignLevel(String softwareDesignLevel) {
		this.softwareDesignLevel = softwareDesignLevel;
	}
	public String getEnglishLevelCategory() {
		return englishLevelCategory;
	}
	public void setEnglishLevelCategory(String englishLevelCategory) {
		this.englishLevelCategory = englishLevelCategory;
	}
    
    
    
    
}
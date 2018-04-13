package com.vortice.SourcingManager.entities;

import java.sql.Date;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name="REQUEST")
public class Request {
	
	
	@Id
	@GeneratedValue
	private Integer id;
	
    private String petitioner;
    
    private String reason;
    
    private String  substitution;
    
    private String suggestedService;
    
    private ArrayList<Provider> provider;
    
    private String sugSerJust;
    
    private String observations;
    
    private String categoryFunc;
    
    private int limitRate;
    
    private String nResources;
    
    private String profile;
    
    private String technology;
    
    private Date startDate;
    
    private Date endDate;
    
    private String area;
    
    private String department;
    
    private String management;
    
    private String unity;
    
    private String code;
    
    private String descProject;
    
    private ArrayList<ReqFunctional> reqFuncts;
    
    private ArrayList<ReqTechnical> reqTechs;
    
    private String descTask;
    
    private String location;
    
    private int floor;
    
    private String place;
    
    private String typeAccess;
    
    private String platEquip;
    
    private String contact;
    
    private String mobile;
    
    private String reasonDotation;
    
    private ArrayList<LanguagesRequest> languages;
    
    private String guards;
    
    private ArrayList<Cv> cv;


}

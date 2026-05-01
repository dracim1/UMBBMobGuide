package com.example.umbbmobguide;

import java.util.ArrayList;
import java.util.HashMap;

public class DataManager {

    // ===== Faculties =====
    public static ArrayList<faculty> getFaculties() {
        ArrayList<faculty> list = new ArrayList<>();

        list.add(new faculty(R.drawable.inimm,
                "Faculty of Sciences", "6 Departments",
                "This faculty covers Mathematics, Physics, Chemistry, Computer Science, Biology, and Agronomy.",
                "+213 24 81 66 20", "science@univ-boumerdes.dz",
                "Boumerdes University Campus", 36.7538, 3.4774));

        list.add(new faculty(R.drawable.ft,
                "Faculty of Technology", "4 Departments",
                "This faculty covers Mechanical, Civil, Electrical, and Process Engineering.",
                "+213 24 81 66 30", "tech@univ-boumerdes.dz",
                "Boumerdes University Campus", 36.7538, 3.4774));

        list.add(new faculty(R.drawable.fhc,
                "Faculty of Hydrocarbons and Chemistry", "4 Departments",
                "This faculty covers Petroleum Engineering, Transport, Chemical Engineering, and Automation.",
                "+213 24 81 66 10", "fhc@univ-boumerdes.dz",
                "Boumerdes University Campus", 36.7538, 3.4774));

        list.add(new faculty(R.drawable.fd,
                "Faculty of Economics, Commerce and Management", "4 Departments",
                "This faculty covers Economics, Management, Commerce, and Finance.",
                "+213 24 81 66 50", "economics@univ-boumerdes.dz",
                "Boumerdes University Campus", 36.7538, 3.4774));

        list.add(new faculty(R.drawable.fd,
                "Faculty of Law and Political Science", "2 Departments",
                "This faculty covers Law and Political Science.",
                "+213 24 81 66 50", "law@univ-boumerdes.dz",
                "Boumerdes University Campus", 36.7538, 3.4774));

        list.add(new faculty(R.drawable.fll,
                "Faculty of Letters and Languages", "3 Departments",
                "This faculty covers Arabic, French, and English language studies.",
                "+213 24 81 66 60", "languages@univ-boumerdes.dz",
                "Boumerdes University Campus", 36.7538, 3.4774));

        list.add(new faculty(R.drawable.igee,
                "Institute of Electrical and Electronic Engineering (IGEE)", "2 Departments",
                "This institute covers Electronics and Electrotechnics.",
                "+213 24 81 66 40", "igee@univ-boumerdes.dz",
                "Boumerdes University Campus", 36.7538, 3.4774));

        list.add(new faculty(R.drawable.img_1,
                "Institute of Applied Sciences and Techniques (ISTA)", "1 Department",
                "This institute covers Metrology and Quality Control.",
                "+213 24 81 66 70", "ista@univ-boumerdes.dz",
                "Boumerdes University Campus", 36.7538, 3.4774));

        return list;
    }

    // ===== Departments and Specialties =====
    
    public static ArrayList<Department> getDepartmentsForFaculty(String facultyName) {
        HashMap<String, ArrayList<Department>> facultyDepartments = getAllDepartments();
        ArrayList<Department> departments = facultyDepartments.get(facultyName);
        return departments != null ? departments : new ArrayList<>();
    }
    
    private static HashMap<String, ArrayList<Department>> getAllDepartments() {
        HashMap<String, ArrayList<Department>> map = new HashMap<>();
        
        // ===== Faculty of Sciences =====
        ArrayList<Department> scienceDepts = new ArrayList<>();
        
        ArrayList<String> mathSpecialties = new ArrayList<>();
        mathSpecialties.add("License: Mathematics");
        mathSpecialties.add("Master: Applied Mathematics");
        mathSpecialties.add("Master: Analysis");
        scienceDepts.add(new Department("Department of Mathematics", 
            "Mathematics department offering comprehensive programs in pure and applied mathematics", 
            mathSpecialties));
        
        ArrayList<String> physicsSpecialties = new ArrayList<>();
        physicsSpecialties.add("License: Physics");
        physicsSpecialties.add("Master: Materials Physics");
        physicsSpecialties.add("Master: Energetics");
        scienceDepts.add(new Department("Department of Physics", 
            "Physics department covering fundamental and applied physics", 
            physicsSpecialties));
        
        ArrayList<String> chemistrySpecialties = new ArrayList<>();
        chemistrySpecialties.add("License: Chemistry");
        chemistrySpecialties.add("Master: Organic Chemistry");
        chemistrySpecialties.add("Master: Analytical Chemistry");
        scienceDepts.add(new Department("Department of Chemistry", 
            "Chemistry department specializing in organic and analytical chemistry", 
            chemistrySpecialties));
        
        ArrayList<String> csSpecialties = new ArrayList<>();
        csSpecialties.add("License: Informatique");
        csSpecialties.add("Master: Artificial Intelligence");
        csSpecialties.add("Master: Data Science");
        csSpecialties.add("Master: Software Engineering");
        scienceDepts.add(new Department("Department of Computer Science", 
            "Computer science department covering AI, Data Science, and Software Engineering", 
            csSpecialties));
        
        ArrayList<String> biologySpecialties = new ArrayList<>();
        biologySpecialties.add("License: Biology");
        biologySpecialties.add("Master: Microbiology");
        biologySpecialties.add("Master: Biotechnology");
        scienceDepts.add(new Department("Department of Biology", 
            "Biology department covering microbiology and biotechnology", 
            biologySpecialties));
        
        ArrayList<String> agronomySpecialties = new ArrayList<>();
        agronomySpecialties.add("License: Agronomy");
        agronomySpecialties.add("Master: Plant Production");
        scienceDepts.add(new Department("Department of Agronomy", 
            "Agronomy department focusing on plant production and agricultural sciences", 
            agronomySpecialties));
        
        map.put("Faculty of Sciences", scienceDepts);
        
        // ===== Faculty of Technology =====
        ArrayList<Department> techDepts = new ArrayList<>();
        
        ArrayList<String> mechSpecialties = new ArrayList<>();
        mechSpecialties.add("License: Mechanical Engineering");
        mechSpecialties.add("Master: Industrial Mechanics");
        techDepts.add(new Department("Department of Mechanical Engineering", 
            "Mechanical engineering department specializing in industrial mechanics", 
            mechSpecialties));
        
        ArrayList<String> civilSpecialties = new ArrayList<>();
        civilSpecialties.add("License: Civil Engineering");
        civilSpecialties.add("Master: Structures");
        civilSpecialties.add("Master: Public Works");
        techDepts.add(new Department("Department of Civil Engineering", 
            "Civil engineering department covering structures and public works", 
            civilSpecialties));
        
        ArrayList<String> elecSpecialties = new ArrayList<>();
        elecSpecialties.add("License: Electrical Engineering");
        elecSpecialties.add("Master: Electrical Systems");
        elecSpecialties.add("Master: Automation");
        techDepts.add(new Department("Department of Electrical Engineering", 
            "Electrical engineering department focusing on electrical systems and automation", 
            elecSpecialties));
        
        ArrayList<String> processSpecialties = new ArrayList<>();
        processSpecialties.add("License: Process Engineering");
        processSpecialties.add("Master: Industrial Processes");
        techDepts.add(new Department("Department of Process Engineering", 
            "Process engineering department specializing in industrial processes", 
            processSpecialties));
        
        map.put("Faculty of Technology", techDepts);
        
        // ===== Faculty of Hydrocarbons and Chemistry =====
        ArrayList<Department> hydrocarbonsDepts = new ArrayList<>();
        
        ArrayList<String> petroleumSpecialties = new ArrayList<>();
        petroleumSpecialties.add("License: Hydrocarbons");
        petroleumSpecialties.add("Master: Reservoir Engineering");
        hydrocarbonsDepts.add(new Department("Department of Petroleum Engineering", 
            "Petroleum engineering department focusing on reservoir engineering", 
            petroleumSpecialties));
        
        ArrayList<String> transportSpecialties = new ArrayList<>();
        transportSpecialties.add("License: Transport of Hydrocarbons");
        transportSpecialties.add("Master: Pipelines and Equipment");
        hydrocarbonsDepts.add(new Department("Department of Transport and Equipment", 
            "Department specializing in hydrocarbon transport and pipeline equipment", 
            transportSpecialties));
        
        ArrayList<String> chemicalSpecialties = new ArrayList<>();
        chemicalSpecialties.add("License: Chemical Engineering");
        chemicalSpecialties.add("Master: Petrochemistry");
        hydrocarbonsDepts.add(new Department("Department of Chemical Engineering", 
            "Chemical engineering department focusing on petrochemistry", 
            chemicalSpecialties));
        
        ArrayList<String> automationSpecialties = new ArrayList<>();
        automationSpecialties.add("License: Industrial Automation");
        automationSpecialties.add("Master: Process Control");
        hydrocarbonsDepts.add(new Department("Department of Automation", 
            "Automation department specializing in industrial automation and process control", 
            automationSpecialties));
        
        map.put("Faculty of Hydrocarbons and Chemistry", hydrocarbonsDepts);
        
        // ===== Faculty of Economics, Commerce and Management =====
        ArrayList<Department> economicsDepts = new ArrayList<>();
        
        ArrayList<String> econSpecialties = new ArrayList<>();
        econSpecialties.add("License: Economics");
        econSpecialties.add("Master: Applied Economics");
        economicsDepts.add(new Department("Department of Economics", 
            "Economics department covering theoretical and applied economics", 
            econSpecialties));
        
        ArrayList<String> mgmtSpecialties = new ArrayList<>();
        mgmtSpecialties.add("License: Management");
        mgmtSpecialties.add("Master: Business Administration");
        economicsDepts.add(new Department("Department of Management", 
            "Management department focusing on business administration", 
            mgmtSpecialties));
        
        ArrayList<String> commerceSpecialties = new ArrayList<>();
        commerceSpecialties.add("License: Commercial Sciences");
        commerceSpecialties.add("Master: Marketing");
        economicsDepts.add(new Department("Department of Commerce", 
            "Commerce department specializing in commercial sciences and marketing", 
            commerceSpecialties));
        
        ArrayList<String> financeSpecialties = new ArrayList<>();
        financeSpecialties.add("License: Finance");
        financeSpecialties.add("Master: Accounting and Finance");
        economicsDepts.add(new Department("Department of Finance and Accounting", 
            "Finance department covering accounting and financial management", 
            financeSpecialties));
        
        map.put("Faculty of Economics, Commerce and Management", economicsDepts);
        
        // ===== Faculty of Law and Political Science =====
        ArrayList<Department> lawDepts = new ArrayList<>();
        
        ArrayList<String> lawSpecialties = new ArrayList<>();
        lawSpecialties.add("License: Law");
        lawSpecialties.add("Master: Public Law");
        lawSpecialties.add("Master: Private Law");
        lawDepts.add(new Department("Department of Law", 
            "Law department covering public and private law", 
            lawSpecialties));
        
        ArrayList<String> poliSciSpecialties = new ArrayList<>();
        poliSciSpecialties.add("License: Political Science");
        poliSciSpecialties.add("Master: International Relations");
        lawDepts.add(new Department("Department of Political Science", 
            "Political science department focusing on international relations", 
            poliSciSpecialties));
        
        map.put("Faculty of Law and Political Science", lawDepts);
        
        // ===== Faculty of Letters and Languages =====
        ArrayList<Department> languagesDepts = new ArrayList<>();
        
        ArrayList<String> arabicSpecialties = new ArrayList<>();
        arabicSpecialties.add("License: Arabic Language");
        arabicSpecialties.add("Master: Arabic Literature");
        languagesDepts.add(new Department("Department of Arabic", 
            "Arabic department covering language and literature", 
            arabicSpecialties));
        
        ArrayList<String> frenchSpecialties = new ArrayList<>();
        frenchSpecialties.add("License: French");
        frenchSpecialties.add("Master: Linguistics");
        languagesDepts.add(new Department("Department of French", 
            "French department focusing on language and linguistics", 
            frenchSpecialties));
        
        ArrayList<String> englishSpecialties = new ArrayList<>();
        englishSpecialties.add("License: English");
        englishSpecialties.add("Master: Applied Linguistics");
        languagesDepts.add(new Department("Department of English", 
            "English department covering language and applied linguistics", 
            englishSpecialties));
        
        map.put("Faculty of Letters and Languages", languagesDepts);
        
        // ===== Institute of Electrical and Electronic Engineering (IGEE) =====
        ArrayList<Department> igeeDepts = new ArrayList<>();
        
        ArrayList<String> electronicsSpecialties = new ArrayList<>();
        electronicsSpecialties.add("License: Electronics");
        electronicsSpecialties.add("Master: Embedded Systems");
        igeeDepts.add(new Department("Department of Electronics", 
            "Electronics department focusing on embedded systems", 
            electronicsSpecialties));
        
        ArrayList<String> electroSpecialties = new ArrayList<>();
        electroSpecialties.add("License: Electrotechnics");
        electroSpecialties.add("Master: Control Systems");
        igeeDepts.add(new Department("Department of Electrotechnics and Automation", 
            "Department specializing in electrotechnics and control systems", 
            electroSpecialties));
        
        map.put("Institute of Electrical and Electronic Engineering (IGEE)", igeeDepts);
        
        // ===== Institute of Applied Sciences and Techniques (ISTA) =====
        ArrayList<Department> istaDepts = new ArrayList<>();
        
        ArrayList<String> metrologySpecialties = new ArrayList<>();
        metrologySpecialties.add("License: Instrumentation");
        metrologySpecialties.add("Master: Industrial Quality");
        istaDepts.add(new Department("Department of Metrology and Quality", 
            "Department specializing in instrumentation and industrial quality control", 
            metrologySpecialties));
        
        map.put("Institute of Applied Sciences and Techniques (ISTA)", istaDepts);
        
        return map;
    }
    
    // ===== Search Data =====
    public static String[][] getSearchData() {
        return new String[][] {
                {"Faculty of Sciences", "Faculty", ""},
                {"Faculty of Technology", "Faculty", ""},
                {"Faculty of Hydrocarbons and Chemistry", "Faculty", ""},
                {"Faculty of Economics, Commerce and Management", "Faculty", ""},
                {"Faculty of Law and Political Science", "Faculty", ""},
                {"Faculty of Letters and Languages", "Faculty", ""},
                {"Institute of Electrical and Electronic Engineering (IGEE)", "Institute", ""},
                {"Institute of Applied Sciences and Techniques (ISTA)", "Institute", ""},
        };
    }
}

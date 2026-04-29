QaBrainsAPIAutomation 🚀
API Test Automation Framework using RestAssured

A robust and scalable API automation framework built using RestAssured to validate RESTful services of the QaBrains platform. This project demonstrates modern QA engineering practices with a focus on clean architecture, reusability, and real-world API testing scenarios.

🚀 Overview

QaBrainsAPIAutomation is designed to test backend services by validating API endpoints, request-response flows, and data integrity.

The framework simulates real-world API interactions such as authentication, CRUD operations, and end-to-end workflows—ensuring high-quality and reliable backend systems.

This project reflects industry-standard API automation practices, making it ideal for portfolios, interviews, and production-ready solutions.

🛠️ Tech Stack Language
: Java API Automation
: RestAssured Test Framework
: TestNG Build Tool
: Maven Data Handling
: JSON / POJO Reporting
: Extent Reports (optional) CI/CD
: Jenkins / GitHub Actions (ready) 
📁 Project Structure QaBrainsAPIAutomation/ 
│ ├── src/test/java/ 
│ ├── tests/ # Test classes 
│ ├── base/ # Base setup (config, request specs)
│ ├── utils/ # Utility classes (helpers, data readers) 
│ └── listeners/ # TestNG listeners & reporting 
│ ├── src/main/java/ 
│ └── models/ # POJO classes for request/response 
│ ├── testng.xml # TestNG suite configuration ├
── pom.xml # Maven dependencies 
└── README.md # Project documentation 
🎯 Test Coverage 
🔐 Authentication APIs Token generation Authorization validation 
📦 CRUD Operations Create, Read, Update, Delete endpoints Request & response validation 
🔎 Response Validation Status code verification JSON schema validation Header and body assertions 
⚠️ Negative Testing Invalid payloads Unauthorized requests Error handling validation 
🔄 End-to-End API Flows Chained API requests Dynamic data extraction and reuse 
⚙️ Framework Highlights

✔️ RestAssured-based fluent API testing 
✔️ Modular and scalable architecture 
✔️ Reusable request specifications 
✔️ POJO-based serialization & deserialization 
✔️ Centralized configuration management 
✔️ TestNG integration for execution control 
✔️ Data-driven testing support 
✔️ CI/CD ready framework

▶️ Running the Tests Using Maven mvn clean test Using TestNG Suite mvn test -DsuiteXmlFile=testng.xml Using IDE (Eclipse / IntelliJ) Right-click on test class or testng.xml Select Run As → TestNG Test 

📌 Prerequisites Java (JDK 8 or higher) Maven installed IDE (Eclipse / IntelliJ) 
Basic understanding of REST APIs Access to QaBrains API endpoints 
📈 Future Enhancements Integrate advanced reporting (Allure / Extent Reports) Add CI/CD pipeline (GitHub Actions / Jenkins) Enable parallel execution Implement advanced schema validation Add database validation (API + DB testing) Integrate contract testing (e.g., Pact) Support environment-based execution 

🤝 Contribution

Contributions are welcome! Feel free to fork the repository, create feature branches, and submit pull requests.

👨‍💻 Author

Ranajit B. Chowdhury ,Software Programmer and QA Automation Engineer | API & UI Automation | Manual Testing

📄 Summary

QaBrains API Automation is a real-world, industry-aligned API automation framework built using RestAssured. It showcases strong backend testing capabilities including request validation, response assertions, and scalable framework design.

This project demonstrates:

API automation expertise Clean and maintainable code structure Real-world testing practices CI/CD readiness

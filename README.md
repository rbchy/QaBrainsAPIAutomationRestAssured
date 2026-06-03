# QaBrainsAPIAutomation 🚀

<div align="center">

<!-- ═══════════════════════════════════════════════════════════ -->
<!--                    IDENTITY BADGES                          -->
<!-- ═══════════════════════════════════════════════════════════ -->

[![Author](https://img.shields.io/badge/Author-Ranajit%20Baran%20Chowdhury-0A66C2?style=for-the-badge&logo=github&logoColor=white)](https://github.com/ranajitchowdhury)
[![Email](https://img.shields.io/badge/Email-chyranajit%40gmail.com-D14836?style=for-the-badge&logo=gmail&logoColor=white)](mailto:chyranajit@gmail.com)
[![GitHub](https://img.shields.io/badge/GitHub-%40ranajitchowdhury-181717?style=for-the-badge&logo=github&logoColor=white)](https://github.com/ranajitchowdhury)

<!-- ═══════════════════════════════════════════════════════════ -->
<!--                    TECH STACK BADGES                        -->
<!-- ═══════════════════════════════════════════════════════════ -->

![Java](https://img.shields.io/badge/Java-17%2B-007396?style=for-the-badge&logo=openjdk&logoColor=white)
![RestAssured](https://img.shields.io/badge/RestAssured-5.x-43B02A?style=for-the-badge&logo=java&logoColor=white)
![TestNG](https://img.shields.io/badge/TestNG-7.x-FF6C37?style=for-the-badge&logo=testng&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-3.x-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)
![Jackson](https://img.shields.io/badge/Jackson%20%2F%20Gson-Serialization-8B0000?style=for-the-badge&logo=java&logoColor=white)
![ExtentReports](https://img.shields.io/badge/Extent%20Reports-5.x-6A0DAD?style=for-the-badge)
![GitHub Actions](https://img.shields.io/badge/GitHub%20Actions-CI%2FCD-2088FF?style=for-the-badge&logo=githubactions&logoColor=white)
![Jenkins](https://img.shields.io/badge/Jenkins-Pipeline%20Ready-D24939?style=for-the-badge&logo=jenkins&logoColor=white)


</div>

---

> A production-grade API test automation framework built with **RestAssured** and **Java** to validate the complete RESTful service layer of the **QaBrains** platform. This project demonstrates dual expertise in **software engineering** and **API quality assurance** — implementing clean layered architecture, POJO-based serialization, reusable request specifications, and CI/CD-ready execution pipelines that mirror enterprise delivery standards.

---

## 🎯 Project Mission

The QaBrains platform exposes a suite of RESTful APIs powering its authentication, content management, and user interaction workflows. This framework establishes a **living contract test suite** around those services — ensuring every endpoint behaves as specified across environments, data conditions, and user roles.

This is not a collection of isolated test methods. It is a **structured automation framework** where tests are modular, configurations are centralized, models are strongly typed via POJOs, and execution is fully automatable from the command line — integrable into any CI/CD pipeline with zero modification.

---

## 🚀 Key Framework Highlights

### Fluent RestAssured DSL
Every API interaction is authored using **RestAssured's Given-When-Then fluent API** — mirroring the BDD style of Gherkin without the Cucumber overhead. Tests are readable, expressive, and self-documenting at the method level.

### Reusable Request Specifications
`RequestSpecification` objects are defined once in the base layer and reused across all test classes. Base URIs, authentication headers, content types, and default query parameters are configured centrally — eliminating duplication and making environment switches a single-line change.

### POJO-Based Serialization and Deserialization
Request payloads and response bodies are mapped to **strongly typed Java POJO classes** using Jackson or Gson. This eliminates raw JSON string manipulation, provides compile-time safety, and makes assertions on deeply nested response structures clean and readable.

### Centralized Configuration Management
All environment-specific values — base URLs, API keys, credentials, and timeouts — are externalized to a `config.properties` file and accessed via a singleton `ConfigReader` utility. No hardcoded values exist anywhere in the test code.

### TestNG Integration
**TestNG** provides full control over test suite composition — grouping by module (`@Test(groups = "auth")`), sequencing dependent tests (`@Test(dependsOnMethods = ...)`), parallel execution across test classes, and rich listener hooks for reporting and failure handling.

### Extent Reports
Every execution produces an **Extent HTML Report** — an interactive dashboard with test-level pass/fail status, request/response logs, execution timelines, and failure details — suitable for attaching to sprint review artifacts or defect tickets.

### Data-Driven Testing
Test methods are parameterized using **TestNG `@DataProvider`**, enabling a single test definition to validate multiple input combinations — valid payloads, boundary values, and malformed inputs — without duplicating test logic.

### CI/CD Ready
The framework executes headlessly via `mvn clean test` with no GUI dependency. A pre-configured **GitHub Actions** workflow ships with the repository, triggering the full suite on every push and pull request.

---

## 🛠 Tech Stack & Tools

| Component | Technology | Version | Purpose |
| :--- | :--- | :--- | :--- |
| **Language** | Java | 17+ | Core programming, OOP design, and type-safe test logic |
| **API Automation** | RestAssured | 5.x | Fluent HTTP client for REST API request and response handling |
| **Test Framework** | TestNG | 7.x | Suite management, grouping, parallel execution, and listeners |
| **Build Tool** | Apache Maven | 3.x | Dependency management, build lifecycle, and CI integration |
| **Serialization** | Jackson / Gson | Latest | POJO ↔ JSON serialization and deserialization |
| **Reporting** | Extent Reports | 5.x | Interactive HTML execution dashboards |
| **Data Handling** | JSON / TestNG DataProvider | — | Data-driven test parameterization |
| **Configuration** | Java Properties API | — | Environment-agnostic config management |
| **CI/CD** | GitHub Actions / Jenkins | — | Pipeline integration for automated scheduled runs |
| **IDE** | Eclipse / IntelliJ IDEA | — | Development, debugging, and run configuration |

---

## 📁 Project Structure

```text
QaBrainsAPIAutomation/
│
├── src/
│   ├── main/
│   │   └── java/
│   │       └── models/
│   │           ├── request/
│   │           │   ├── LoginRequest.java          # Login endpoint request POJO
│   │           │   ├── CreateUserRequest.java     # User creation request POJO
│   │           │   └── UpdateCourseRequest.java   # Course update request POJO
│   │           └── response/
│   │               ├── LoginResponse.java         # Login endpoint response POJO
│   │               ├── UserResponse.java          # User retrieval response POJO
│   │               └── ErrorResponse.java         # Standard error response POJO
│   │
│   └── test/
│       └── java/
│           ├── base/
│           │   ├── BaseTest.java                  # Test lifecycle hooks (@Before/@After)
│           │   └── RequestSpecBuilder.java        # Centralized RequestSpecification factory
│           │
│           ├── tests/
│           │   ├── AuthTests.java                 # Authentication endpoint test cases
│           │   ├── UserTests.java                 # User management CRUD test cases
│           │   ├── CourseTests.java               # Course catalog CRUD test cases
│           │   ├── EnrollmentTests.java           # Enrollment workflow test cases
│           │   └── NegativeTests.java             # Boundary, invalid, unauthorized tests
│           │
│           ├── utils/
│           │   ├── ConfigReader.java              # config.properties singleton accessor
│           │   ├── JsonUtils.java                 # JSON read/write and assertion helpers
│           │   ├── DataProviders.java             # TestNG @DataProvider methods
│           │   └── TokenManager.java              # Auth token extraction and caching
│           │
│           └── listeners/
│               ├── ExtentReportListener.java      # Extent Report lifecycle manager
│               └── TestNGRetryAnalyzer.java       # Flaky test retry logic
│
├── src/test/resources/
│   ├── config.properties                          # Environment configuration (URL, creds)
│   ├── test-data/
│   │   ├── valid_users.json                       # Positive test payload sets
│   │   ├── invalid_users.json                     # Negative / boundary payload sets
│   │   └── course_data.json                       # Course module data sets
│   └── schemas/
│       ├── login_response_schema.json             # JSON schema for login response
│       └── user_response_schema.json              # JSON schema for user response
│
├── test-output/
│   └── ExtentReport.html                          # Auto-generated HTML execution report
│
├── .github/
│   └── workflows/
│       └── api-tests.yml                          # GitHub Actions CI/CD pipeline
│
├── testng.xml                                     # TestNG suite and group configuration
├── pom.xml                                        # Maven dependencies and Surefire config
└── README.md                                      # Project documentation
```

---

## 🌐 API Modules Under Test

| Module | Endpoint Group | Scenarios Covered |
| :--- | :--- | :--- |
| **Authentication** | `/auth/login`, `/auth/logout`, `/auth/refresh` | Valid login, invalid credentials, token expiry, refresh flow |
| **User Management** | `/users`, `/users/{id}` | Create, read, update, delete; field-level assertions |
| **Course Catalog** | `/courses`, `/courses/{id}` | List, create, update, delete; pagination and filter validation |
| **Enrollment** | `/enrollments`, `/enrollments/{id}` | Enroll, verify status, cancel; conflict handling |
| **Search** | `/search?q=` | Valid queries, empty strings, special characters, no-results |
| **Error Handling** | All endpoints | `400`, `401`, `403`, `404`, `409`, `422`, `500` contract validation |

---

## 🎯 Test Coverage Matrix

### 🔐 Authentication APIs
- Token generation on valid credentials; assert `200` and token presence
- Authorization header propagation across all protected endpoints
- Session expiry and token refresh behavior
- Unauthorized access rejection — assert `401` with correct error body

### 📦 CRUD Operations
- `POST` — Resource creation with valid POJO payload; assert `201 Created` and `Location` header
- `GET` — Single and collection retrieval; assert response schema and field values
- `PUT` / `PATCH` — Full and partial updates; assert field-level mutation in response
- `DELETE` — Soft and hard delete; assert `204 No Content` or `200 OK`

### 🔎 Response Validation
- HTTP status code assertion on every request
- JSON schema validation against pre-defined schema files in `resources/schemas/`
- Key/value assertions on critical response fields using RestAssured `body()` matchers
- Response time assertions for SLA compliance (`time < 2000ms`)
- Response header validation — `Content-Type`, `Authorization`, `Cache-Control`

### ⚠️ Negative Testing
- Missing required fields → assert `422 Unprocessable Entity`
- Incorrect data types in payload → assert `400 Bad Request`
- Duplicate resource creation → assert `409 Conflict`
- Non-existent resource access → assert `404 Not Found`
- Expired or missing token → assert `401 Unauthorized`
- Insufficient role permissions → assert `403 Forbidden`

### 🔄 End-to-End API Flows
- **Login → Get User Profile → Update Profile → Logout**
- **Create Course → Enroll User → Verify Enrollment → Delete Course**
- **Register User → Authenticate → Access Protected Resource → Revoke Token**

---

## ⚙️ Setup & Installation

### Prerequisites

- Java JDK 17+
- Apache Maven 3.6+
- Eclipse IDE or IntelliJ IDEA
- Access to QaBrains API endpoints (Dev or Test environment)

### Clone the Repository

```bash
git clone https://github.com/ranajitchowdhury/QaBrainsAPIAutomation.git
cd QaBrainsAPIAutomation
```

### Configure the Environment

Edit `src/test/resources/config.properties`:

```properties
base.url=https://api.practice.qabrains.com
auth.username=testuser@qabrains.com
auth.password=Test@1234
connect.timeout=10000
read.timeout=20000
```

### Install Dependencies

```bash
mvn clean install -DskipTests
```

---

## ▶️ Running the Tests

### Run the Full Suite

```bash
mvn clean test
```

### Run a Specific TestNG Suite

```bash
mvn test -DsuiteXmlFile=testng.xml
```

### Run by Group Tag

```bash
# Run authentication tests only
mvn test -Dgroups=auth

# Run smoke suite
mvn test -Dgroups=smoke

# Run full regression
mvn test -Dgroups=regression
```

### Run a Single Test Class

```bash
mvn test -Dtest=AuthTests
```

### Run from IDE

1. Right-click `testng.xml` → **Run As → TestNG Suite**
2. Or right-click any test class → **Run As → TestNG Test**

---

## 📊 Sample Test — Login API

```java
@Test(groups = {"smoke", "auth"}, description = "Valid login returns 200 and auth token")
public void testValidLogin() {

    // Arrange — build request POJO
    LoginRequest loginRequest = new LoginRequest();
    loginRequest.setUsername(ConfigReader.get("auth.username"));
    loginRequest.setPassword(ConfigReader.get("auth.password"));

    // Act — execute POST /auth/login
    LoginResponse response =
        given()
            .spec(RequestSpecBuilder.getBaseSpec())
            .body(loginRequest)
        .when()
            .post("/auth/login")
        .then()
            .statusCode(200)
            .time(lessThan(2000L))
            .header("Content-Type", containsString("application/json"))
            .body("token", not(emptyOrNullString()))
            .body("user.email", equalTo(ConfigReader.get("auth.username")))
            .body("user.role", notNullValue())
        .extract()
            .as(LoginResponse.class);

    // Cache token for downstream tests
    TokenManager.setToken(response.getToken());

    Assert.assertNotNull(response.getToken(), "Auth token must not be null");
    Assert.assertEquals(response.getUser().getEmail(), ConfigReader.get("auth.username"));
}

@Test(groups = {"regression", "negative"}, description = "Invalid credentials return 401")
public void testInvalidLoginCredentials() {

    LoginRequest loginRequest = new LoginRequest("invalid@test.com", "wrongpassword");

    given()
        .spec(RequestSpecBuilder.getBaseSpec())
        .body(loginRequest)
    .when()
        .post("/auth/login")
    .then()
        .statusCode(401)
        .body("error", equalTo("Invalid credentials"))
        .body("message", not(emptyOrNullString()));
}
```

---

## 🔄 CI/CD Pipeline Integration

```yaml
# .github/workflows/api-tests.yml
name: QaBrains RestAssured API Test Suite

on:
  push:
    branches: [ main ]
  pull_request:
    branches: [ main ]

jobs:
  api-tests:
    runs-on: ubuntu-latest

    steps:
      - name: Checkout repository
        uses: actions/checkout@v3

      - name: Set up Java 17
        uses: actions/setup-java@v3
        with:
          java-version: '17'
          distribution: 'temurin'

      - name: Cache Maven packages
        uses: actions/cache@v3
        with:
          path: ~/.m2
          key: ${{ runner.os }}-m2-${{ hashFiles('**/pom.xml') }}

      - name: Run API Test Suite
        run: mvn clean test --no-transfer-progress

      - name: Upload Extent Report
        if: always()
        uses: actions/upload-artifact@v3
        with:
          name: API-Extent-Report
          path: test-output/ExtentReport.html
```

---

## 📈 Roadmap — Future Enhancements

- [ ] **Allure Report Integration** — richer, interactive execution dashboards with trend analysis
- [ ] **Parallel Execution** — configure TestNG `parallel="methods"` for faster regression cycles
- [ ] **Database Validation** — cross-validate API responses against backend DB state via JDBC
- [ ] **Contract Testing with Pact** — consumer-driven contract validation to catch breaking API changes early
- [ ] **Multi-Environment Matrix** — parameterize `config.properties` selection via Maven profiles
- [ ] **Jenkins Pipeline** — add `Jenkinsfile` for Jenkins-based CI infrastructure
- [ ] **Secrets Management** — integrate with GitHub Secrets / HashiCorp Vault for credential injection
- [ ] **Response Caching Layer** — cache repeated `GET` responses within a suite run to reduce API call volume

---

## 🏗 Design Principles

### Separation of Concerns
Test logic, API interaction (request specs), data models (POJOs), and infrastructure (utilities, config) are cleanly separated. No layer reaches into another's internals — only its public interface.

### Strongly Typed Models Over Raw JSON
Raw JSON string manipulation is replaced everywhere with **POJO deserialization**. This gives compile-time safety, IDE autocomplete, and eliminates typo-driven test failures.

### DRY — One Source of Truth
`RequestSpecBuilder` is authored once. `ConfigReader` is a singleton. `TokenManager` caches the auth token once per suite. Nothing is duplicated across test classes.

### Fail Fast with Meaningful Errors
All assertions produce actionable failure messages. Extent Reports and TestNG's detailed stack traces ensure every defect contains sufficient context for immediate triage.

### Configuration-Driven, Environment-Agnostic
No credentials or base URLs live inside test code. The framework is promoted from Dev to Test to Staging by changing a single properties file — or injecting a Maven property from CI.

---

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch: `git checkout -b feature/add-enrollment-negative-tests`
3. Commit your changes: `git commit -m "feat: add 409 conflict test for duplicate enrollment"`
4. Push to your branch: `git push origin feature/add-enrollment-negative-tests`
5. Open a Pull Request against `main`

Please follow the existing package structure, naming conventions, and group tagging patterns.

---

## 👨‍💻 Author

<div align="center">

<table>
  <tr>
    <td align="center" style="padding: 20px;">
      <a href="https://github.com/ranajitchowdhury">
        <img src="https://img.shields.io/badge/-ranajitchowdhury-181717?style=for-the-badge&logo=github&logoColor=white" alt="GitHub Profile"/>
      </a>
      <br/><br/>
      <strong>Ranajit Baran Chowdhury</strong>
      <br/>
      <em>Software Programmer &amp; QA Automation Engineer</em>
    </td>
  </tr>
</table>
<br/>

**Core Expertise**

![API Automation](https://img.shields.io/badge/API%20Automation-RestAssured%20%7C%20Postman-43B02A?style=flat-square&logo=java&logoColor=white)
![UI Automation](https://img.shields.io/badge/UI%20Automation-Selenium%20%7C%20Playwright-43B02A?style=flat-square&logo=selenium&logoColor=white)
![Language](https://img.shields.io/badge/Language-Java%20%7C%20JavaScript-007396?style=flat-square&logo=openjdk&logoColor=white)
![Framework](https://img.shields.io/badge/Framework-TestNG%20%7C%20Cucumber%20%7C%20Maven-C71A36?style=flat-square&logo=apachemaven&logoColor=white)
![CI/CD](https://img.shields.io/badge/CI%2FCD-GitHub%20Actions%20%7C%20Jenkins-2088FF?style=flat-square&logo=githubactions&logoColor=white)
![Testing](https://img.shields.io/badge/Testing-Manual%20%7C%20Automation%20%7C%20API-6A0DAD?style=flat-square)

</div>

> *"A test that doesn't fail when it should is worse than no test at all."*

---

## 📄 License

This project is licensed under the MIT License. See the `LICENSE` file for full details.
